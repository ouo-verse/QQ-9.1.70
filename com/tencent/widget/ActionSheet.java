package com.tencent.widget;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.IdRes;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.proxy.feedcomponent.model.CellDynamicAlbum;
import com.tencent.common.config.AppSetting;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import com.tencent.mobileqq.widget.az;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.QViewImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ActionSheet extends ReportDialog {
    static IPatchRedirector $redirector_ = null;
    public static final int BLUE_BOLD_STYLE_BTN = 6;
    public static final int BLUE_STYLE_BTN = 5;
    public static final int CUSTOM_TEXT_COLOR_BTN = 9;
    private static final ae0.a DEFAULT_COLOR_PALETTE;
    public static final int DEFAULT_STYLE_BTN = 0;
    public static final int DEFAULT_TWO_LINES_STYLE_BTN = 65537;
    public static final int GRAY_STYLE_BTN = 7;

    @Deprecated
    public static final int GREEN_STYLE_BTN = 2;

    @Deprecated
    public static final int GREY_STYLE_BTN = 4;
    public static final String ICON_PREFIX = "icon";
    public static final int REAL_BLUE_STYLE_BTN = 8;
    public static final int RED_STYLE_BTN = 3;
    public static final int SELECTOR_TYPE_BG = 0;
    public static final int SELECTOR_TYPE_BG_NIGHT_MODE = 3;
    public static final int SELECTOR_TYPE_BOTTOM_RADIUS_REAL = 4;
    public static final int SELECTOR_TYPE_TOP = 1;
    public static final int SELECTOR_TYPE_TOP_NIGHT_MODE = 2;
    public static final int STYLE_BTN_LEFT_URL_ICON = 10;
    public static final int STYLE_DIVIDER = 12;
    public static final int STYPE_BTN_PUBLIC_ACCOUNT_TITLE = 11;
    public static final int STYPE_BTN_TOP_MSG_CANNOT_HIDE_TITLE = 13;
    public static final String TAG = "ActionSheet";
    private static final int TEXT_COLOR_MASK = 65535;

    @Deprecated
    public static final int WHITE_STYLE_BTN = 1;
    public static final int WHITE_STYPE_BTN = 10;
    private TranslateAnimation animation;
    private int mAccuseIconColor;
    private int mAccuseText;
    private HashMap<CharSequence, ActionMenuItem> mActionMenuMap;
    private RelativeLayout mActionView;
    private int mAnimationTime;
    private View.OnClickListener mBtnClickListener;
    private OnButtonClickListener mButtonsListener;
    private OnButtonClickListenerV2 mButtonsListenerV2;
    private CharSequence mCancelText;
    private boolean mCloseAutoRead;
    public LinearLayout mContentContainer;
    private ArrayList<Pair<CharSequence, Integer>> mContents;
    private Context mContext;
    private int mCurrentSelectedViewId;
    private int mCustomItemHeight;
    public View.OnClickListener mDefaultDismissListener;
    private boolean mDismissFinish;
    private OnDismissListener mDismissListener;
    private Map<Integer, URLDrawable> mFetchDrawableMap;
    private Map<Integer, OnTextImageFetchedListener> mFetchListenerMap;
    private boolean mForceDayMode;
    private boolean mForceNightMode;
    private Handler mHandler;
    private HashMap<Integer, Drawable> mIconsLeftMap;
    private HashMap<Integer, Drawable> mIconsMap;
    private List<Integer> mIds;
    private LayoutInflater mInflater;
    private boolean mIsMenuMode;
    public boolean mIsReady;
    private boolean mIsRoundCornerTop;
    private boolean mIsSupportNightMode;
    private int mLastScreenWidth;
    private CharSequence mMainTitle;
    private int mMainTitleColor;
    private onPreShowListener mOnPreShowListener;
    private g mOnWidthChangedListener;
    private OrientationEventListener mOrientationEventListener;
    private SparseArray<View> mRadioButtonMap;
    private boolean mRadioGroupMode;
    protected Resources mResources;
    private ViewGroup mRootView;
    private SparseArray<Integer> mSubTextColorArray;
    protected boolean mSupportBottomRadius;
    private HashMap<Integer, String> mTextColorMap;
    private HashSet<Integer> mUncheckeable;
    public Object mUserData;
    private WatchDismissActions mWatchDismissListener;
    private TextView mainTitleText;
    private View.OnClickListener onBottomAccuseListener;
    private View.OnClickListener onBottomCancelListener;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class ItemViewHolder {
        static IPatchRedirector $redirector_;
        public ImageView iconIv;
        public TextView titleTv;

        public ItemViewHolder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnButtonClickListener {
        void onClick(View view, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnButtonClickListenerV2 {
        void OnClick(View view, int i3, String str);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnDismissListener {
        void onDismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnTextImageFetchedListener {
        void onFetched(CharSequence charSequence);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface WatchDismissActions {
        void onDismissOperations();
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ActionSheet.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TextView textView;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                int id5 = view.getId();
                if (ActionSheet.this.mRadioGroupMode && ((ActionSheet.this.mUncheckeable == null || !ActionSheet.this.mUncheckeable.contains(Integer.valueOf(id5))) && ActionSheet.this.mCurrentSelectedViewId != -1 && id5 != ActionSheet.this.mCurrentSelectedViewId)) {
                    View view2 = (View) ActionSheet.this.mRadioButtonMap.get(ActionSheet.this.mCurrentSelectedViewId);
                    view2.findViewById(R.id.f163929cr).setVisibility(8);
                    ActionSheet.this.updateRadioGroupButtonDesc((TextView) view2.findViewById(R.id.action_sheet_button), false);
                    View view3 = (View) ActionSheet.this.mRadioButtonMap.get(id5);
                    view3.findViewById(R.id.f163929cr).setVisibility(0);
                    ActionSheet.this.updateRadioGroupButtonDesc((TextView) view3.findViewById(R.id.action_sheet_button), true);
                    ActionSheet.this.mCurrentSelectedViewId = id5;
                }
                if (ActionSheet.this.mButtonsListener != null) {
                    ActionSheet.this.mButtonsListener.onClick(view, id5);
                }
                if (ActionSheet.this.mButtonsListenerV2 != null && (textView = (TextView) view.findViewById(R.id.action_sheet_button)) != null) {
                    ActionSheet.this.mButtonsListenerV2.OnClick(view, id5, textView.getText().toString());
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ActionSheet.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ActionSheet.this.dismiss();
                if (ActionSheet.this.mDismissListener != null) {
                    ActionSheet.this.mDismissListener.onDismiss();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    class c implements ae0.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // ae0.a
        public int[] getColor(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return ActionSheet.getDefaultColorsByToken(str, false);
            }
            return (int[]) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    class d extends OrientationEventListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f384524a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Context context, Context context2) {
            super(context);
            this.f384524a = context2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ActionSheet.this, context, context2);
            }
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            int i16 = this.f384524a.getResources().getDisplayMetrics().widthPixels;
            if (i16 != ActionSheet.this.mLastScreenWidth) {
                ActionSheet.this.mLastScreenWidth = i16;
                ActionSheet.this.padAndFoldCompat(this.f384524a);
                if (ActionSheet.this.mOnWidthChangedListener != null) {
                    ActionSheet.this.mOnWidthChangedListener.b0(i16);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class e implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ActionSheet.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class f implements URLDrawable.DownloadListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ActionSheet.this);
            }
        }

        @Override // com.tencent.image.URLDrawable.DownloadListener
        public void onFileDownloadFailed(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
                return;
            }
            QLog.i("ActionSheet", 1, "onFileDownloadFailed " + i3);
        }

        @Override // com.tencent.image.URLDrawable.DownloadListener
        public void onFileDownloadStarted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                QLog.i("ActionSheet", 1, "onFileDownloadStarted");
            }
        }

        @Override // com.tencent.image.URLDrawable.DownloadListener
        public void onFileDownloadSucceed(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, j3);
                return;
            }
            QLog.i("ActionSheet", 1, "onFileDownloadSucceed " + j3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface g {
        void b0(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface onPreShowListener {
        void onPreShow();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38267);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 97)) {
            redirector.redirect((short) 97);
        } else {
            DEFAULT_COLOR_PALETTE = new c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ActionSheet(Context context) {
        this(context, false, false);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CharSequence buildLeftUrlIconCharSequence(CharSequence charSequence, Drawable drawable) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("icon" + ((Object) charSequence));
        drawable.setBounds(0, 0, az.a(getContext(), 20.0f), az.a(getContext(), 20.0f));
        VerticalCenterImageSpan verticalCenterImageSpan = new VerticalCenterImageSpan(drawable, 0);
        verticalCenterImageSpan.setPadding(az.a(getContext(), 6.5f), az.a(getContext(), 6.5f));
        spannableStringBuilder.setSpan(verticalCenterImageSpan, 0, 4, 18);
        return spannableStringBuilder;
    }

    public static ActionSheet create(Context context) {
        ActionSheet actionSheet = new ActionSheet(context, false, false);
        if (Build.VERSION.SDK_INT != 23) {
            actionSheet.getWindow().setWindowAnimations(R.style.f173293c);
        }
        return actionSheet;
    }

    public static ActionSheet createFullScreenDialog(Context context) {
        ActionSheet actionSheet = new ActionSheet(context, false, true);
        if (Build.VERSION.SDK_INT != 23) {
            actionSheet.getWindow().setWindowAnimations(R.style.f173293c);
        }
        return actionSheet;
    }

    public static ActionSheet createFullScreenMenuSheet(Context context) {
        ActionSheet actionSheet = new ActionSheet(context, true, true);
        if (Build.VERSION.SDK_INT != 23) {
            actionSheet.getWindow().setWindowAnimations(R.style.f173293c);
        }
        return actionSheet;
    }

    public static ActionSheet createMenuSheet(Context context) {
        ActionSheet actionSheet = new ActionSheet(context, true, false);
        if (Build.VERSION.SDK_INT != 23) {
            actionSheet.getWindow().setWindowAnimations(R.style.f173293c);
        }
        return actionSheet;
    }

    public static boolean enablePadAndFoldCompat(Context context) {
        if (context == null) {
            return false;
        }
        return AppSetting.o(context);
    }

    private int getDayColor(int i3) {
        return ie0.a.f().g(BaseApplication.context, i3, 1001);
    }

    private ColorStateList getDayColorStateList(int i3) {
        return ie0.a.f().h(this.mContext, i3, 1001);
    }

    private Drawable getDayDrawable(Drawable drawable) {
        ae0.a aVar = DEFAULT_COLOR_PALETTE;
        return new ce0.e(new ce0.a(aVar), aVar).g(this.mContext, drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int[] getDefaultColorsByToken(String str, boolean z16) {
        String[] j3;
        if (str != null && (j3 = ie0.a.f().j(BaseApplication.getContext(), removeSuffix(str), z16)) != null && j3.length != 0) {
            try {
                int[] iArr = new int[j3.length];
                for (int i3 = 0; i3 < j3.length; i3++) {
                    iArr[i3] = Color.parseColor(j3[i3]);
                }
                return iArr;
            } catch (Exception e16) {
                QLog.e("ActionSheet", 1, "getDefaultColorsByToken exception", e16);
            }
        }
        return null;
    }

    private void handleLeftUrlButtonStyle(Pair<CharSequence, Integer> pair, TextView textView) {
        Object obj;
        URLDrawable uRLDrawable;
        if (pair != null && textView != null && ((Integer) pair.second).intValue() == 10 && (obj = pair.first) != null) {
            setOnTextImageFetched((CharSequence) obj, new OnTextImageFetchedListener(textView) { // from class: com.tencent.widget.ActionSheet.3
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ TextView f384509a;

                {
                    this.f384509a = textView;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ActionSheet.this, (Object) textView);
                    }
                }

                @Override // com.tencent.widget.ActionSheet.OnTextImageFetchedListener
                public void onFetched(CharSequence charSequence) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) charSequence);
                    } else {
                        ActionSheet.this.mHandler.post(new Runnable(charSequence) { // from class: com.tencent.widget.ActionSheet.3.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ CharSequence f384511d;

                            {
                                this.f384511d = charSequence;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this, (Object) charSequence);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                } else {
                                    AnonymousClass3.this.f384509a.setText(this.f384511d);
                                }
                            }
                        });
                    }
                }
            });
            if (this.mFetchDrawableMap.containsKey(Integer.valueOf(((CharSequence) pair.first).hashCode())) && (uRLDrawable = this.mFetchDrawableMap.get(Integer.valueOf(((CharSequence) pair.first).hashCode()))) != null) {
                QLog.i("ActionSheet", 1, "prepareContentViews " + uRLDrawable);
                if (uRLDrawable.getStatus() == 1) {
                    textView.setText(buildLeftUrlIconCharSequence((CharSequence) pair.first, uRLDrawable));
                } else {
                    handleLeftUrlDrawable(uRLDrawable, pair, textView);
                }
            }
        }
    }

    private void handleLeftUrlDrawable(URLDrawable uRLDrawable, Pair<CharSequence, Integer> pair, TextView textView) {
        if (uRLDrawable != null && pair != null && textView != null) {
            uRLDrawable.setURLDrawableListener(new URLDrawable.URLDrawableListener(textView, pair) { // from class: com.tencent.widget.ActionSheet.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ TextView f384513d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ Pair f384514e;

                {
                    this.f384513d = textView;
                    this.f384514e = pair;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, ActionSheet.this, textView, pair);
                    }
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadCanceled(URLDrawable uRLDrawable2) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        iPatchRedirector.redirect((short) 4, (Object) this, (Object) uRLDrawable2);
                    } else {
                        QLog.i("ActionSheet", 1, "onLoadCanceled");
                    }
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadFialed(URLDrawable uRLDrawable2, Throwable th5) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this, (Object) uRLDrawable2, (Object) th5);
                    } else {
                        QLog.i("ActionSheet", 1, "onLoadFialed ", th5);
                    }
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadProgressed(URLDrawable uRLDrawable2, int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                        iPatchRedirector.redirect((short) 5, (Object) this, (Object) uRLDrawable2, i3);
                        return;
                    }
                    QLog.i("ActionSheet", 1, "onLoadProgressed " + i3);
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadSuccessed(URLDrawable uRLDrawable2) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) uRLDrawable2);
                        return;
                    }
                    try {
                        QLog.i("ActionSheet", 1, "onLoadSuccessed " + uRLDrawable2);
                        if (uRLDrawable2 != null) {
                            ActionSheet.this.mHandler.post(new Runnable(uRLDrawable2) { // from class: com.tencent.widget.ActionSheet.4.1
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ URLDrawable f384516d;

                                {
                                    this.f384516d = uRLDrawable2;
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this, (Object) uRLDrawable2);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                        iPatchRedirector2.redirect((short) 2, (Object) this);
                                    } else {
                                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                        anonymousClass4.f384513d.setText(ActionSheet.this.buildLeftUrlIconCharSequence((CharSequence) anonymousClass4.f384514e.first, this.f384516d));
                                    }
                                }
                            });
                        }
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
            });
            uRLDrawable.setDownloadListener(new f());
            ThreadManagerV2.executeOnSubThread(new Runnable(uRLDrawable) { // from class: com.tencent.widget.ActionSheet.6
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ URLDrawable f384518d;

                {
                    this.f384518d = uRLDrawable;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ActionSheet.this, (Object) uRLDrawable);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        this.f384518d.startDownload();
                    }
                }
            });
        }
    }

    private void handlePublicAccountButtonStyle(Pair<CharSequence, Integer> pair, TextView textView) {
        if (pair != null && textView != null && ((Integer) pair.second).intValue() == 11) {
            textView.setTextSize(12.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void padAndFoldCompat(Context context) {
        if (enablePadAndFoldCompat(context)) {
            setPadAndFoldCompat(this.mActionView);
        } else {
            unsetPadAndFoldCompat(this.mActionView);
        }
    }

    private void prepareButtonViews() {
        View inflate;
        TextView textView;
        ArrayList<Pair<CharSequence, Integer>> arrayList = this.mContents;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        if (size != this.mIds.size() && this.mIds.size() != 0) {
            throw new IllegalArgumentException("buttons size and custom ids size not match");
        }
        for (int i3 = 0; i3 < size; i3++) {
            Pair<CharSequence, Integer> pair = this.mContents.get(i3);
            if (((Integer) pair.second).intValue() == 12) {
                prepareContentViewsAddDivider();
            } else {
                if (((Integer) pair.second).intValue() == 65537) {
                    inflate = this.mInflater.inflate(getActionSheetCommonButtonLayoutId(), (ViewGroup) this.mContentContainer, false);
                    textView = (TextView) inflate.findViewById(R.id.action_sheet_button);
                    TextView textView2 = (TextView) inflate.findViewById(R.id.j7y);
                    String charSequence = ((CharSequence) pair.first).toString();
                    int indexOf = charSequence.indexOf(10);
                    if (indexOf >= 0 && indexOf < ((CharSequence) pair.first).length()) {
                        textView.setText(charSequence.substring(0, indexOf));
                        textView2.setText(charSequence.substring(indexOf + 1));
                        inflate.findViewById(R.id.amr).setContentDescription(textView.getText());
                    } else {
                        textView.setText((CharSequence) pair.first);
                    }
                    Integer num = this.mSubTextColorArray.get(i3);
                    if (num != null) {
                        textView2.setTextColor(num.intValue());
                    }
                    AccessibilityUtil.d(inflate.findViewById(R.id.amr), LinearLayout.class.getName());
                } else {
                    inflate = this.mInflater.inflate(R.layout.dq9, (ViewGroup) this.mContentContainer, false);
                    textView = (TextView) inflate.findViewById(R.id.action_sheet_button);
                    textView.setText((CharSequence) pair.first);
                    AccessibilityUtil.d(textView, Button.class.getName());
                    if (((Integer) pair.second).intValue() == 11) {
                        handlePublicAccountButtonStyle(pair, textView);
                    } else if (((Integer) pair.second).intValue() == 10) {
                        handleLeftUrlButtonStyle(pair, textView);
                    }
                }
                prepareContentViewsSetTextViewId(pair, textView);
                prepareContentViewsDealIconImgs(i3, inflate);
                prepareContentViewsSetTextColor(i3, pair, textView);
                prepareContentViewsSetBackground(i3, inflate);
                prepareContentViewSetViewId(i3, inflate);
                prepareContentViesDealRadioButton(i3, inflate, textView);
                setItemHeight(inflate);
                inflate.setOnClickListener(this.mBtnClickListener);
                this.mContentContainer.addView(inflate);
            }
        }
    }

    private void prepareCancelButtonView() {
        if (this.mCancelText == null) {
            return;
        }
        View inflate = this.mInflater.inflate(getActionSheetCancelButtonLayoutId(), (ViewGroup) this.mContentContainer, false);
        if (this.mAccuseText != 0) {
            Button button = (Button) inflate.findViewById(R.id.s_1);
            button.setVisibility(0);
            button.setText(this.mAccuseText);
            button.setTextColor(this.mAccuseIconColor);
            button.setContentDescription(this.mCancelText);
            View.OnClickListener onClickListener = this.onBottomAccuseListener;
            if (onClickListener != null) {
                button.setOnClickListener(onClickListener);
            }
            setItemHeight(button);
        }
        Button button2 = (Button) inflate.findViewById(R.id.action_sheet_btnCancel);
        button2.setOnClickListener(this.onBottomCancelListener);
        button2.setText(this.mCancelText);
        button2.setTextColor(this.mResources.getColorStateList(R.color.qui_common_text_primary));
        button2.setContentDescription(this.mCancelText);
        setItemHeight(button2);
        View findViewById = inflate.findViewById(R.id.s_4);
        if (this.mForceNightMode) {
            button2.setBackground(this.mResources.getDrawable(R.drawable.j2m));
            button2.setTextColor(this.mContext.getResources().getColorStateList(R.color.f158017al3));
            findViewById.setBackgroundColor(this.mContext.getResources().getColor(R.color.b95));
        }
        this.mContentContainer.addView(inflate);
        if (this.mForceDayMode) {
            button2.setTextColor(getDayColorStateList(R.color.qui_common_text_primary));
            button2.setBackground(getDayDrawable(button2.getBackground()));
            findViewById.setBackground(getDayDrawable(findViewById.getBackground()));
        }
    }

    private void prepareContentViesDealRadioButton(int i3, View view, TextView textView) {
        if (this.mRadioGroupMode) {
            if (this.mRadioButtonMap == null) {
                this.mRadioButtonMap = new SparseArray<>();
            }
            this.mRadioButtonMap.append(i3, view);
            if (i3 == this.mCurrentSelectedViewId) {
                view.findViewById(R.id.f163929cr).setVisibility(0);
                updateRadioGroupButtonDesc(textView, true);
            } else {
                updateRadioGroupButtonDesc(textView, false);
            }
        }
    }

    private void prepareContentViewSetViewId(int i3, View view) {
        if (i3 < this.mIds.size()) {
            view.setId(this.mIds.get(i3).intValue());
        } else {
            view.setId(i3);
        }
    }

    private void prepareContentViews() {
        if (this.mIsReady) {
            return;
        }
        prepareTitleView();
        prepareButtonViews();
        prepareCancelButtonView();
        this.mIsReady = true;
    }

    private void prepareContentViewsAddDivider() {
        View view = new View(this.mContext);
        view.setBackgroundColor(this.mContext.getResources().getColor(R.color.qui_common_bg_middle_standard));
        this.mContentContainer.addView(view, new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(R.dimen.f158529i0)));
        if (this.mForceDayMode) {
            view.setBackgroundColor(getDayColor(R.color.qui_common_bg_middle_standard));
        }
    }

    private void prepareContentViewsDealIconImgs(int i3, View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.f163938d1);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.rightMargin = az.a(this.mContext, 15.0f);
        imageView.setLayoutParams(layoutParams);
        if (this.mIconsMap.containsKey(Integer.valueOf(i3))) {
            imageView.setVisibility(0);
            imageView.setImageDrawable(this.mIconsMap.get(Integer.valueOf(i3)));
        } else {
            imageView.setImageDrawable(null);
            imageView.setVisibility(8);
        }
        ImageView imageView2 = (ImageView) view.findViewById(R.id.f163939d2);
        if (this.mIconsLeftMap.containsKey(Integer.valueOf(i3))) {
            imageView2.setVisibility(0);
            imageView2.setImageDrawable(this.mIconsLeftMap.get(Integer.valueOf(i3)));
        } else {
            imageView2.setImageDrawable(null);
            imageView2.setVisibility(8);
        }
    }

    private void prepareContentViewsSetBackground(int i3, View view) {
        if (this.mForceNightMode) {
            view.setBackground(this.mResources.getDrawable(R.drawable.j2m));
        }
        setContentViewBackground(i3, view);
    }

    private void prepareContentViewsSetTextColor(int i3, Pair<CharSequence, Integer> pair, TextView textView) {
        if (this.mForceNightMode) {
            textView.setTextColor(getActionButtonColorByType(10));
        } else {
            if (((Integer) pair.second).intValue() == 9) {
                if (this.mTextColorMap.containsKey(Integer.valueOf(i3))) {
                    textView.setTextColor(Color.parseColor(this.mTextColorMap.get(Integer.valueOf(i3))));
                    return;
                }
                return;
            }
            textView.setTextColor(getActionButtonColorByType(((Integer) pair.second).intValue()));
        }
    }

    private void prepareContentViewsSetTextViewId(Pair<CharSequence, Integer> pair, TextView textView) {
        ActionMenuItem actionMenuItem;
        int i3;
        HashMap<CharSequence, ActionMenuItem> hashMap = this.mActionMenuMap;
        if (hashMap != null && hashMap.size() > 0 && (actionMenuItem = this.mActionMenuMap.get(pair.first)) != null && (i3 = actionMenuItem.viewid) != 0) {
            textView.setId(i3);
        }
    }

    private static String removeSuffix(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf > 0 && lastIndexOf < str.length()) {
            return str.substring(0, lastIndexOf);
        }
        return str;
    }

    private void setContentViewBackground(int i3, View view) {
        if (this.mMainTitle == null && i3 == 0) {
            view.setBackground(getSelectorByType(1));
        } else {
            view.setBackground(getSelectorByType(0));
        }
        if (this.mForceDayMode) {
            view.setBackground(getDayDrawable(view.getBackground()));
        }
    }

    private void setItemHeight(View view) {
        if (this.mCustomItemHeight > 0 && view.getLayoutParams() != null) {
            view.getLayoutParams().height = this.mCustomItemHeight;
        }
    }

    private void setOnTextImageFetched(CharSequence charSequence, OnTextImageFetchedListener onTextImageFetchedListener) {
        if (charSequence != null && onTextImageFetchedListener != null) {
            this.mFetchListenerMap.put(Integer.valueOf(charSequence.hashCode()), onTextImageFetchedListener);
        }
    }

    private static void setPadAndFoldCompat(View view) {
        BaseApplication context = BaseApplication.getContext();
        if (context.getResources().getDisplayMetrics().widthPixels <= x.c(context, 600.0f)) {
            unsetPadAndFoldCompat(view);
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = x.c(context, 360.0f);
        view.setLayoutParams(layoutParams);
    }

    private static void unsetPadAndFoldCompat(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = -1;
        view.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRadioGroupButtonDesc(TextView textView, boolean z16) {
        if (textView != null && textView.getText() != null) {
            AccessibilityUtil.x(textView, textView.getText().toString(), z16, Button.class.getName());
        }
    }

    public void addButton(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 28)) {
            addButton(this.mResources.getText(i3), 0);
        } else {
            iPatchRedirector.redirect((short) 28, (Object) this, i3);
        }
    }

    public void addButtonWithIcon(CharSequence charSequence, Drawable drawable, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 86)) {
            iPatchRedirector.redirect((short) 86, this, charSequence, drawable, Integer.valueOf(i3));
            return;
        }
        if (this.mContents == null) {
            this.mContents = new ArrayList<>();
        }
        Pair<CharSequence, Integer> pair = new Pair<>(charSequence, Integer.valueOf(i3));
        if (!this.mContents.contains(pair)) {
            this.mContents.add(pair);
        }
        this.mIconsMap.put(Integer.valueOf(this.mContents.size() - 1), drawable);
    }

    public void addButtonWithLeftIcon(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 87)) {
            iPatchRedirector.redirect((short) 87, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (this.mContents == null) {
            this.mContents = new ArrayList<>();
        }
        Drawable drawable = this.mResources.getDrawable(i3);
        if (drawable == null) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("icon" + str);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        VerticalCenterImageSpan verticalCenterImageSpan = new VerticalCenterImageSpan(drawable, 0);
        verticalCenterImageSpan.setPadding(0, az.a(getContext(), 10.0f));
        spannableStringBuilder.setSpan(verticalCenterImageSpan, 0, 4, 18);
        Pair<CharSequence, Integer> pair = new Pair<>(spannableStringBuilder, Integer.valueOf(i16));
        if (this.mContents.contains(pair)) {
            return;
        }
        this.mContents.add(pair);
    }

    public void addButtonWithLeftUrlIcon(String str, String str2) {
        Pair<CharSequence, Integer> pair;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 89)) {
            iPatchRedirector.redirect((short) 89, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (str2 == null) {
            return;
        }
        if (this.mContents == null) {
            this.mContents = new ArrayList<>();
        }
        ColorDrawable colorDrawable = new ColorDrawable(0);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mFailedDrawable = colorDrawable;
        obtain.mLoadingDrawable = colorDrawable;
        obtain.mUseAutoScaleParams = false;
        URLDrawable drawable = URLDrawable.getDrawable(str2, obtain);
        if (drawable != null) {
            ThreadManagerV2.executeOnSubThread(new Runnable(drawable) { // from class: com.tencent.widget.ActionSheet.12
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ URLDrawable f384508d;

                {
                    this.f384508d = drawable;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ActionSheet.this, (Object) drawable);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        this.f384508d.startDownload();
                    }
                }
            });
        }
        if (drawable != null && drawable.getStatus() == 1) {
            pair = new Pair<>(buildLeftUrlIconCharSequence(str, drawable), 10);
        } else {
            pair = new Pair<>(str, 10);
            if (drawable != null) {
                this.mFetchDrawableMap.put(Integer.valueOf(str.hashCode()), drawable);
            }
        }
        if (!this.mContents.contains(pair)) {
            this.mContents.add(pair);
        }
    }

    public void addButtonWithRightIcon(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 90)) {
            iPatchRedirector.redirect((short) 90, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (this.mContents == null) {
            this.mContents = new ArrayList<>();
        }
        Drawable drawable = this.mResources.getDrawable(i3);
        if (drawable == null) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + "icon");
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        VerticalCenterImageSpan verticalCenterImageSpan = new VerticalCenterImageSpan(drawable, 0);
        verticalCenterImageSpan.setPadding(az.a(getContext(), 10.0f), 0);
        spannableStringBuilder.setSpan(verticalCenterImageSpan, str.length(), spannableStringBuilder.length(), 18);
        Pair<CharSequence, Integer> pair = new Pair<>(spannableStringBuilder, Integer.valueOf(i16));
        if (!this.mContents.contains(pair)) {
            this.mContents.add(pair);
        }
    }

    public void addCancelButton(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 51)) {
            addCancelButton(this.mResources.getText(i3));
        } else {
            iPatchRedirector.redirect((short) 51, (Object) this, i3);
        }
    }

    public void addDivider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this);
        } else {
            this.mIds.add(Integer.valueOf(R.id.biw));
            this.mContents.add(new Pair<>("", 12));
        }
    }

    public void addRadioButton(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 55)) {
            addRadioButton(i3, 0, z16);
        } else {
            iPatchRedirector.redirect((short) 55, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
    }

    public void addView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this, (Object) view);
        } else {
            this.mContentContainer.addView(view);
        }
    }

    public void addViewCustomeTitle(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this, (Object) view);
        } else {
            this.mContentContainer.addView(view);
        }
    }

    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this);
            return;
        }
        this.mIsReady = false;
        this.mContents.clear();
        this.mActionMenuMap.clear();
        this.mIconsMap.clear();
        this.mIconsLeftMap.clear();
        this.mTextColorMap.clear();
        this.mActionView.removeAllViews();
        OrientationEventListener orientationEventListener = this.mOrientationEventListener;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
    }

    public void clearAllRadioBtnCheckStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            iPatchRedirector.redirect((short) 61, (Object) this);
            return;
        }
        this.mCurrentSelectedViewId = -1;
        SparseArray<View> sparseArray = this.mRadioButtonMap;
        if (sparseArray == null) {
            return;
        }
        int size = sparseArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            View valueAt = this.mRadioButtonMap.valueAt(i3);
            if (valueAt != null) {
                valueAt.findViewById(R.id.f163929cr).setVisibility(8);
                updateRadioGroupButtonDesc((TextView) valueAt.findViewById(R.id.action_sheet_button), false);
            }
        }
    }

    public void clearMainTitle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this);
            return;
        }
        this.mIsReady = false;
        this.mIds.clear();
        this.mContentContainer.removeAllViews();
        QLog.d("ActionSheet", 1, "cleatMainTitle is done");
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            iPatchRedirector.redirect((short) 77, (Object) this);
        } else {
            dismissWithAnimationToken(0);
        }
    }

    public void dismissWithAnimationToken(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            iPatchRedirector.redirect((short) 78, (Object) this, i3);
            return;
        }
        WatchDismissActions watchDismissActions = this.mWatchDismissListener;
        if (watchDismissActions != null) {
            watchDismissActions.onDismissOperations();
        }
        if (this.mDismissFinish) {
            this.mDismissFinish = false;
            this.mHandler.postDelayed(new Runnable(i3) { // from class: com.tencent.widget.ActionSheet.9
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f384520d;

                /* compiled from: P */
                /* renamed from: com.tencent.widget.ActionSheet$9$a */
                /* loaded from: classes27.dex */
                class a implements Animation.AnimationListener {
                    static IPatchRedirector $redirector_;

                    a() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass9.this);
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                        } else {
                            ActionSheet.this.superDismiss();
                            ActionSheet.this.mDismissFinish = true;
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                            iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                            iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
                        }
                    }
                }

                {
                    this.f384520d = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ActionSheet.this, i3);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    ActionSheet.this.animation = new TranslateAnimation(0.0f, 0.0f, 0.0f, ActionSheet.this.mActionView.getHeight());
                    if (this.f384520d != 0) {
                        he0.b.l(ActionSheet.this.animation, this.f384520d);
                    } else {
                        ActionSheet.this.animation.setDuration(200L);
                    }
                    ActionSheet.this.animation.setFillAfter(true);
                    ActionSheet.this.mActionView.startAnimation(ActionSheet.this.animation);
                    ActionSheet.this.animation.setAnimationListener(new a());
                }
            }, 0L);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 93)) {
            return ((Boolean) iPatchRedirector.redirect((short) 93, (Object) this, (Object) accessibilityEvent)).booleanValue();
        }
        if (this.mCloseAutoRead && accessibilityEvent.getEventType() == 32) {
            return true;
        }
        super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Dialog.class.getName());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ColorStateList getActionButtonColorByType(int i3) {
        int color;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            return (ColorStateList) iPatchRedirector.redirect((short) 54, (Object) this, i3);
        }
        int i16 = i3 & 65535;
        if (i16 != 3) {
            if (i16 != 8) {
                if (i16 != 13) {
                    if (i16 != 10) {
                        if (i16 != 11) {
                            color = this.mResources.getColor(R.color.qui_common_text_primary);
                            if (this.mForceDayMode) {
                                color = getDayColor(R.color.qui_common_text_primary);
                            }
                        }
                    } else {
                        color = this.mResources.getColor(R.color.b3k);
                    }
                }
                color = this.mResources.getColor(R.color.b3j);
            } else {
                color = this.mResources.getColor(R.color.f157206la);
            }
        } else {
            color = this.mResources.getColor(R.color.qui_common_feedback_error);
            if (this.mForceDayMode) {
                color = getDayColor(R.color.qui_common_feedback_error);
            }
        }
        return new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{android.R.attr.state_enabled}, new int[0]}, new int[]{(16777215 & color) | CellDynamicAlbum.sBtnBackgroundColor, color, color});
    }

    public RelativeLayout getActionContentView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (RelativeLayout) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return this.mActionView;
    }

    public ActionMenuItem getActionMenuItem(CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return (ActionMenuItem) iPatchRedirector.redirect((short) 41, (Object) this, (Object) charSequence);
        }
        HashMap<CharSequence, ActionMenuItem> hashMap = this.mActionMenuMap;
        if (hashMap == null) {
            return null;
        }
        return hashMap.get(charSequence);
    }

    protected int getActionSheetCancelButtonLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            return ((Integer) iPatchRedirector.redirect((short) 66, (Object) this)).intValue();
        }
        return R.layout.action_sheet_cancel_button;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getActionSheetCommonButtonLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            return ((Integer) iPatchRedirector.redirect((short) 65, (Object) this)).intValue();
        }
        return R.layout.f167539iv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getActionSheetTitleLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            return ((Integer) iPatchRedirector.redirect((short) 64, (Object) this)).intValue();
        }
        return R.layout.action_sheet_title;
    }

    public String getContent(int i3) {
        Pair<CharSequence, Integer> pair;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return (String) iPatchRedirector.redirect((short) 45, (Object) this, i3);
        }
        ArrayList<Pair<CharSequence, Integer>> arrayList = this.mContents;
        if (arrayList != null && i3 < arrayList.size() && (pair = this.mContents.get(i3)) != null) {
            return ((CharSequence) pair.first).toString();
        }
        return null;
    }

    public ItemViewHolder getItemViewById(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            return (ItemViewHolder) iPatchRedirector.redirect((short) 73, (Object) this, i3);
        }
        LinearLayout linearLayout = this.mContentContainer;
        if (linearLayout != null && linearLayout.findViewById(i3) != null) {
            ItemViewHolder itemViewHolder = new ItemViewHolder();
            View findViewById = this.mContentContainer.findViewById(i3);
            if (findViewById == null) {
                return itemViewHolder;
            }
            itemViewHolder.titleTv = (TextView) findViewById.findViewById(R.id.action_sheet_button);
            itemViewHolder.iconIv = (ImageView) findViewById.findViewById(R.id.f163939d2);
            return itemViewHolder;
        }
        return null;
    }

    public SparseArray<View> getRadioButtonArray() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 88)) {
            return (SparseArray) iPatchRedirector.redirect((short) 88, (Object) this);
        }
        SparseArray<View> sparseArray = this.mRadioButtonMap;
        if (sparseArray != null) {
            return sparseArray;
        }
        return new SparseArray<>();
    }

    public ViewGroup getRootView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            return (ViewGroup) iPatchRedirector.redirect((short) 68, (Object) this);
        }
        return this.mRootView;
    }

    public Drawable getSelectorByType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return (Drawable) iPatchRedirector.redirect((short) 53, (Object) this, i3);
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 4) {
                    return this.mResources.getDrawable(R.drawable.f160040p);
                }
                return this.mResources.getDrawable(R.drawable.f160045v);
            }
            return this.mResources.getDrawable(R.drawable.j2w);
        }
        return this.mResources.getDrawable(R.drawable.f160040p);
    }

    @Override // android.app.Dialog
    public boolean onPrepareOptionsMenu(Menu menu) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) menu)).booleanValue();
        }
        if (this.mIsMenuMode) {
            try {
                dismiss();
            } catch (Exception unused) {
            }
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Dialog
    protected void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onStart();
        OrientationEventListener orientationEventListener = this.mOrientationEventListener;
        if (orientationEventListener != null) {
            orientationEventListener.enable();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog, android.app.Dialog
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        OrientationEventListener orientationEventListener = this.mOrientationEventListener;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        super.onStop();
    }

    public void preInitView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            iPatchRedirector.redirect((short) 69, (Object) this);
        } else {
            this.mRootView.setVisibility(8);
            prepareContentViews();
        }
    }

    protected void prepareTitleView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            iPatchRedirector.redirect((short) 63, (Object) this);
            return;
        }
        if (this.mMainTitle == null) {
            return;
        }
        View inflate = this.mInflater.inflate(getActionSheetTitleLayoutId(), (ViewGroup) this.mContentContainer, false);
        inflate.setOnClickListener(new e());
        setItemHeight(inflate);
        TextView textView = (TextView) inflate.findViewById(R.id.action_sheet_title);
        this.mainTitleText = textView;
        textView.setVisibility(0);
        this.mainTitleText.setMaxLines(Integer.MAX_VALUE);
        this.mainTitleText.setText(this.mMainTitle);
        this.mainTitleText.setContentDescription(this.mMainTitle);
        this.mainTitleText.setTextColor(this.mMainTitleColor);
        this.mContentContainer.addView(inflate, 0);
        if (this.mForceDayMode) {
            inflate.setBackground(getDayDrawable(inflate.getBackground()));
        }
    }

    public void registerWatchDisMissActionListener(WatchDismissActions watchDismissActions) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            iPatchRedirector.redirect((short) 76, (Object) this, (Object) watchDismissActions);
        } else {
            this.mWatchDismissListener = watchDismissActions;
        }
    }

    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this);
            return;
        }
        clear();
        this.mMainTitle = null;
        this.mCancelText = null;
        this.mAccuseText = 0;
        this.mButtonsListener = null;
        this.mButtonsListenerV2 = null;
    }

    public void setActionContentView(View view, LinearLayout.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) view, (Object) layoutParams);
        } else if (view != null) {
            this.mActionView.removeAllViews();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-1, -2);
            }
            this.mActionView.addView(view, layoutParams);
        }
    }

    public void setAnimationTime(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 85)) {
            iPatchRedirector.redirect((short) 85, (Object) this, i3);
        } else if (i3 > 0) {
            this.mAnimationTime = i3;
        }
    }

    public void setBlueStyleMainTitle(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
            setBlueStyleMainTitle(this.mResources.getText(i3));
        } else {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
        }
    }

    public void setButtonEnable(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            iPatchRedirector.redirect((short) 67, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        ArrayList<Pair<CharSequence, Integer>> arrayList = this.mContents;
        if (arrayList != null && i3 >= 0 && i3 < arrayList.size()) {
            if (!this.mIsReady) {
                prepareContentViews();
            }
            View findViewById = this.mContentContainer.findViewById(i3);
            View findViewById2 = this.mContentContainer.findViewById(R.id.action_sheet_button);
            if (findViewById != null) {
                findViewById.setEnabled(z16);
            }
            if (findViewById2 != null) {
                findViewById2.setEnabled(z16);
            }
        }
    }

    public void setCloseAutoRead(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 92)) {
            iPatchRedirector.redirect((short) 92, (Object) this, z16);
        } else {
            this.mCloseAutoRead = z16;
        }
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            throw new UnsupportedOperationException("this method is not support");
        }
        iPatchRedirector.redirect((short) 12, (Object) this, (Object) view);
    }

    public void setCustomItemHeight(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            iPatchRedirector.redirect((short) 72, this, Float.valueOf(f16));
        } else {
            this.mCustomItemHeight = x.c(BaseApplication.getContext(), f16);
        }
    }

    public void setForceDayMode(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 95)) {
            iPatchRedirector.redirect((short) 95, (Object) this, z16);
        } else {
            this.mForceDayMode = z16;
        }
    }

    public void setForceNightMode(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 94)) {
            iPatchRedirector.redirect((short) 94, (Object) this, z16);
        } else {
            this.mForceNightMode = z16;
        }
    }

    @Deprecated
    public void setHeaderView(View view, LinearLayout.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) view, (Object) layoutParams);
        } else if (view != null) {
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-1, -2);
            }
            this.mContentContainer.addView(view, 0, layoutParams);
        }
    }

    public void setMainTitle(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) {
            setMainTitle(this.mResources.getText(i3));
        } else {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
        }
    }

    public void setOnBottomAccuseListener(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) onClickListener);
        } else {
            this.onBottomAccuseListener = onClickListener;
        }
    }

    public void setOnBottomCancelListener(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) onClickListener);
        } else {
            this.onBottomCancelListener = onClickListener;
        }
    }

    public void setOnButtonClickListener(OnButtonClickListener onButtonClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 80)) {
            iPatchRedirector.redirect((short) 80, (Object) this, (Object) onButtonClickListener);
        } else {
            this.mButtonsListener = onButtonClickListener;
        }
    }

    public void setOnButtonClickListenerV2(OnButtonClickListenerV2 onButtonClickListenerV2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 81)) {
            iPatchRedirector.redirect((short) 81, (Object) this, (Object) onButtonClickListenerV2);
        } else {
            this.mButtonsListenerV2 = onButtonClickListenerV2;
        }
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 82)) {
            iPatchRedirector.redirect((short) 82, (Object) this, (Object) onDismissListener);
        } else {
            this.mDismissListener = onDismissListener;
        }
    }

    public void setOnPreShowListener(onPreShowListener onpreshowlistener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            iPatchRedirector.redirect((short) 75, (Object) this, (Object) onpreshowlistener);
        } else {
            this.mOnPreShowListener = onpreshowlistener;
        }
    }

    public void setOnWidthChangedListener(g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 96)) {
            iPatchRedirector.redirect((short) 96, (Object) this, (Object) gVar);
        } else {
            this.mOnWidthChangedListener = gVar;
        }
    }

    public void setOutsideDismissEnable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 83)) {
            iPatchRedirector.redirect((short) 83, (Object) this, z16);
        } else if (z16) {
            this.mRootView.setOnClickListener(this.mDefaultDismissListener);
        } else {
            this.mRootView.setOnClickListener(null);
        }
    }

    public void setOutsideDismissEnableCompat(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 84)) {
            iPatchRedirector.redirect((short) 84, (Object) this, z16);
            return;
        }
        ViewGroup viewGroup = this.mRootView;
        if (viewGroup != null && viewGroup.getChildAt(0) != null) {
            if (z16) {
                this.mRootView.getChildAt(0).setOnClickListener(this.mDefaultDismissListener);
            } else {
                this.mRootView.getChildAt(0).setOnClickListener(null);
            }
        }
    }

    public void setRadioButtonChecked(int i3) {
        ArrayList<Pair<CharSequence, Integer>> arrayList;
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, (Object) this, i3);
            return;
        }
        if (i3 >= 0 && (arrayList = this.mContents) != null && i3 < arrayList.size()) {
            this.mCurrentSelectedViewId = i3;
            SparseArray<View> sparseArray = this.mRadioButtonMap;
            if (sparseArray != null && (view = sparseArray.get(i3)) != null) {
                view.findViewById(R.id.f163929cr).setVisibility(0);
                updateRadioGroupButtonDesc((TextView) view.findViewById(R.id.action_sheet_button), true);
            }
        }
    }

    public void setRedStyleMainTitle(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 21)) {
            setRedStyleMainTitle(this.mResources.getText(i3));
        } else {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
        }
    }

    public void setRoundCornerTop(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            iPatchRedirector.redirect((short) 74, (Object) this, z16);
        } else {
            this.mIsRoundCornerTop = z16;
        }
    }

    public void setSupportBottomRadius(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, (Object) this, z16);
        } else {
            this.mSupportBottomRadius = z16;
        }
    }

    @Override // android.app.Dialog
    public void setTitle(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            throw new UnsupportedOperationException("this method is not support");
        }
        iPatchRedirector.redirect((short) 14, (Object) this, i3);
    }

    public void setTitleEllipsize(TextUtils.TruncateAt truncateAt) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) truncateAt);
            return;
        }
        TextView textView = this.mainTitleText;
        if (textView != null) {
            textView.setMaxLines(1);
            this.mainTitleText.setEllipsize(truncateAt);
            int a16 = az.a(this.mContext, 18.0f);
            this.mainTitleText.setPadding(a16, 0, a16, 0);
        }
    }

    public void setTitleSize(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, i3);
            return;
        }
        TextView textView = this.mainTitleText;
        if (textView != null) {
            textView.setTextSize(i3);
        }
    }

    public void setTitleWithColor(CharSequence charSequence, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) charSequence, (Object) str);
            return;
        }
        setMainTitle(charSequence);
        try {
            this.mMainTitleColor = Color.parseColor(str);
        } catch (Exception e16) {
            QLog.e("ActionSheet", 1, "Exception", e16);
            this.mMainTitleColor = this.mResources.getColor(R.color.qui_common_feedback_error);
            if (this.mForceDayMode) {
                this.mMainTitleColor = getDayColor(R.color.qui_common_feedback_error);
            }
        }
        this.mainTitleText.setText(this.mMainTitle);
        this.mainTitleText.setTextColor(this.mMainTitleColor);
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 70)) {
            show(true, 0);
        } else {
            iPatchRedirector.redirect((short) 70, (Object) this);
        }
    }

    public void superDismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 79)) {
            iPatchRedirector.redirect((short) 79, (Object) this);
            return;
        }
        try {
            super.dismiss();
        } catch (Exception unused) {
        } catch (Throwable th5) {
            sy3.a.a(this);
            throw th5;
        }
        sy3.a.a(this);
    }

    public void updateAllButton() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this);
            return;
        }
        this.mIsReady = false;
        this.mContentContainer.removeAllViews();
        prepareContentViews();
    }

    public void updateButton(int i3, CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 32)) {
            updateButton(i3, charSequence, 0);
        } else {
            iPatchRedirector.redirect((short) 32, (Object) this, i3, (Object) charSequence);
        }
    }

    public void updateUI() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this);
        } else {
            this.mIsReady = false;
            invalidateOptionsMenu();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ActionSheet(Context context, boolean z16, boolean z17) {
        this(context, z16, z17, true, -1, null, false, true);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, Boolean.valueOf(z16), Boolean.valueOf(z17));
    }

    public void addRadioButton(CharSequence charSequence, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 56)) {
            addRadioButton(charSequence, 0, z16);
        } else {
            iPatchRedirector.redirect((short) 56, this, charSequence, Boolean.valueOf(z16));
        }
    }

    public ActionMenuItem getActionMenuItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 42)) ? getActionMenuItem(getContent(i3)) : (ActionMenuItem) iPatchRedirector.redirect((short) 42, (Object) this, i3);
    }

    @Override // android.app.Dialog
    public void setContentView(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            throw new UnsupportedOperationException("this method is not support");
        }
        iPatchRedirector.redirect((short) 13, (Object) this, i3);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            throw new UnsupportedOperationException("this method is not support");
        }
        iPatchRedirector.redirect((short) 15, (Object) this, (Object) charSequence);
    }

    public void show(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            iPatchRedirector.redirect((short) 71, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        this.mRootView.setVisibility(4);
        super.show();
        prepareContentViews();
        if (z16) {
            this.mHandler.postDelayed(new Runnable(i3) { // from class: com.tencent.widget.ActionSheet.7
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f384519d;

                {
                    this.f384519d = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ActionSheet.this, i3);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (ActionSheet.this.mOnPreShowListener != null) {
                        ActionSheet.this.mOnPreShowListener.onPreShow();
                    }
                    ActionSheet.this.mRootView.setVisibility(0);
                    ActionSheet.this.animation = new TranslateAnimation(0.0f, 0.0f, ActionSheet.this.mActionView.getHeight(), 0.0f);
                    ActionSheet.this.animation.setFillEnabled(true);
                    ActionSheet.this.animation.setStartTime(300L);
                    if (this.f384519d != 0) {
                        he0.b.l(ActionSheet.this.animation, this.f384519d);
                    } else {
                        ActionSheet.this.animation.setDuration(ActionSheet.this.mAnimationTime);
                    }
                    ActionSheet.this.mDismissFinish = true;
                    ActionSheet.this.mActionView.startAnimation(ActionSheet.this.animation);
                }
            }, 0L);
        } else {
            this.mHandler.postDelayed(new Runnable() { // from class: com.tencent.widget.ActionSheet.8
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ActionSheet.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (ActionSheet.this.mOnPreShowListener != null) {
                        ActionSheet.this.mOnPreShowListener.onPreShow();
                    }
                    ActionSheet.this.mRootView.setVisibility(0);
                }
            }, 0L);
        }
    }

    public void updateButton(int i3, CharSequence charSequence, int i16) {
        ArrayList<Pair<CharSequence, Integer>> arrayList;
        View findViewById;
        View findViewById2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, Integer.valueOf(i3), charSequence, Integer.valueOf(i16));
            return;
        }
        if (i3 < 0 || (arrayList = this.mContents) == null || i3 >= arrayList.size() || (findViewById = this.mContentContainer.findViewById(i3)) == null || (findViewById2 = findViewById.findViewById(R.id.action_sheet_button)) == null || !TextView.class.isInstance(findViewById2)) {
            return;
        }
        TextView textView = (TextView) findViewById2;
        textView.setText(charSequence);
        textView.setTextColor(getActionButtonColorByType(i16));
        this.mContents.set(i3, new Pair<>(charSequence, Integer.valueOf(i16)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ActionSheet(Context context, boolean z16, boolean z17, boolean z18) {
        this(context, z16, z17, true, -1, null, false, z18);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18));
    }

    public void addButton(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 29)) {
            addButton(this.mResources.getText(i3), i16);
        } else {
            iPatchRedirector.redirect((short) 29, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public void addCancelButton(CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, (Object) charSequence);
        } else if (charSequence != null) {
            this.mCancelText = charSequence;
        }
    }

    public void addRadioButton(int i3, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 57)) {
            addRadioButton(this.mResources.getText(i3), i16, z16);
        } else {
            iPatchRedirector.redirect((short) 57, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
        }
    }

    public void setBlueStyleMainTitle(CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) charSequence);
            return;
        }
        setMainTitle(charSequence);
        this.mMainTitleColor = this.mResources.getColor(R.color.qui_common_feedback_normal);
        if (this.mForceDayMode) {
            this.mMainTitleColor = getDayColor(R.color.qui_common_feedback_normal);
        }
    }

    public void setMainTitle(CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) charSequence);
            return;
        }
        if (charSequence != null) {
            this.mMainTitle = charSequence;
            this.mMainTitleColor = this.mResources.getColor(R.color.qui_common_text_secondary);
            if (this.mForceDayMode) {
                this.mMainTitleColor = getDayColor(R.color.qui_common_text_secondary);
            }
        }
    }

    public void setRedStyleMainTitle(CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) charSequence);
            return;
        }
        setMainTitle(charSequence);
        this.mMainTitleColor = this.mResources.getColor(R.color.qui_common_feedback_error);
        if (this.mForceDayMode) {
            this.mMainTitleColor = getDayColor(R.color.qui_common_feedback_error);
        }
    }

    protected ActionSheet(Context context, boolean z16) {
        this(context, false, false, true, -1, null, z16, true);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, this, context, Boolean.valueOf(z16));
    }

    public static ActionSheet create(Context context, int i3, ViewGroup.LayoutParams layoutParams) {
        ActionSheet actionSheet = new ActionSheet(context, false, false, true, i3, layoutParams, false);
        if (Build.VERSION.SDK_INT != 23) {
            actionSheet.getWindow().setWindowAnimations(R.style.f173293c);
        }
        return actionSheet;
    }

    public static ActionSheet createFullScreenDialog(Context context, boolean z16) {
        ActionSheet actionSheet = new ActionSheet(context, false, true, z16, -1, null, false);
        if (Build.VERSION.SDK_INT != 23) {
            actionSheet.getWindow().setWindowAnimations(R.style.f173293c);
        }
        return actionSheet;
    }

    @TargetApi(14)
    protected ActionSheet(Context context, boolean z16, boolean z17, boolean z18, int i3, ViewGroup.LayoutParams layoutParams, boolean z19) {
        this(context, z16, z17, z18, i3, layoutParams, z19, true);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, this, context, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Integer.valueOf(i3), layoutParams, Boolean.valueOf(z19));
    }

    public void addButton(int i3, int i16, @IdRes int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        } else {
            this.mIds.add(Integer.valueOf(i17));
            addButton(i3, i16);
        }
    }

    public void addRadioButton(CharSequence charSequence, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 58)) {
            addRadioButton(charSequence, i3, z16, true);
        } else {
            iPatchRedirector.redirect((short) 58, this, charSequence, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
    }

    @TargetApi(14)
    protected ActionSheet(Context context, boolean z16, boolean z17, boolean z18, int i3, ViewGroup.LayoutParams layoutParams, boolean z19, boolean z26) {
        super(context, R.style.MenuDialogStyle);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, context, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Integer.valueOf(i3), layoutParams, Boolean.valueOf(z19), Boolean.valueOf(z26));
            return;
        }
        this.mIds = new ArrayList();
        this.mActionMenuMap = new HashMap<>();
        this.mAccuseIconColor = 0;
        this.mIconsMap = new HashMap<>();
        this.mIconsLeftMap = new HashMap<>();
        this.mTextColorMap = new HashMap<>();
        this.mSubTextColorArray = new SparseArray<>();
        this.mButtonsListener = null;
        this.mButtonsListenerV2 = null;
        this.mDismissListener = null;
        this.mCurrentSelectedViewId = -1;
        this.mRadioGroupMode = false;
        this.mAnimationTime = 300;
        this.mForceNightMode = false;
        this.mForceDayMode = false;
        this.mLastScreenWidth = 0;
        this.mSupportBottomRadius = false;
        this.mDismissFinish = true;
        this.mIsRoundCornerTop = false;
        this.mOnPreShowListener = null;
        this.mWatchDismissListener = null;
        this.mBtnClickListener = new a();
        this.mDefaultDismissListener = new b();
        this.mFetchListenerMap = new HashMap();
        this.mFetchDrawableMap = new HashMap();
        this.mCloseAutoRead = false;
        Window window = getWindow();
        int i16 = Build.VERSION.SDK_INT;
        window.setDimAmount(0.5f);
        this.mContext = context;
        this.mIsMenuMode = z16;
        this.mInflater = LayoutInflater.from(context);
        this.mResources = context.getResources();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mIsSupportNightMode = z19;
        if (z18 && QViewImmersiveUtils.isSupporImmersive() == 1) {
            window.addFlags(67108864);
        }
        if (z17) {
            requestWindowFeature(1);
            window.setFlags(1024, 1024);
            if (i16 >= 28) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                window.setAttributes(attributes);
            }
        }
        QViewImmersiveUtils.clearCoverForStatus(window, true);
        ViewGroup viewGroup = (ViewGroup) this.mInflater.inflate(i3 == -1 ? R.layout.action_sheet_base : i3, (ViewGroup) null);
        this.mRootView = viewGroup;
        if (layoutParams != null) {
            super.setContentView(viewGroup, layoutParams);
        } else {
            super.setContentView(viewGroup);
        }
        this.mActionView = (RelativeLayout) this.mRootView.findViewById(R.id.action_sheet_actionView);
        this.mContentContainer = (LinearLayout) this.mRootView.findViewById(R.id.f163931ct);
        this.mRootView.getChildAt(0).setOnClickListener(this.mDefaultDismissListener);
        this.mActionView.setOnClickListener(null);
        this.onBottomCancelListener = this.mDefaultDismissListener;
        if (z26) {
            if (AppSetting.o(context) || PadUtil.a(context) == DeviceType.FOLD) {
                padAndFoldCompat(context);
                this.mOrientationEventListener = new d(context, context);
            }
        }
    }

    public void addRadioButton(CharSequence charSequence, int i3, boolean z16, boolean z17) {
        ArrayList<Pair<CharSequence, Integer>> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, this, charSequence, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (charSequence != null) {
            if (!this.mRadioGroupMode && (arrayList = this.mContents) != null && arrayList.size() > 0) {
                throw new UnsupportedOperationException("ActionSheet is in normal button mode,shouldn't call addRadioButton!");
            }
            if (this.mContents == null) {
                this.mContents = new ArrayList<>();
            }
            Pair<CharSequence, Integer> pair = new Pair<>(charSequence, Integer.valueOf(i3));
            if (!this.mContents.contains(pair)) {
                this.mContents.add(pair);
            }
            if (!z17) {
                if (this.mUncheckeable == null) {
                    this.mUncheckeable = new HashSet<>();
                }
                this.mUncheckeable.add(Integer.valueOf(this.mContents.size() - 1));
            } else if (z16) {
                this.mCurrentSelectedViewId = this.mContents.size() - 1;
            }
            this.mRadioGroupMode = true;
        }
    }

    public static ActionSheet create(Context context, int i3, ViewGroup.LayoutParams layoutParams, boolean z16) {
        ActionSheet actionSheet = new ActionSheet(context, false, false, true, i3, layoutParams, z16);
        if (Build.VERSION.SDK_INT != 23) {
            actionSheet.getWindow().setWindowAnimations(R.style.f173293c);
        }
        return actionSheet;
    }

    public void addButton(CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 31)) {
            addButton(charSequence, 0);
        } else {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) charSequence);
        }
    }

    public void addButton(int i3, CharSequence charSequence, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, Integer.valueOf(i3), charSequence, Integer.valueOf(i16));
            return;
        }
        if (charSequence != null) {
            if (this.mContents == null) {
                this.mContents = new ArrayList<>();
            }
            Pair<CharSequence, Integer> pair = new Pair<>(charSequence, Integer.valueOf(i16));
            if (!this.mContents.contains(pair)) {
                this.mContents.add(i3, pair);
            }
            if (this.mRadioGroupMode) {
                throw new UnsupportedOperationException("ActionSheet is in radio group mode,shouldn't call addButton!");
            }
        }
    }

    public static ActionSheet create(Context context, boolean z16) {
        ActionSheet actionSheet = new ActionSheet(context, false, false, z16, -1, null, false);
        if (Build.VERSION.SDK_INT != 23) {
            actionSheet.getWindow().setWindowAnimations(R.style.f173293c);
        }
        return actionSheet;
    }

    public void addButtonWithLeftIcon(String str, Drawable drawable, int i3, String str2, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 91)) {
            iPatchRedirector.redirect((short) 91, this, str, drawable, Integer.valueOf(i3), str2, Integer.valueOf(i16));
            return;
        }
        if (this.mContents == null) {
            this.mContents = new ArrayList<>();
        }
        if (drawable == null) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            i3 = 0;
        }
        this.mIds.add(Integer.valueOf(i16));
        Pair<CharSequence, Integer> pair = new Pair<>(str, Integer.valueOf(i3));
        if (!this.mContents.contains(pair)) {
            this.mContents.add(pair);
        }
        if (i3 == 9) {
            this.mTextColorMap.put(Integer.valueOf(this.mContents.size() - 1), str2);
        }
        this.mIconsLeftMap.put(Integer.valueOf(this.mContents.size() - 1), drawable);
    }

    public void addButton(CharSequence charSequence, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) charSequence, i3);
            return;
        }
        if (charSequence != null) {
            if (this.mContents == null) {
                this.mContents = new ArrayList<>();
            }
            Pair<CharSequence, Integer> pair = new Pair<>(charSequence, Integer.valueOf(i3));
            if (!this.mContents.contains(pair)) {
                this.mContents.add(pair);
            }
            if (this.mRadioGroupMode) {
                throw new UnsupportedOperationException("ActionSheet is in radio group mode,shouldn't call addButton!");
            }
        }
    }

    public void addButton(CharSequence charSequence, int i3, @IdRes int i16, Integer num) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), num);
            return;
        }
        this.mIds.add(Integer.valueOf(i16));
        addButton(charSequence, i3);
        this.mSubTextColorArray.put(this.mContents.size() - 1, num);
    }

    public void addButton(CharSequence charSequence, int i3, @IdRes int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 37)) {
            addButton(charSequence, i3, i16, Integer.valueOf(this.mResources.getColor(R.color.b3i)));
        } else {
            iPatchRedirector.redirect((short) 37, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public void addButton(CharSequence charSequence, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, charSequence, Integer.valueOf(i3), str);
            return;
        }
        if (charSequence != null) {
            if (this.mContents == null) {
                this.mContents = new ArrayList<>();
            }
            if (TextUtils.isEmpty(str)) {
                i3 = 0;
            }
            Pair<CharSequence, Integer> pair = new Pair<>(charSequence, Integer.valueOf(i3));
            if (!this.mContents.contains(pair)) {
                this.mContents.add(pair);
            }
            if (i3 == 9) {
                this.mTextColorMap.put(Integer.valueOf(this.mContents.size() - 1), str);
            }
            if (this.mRadioGroupMode) {
                throw new UnsupportedOperationException("ActionSheet is in radio group mode,shouldn't call addButton!");
            }
        }
    }

    public void addButton(ActionMenuItem actionMenuItem, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, (Object) actionMenuItem, i3);
        } else {
            if (actionMenuItem == null) {
                return;
            }
            this.mActionMenuMap.put(actionMenuItem.content, actionMenuItem);
            addButton(actionMenuItem.content, i3);
        }
    }
}
