package com.tencent.pts.ui;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.view.IMeasureText;
import com.tencent.pts.ui.vnode.PTSNodeContainer;
import com.tencent.pts.ui.vnode.PTSNodeImage;
import com.tencent.pts.ui.vnode.PTSNodeScrollView;
import com.tencent.pts.ui.vnode.PTSNodeSwiper;
import com.tencent.pts.ui.vnode.PTSNodeText;
import com.tencent.pts.ui.vnode.PTSNodeTextBase;
import com.tencent.pts.ui.vnode.PTSNodeView;
import com.tencent.pts.ui.vnode.PTSNodeVirtual;
import com.tencent.pts.ui.vnode.b;
import com.tencent.pts.utils.PTSConfig;
import com.tencent.pts.utils.PTSConstant;
import com.tencent.pts.utils.PTSDeviceUtil;
import com.tencent.pts.utils.PTSLog;
import com.tencent.pts.utils.PTSReportUtil;
import com.tencent.pts.utils.PTSValueConvertUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes22.dex */
public class PTSNodeFactory {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "PTSNodeFactory";
    private static HashMap<String, PTSNodeVirtual.a> sNodeBuilders;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38960);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sNodeBuilders = new HashMap<>();
            registerNodeVirtualList();
        }
    }

    public PTSNodeFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void addNodeToParent(PTSNodeVirtual pTSNodeVirtual, PTSNodeInfo pTSNodeInfo, HashMap<String, List<PTSNodeVirtual>> hashMap) {
        boolean z16;
        if (pTSNodeInfo.hasParent()) {
            String parentID = pTSNodeInfo.getParentID();
            Iterator<List<PTSNodeVirtual>> it = hashMap.values().iterator();
            while (it.hasNext()) {
                Iterator<PTSNodeVirtual> it5 = it.next().iterator();
                while (true) {
                    if (it5.hasNext()) {
                        PTSNodeVirtual next = it5.next();
                        if (next != null && next.getNodeInfo() != null && TextUtils.equals(next.getNodeInfo().getUniqueID(), parentID)) {
                            if (pTSNodeVirtual.getParent() == null) {
                                next.addChild(pTSNodeVirtual);
                            }
                            z16 = true;
                        }
                    } else {
                        z16 = false;
                        break;
                    }
                }
                if (z16) {
                    return;
                }
            }
        }
    }

    private static void addToListMap(String str, PTSNodeVirtual pTSNodeVirtual, HashMap<String, List<PTSNodeVirtual>> hashMap) {
        if (!TextUtils.isEmpty(str) && pTSNodeVirtual != null && hashMap != null) {
            List<PTSNodeVirtual> list = hashMap.get(str);
            if (list == null) {
                list = new ArrayList<>();
                hashMap.put(str, list);
            }
            list.add(pTSNodeVirtual);
        }
    }

    public static PTSNodeVirtual bindData(PTSAppInstance pTSAppInstance, PTSNodeInfo pTSNodeInfo, HashMap<String, List<PTSNodeVirtual>> hashMap) {
        PTSNodeVirtual pTSNodeVirtual = null;
        if (pTSAppInstance != null && pTSNodeInfo != null && hashMap != null) {
            hideAllNodeOfListMap(hashMap);
            LinkedList linkedList = new LinkedList();
            linkedList.add(pTSNodeInfo);
            while (!linkedList.isEmpty()) {
                PTSNodeInfo pTSNodeInfo2 = (PTSNodeInfo) linkedList.remove();
                PTSNodeVirtual reusableNodeFromListMap = getReusableNodeFromListMap(pTSNodeInfo2.getAttributes().getViewID(), hashMap, pTSNodeInfo2);
                if (reusableNodeFromListMap == null) {
                    reusableNodeFromListMap = buildVirtualNodeBFS(pTSNodeInfo2, pTSAppInstance, hashMap);
                    if (reusableNodeFromListMap != null) {
                        reusableNodeFromListMap.bindNodeInfo(pTSNodeInfo2);
                    }
                } else {
                    reusableNodeFromListMap.bindNodeInfo(pTSNodeInfo2);
                }
                if (reusableNodeFromListMap != null && reusableNodeFromListMap.getParent() == null) {
                    addNodeToParent(reusableNodeFromListMap, pTSNodeInfo2, hashMap);
                }
                if (pTSNodeInfo2.isRootNode()) {
                    pTSNodeVirtual = reusableNodeFromListMap;
                }
                if (reusableNodeFromListMap != null) {
                    reusableNodeFromListMap.showNode();
                    reusableNodeFromListMap.setReusable(false);
                }
                if (pTSNodeInfo2.isContainer()) {
                    linkedList.addAll(pTSNodeInfo2.getChildren());
                }
            }
            makeAllNodeReusableOfListMap(hashMap);
            updateAllNodeLayoutAndAttributes(hashMap);
        }
        return pTSNodeVirtual;
    }

    public static PTSNodeVirtual buildVirtualNode(PTSNodeInfo pTSNodeInfo, PTSAppInstance pTSAppInstance) {
        String str;
        PTSNodeVirtual pTSNodeVirtual = null;
        if (pTSNodeInfo != null && pTSAppInstance != null) {
            if (pTSNodeInfo.getAttributes() != null) {
                str = PTSValueConvertUtil.getString(pTSNodeInfo.getAttributes().get(PTSNodeAttributeConstant.PTS_CUSTOM_VIEW_TYPE));
            } else {
                str = "";
            }
            String key = getKey(pTSNodeInfo.getNodeType(), str);
            PTSNodeVirtual.a nodeBuilder = getNodeBuilder(pTSNodeInfo.getNodeType(), str);
            if (nodeBuilder != null) {
                pTSNodeVirtual = nodeBuilder.buildNodeVirtual(pTSAppInstance);
            }
            if (pTSNodeVirtual == null) {
                String str2 = "[buildVirtualNode] error, use default PTSNodeView, the node type constructor does not exist, key = " + key;
                PTSLog.e(TAG, str2);
                PTSReportUtil.reportEvent(TAG, str2, 1);
                PTSNodeView pTSNodeView = new PTSNodeView(pTSAppInstance);
                pTSNodeView.setViewID(pTSNodeInfo.getAttributes().getViewID());
                pTSNodeView.setNodeVirtualKey(key);
                return pTSNodeView;
            }
            return pTSNodeVirtual;
        }
        PTSLog.e(TAG, "can not buildVirtualNode, nodeInfo or appInstance is null.");
        return null;
    }

    public static PTSNodeVirtual buildVirtualNodeBFS(PTSNodeInfo pTSNodeInfo, PTSAppInstance pTSAppInstance, HashMap<String, List<PTSNodeVirtual>> hashMap) {
        PTSNodeVirtual pTSNodeVirtual;
        PTSNodeVirtual pTSNodeVirtual2 = null;
        if (pTSNodeInfo != null && pTSAppInstance != null) {
            HashMap hashMap2 = new HashMap();
            LinkedList linkedList = new LinkedList();
            linkedList.add(pTSNodeInfo);
            while (!linkedList.isEmpty()) {
                PTSNodeInfo pTSNodeInfo2 = (PTSNodeInfo) linkedList.remove();
                PTSNodeVirtual buildVirtualNode = buildVirtualNode(pTSNodeInfo2, pTSAppInstance);
                String viewID = pTSNodeInfo2.getAttributes().getViewID();
                if (pTSNodeVirtual2 == null) {
                    pTSNodeVirtual2 = buildVirtualNode;
                }
                if (buildVirtualNode == null) {
                    PTSLog.e(TAG, "[buildVirtualNodeBFS], currentNode is null.");
                    if (!PTSLog.isDebug()) {
                        PTSLog.e(TAG, "[buildVirtualNodeBFS], currentNode is null.");
                    } else {
                        throw new IllegalArgumentException("[buildVirtualNodeBFS], currentNode is null.");
                    }
                }
                if (pTSNodeInfo2.hasParent() && (pTSNodeVirtual = (PTSNodeVirtual) hashMap2.get(pTSNodeInfo2.getParentID())) != null) {
                    pTSNodeVirtual.addChild(buildVirtualNode);
                }
                hashMap2.put(pTSNodeInfo2.getUniqueID(), buildVirtualNode);
                if (!TextUtils.isEmpty(viewID)) {
                    if (hashMap != null) {
                        addToListMap(viewID, buildVirtualNode, hashMap);
                    }
                } else {
                    PTSLog.e(TAG, "[buildVirtualNodeBFS], currentViewID is null.");
                }
                if (pTSNodeInfo2.isContainer()) {
                    linkedList.addAll(pTSNodeInfo2.getChildren());
                }
            }
            return pTSNodeVirtual2;
        }
        PTSLog.e(TAG, "can not buildVirtualNodeBFS, nodeInfo or appInstance is null.");
        return null;
    }

    public static float[] getCustomTextMeasuredSize(float[] fArr, String str, String str2, String str3, String str4, String str5) {
        return getCustomTextMeasuredSize(fArr, str, str2, str3, str4, str5, "normal");
    }

    private static String getKey(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            return str + "-" + str2;
        }
        return str;
    }

    public static PTSNodeVirtual.a getNodeBuilder(String str, String str2) {
        PTSNodeVirtual.a aVar = sNodeBuilders.get(getKey(str, str2));
        if (aVar == null) {
            return sNodeBuilders.get(getKey(str, ""));
        }
        return aVar;
    }

    private static PTSNodeVirtual getReusableNodeFromListMap(String str, HashMap<String, List<PTSNodeVirtual>> hashMap, PTSNodeInfo pTSNodeInfo) {
        List<PTSNodeVirtual> list;
        if (!TextUtils.isEmpty(str) && hashMap != null && pTSNodeInfo != null && (list = hashMap.get(str)) != null && list.size() > 0) {
            for (PTSNodeVirtual pTSNodeVirtual : list) {
                if (pTSNodeVirtual != null && pTSNodeVirtual.getReusable() && (pTSNodeInfo.isRootNode() || pTSNodeVirtual.getNodeInfo() == null || (pTSNodeVirtual.getNodeInfo() != null && TextUtils.equals(pTSNodeInfo.getParentID(), pTSNodeVirtual.getNodeInfo().getParentID())))) {
                    return pTSNodeVirtual;
                }
            }
        }
        return null;
    }

    public static float[] getRichTextMeasuredSize(float[] fArr, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        float[] fArr2 = new float[2];
        PTSNodeVirtual.a nodeBuilder = getNodeBuilder(PTSConstant.VNT_RICH_TEXT, "");
        if (nodeBuilder != null) {
            Object buildNodeVirtual = nodeBuilder.buildNodeVirtual(null);
            if (buildNodeVirtual instanceof com.tencent.pts.ui.view.a) {
                return ((com.tencent.pts.ui.view.a) buildNodeVirtual).getRichTextMeasuredSize(fArr, str, str2, str3, str4, str5, str6, str7);
            }
            return fArr2;
        }
        return fArr2;
    }

    public static float[] getTextMeasuredSize(float[] fArr, String str, String str2, String str3, String str4) {
        return getTextMeasuredSize(fArr, str, str2, str3, str4, "normal");
    }

    private static void hideAllNodeOfListMap(HashMap<String, List<PTSNodeVirtual>> hashMap) {
        for (List<PTSNodeVirtual> list : hashMap.values()) {
            if (list != null) {
                for (PTSNodeVirtual pTSNodeVirtual : list) {
                    if (pTSNodeVirtual != null) {
                        pTSNodeVirtual.hideNode();
                    }
                }
            }
        }
    }

    private static void makeAllNodeReusableOfListMap(HashMap<String, List<PTSNodeVirtual>> hashMap) {
        for (List<PTSNodeVirtual> list : hashMap.values()) {
            if (list != null) {
                for (PTSNodeVirtual pTSNodeVirtual : list) {
                    if (pTSNodeVirtual != null) {
                        pTSNodeVirtual.setReusable(true);
                    }
                }
            }
        }
    }

    public static void registerCustomViewNodeVirtual(String str, String str2, PTSNodeVirtual.a aVar) {
        if (!TextUtils.isEmpty(str) && aVar != null) {
            registerNodeVirtualImp(getKey(str, str2), aVar);
        }
    }

    public static void registerNodeVirtual(String str, PTSNodeVirtual.a aVar) {
        if (!TextUtils.isEmpty(str) && aVar != null) {
            registerNodeVirtualImp(str, aVar);
        }
    }

    private static void registerNodeVirtualImp(String str, PTSNodeVirtual.a aVar) {
        if (!TextUtils.isEmpty(str) && aVar != null) {
            PTSLog.i(TAG, "[registerNodeVirtualImp] key = " + str + ", builder = " + aVar.getClass());
            sNodeBuilders.put(str, aVar);
        }
    }

    private static void registerNodeVirtualList() {
        registerNodeVirtual("view", new PTSNodeContainer.a());
        registerNodeVirtual("page", new PTSNodeContainer.a());
        registerNodeVirtual("block", new PTSNodeContainer.a());
        registerNodeVirtual("text", new PTSNodeText.a());
        registerNodeVirtual("img", new PTSNodeImage.a());
        registerNodeVirtual(PTSConstant.VNT_SWIPER, new PTSNodeSwiper.q());
        registerNodeVirtual(PTSConstant.VNT_SWIPER_ITEM, new PTSNodeContainer.a());
        registerNodeVirtual(PTSConstant.VNT_BORING, new PTSNodeView.a());
        registerCustomViewNodeVirtual("view", PTSConstant.CUSTOM_VIEW_TYPE_SCROLL_VIEW, new PTSNodeScrollView.a());
        registerCustomViewNodeVirtual("img", PTSConstant.CUSTOM_VIEW_TYPE_UMBREON, new b.C9290b());
    }

    private static void removeNodeFromParent(PTSNodeVirtual pTSNodeVirtual) {
        if (pTSNodeVirtual != null && pTSNodeVirtual.getParent() != null) {
            pTSNodeVirtual.getParent().removeChild(pTSNodeVirtual);
        }
    }

    private static void updateAllNodeLayoutAndAttributes(HashMap<String, List<PTSNodeVirtual>> hashMap) {
        for (List<PTSNodeVirtual> list : hashMap.values()) {
            if (list != null) {
                for (PTSNodeVirtual pTSNodeVirtual : list) {
                    if (pTSNodeVirtual != null && pTSNodeVirtual.isVisible()) {
                        pTSNodeVirtual.applyLayout();
                        pTSNodeVirtual.onParseValueFinished();
                    }
                }
            }
        }
    }

    public static float[] getCustomTextMeasuredSize(float[] fArr, String str, String str2, String str3, String str4, String str5, String str6) {
        return getCustomTextMeasuredSize(fArr, str, str2, str3, str4, str5, str6, "");
    }

    public static float[] getTextMeasuredSize(float[] fArr, CharSequence charSequence, String str, String str2, String str3, String str4) {
        return getTextMeasuredSize(fArr, charSequence, str, str2, str3, str4, "");
    }

    public static float[] getCustomTextMeasuredSize(float[] fArr, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        float[] fArr2 = new float[2];
        if (TextUtils.isEmpty(str5)) {
            return fArr2;
        }
        PTSNodeVirtual.a aVar = sNodeBuilders.get(getKey("text", str5));
        if (aVar != null) {
            Object buildNodeVirtual = aVar.buildNodeVirtual(null);
            return buildNodeVirtual instanceof IMeasureText ? ((IMeasureText) buildNodeVirtual).getTextMeasuredSize(fArr, str, str2, str3, str4, str6, str7) : fArr2;
        }
        return getTextMeasuredSize(fArr, str, str2, str3, str4, str6, str7);
    }

    public static float[] getTextMeasuredSize(float[] fArr, CharSequence charSequence, String str, String str2, String str3, String str4, String str5) {
        float f16;
        if (fArr != null && fArr.length >= 2) {
            PTSLog.i(TAG, "[getTextMeasuredSize] constrainedSize[0] = " + fArr[0] + ", constrainedSize[1] = " + fArr[1]);
            int i3 = 0;
            while (true) {
                f16 = 0.0f;
                if (i3 >= fArr.length) {
                    break;
                }
                if (fArr[i3] < 0.0f) {
                    fArr[i3] = 0.0f;
                }
                i3++;
            }
            TextPaint textPaint = new TextPaint();
            textPaint.setAntiAlias(true);
            float dp2px = PTSDeviceUtil.dp2px(PTSValueConvertUtil.getFloat(str));
            textPaint.setTextSize(dp2px);
            if (TextUtils.equals("bold", str4)) {
                textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
                textPaint.setTypeface(Typeface.DEFAULT_BOLD);
            }
            if (!TextUtils.isEmpty(str5)) {
                try {
                    textPaint.setTypeface(Typeface.createFromAsset(PTSConfig.getApplicationContext().getAssets(), "fonts" + File.separator + str5 + ".ttf"));
                    PTSLog.i(TAG, "[getTextMeasuredSize] fontFamily = " + str5);
                } catch (Exception e16) {
                    PTSLog.e(TAG, "[getTextMeasuredSize] e = " + e16);
                }
            }
            float[] fArr2 = {fArr[0], fArr[1]};
            float lineSpacing = PTSNodeTextBase.getLineSpacing(PTSValueConvertUtil.getFloat(str2), PTSValueConvertUtil.getFloat(str), textPaint);
            int i16 = PTSValueConvertUtil.getInt(str3);
            int dp2pxInt = PTSDeviceUtil.dp2pxInt(Math.min(fArr[0], PTSDeviceUtil.getScreenWidthDp()));
            int length = TextUtils.isEmpty(charSequence) ? 0 : charSequence.length() - 1;
            int i17 = Build.VERSION.SDK_INT;
            StaticLayout.Builder ellipsize = StaticLayout.Builder.obtain(charSequence, 0, length, textPaint, dp2pxInt).setEllipsizedWidth(dp2pxInt).setAlignment(Layout.Alignment.ALIGN_NORMAL).setIncludePad(false).setMaxLines(i16).setLineSpacing(lineSpacing, 1.0f).setText(charSequence).setEllipsize(TextUtils.TruncateAt.END);
            if (i17 >= 28) {
                ellipsize.setUseLineSpacingFromFallbacks(true);
            }
            StaticLayout build = ellipsize.build();
            float px2dp = PTSDeviceUtil.px2dp(Layout.getDesiredWidth(charSequence, textPaint));
            float px2dp2 = PTSDeviceUtil.px2dp(build.getWidth());
            float px2dp3 = PTSDeviceUtil.px2dp(build.getHeight());
            float px2dp4 = PTSDeviceUtil.px2dp(PTSNodeTextBase.getHeightOffset(dp2px, build.getLineCount()));
            fArr2[0] = Math.min(px2dp, px2dp2);
            fArr2[1] = px2dp3 + px2dp4;
            if (build.getLineCount() == 1) {
                f16 = PTSDeviceUtil.px2dp(PTSNodeTextBase.getWidthOffset(dp2px, TextUtils.isEmpty(charSequence) ? 0 : charSequence.length()));
                fArr2[0] = fArr2[0] + f16;
            }
            if (PTSLog.isDebug()) {
                PTSLog.i(TAG, "[getTextMeasuredSizeImpNew], measuredWidth = " + fArr2[0] + " dp , measureHeight = " + fArr2[1] + " dp , content = " + ((Object) charSequence) + ", fontSize = " + str + ", fontWeight = " + str4 + ", lineHeight = " + str2 + ", lineSpacing = " + lineSpacing + ", lineClamp = " + str3 + ", layoutHeightOffset = " + px2dp4 + " dp , layoutWidthOffset = " + f16 + " dp , actualLineCount = " + build.getLineCount());
            }
            return fArr2;
        }
        PTSLog.e(TAG, "[getTextMeasuredSize] constrainedSize is not valid.");
        return fArr;
    }
}
