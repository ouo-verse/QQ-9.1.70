package com.tencent.mobileqq.weather.part;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.weather.event.WeatherConstellationChangeEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0001%B\u0017\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010\"\u001a\u00020\u001c\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/weather/part/n;", "Landroid/app/Dialog;", "", "initView", ExifInterface.LATITUDE_SOUTH, BdhLogUtil.LogTag.Tag_Req, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/widget/GridView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/GridView;", "mConstellationGridView", "Landroid/widget/FrameLayout;", "D", "Landroid/widget/FrameLayout;", "mContainerBg", "E", "mContainer", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "mTitle", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "mCloseIcon", "", "H", "I", "mSelectPos", "Landroid/content/Context;", "context", "selectPos", "<init>", "(Landroid/content/Context;I)V", "a", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class n extends ReportDialog {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private GridView mConstellationGridView;

    /* renamed from: D, reason: from kotlin metadata */
    private FrameLayout mContainerBg;

    /* renamed from: E, reason: from kotlin metadata */
    private FrameLayout mContainer;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView mTitle;

    /* renamed from: G, reason: from kotlin metadata */
    private ImageView mCloseIcon;

    /* renamed from: H, reason: from kotlin metadata */
    private final int mSelectPos;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/weather/part/n$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.weather.part.n$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36946);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(@NotNull Context context, int i3) {
        super(context, R.style.b0r);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, i3);
        } else {
            this.mSelectPos = i3;
        }
    }

    private final void Q() {
        if (com.tencent.mobileqq.weather.util.b.g()) {
            TextView textView = this.mTitle;
            FrameLayout frameLayout = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitle");
                textView = null;
            }
            textView.setTextColor(-1);
            FrameLayout frameLayout2 = this.mContainer;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            } else {
                frameLayout = frameLayout2;
            }
            frameLayout.setBackground(getContext().getDrawable(R.drawable.f161921l05));
        }
    }

    private final void R() {
        Window window = getWindow();
        if (window != null) {
            window.addFlags(Integer.MIN_VALUE);
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setType(1000);
        }
        Window window3 = getWindow();
        if (window3 != null) {
            window3.setStatusBarColor(0);
        }
    }

    private final void S() {
        ImageView imageView = this.mCloseIcon;
        GridView gridView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCloseIcon");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.weather.part.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                n.U(n.this, view);
            }
        });
        FrameLayout frameLayout = this.mContainerBg;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainerBg");
            frameLayout = null;
        }
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.weather.part.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                n.W(n.this, view);
            }
        });
        GridView gridView2 = this.mConstellationGridView;
        if (gridView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConstellationGridView");
        } else {
            gridView = gridView2;
        }
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.tencent.mobileqq.weather.part.m
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i3, long j3) {
                n.X(n.this, adapterView, view, i3, j3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(n this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(n this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(n this$0, AdapterView adapterView, View view, int i3, long j3) {
        EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SimpleEventBus.getInstance().dispatchEvent(new WeatherConstellationChangeEvent(i3));
        QLog.d("WeatherConstellationSelectDialog", 1, "WeatherConstellationChangeEvent pos:", Integer.valueOf(i3));
        this$0.dismiss();
        EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
    }

    private final void initView() {
        R();
        GridView gridView = null;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f168901h74, (ViewGroup) null);
        setContentView(inflate);
        View findViewById = inflate.findViewById(R.id.u5n);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026nstellation_select_close)");
        this.mCloseIcon = (ImageView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.u5t);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026lect_layout_container_bg)");
        this.mContainerBg = (FrameLayout) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.u5s);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026_select_layout_container)");
        this.mContainer = (FrameLayout) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.u5v);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026nstellation_select_title)");
        this.mTitle = (TextView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.u5p);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.\u2026llation_select_grid_view)");
        GridView gridView2 = (GridView) findViewById5;
        this.mConstellationGridView = gridView2;
        if (gridView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConstellationGridView");
            gridView2 = null;
        }
        gridView2.setSelector(new ColorDrawable(0));
        GridView gridView3 = this.mConstellationGridView;
        if (gridView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConstellationGridView");
        } else {
            gridView = gridView3;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        gridView.setAdapter((ListAdapter) new com.tencent.mobileqq.weather.adapter.h(context, this.mSelectPos));
        Q();
    }

    @Override // android.app.Dialog
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        initView();
        S();
    }
}
