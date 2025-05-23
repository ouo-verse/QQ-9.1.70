package com.tencent.mobileqq.qqfloatingwindow.impl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager;
import com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper.FloatingVideoWrapper;
import com.tencent.mobileqq.qqfloatingwindow.listener.IFullScreenEnterListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;
import com.tencent.qphone.base.util.QLog;
import gh2.c;
import gh2.d;
import gh2.f;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class FloatingWrapperManagerImpl implements IFloatingWrapperManager {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "FloatingWrapperManagerImpl";
    private final Context mContext;
    private ImageView mFloatingCloseBtn;
    private FloatingScreenContainer mFloatingContainer;
    private FrameLayout mFloatingWidgetWrapper;
    private RelativeLayout mRootLayout;
    private FloatingScreenStatusReceiver mStatusReceiver;
    private d mWindowClickListener;

    public FloatingWrapperManagerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mContext = MobileQQ.sMobileQQ;
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void addRootLayoutToFloatingWidgetWrapper(ViewGroup.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this, (Object) layoutParams);
            return;
        }
        FrameLayout frameLayout = this.mFloatingWidgetWrapper;
        if (frameLayout != null) {
            frameLayout.addView(this.mRootLayout, layoutParams);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void addScreenStatusReceiver(int i3, f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, i3, (Object) fVar);
        } else if (this.mStatusReceiver == null) {
            FloatingScreenStatusReceiver floatingScreenStatusReceiver = new FloatingScreenStatusReceiver(this.mContext);
            this.mStatusReceiver = floatingScreenStatusReceiver;
            floatingScreenStatusReceiver.a(i3, fVar);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void addViewToFloatingWidgetWrapper(View view, ViewGroup.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, (Object) view, (Object) layoutParams);
            return;
        }
        FrameLayout frameLayout = this.mFloatingWidgetWrapper;
        if (frameLayout != null) {
            frameLayout.addView(view, layoutParams);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void changeContainerLayoutParams(boolean z16, int i3, int i16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z17));
            return;
        }
        FloatingScreenContainer floatingScreenContainer = this.mFloatingContainer;
        if (floatingScreenContainer != null) {
            floatingScreenContainer.g(z16, i3, i16, z17);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public boolean checkPermission(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            return ((Boolean) iPatchRedirector.redirect((short) 69, (Object) this, (Object) context)).booleanValue();
        }
        return FloatingScreenPermission.checkPermission(context);
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public int enterWindowFloat(FloatingScreenParams floatingScreenParams, View view, fh2.b bVar, fh2.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, this, floatingScreenParams, view, bVar, aVar)).intValue();
        }
        if (floatingScreenParams == null) {
            if (this.mContext == null) {
                return 2;
            }
            floatingScreenParams = new FloatingScreenParams.FloatingBuilder().setCanZoom(true).build();
        }
        if (bVar != null) {
            bVar.initWidgetWrapper(view);
            bVar.setRoundCorners(floatingScreenParams.getInnerRoundCorner(), floatingScreenParams.getOuterRoundCorner());
        }
        removeParent(this.mFloatingWidgetWrapper);
        this.mFloatingContainer.l(this.mFloatingWidgetWrapper, floatingScreenParams);
        if (bVar != null) {
            bVar.updateFloatingView();
        }
        if (aVar != null) {
            aVar.initStatusReceiver();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void enterWindowFloatWithWidgetWrapper(FloatingScreenParams floatingScreenParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, (Object) floatingScreenParams);
        } else {
            this.mFloatingContainer.l(this.mFloatingWidgetWrapper, floatingScreenParams);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void floatingContainerEnterFullScreen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, (Object) this);
            return;
        }
        FloatingScreenContainer floatingScreenContainer = this.mFloatingContainer;
        if (floatingScreenContainer != null) {
            floatingScreenContainer.j();
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void floatingContainerQuitFullScreen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, (Object) this);
            return;
        }
        FloatingScreenContainer floatingScreenContainer = this.mFloatingContainer;
        if (floatingScreenContainer != null) {
            floatingScreenContainer.D();
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public View getCloseView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return (View) iPatchRedirector.redirect((short) 49, (Object) this);
        }
        return this.mFloatingCloseBtn;
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public boolean getContainerIsFloating() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return ((Boolean) iPatchRedirector.redirect((short) 53, (Object) this)).booleanValue();
        }
        FloatingScreenContainer floatingScreenContainer = this.mFloatingContainer;
        if (floatingScreenContainer != null) {
            return floatingScreenContainer.s();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public boolean getContainerIsSmallFloating() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Boolean) iPatchRedirector.redirect((short) 42, (Object) this)).booleanValue();
        }
        FloatingScreenContainer floatingScreenContainer = this.mFloatingContainer;
        if (floatingScreenContainer != null) {
            return floatingScreenContainer.u();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public int getFloatWindowShapeType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.mFloatingContainer.w();
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public int getFloatingContainerCenterX() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return ((Integer) iPatchRedirector.redirect((short) 43, (Object) this)).intValue();
        }
        FloatingScreenContainer floatingScreenContainer = this.mFloatingContainer;
        if (floatingScreenContainer != null) {
            return floatingScreenContainer.q();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public int getFloatingContainerCenterY() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return ((Integer) iPatchRedirector.redirect((short) 44, (Object) this)).intValue();
        }
        FloatingScreenContainer floatingScreenContainer = this.mFloatingContainer;
        if (floatingScreenContainer != null) {
            return floatingScreenContainer.r();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public boolean getFloatingContainerIsNull() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Boolean) iPatchRedirector.redirect((short) 41, (Object) this)).booleanValue();
        }
        if (this.mFloatingContainer == null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public int getFloatingContainerVisibility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        FloatingScreenContainer floatingScreenContainer = this.mFloatingContainer;
        if (floatingScreenContainer != null) {
            return floatingScreenContainer.getVisibility();
        }
        return 8;
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public Context getFloatingContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (Context) iPatchRedirector.redirect((short) 37, (Object) this);
        }
        return this.mContext;
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public boolean getFloatingIsFullScreen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return ((Boolean) iPatchRedirector.redirect((short) 57, (Object) this)).booleanValue();
        }
        FloatingScreenContainer floatingScreenContainer = this.mFloatingContainer;
        if (floatingScreenContainer != null) {
            return floatingScreenContainer.t();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public String getFloatingVideoWrapperName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            return (String) iPatchRedirector.redirect((short) 68, (Object) this);
        }
        return FloatingVideoWrapper.CLASS_NAME;
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public boolean getIsInterceptWindowClick(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return ((Boolean) iPatchRedirector.redirect((short) 56, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        d dVar = this.mWindowClickListener;
        if (dVar == null) {
            return false;
        }
        return dVar.onEnterClick(i3, i16);
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public boolean getIsWindowClickListenerNull() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return ((Boolean) iPatchRedirector.redirect((short) 55, (Object) this)).booleanValue();
        }
        if (this.mWindowClickListener == null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public View getRootLayout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return (View) iPatchRedirector.redirect((short) 48, (Object) this);
        }
        return this.mRootLayout;
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public View getViewById(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (View) iPatchRedirector.redirect((short) 35, (Object) this, i3);
        }
        RelativeLayout relativeLayout = this.mRootLayout;
        if (relativeLayout != null) {
            return relativeLayout.findViewById(i3);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void initStatusReceiver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void initViews(Context context, View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) onClickListener);
            return;
        }
        if (context == null) {
            return;
        }
        FloatingScreenContainer floatingScreenContainer = new FloatingScreenContainer(context);
        this.mFloatingContainer = floatingScreenContainer;
        floatingScreenContainer.setBackgroundColor(context.getResources().getColor(R.color.ajr));
        FrameLayout frameLayout = new FrameLayout(context);
        this.mFloatingWidgetWrapper = frameLayout;
        frameLayout.setId(R.id.f166636m30);
        this.mFloatingWidgetWrapper.setBackgroundColor(context.getResources().getColor(R.color.ajr));
        RelativeLayout relativeLayout = (RelativeLayout) View.inflate(context, R.layout.cca, null);
        this.mRootLayout = relativeLayout;
        ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.m2n);
        this.mFloatingCloseBtn = imageView;
        imageView.setContentDescription(this.mContext.getResources().getString(R.string.f209595fu));
        setViewsClick(onClickListener, this.mRootLayout, this.mFloatingCloseBtn);
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void initWidgetWrapper(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) view);
            return;
        }
        this.mFloatingWidgetWrapper.removeAllViews();
        removeParent(view);
        view.setId(R.id.f166638m32);
        this.mFloatingWidgetWrapper.addView(view, new FrameLayout.LayoutParams(-1, -1));
        removeParent(this.mRootLayout);
        this.mFloatingWidgetWrapper.addView(this.mRootLayout, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public boolean isFloatWindowHasZoomed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.mFloatingContainer.y();
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void onViewClick(View view, fh2.b bVar) {
        d dVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) view, (Object) bVar);
            return;
        }
        int id5 = view.getId();
        if (id5 == R.id.m2n) {
            if (bVar != null) {
                bVar.quitWindowFloat(1);
            }
        } else if (id5 == R.id.m2t && (dVar = this.mWindowClickListener) != null) {
            dVar.onEnterClick(this.mFloatingContainer.q(), this.mFloatingContainer.r());
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void quitWindowFloat(int i3) {
        d dVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
            return;
        }
        if (i3 != 1 || (dVar = this.mWindowClickListener) == null || !dVar.onCloseClick()) {
            this.mWindowClickListener = null;
            FloatingScreenContainer floatingScreenContainer = this.mFloatingContainer;
            if (floatingScreenContainer != null && floatingScreenContainer.F()) {
                removeParent(this.mFloatingWidgetWrapper);
                FrameLayout frameLayout = this.mFloatingWidgetWrapper;
                if (frameLayout != null) {
                    frameLayout.removeAllViews();
                }
                setViewsVisibility(false, this.mFloatingCloseBtn);
                this.mWindowClickListener = null;
            }
            FloatingScreenStatusReceiver floatingScreenStatusReceiver = this.mStatusReceiver;
            if (floatingScreenStatusReceiver != null) {
                floatingScreenStatusReceiver.c();
                this.mStatusReceiver = null;
            }
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void removeFloatingWidgetWrapperViews() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this);
            return;
        }
        FrameLayout frameLayout = this.mFloatingWidgetWrapper;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void removeParent(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) view);
            return;
        }
        if (view != null) {
            try {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(view);
                }
            } catch (ClassCastException e16) {
                e16.printStackTrace();
            } catch (Exception e17) {
                e17.printStackTrace();
            }
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void removeRootLayoutParent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this);
        } else {
            removeParent(this.mRootLayout);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void removeWidgetWrapperParent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this);
        } else {
            removeParent(this.mFloatingWidgetWrapper);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void resetFloatWindowScale() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.mFloatingContainer.L();
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void resetWindowSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.mFloatingContainer.M();
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void restoreLastCenterPosition(FloatingScreenParams floatingScreenParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) floatingScreenParams);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void setCloseBtnContentDescription(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) str);
            return;
        }
        ImageView imageView = this.mFloatingCloseBtn;
        if (imageView != null) {
            imageView.setContentDescription("\u5173\u95ed\u4f4d\u7f6e\u5171\u4eab\u60ac\u6d6e\u7a97");
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void setContainerClipToOutline(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            iPatchRedirector.redirect((short) 65, (Object) this, z16);
            return;
        }
        FloatingScreenContainer floatingScreenContainer = this.mFloatingContainer;
        if (floatingScreenContainer != null) {
            floatingScreenContainer.setClipToOutline(z16);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public IVideoOuterStatusListener setDuplexVideoStatusListener(IVideoInnerStatusListener iVideoInnerStatusListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (IVideoOuterStatusListener) iPatchRedirector.redirect((short) 31, (Object) this, (Object) iVideoInnerStatusListener);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void setFloatingCloseBtnVisibility(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, z16);
        } else {
            setViewsVisibility(z16, this.mFloatingCloseBtn);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void setFloatingContainerBackPressListener(gh2.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, (Object) aVar);
            return;
        }
        FloatingScreenContainer floatingScreenContainer = this.mFloatingContainer;
        if (floatingScreenContainer != null) {
            floatingScreenContainer.setOnBackPressListener(aVar);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void setFloatingContainerBackground(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) drawable);
            return;
        }
        FloatingScreenContainer floatingScreenContainer = this.mFloatingContainer;
        if (floatingScreenContainer != null) {
            floatingScreenContainer.setBackgroundDrawable(drawable);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void setFloatingContainerBackgroundRes(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
            return;
        }
        FloatingScreenContainer floatingScreenContainer = this.mFloatingContainer;
        if (floatingScreenContainer != null) {
            floatingScreenContainer.setOutCornerBackgroundDrawable(i3);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void setFloatingContainerDragListener(gh2.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) bVar);
            return;
        }
        FloatingScreenContainer floatingScreenContainer = this.mFloatingContainer;
        if (floatingScreenContainer != null) {
            floatingScreenContainer.setOnDragListener(bVar);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void setFloatingContainerOrientation(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this, z16);
            return;
        }
        FloatingScreenContainer floatingScreenContainer = this.mFloatingContainer;
        if (floatingScreenContainer != null && floatingScreenContainer.s()) {
            this.mFloatingContainer.f(z16);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void setFloatingContainerPadding(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        FloatingScreenContainer floatingScreenContainer = this.mFloatingContainer;
        if (floatingScreenContainer != null) {
            floatingScreenContainer.setPadding(i3, i16, i17, i18);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void setFloatingContainerVisibility(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, z16);
        } else {
            setViewsVisibility(z16, this.mFloatingContainer);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void setFloatingWidgetBackground(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            iPatchRedirector.redirect((short) 67, (Object) this, (Object) drawable);
            return;
        }
        FrameLayout frameLayout = this.mFloatingWidgetWrapper;
        if (frameLayout != null) {
            frameLayout.setBackground(drawable);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void setFloatingWidgetClipToOutLine(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            iPatchRedirector.redirect((short) 66, (Object) this, z16);
            return;
        }
        FrameLayout frameLayout = this.mFloatingWidgetWrapper;
        if (frameLayout != null) {
            frameLayout.setClipToOutline(z16);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void setFullScreenEnterListener(IFullScreenEnterListener iFullScreenEnterListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) iFullScreenEnterListener);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void setFullScreenViewClickListener(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) cVar);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void setRootLayoutAlpha(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            iPatchRedirector.redirect((short) 61, this, Float.valueOf(f16));
            return;
        }
        RelativeLayout relativeLayout = this.mRootLayout;
        if (relativeLayout != null && relativeLayout.getAlpha() != f16) {
            this.mRootLayout.setAlpha(f16);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void setRootLayoutBackgroundColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, (Object) this, i3);
            return;
        }
        RelativeLayout relativeLayout = this.mRootLayout;
        if (relativeLayout != null) {
            relativeLayout.setBackgroundColor(i3);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void setRootLayoutBackgroundRes(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            iPatchRedirector.redirect((short) 63, (Object) this, i3);
            return;
        }
        RelativeLayout relativeLayout = this.mRootLayout;
        if (relativeLayout != null) {
            relativeLayout.setBackgroundResource(i3);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void setRootLayoutContentDescription(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            iPatchRedirector.redirect((short) 64, (Object) this, (Object) str);
            return;
        }
        RelativeLayout relativeLayout = this.mRootLayout;
        if (relativeLayout != null) {
            relativeLayout.setContentDescription(str);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void setRootLayoutVisible() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, (Object) this);
            return;
        }
        RelativeLayout relativeLayout = this.mRootLayout;
        if (relativeLayout != null && relativeLayout.getVisibility() != 0) {
            this.mRootLayout.setVisibility(0);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void setRoundCorners(int i3, int i16) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        FloatingScreenContainer floatingScreenContainer = this.mFloatingContainer;
        if (floatingScreenContainer != null) {
            floatingScreenContainer.setOutlineProvider(new a(i16));
            this.mFloatingContainer.setClipToOutline(true);
            if (i16 > 0) {
                this.mFloatingContainer.setElevation(15.0f);
                this.mFloatingContainer.setBackground(this.mContext.getResources().getDrawable(this.mFloatingContainer.v()));
            }
            FrameLayout frameLayout = (FrameLayout) this.mFloatingContainer.findViewById(R.id.m2z);
            if (frameLayout != null) {
                frameLayout.setOutlineProvider(new a(i3));
                frameLayout.setClipToOutline(true);
            }
            View findViewById = this.mFloatingContainer.findViewById(R.id.f166638m32);
            if (findViewById != null) {
                findViewById.setOutlineProvider(new a(i3));
                findViewById.setClipToOutline(true);
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("setRoundCorners() videoCoverContainer == null: ");
                if (frameLayout == null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb5.append(z16);
                sb5.append(" customView == null: ");
                if (findViewById == null) {
                    z17 = true;
                }
                sb5.append(z17);
                QLog.d(TAG, 2, sb5.toString());
            }
        }
        FrameLayout frameLayout2 = this.mFloatingWidgetWrapper;
        if (frameLayout2 != null) {
            frameLayout2.setOutlineProvider(new a(i3));
            this.mFloatingWidgetWrapper.setClipToOutline(true);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setRoundCorners() innerRoundCorners = " + i3 + " outerRoundCorners = " + i16);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void setVideoWrapperBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this);
            return;
        }
        if (this.mRootLayout != null) {
            FloatingScreenContainer floatingScreenContainer = this.mFloatingContainer;
            if (floatingScreenContainer != null && floatingScreenContainer.t()) {
                this.mRootLayout.setBackgroundResource(R.drawable.hvu);
                return;
            }
            Context context = this.mContext;
            if (context != null && context.getResources() != null) {
                this.mRootLayout.setBackgroundColor(this.mContext.getResources().getColor(R.color.ajr));
            }
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void setViewEnabled(boolean z16, View... viewArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, Boolean.valueOf(z16), viewArr);
            return;
        }
        if (viewArr == null) {
            return;
        }
        for (View view : viewArr) {
            if (view != null) {
                view.setEnabled(z16);
            }
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void setViewsClick(View.OnClickListener onClickListener, View... viewArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) onClickListener, (Object) viewArr);
            return;
        }
        if (viewArr == null) {
            return;
        }
        for (View view : viewArr) {
            if (view != null) {
                view.setOnClickListener(onClickListener);
            }
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void setViewsVisibility(boolean z16, View... viewArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Boolean.valueOf(z16), viewArr);
            return;
        }
        if (viewArr == null) {
            return;
        }
        for (View view : viewArr) {
            if (view != null) {
                if (z16) {
                    view.setVisibility(0);
                } else {
                    view.setVisibility(4);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void setWindowClickListener(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) dVar);
        } else {
            this.mWindowClickListener = dVar;
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void updateFloatingView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            setViewsVisibility(true, this.mFloatingContainer, this.mFloatingCloseBtn);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void updateLocation(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.mFloatingContainer.W(i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void updateRatio(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16));
        } else {
            this.mFloatingContainer.Y(f16);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void updateShapeType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.mFloatingContainer.Z(i3);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager
    public void updateSize(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.mFloatingContainer.a0(i3, i16);
        }
    }
}
