package com.tencent.mtt.hippy.uimanager;

import android.text.TextUtils;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.views.custom.HippyCustomPropsController;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class DiffUtils {

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class CreatePatch extends Patch {
        final RenderNode renderNode;

        public CreatePatch(RenderNode renderNode) {
            this.renderNode = renderNode;
        }

        public String toString() {
            return "CreatePatch id :" + this.renderNode.mId;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class DeletePatch extends Patch {
        final int mId;
        final String mPClassName;
        final int mPid;

        public DeletePatch(int i3, int i16, String str) {
            this.mId = i3;
            this.mPid = i16;
            this.mPClassName = str;
        }

        public String toString() {
            return "DeletePatch  Id " + this.mId;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class ExtraPatch extends Patch {
        final String mClassName;
        final int mID;
        final Object mText;

        public ExtraPatch(int i3, Object obj, String str) {
            this.mID = i3;
            this.mText = obj;
            this.mClassName = str;
        }

        public String toString() {
            return "ExtraPatch";
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class LayoutPatch extends Patch {
        final String mClassName;
        final int mHeight;
        final int mId;
        final int mParentId;
        final int mWidth;
        final int mX;
        final int mY;

        public LayoutPatch(int i3, int i16, int i17, int i18, int i19, int i26, String str) {
            this.mX = i3;
            this.mY = i16;
            this.mHeight = i17;
            this.mWidth = i18;
            this.mId = i19;
            this.mParentId = i26;
            this.mClassName = str;
        }

        public String toString() {
            return "LayoutPatch";
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class Patch {
        public static final int TYPE_CREATE = 5;
        public static final int TYPE_DELETE_CHILDREN = 0;
        public static final int TYPE_EXTRA = 3;
        public static final int TYPE_LAYOUT = 2;
        public static final int TYPE_PROPS = 1;
        public static final int TYPE_REPLACE_ID = 4;
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class PatchType {
        public final Patch mPatch;
        public final int mType;

        public PatchType(int i3, Patch patch) {
            this.mPatch = patch;
            this.mType = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class PropsPatch extends Patch {
        final String mClassName;
        final int mId;
        final HippyMap mPropsToUpdate;

        public PropsPatch(HippyMap hippyMap, int i3, String str) {
            this.mPropsToUpdate = hippyMap;
            this.mId = i3;
            this.mClassName = str;
        }

        public String toString() {
            return "PropsPatch";
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class ReplacePatch extends Patch {
        final int newId;
        final int oldId;

        public ReplacePatch(int i3, int i16) {
            this.oldId = i3;
            this.newId = i16;
        }

        public String toString() {
            return "ReplacePatch oldId:" + this.oldId + " newId:" + this.newId;
        }
    }

    public static void createView(List<PatchType> list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            PatchType patchType = list.get(i3);
            if (patchType.mType == 5) {
                CreatePatch createPatch = (CreatePatch) patchType.mPatch;
                createPatch.renderNode.createViewRecursive();
                RenderNode renderNode = createPatch.renderNode.mParent;
                if (renderNode != null) {
                    renderNode.update();
                }
                createPatch.renderNode.updateViewRecursive();
            }
        }
    }

    public static void deleteViews(ControllerManager controllerManager, List<PatchType> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            PatchType patchType = list.get(size);
            if (patchType.mType == 0) {
                DeletePatch deletePatch = (DeletePatch) patchType.mPatch;
                controllerManager.deleteChild(deletePatch.mPid, deletePatch.mId);
                list.remove(patchType);
            }
        }
    }

    public static ArrayList<PatchType> diff(RenderNode renderNode, RenderNode renderNode2) {
        ArrayList<PatchType> arrayList = new ArrayList<>();
        if (renderNode.getId() == renderNode2.getId()) {
            return arrayList;
        }
        try {
            diffFromNode(renderNode, renderNode2, arrayList);
            diffToNode(renderNode, renderNode2, arrayList);
        } catch (Throwable th5) {
            LogUtils.d("DiffUtils", "diff: " + th5.getMessage());
        }
        return arrayList;
    }

    private static ExtraPatch diffExtra(RenderNode renderNode, RenderNode renderNode2) {
        Object obj = renderNode.mTextExtra;
        if (obj != null && renderNode2.mTextExtra != null && !TextUtils.equals(obj.toString(), renderNode2.mTextExtra.toString())) {
            return new ExtraPatch(renderNode2.getId(), renderNode2.mTextExtra, renderNode2.getClassName());
        }
        return null;
    }

    private static void diffFromNode(RenderNode renderNode, RenderNode renderNode2, ArrayList<PatchType> arrayList) {
        RenderNode renderNode3;
        boolean z16;
        int i3 = 3;
        boolean z17 = false;
        if (TextUtils.equals(renderNode.getClassName(), renderNode2.getClassName())) {
            arrayList.add(new PatchType(4, new ReplacePatch(renderNode.getId(), renderNode2.getId())));
            HippyMap diffProps = diffProps(renderNode.getProps(), renderNode2.getProps(), 0);
            if (diffProps != null && diffProps.size() >= 1) {
                arrayList.add(new PatchType(1, new PropsPatch(diffProps, renderNode2.getId(), renderNode2.getClassName())));
            }
            LayoutPatch diffLayout = diffLayout(renderNode, renderNode2);
            if (diffLayout != null) {
                arrayList.add(new PatchType(2, diffLayout));
            }
            ExtraPatch diffExtra = diffExtra(renderNode, renderNode2);
            if (diffExtra != null) {
                arrayList.add(new PatchType(3, diffExtra));
            }
        }
        int i16 = 0;
        while (i16 < renderNode.getChildCount()) {
            RenderNode childAt = renderNode.getChildAt(i16);
            if (i16 < renderNode2.getChildCount()) {
                renderNode3 = renderNode2.getChildAt(i16);
            } else {
                renderNode3 = null;
            }
            if (renderNode3 != null && TextUtils.equals(childAt.getClassName(), renderNode3.getClassName())) {
                diffFromNode(childAt, renderNode3, arrayList);
                z16 = z17;
            } else {
                if (renderNode3 != null) {
                    arrayList.add(new PatchType(5, new CreatePatch(renderNode3)));
                    if (TextUtils.equals(renderNode3.getClassName(), "Text")) {
                        arrayList.add(new PatchType(i3, new ExtraPatch(renderNode3.mId, renderNode3.mTextExtra, renderNode3.getClassName())));
                    }
                    arrayList.add(new PatchType(2, new LayoutPatch(renderNode3.mX, renderNode3.mY, renderNode3.mHeight, renderNode3.getWidth(), renderNode3.mId, renderNode3.mParent.mId, renderNode3.mClassName)));
                }
                DeletePatch deletePatch = new DeletePatch(childAt.getId(), childAt.getParent().getId(), childAt.getParent().getClassName());
                z16 = false;
                arrayList.add(new PatchType(0, deletePatch));
            }
            i16++;
            z17 = z16;
            i3 = 3;
        }
    }

    private static LayoutPatch diffLayout(RenderNode renderNode, RenderNode renderNode2) {
        if (renderNode != null && renderNode.getX() == renderNode2.getX() && renderNode.getY() == renderNode2.getY() && renderNode.getWidth() == renderNode2.getWidth() && renderNode.getHeight() == renderNode2.getHeight()) {
            return null;
        }
        return new LayoutPatch(renderNode2.getX(), renderNode2.getY(), renderNode2.getHeight(), renderNode2.getWidth(), renderNode2.getId(), renderNode2.mParent.getId(), renderNode2.getClassName());
    }

    public static HippyMap diffProps(HippyMap hippyMap, HippyMap hippyMap2, int i3) {
        if (hippyMap == null) {
            return hippyMap2;
        }
        HippyMap hippyMap3 = new HippyMap();
        for (String str : hippyMap.keySet()) {
            if (!str.equals(HippyCustomPropsController.DT_EBLID)) {
                Object obj = hippyMap.get(str);
                Object obj2 = hippyMap2.get(str);
                if (obj instanceof Boolean) {
                    if (!equalsBoolean((Boolean) obj, obj2)) {
                        hippyMap3.pushObject(str, obj2);
                    }
                } else if (obj instanceof Number) {
                    if (!equalsNumber((Number) obj, obj2)) {
                        hippyMap3.pushObject(str, obj2);
                    }
                } else if (obj instanceof String) {
                    if (obj2 != null && equalsString((String) obj, obj2.toString())) {
                    }
                    hippyMap3.pushObject(str, obj2);
                } else if (obj instanceof HippyArray) {
                    if (!str.equals("tintColors") && !str.equals("tintColor") && equalsArray((HippyArray) obj, obj2)) {
                    }
                    hippyMap3.pushObject(str, obj2);
                } else if (obj instanceof HippyMap) {
                    if (i3 == 0 && str.equals("style")) {
                        if (!(obj2 instanceof HippyMap)) {
                            obj2 = new HippyMap();
                        }
                        hippyMap3.pushMap(str, diffProps((HippyMap) obj, (HippyMap) obj2, i3 + 1));
                    } else if (!equalsMap((HippyMap) obj, obj2)) {
                        hippyMap3.pushObject(str, obj2);
                    }
                }
            }
        }
        for (String str2 : hippyMap2.keySet()) {
            if (hippyMap.get(str2) == null && !str2.equals(HippyCustomPropsController.DT_EBLID)) {
                hippyMap3.pushObject(str2, hippyMap2.get(str2));
            }
        }
        return hippyMap3;
    }

    private static void diffToNode(RenderNode renderNode, RenderNode renderNode2, ArrayList<PatchType> arrayList) {
        if (renderNode != null && renderNode2 != null) {
            for (int i3 = 0; i3 < renderNode2.getChildCount(); i3++) {
                if (i3 >= renderNode.getChildCount()) {
                    RenderNode childAt = renderNode2.getChildAt(i3);
                    arrayList.add(new PatchType(5, new CreatePatch(childAt)));
                    if (TextUtils.equals(childAt.getClassName(), "Text")) {
                        arrayList.add(new PatchType(3, new ExtraPatch(childAt.mId, childAt.mTextExtra, childAt.getClassName())));
                    }
                    arrayList.add(new PatchType(2, new LayoutPatch(childAt.mX, childAt.mY, childAt.mHeight, childAt.getWidth(), childAt.mId, childAt.mParent.mId, childAt.mClassName)));
                } else {
                    diffToNode(renderNode.getChildAt(i3), renderNode2.getChildAt(i3), arrayList);
                }
            }
        }
    }

    public static void doPatch(ControllerManager controllerManager, List<PatchType> list) {
        HippyEngineContext hippyEngineContext = controllerManager.f337639a;
        for (PatchType patchType : list) {
            int i3 = patchType.mType;
            if (i3 == 1) {
                PropsPatch propsPatch = (PropsPatch) patchType.mPatch;
                HippyMap hippyMap = propsPatch.mPropsToUpdate;
                RenderNode renderNode = hippyEngineContext.getRenderManager().getRenderNode(propsPatch.mId);
                if (renderNode != null) {
                    HippyMap props = renderNode.getProps();
                    if (renderNode.mHasSetDteblId) {
                        if (hippyMap.containsKey(HippyCustomPropsController.DT_EBLID)) {
                            hippyMap.remove(HippyCustomPropsController.DT_EBLID);
                        }
                    } else if (props != null && props.containsKey(HippyCustomPropsController.DT_EBLID)) {
                        hippyMap.pushString(HippyCustomPropsController.DT_EBLID, props.getString(HippyCustomPropsController.DT_EBLID));
                    }
                }
                controllerManager.a(propsPatch.mId, propsPatch.mClassName, hippyMap);
            } else if (i3 == 2) {
                LayoutPatch layoutPatch = (LayoutPatch) patchType.mPatch;
                controllerManager.a(layoutPatch.mClassName, layoutPatch.mId, layoutPatch.mX, layoutPatch.mY, layoutPatch.mWidth, layoutPatch.mHeight);
            } else if (i3 == 3) {
                ExtraPatch extraPatch = (ExtraPatch) patchType.mPatch;
                controllerManager.a(extraPatch.mID, extraPatch.mClassName, extraPatch.mText);
            }
        }
    }

    private static boolean equalsArray(HippyArray hippyArray, Object obj) {
        if (hippyArray == obj) {
            return true;
        }
        int size = hippyArray.size();
        if (obj instanceof HippyArray) {
            HippyArray hippyArray2 = (HippyArray) obj;
            if (size == hippyArray2.size()) {
                for (int i3 = 0; i3 < size; i3++) {
                    if (!equalsObject(hippyArray.getObject(i3), hippyArray2.getObject(i3))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    private static boolean equalsBoolean(Boolean bool, Object obj) {
        return bool.equals(obj);
    }

    private static boolean equalsMap(HippyMap hippyMap, Object obj) {
        if (hippyMap == obj) {
            return true;
        }
        if (obj instanceof HippyMap) {
            HippyMap hippyMap2 = (HippyMap) obj;
            if (hippyMap.size() == hippyMap2.size()) {
                for (String str : hippyMap.keySet()) {
                    Object obj2 = hippyMap.get(str);
                    if (!equalsObject(obj2, hippyMap2.get(str))) {
                        return false;
                    }
                    if (obj2 == null && !hippyMap2.containsKey(str)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    private static boolean equalsNumber(Number number, Object obj) {
        if ((obj instanceof Number) && number.doubleValue() == ((Number) obj).doubleValue()) {
            return true;
        }
        return false;
    }

    private static boolean equalsObject(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj instanceof Boolean) {
            return equalsBoolean((Boolean) obj, obj2);
        }
        if (obj instanceof Number) {
            return equalsNumber((Number) obj, obj2);
        }
        if (obj instanceof String) {
            return equalsString((String) obj, obj2);
        }
        if (obj instanceof HippyArray) {
            return equalsArray((HippyArray) obj, obj2);
        }
        if (obj instanceof HippyMap) {
            return equalsMap((HippyMap) obj, obj2);
        }
        return false;
    }

    private static boolean equalsString(String str, Object obj) {
        return str.equals(obj);
    }

    public static void replaceIds(ControllerManager controllerManager, List<PatchType> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            PatchType patchType = list.get(size);
            if (patchType.mType == 4) {
                ReplacePatch replacePatch = (ReplacePatch) patchType.mPatch;
                controllerManager.a(replacePatch.oldId, replacePatch.newId);
                list.remove(patchType);
            }
        }
    }
}
