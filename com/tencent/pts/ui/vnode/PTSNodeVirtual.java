package com.tencent.pts.ui.vnode;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.pts.bridge.PTSJSBridge;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.pts.core.lite.PTSLiteItemViewManager;
import com.tencent.pts.ui.PTSNodeAttribute;
import com.tencent.pts.ui.PTSNodeAttributeConstant;
import com.tencent.pts.ui.PTSNodeFactory;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.PTSNodeStyle;
import com.tencent.pts.ui.PTSNodeStyleConstant;
import com.tencent.pts.ui.view.IView;
import com.tencent.pts.utils.PTSLog;
import com.tencent.pts.utils.PTSNodeVirtualUtil;
import com.tencent.pts.utils.PTSValueConvertUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes22.dex */
public abstract class PTSNodeVirtual {
    static IPatchRedirector $redirector_;
    protected final String TAG;
    private int backgroundColor;
    private String backgroundImage;
    private PTSAppInstance mAppInstance;
    protected List<PTSNodeVirtual> mChildren;
    private PTSNodeInfo mNodeInfo;
    private PTSNodeVirtual mParent;
    private View mView;
    private String mViewID;
    private ColorDrawable normalDrawable;
    private View.OnClickListener onClickListener;
    private int[] padding;
    private ColorDrawable pressDrawable;
    private Integer ptsOnPressBackgroundColor;
    private Integer ptsOnPressColor;
    private String ptsOnPressSrc;
    private boolean reusable;
    private StateListDrawable stateListDrawable;

    /* loaded from: classes22.dex */
    public interface a {
        View buildNativeView(Context context, PTSNodeVirtual pTSNodeVirtual);

        PTSNodeVirtual buildNodeVirtual(PTSAppInstance pTSAppInstance);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PTSNodeVirtual(PTSAppInstance pTSAppInstance, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, pTSAppInstance, str, str2);
            return;
        }
        this.TAG = getClass().getSimpleName();
        this.reusable = true;
        this.backgroundColor = 16777215;
        this.padding = new int[4];
        if (pTSAppInstance == null) {
            return;
        }
        this.mAppInstance = pTSAppInstance;
        View initView = initView(pTSAppInstance.getContext());
        this.mView = initView == null ? initView(str, str2, pTSAppInstance.getContext()) : initView;
    }

    private void bindAttributes(PTSNodeAttribute pTSNodeAttribute) {
        for (Map.Entry<String, Object> entry : pTSNodeAttribute.entrySet()) {
            setAttributes(entry.getKey(), entry.getValue());
        }
    }

    private void bindExtra(PTSNodeInfo pTSNodeInfo) {
        if (pTSNodeInfo != null) {
            setContent(pTSNodeInfo.getContent());
        }
    }

    private void bindStyle(PTSNodeStyle pTSNodeStyle) {
        for (Map.Entry<String, Object> entry : pTSNodeStyle.entrySet()) {
            setStyle(entry.getKey(), entry.getValue());
        }
    }

    private void bindTapEvent() {
        PTSLog.i(this.TAG, "[bindTapEvent]");
        if (this.onClickListener == null) {
            this.onClickListener = new View.OnClickListener() { // from class: com.tencent.pts.ui.vnode.PTSNodeVirtual.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) PTSNodeVirtual.this);
                    }
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        PTSNodeVirtual.this.handleTapEvent();
                        PTSNodeVirtualUtil.onViewClicked(view);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                    }
                    EventCollector.getInstance().onViewClicked(view);
                }
            };
        }
        getView().setOnClickListener(this.onClickListener);
    }

    private int convertRgbaToArgb(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (str.startsWith("#")) {
            if (str.length() == 7) {
                return Color.parseColor(str);
            }
            if (str.length() != 9) {
                return -1;
            }
            return Color.parseColor(str.charAt(0) + str.substring(7, 9) + str.substring(1, 7));
        }
        return PTSValueConvertUtil.getColor(str);
    }

    private GradientDrawable.Orientation getGradientDirection(String str) {
        if (str.contains("top")) {
            if (str.contains("left")) {
                return GradientDrawable.Orientation.BR_TL;
            }
            if (str.contains("right")) {
                return GradientDrawable.Orientation.BL_TR;
            }
            return GradientDrawable.Orientation.BOTTOM_TOP;
        }
        if (str.contains("bottom")) {
            if (str.contains("left")) {
                return GradientDrawable.Orientation.TR_BL;
            }
            if (str.contains("right")) {
                return GradientDrawable.Orientation.TL_BR;
            }
            return GradientDrawable.Orientation.TOP_BOTTOM;
        }
        if (str.contains("left")) {
            return GradientDrawable.Orientation.RIGHT_LEFT;
        }
        if (str.contains("right")) {
            return GradientDrawable.Orientation.LEFT_RIGHT;
        }
        return GradientDrawable.Orientation.LEFT_RIGHT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleTapEvent() {
        String[] strArr;
        String[] strArr2;
        PTSNodeInfo nodeInfo = getNodeInfo();
        if (nodeInfo == null) {
            PTSLog.i(this.TAG, "[handleTapEvent], nodeInfo is null.");
            return;
        }
        try {
            int parseInt = Integer.parseInt(nodeInfo.getUniqueID());
            String attributeID = nodeInfo.getAttributes().getAttributeID();
            HashMap<String, String> eventInfo = nodeInfo.getEventInfo();
            if (eventInfo != null && eventInfo.size() > 0) {
                int size = eventInfo.size();
                String[] strArr3 = new String[size];
                String[] strArr4 = new String[size];
                int i3 = 0;
                for (Map.Entry<String, String> entry : eventInfo.entrySet()) {
                    strArr3[i3] = entry.getKey();
                    strArr4[i3] = entry.getValue();
                    i3++;
                }
                strArr2 = strArr4;
                strArr = strArr3;
            } else {
                strArr = null;
                strArr2 = null;
            }
            if (this.mAppInstance.isJsAppInstance()) {
                String eventBindTap = nodeInfo.getAttributes().getEventBindTap();
                PTSJSBridge jsBridge = this.mAppInstance.getJsBridge();
                if (jsBridge != null) {
                    jsBridge.callJSEventFunction(eventBindTap, parseInt, "tap", attributeID, strArr, strArr2, null, null, this.mAppInstance);
                    return;
                }
                return;
            }
            if (this.mAppInstance.isLiteAppInstance()) {
                String eventPtsOnTap = nodeInfo.getAttributes().getEventPtsOnTap();
                IPTSLiteEventListener liteEventListener = ((PTSAppInstance.PTSLiteAppInstance) this.mAppInstance).getLiteEventListener();
                PTSLiteItemViewManager liteItemViewManager = ((PTSAppInstance.PTSLiteAppInstance) this.mAppInstance).getLiteItemViewManager();
                if (liteItemViewManager != null) {
                    liteItemViewManager.triggerLiteEvent(1, eventPtsOnTap, eventInfo, getView());
                } else if (liteEventListener != null) {
                    ((PTSAppInstance.PTSLiteAppInstance) this.mAppInstance).triggerLiteEvent(1, eventPtsOnTap, eventInfo, getView(), this.mAppInstance.getPtsComposer());
                }
            }
        } catch (NumberFormatException e16) {
            PTSLog.e(this.TAG, "[handleTapEvent], e = " + e16);
        }
    }

    private final void reset() {
        View view = getView();
        this.backgroundColor = 16777215;
        if (!isContainer()) {
            this.padding = new int[]{0, 0, 0, 0};
        }
        setViewID("");
        if (view.hasOnClickListeners()) {
            view.setOnClickListener(null);
        }
        this.ptsOnPressSrc = null;
        this.ptsOnPressColor = null;
        this.ptsOnPressBackgroundColor = null;
        resetAll();
    }

    private void setAttributes(String str, Object obj) {
        if (!setAttribute(str, obj)) {
            setEventListener(str);
        }
    }

    private void setEventListener(String str) {
        if (!PTSNodeAttributeConstant.EVENT_TYPE_TAP.equalsIgnoreCase(str) && !PTSNodeAttributeConstant.EVENT_TYPE_PTS_ON_TAP.equalsIgnoreCase(str)) {
            if (PTSNodeAttributeConstant.EVENT_TYPE_PTS_ON_EXPOSURE.equalsIgnoreCase(str)) {
                bindExposeEvent();
                return;
            }
            return;
        }
        bindTapEvent();
    }

    private void updateGradientBackground() {
        if (!TextUtils.isEmpty(this.backgroundImage) && this.backgroundImage.contains("linear-gradient")) {
            PTSLog.i(this.TAG, "[updateGradientBackground] backgroundImage = " + this.backgroundImage);
            try {
                String[] split = this.backgroundImage.substring(this.backgroundImage.indexOf("(") + 1, this.backgroundImage.indexOf(")")).split(",");
                if (split.length >= 3) {
                    getView().setBackgroundDrawable(new GradientDrawable(getGradientDirection(split[0].trim()), new int[]{convertRgbaToArgb(split[1].trim()), convertRgbaToArgb(split[2].trim())}));
                }
            } catch (StringIndexOutOfBoundsException e16) {
                PTSLog.e(this.TAG, "[updateGradientBackground] e = " + e16);
            } catch (Exception e17) {
                PTSLog.e(this.TAG, "[updateGradientBackground] e = " + e17);
            }
        }
    }

    private void updatePtsOnPressBackgroundColor() {
        Integer ptsOnPressBackgroundColor = getPtsOnPressBackgroundColor();
        if (ptsOnPressBackgroundColor == null) {
            return;
        }
        if (this.stateListDrawable == null) {
            this.stateListDrawable = new StateListDrawable();
            this.normalDrawable = new ColorDrawable(getBackgroundColor());
            ColorDrawable colorDrawable = new ColorDrawable(ptsOnPressBackgroundColor.intValue());
            this.pressDrawable = colorDrawable;
            this.stateListDrawable.addState(new int[]{R.attr.state_pressed}, colorDrawable);
            this.stateListDrawable.addState(new int[0], this.normalDrawable);
        }
        this.normalDrawable.setColor(getBackgroundColor());
        this.pressDrawable.setColor(ptsOnPressBackgroundColor.intValue());
        getView().setBackgroundDrawable(this.stateListDrawable);
    }

    public void addChild(PTSNodeVirtual pTSNodeVirtual) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) pTSNodeVirtual);
            return;
        }
        if (!isLeafNode() && (this.mView instanceof ViewGroup)) {
            if (this.mChildren == null) {
                this.mChildren = new ArrayList();
            }
            if (pTSNodeVirtual == null) {
                PTSLog.e(this.TAG, "[addChild], the child is null.");
                return;
            }
            this.mChildren.add(pTSNodeVirtual);
            pTSNodeVirtual.setParent(this);
            ((ViewGroup) this.mView).addView(pTSNodeVirtual.getView());
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[addChild] failed, can not add child for leaf node, or mView is not ViewGroup, nodeInfo = \n");
        PTSNodeInfo pTSNodeInfo = this.mNodeInfo;
        if (pTSNodeInfo != null) {
            str = pTSNodeInfo.toString();
        } else {
            str = "";
        }
        sb5.append(str);
        String sb6 = sb5.toString();
        PTSLog.e(this.TAG, sb6);
        if (!PTSLog.isDebug()) {
        } else {
            throw new IllegalArgumentException(sb6);
        }
    }

    public void applyLayout() {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this);
            return;
        }
        if (this.mView.getLayoutParams() != null) {
            layoutParams = this.mView.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams == null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(getWidth(), getHeight());
            marginLayoutParams.setMargins(getLeft(), getTop(), 0, 0);
            layoutParams2 = marginLayoutParams;
        } else {
            layoutParams.width = getWidth();
            layoutParams.height = getHeight();
            boolean z16 = layoutParams instanceof ViewGroup.MarginLayoutParams;
            layoutParams2 = layoutParams;
            if (z16) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(getLeft(), getTop(), 0, 0);
                layoutParams2 = layoutParams;
            }
        }
        getView().setLayoutParams(layoutParams2);
    }

    public final void bindNodeInfo(PTSNodeInfo pTSNodeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) pTSNodeInfo);
            return;
        }
        if (pTSNodeInfo != null) {
            reset();
            this.mNodeInfo = pTSNodeInfo;
            bindStyle(pTSNodeInfo.getStyle());
            bindAttributes(pTSNodeInfo.getAttributes());
            bindExtra(pTSNodeInfo);
            if (getView() instanceof IView) {
                ((IView) getView()).onBindNodeInfo(pTSNodeInfo);
            }
            PTSNodeVirtualUtil.onBindNodeInfoFinished(pTSNodeInfo.getUniqueID(), getView(), pTSNodeInfo.getContent(), pTSNodeInfo.getStyle(), pTSNodeInfo.getAttributes());
        }
    }

    public PTSAppInstance getAppInstance() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (PTSAppInstance) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mAppInstance;
    }

    public int getBackgroundColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return this.backgroundColor;
    }

    public List<PTSNodeVirtual> getChildren() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (List) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        if (this.mChildren == null) {
            return new ArrayList();
        }
        return new ArrayList(this.mChildren);
    }

    public Context getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Context) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mAppInstance.getContext();
    }

    public int getHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return this.mNodeInfo.getStyle().getHeight();
    }

    public int getLeft() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.mNodeInfo.getStyle().getLeft();
    }

    public int getMeasuredHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        return this.mView.getMeasuredHeight();
    }

    public int getMeasuredWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        return this.mView.getMeasuredWidth();
    }

    public PTSNodeInfo getNodeInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (PTSNodeInfo) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return this.mNodeInfo;
    }

    public PTSNodeVirtual getParent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (PTSNodeVirtual) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return this.mParent;
    }

    public Integer getPtsOnPressBackgroundColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (Integer) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.ptsOnPressBackgroundColor;
    }

    public Integer getPtsOnPressColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (Integer) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.ptsOnPressColor;
    }

    public String getPtsOnPressSrc() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.ptsOnPressSrc;
    }

    public boolean getReusable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.reusable;
    }

    public int getTop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.mNodeInfo.getStyle().getTop();
    }

    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (View) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return this.mView;
    }

    public String getViewID() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (TextUtils.isEmpty(this.mViewID)) {
            return "";
        }
        return this.mViewID;
    }

    public int getVisibility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.mView.getVisibility();
    }

    public int getWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return this.mNodeInfo.getStyle().getWidth();
    }

    public void hideNode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
        } else {
            this.mView.setVisibility(8);
        }
    }

    protected View initView(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 32)) {
            return null;
        }
        return (View) iPatchRedirector.redirect((short) 32, (Object) this, (Object) context);
    }

    public boolean isContainer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return getView() instanceof ViewGroup;
    }

    public boolean isLeafNode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return !isContainer();
    }

    public boolean isVisible() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if (getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public void onParseValueFinished() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this);
            return;
        }
        View view = getView();
        view.setBackgroundColor(this.backgroundColor);
        int[] iArr = this.padding;
        view.setPadding(iArr[0], iArr[1], iArr[2], iArr[3]);
        updatePtsOnPressBackgroundColor();
        updateGradientBackground();
    }

    public void removeChild(PTSNodeVirtual pTSNodeVirtual) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) pTSNodeVirtual);
            return;
        }
        if (!isLeafNode() && (this.mView instanceof ViewGroup)) {
            List<PTSNodeVirtual> list = this.mChildren;
            if (list != null && pTSNodeVirtual != null) {
                list.remove(pTSNodeVirtual);
                pTSNodeVirtual.setParent(null);
                ((ViewGroup) this.mView).removeView(pTSNodeVirtual.getView());
                return;
            }
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[remove] failed, can not remove child for leaf node, or mView is not ViewGroup, nodeInfo = \n");
        PTSNodeInfo pTSNodeInfo = this.mNodeInfo;
        if (pTSNodeInfo != null) {
            str = pTSNodeInfo.toString();
        } else {
            str = "";
        }
        sb5.append(str);
        String sb6 = sb5.toString();
        PTSLog.e(this.TAG, sb6);
        if (!PTSLog.isDebug()) {
        } else {
            throw new IllegalArgumentException(sb6);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void resetAll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean setAttribute(String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this, (Object) str, obj)).booleanValue();
        }
        if (PTSNodeAttributeConstant.VIEW_ID.equalsIgnoreCase(str)) {
            this.mViewID = PTSValueConvertUtil.getString(obj);
            return true;
        }
        if (PTSNodeAttributeConstant.ATTRIBUTE_PRESS_COLOR.equalsIgnoreCase(str)) {
            this.ptsOnPressColor = Integer.valueOf(PTSValueConvertUtil.getColor(obj));
            return true;
        }
        if (PTSNodeAttributeConstant.ATTRIBUTE_PRESS_BACKGROUND_COLOR.equalsIgnoreCase(str)) {
            this.ptsOnPressBackgroundColor = Integer.valueOf(PTSValueConvertUtil.getColor(obj));
            return true;
        }
        if (PTSNodeAttributeConstant.ATTRIBUTE_PRESS_SRC.equalsIgnoreCase(str)) {
            this.ptsOnPressSrc = PTSValueConvertUtil.getString(obj);
            return true;
        }
        return false;
    }

    protected boolean setContent(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this, (Object) str)).booleanValue();
        }
        return false;
    }

    public void setPTSAppInstance(PTSAppInstance pTSAppInstance) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) pTSAppInstance);
        } else if (pTSAppInstance != null) {
            this.mAppInstance = pTSAppInstance;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setParent(PTSNodeVirtual pTSNodeVirtual) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) pTSNodeVirtual);
        } else {
            this.mParent = pTSNodeVirtual;
        }
    }

    public void setReusable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            this.reusable = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean setStyle(String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Boolean) iPatchRedirector.redirect((short) 34, (Object) this, (Object) str, obj)).booleanValue();
        }
        if ("background-color".equalsIgnoreCase(str)) {
            this.backgroundColor = PTSValueConvertUtil.getColor(obj);
            return true;
        }
        if ("padding".equalsIgnoreCase(str)) {
            if (isContainer()) {
                return false;
            }
            this.padding = this.mNodeInfo.getStyle().getPadding();
            return true;
        }
        if (!PTSNodeStyleConstant.BACKGROUND_IMAGE.equalsIgnoreCase(str)) {
            return false;
        }
        this.backgroundImage = PTSValueConvertUtil.getString(obj);
        return true;
    }

    public void setViewID(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) str);
        } else {
            this.mViewID = str;
        }
    }

    public void showNode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
        } else {
            this.mView.setVisibility(0);
        }
    }

    private View initView(String str, String str2, Context context) {
        a nodeBuilder = PTSNodeFactory.getNodeBuilder(str, str2);
        if (nodeBuilder != null) {
            return nodeBuilder.buildNativeView(context, this);
        }
        PTSLog.e(this.TAG, "[initView] error, nodeType = " + str + ", customViewType = " + str2);
        return null;
    }

    private void bindExposeEvent() {
    }
}
