package com.qzone.reborn.widget;

import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000  2\u00020\u0001:\u0001!B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\u000e\u001a\u00020\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006R\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/qzone/reborn/widget/f;", "Landroid/app/Dialog;", "", "initWindow", "Landroid/content/Context;", "context", "Landroid/view/View;", "U", "initView", "Landroidx/recyclerview/widget/RecyclerView;", "X", "", "Lcom/qzone/reborn/widget/b;", QbSdk.FILERADER_MENUDATA, "Y", ExifInterface.LATITUDE_SOUTH, "Lcom/qzone/reborn/widget/a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/widget/a;", BdhLogUtil.LogTag.Tag_Req, "()Lcom/qzone/reborn/widget/a;", "buildParam", "Lcom/qzone/reborn/widget/d;", "D", "Lcom/qzone/reborn/widget/d;", "mAdapter", "Landroid/widget/FrameLayout;", "E", "Landroid/widget/FrameLayout;", "mContainer", "<init>", "(Landroid/content/Context;Lcom/qzone/reborn/widget/a;)V", UserInfo.SEX_FEMALE, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class f extends ReportDialog {

    /* renamed from: C, reason: from kotlin metadata */
    private final a buildParam;

    /* renamed from: D, reason: from kotlin metadata */
    private d mAdapter;

    /* renamed from: E, reason: from kotlin metadata */
    private FrameLayout mContainer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"com/qzone/reborn/widget/f$b", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends com.tencent.mobileqq.widget.qus.e {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f59693e;

        b(Context context) {
            this.f59693e = context;
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        /* renamed from: createContentView */
        public View getF58528d() {
            f.this.mContainer = new FrameLayout(f.this.getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            FrameLayout frameLayout = f.this.mContainer;
            if (frameLayout != null) {
                frameLayout.setLayoutParams(layoutParams);
            }
            FrameLayout frameLayout2 = f.this.mContainer;
            if (frameLayout2 != null) {
                frameLayout2.setBackground(ie0.a.f().k(f.this.getContext(), R.color.qui_common_bg_middle_light, 0.0f, f.this.getBuildParam().getSkinMode()));
            }
            FrameLayout frameLayout3 = f.this.mContainer;
            if (frameLayout3 != null) {
                frameLayout3.setPadding(0, 0, 0, ef.d.b(30));
            }
            f.this.initView(this.f59693e);
            return f.this.mContainer;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context, a buildParam) {
        super(context, R.style.f173448dl);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(buildParam, "buildParam");
        this.buildParam = buildParam;
        initWindow();
        setContentView(R.layout.f1294362);
        U(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(f this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    private final RecyclerView X(Context context) {
        RecyclerView recyclerView = new RecyclerView(context);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setVerticalScrollBarEnabled(false);
        d dVar = new d(context, this, this.buildParam);
        this.mAdapter = dVar;
        Intrinsics.checkNotNull(dVar);
        recyclerView.setAdapter(dVar);
        return recyclerView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initView(Context context) {
        FrameLayout frameLayout = this.mContainer;
        if (frameLayout != null) {
            frameLayout.addView(X(context));
        }
    }

    private final void initWindow() {
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.requestFeature(1);
        try {
            ImmersiveUtils.clearCoverForStatus(window, true);
        } catch (Exception e16) {
            QLog.e("QZoneBottomSheetMenuDialog", 1, "clearCoverForStatus fail:" + e16.getMessage());
        }
    }

    /* renamed from: R, reason: from getter */
    public final a getBuildParam() {
        return this.buildParam;
    }

    public final View S() {
        return this.mContainer;
    }

    public final void Y(List<com.qzone.reborn.widget.b> menuData) {
        Intrinsics.checkNotNullParameter(menuData, "menuData");
        d dVar = this.mAdapter;
        if (dVar != null) {
            dVar.setData(menuData);
        }
        d dVar2 = this.mAdapter;
        if (dVar2 != null) {
            dVar2.notifyDataSetChanged();
        }
    }

    private final View U(Context context) {
        View findViewById = findViewById(R.id.n27);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_floating_half_screen)");
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = (QUSHalfScreenFloatingView) findViewById;
        qUSHalfScreenFloatingView.setThemeId(this.buildParam.getSkinMode());
        qUSHalfScreenFloatingView.setIsHeightWrapContent(true);
        qUSHalfScreenFloatingView.setFitsSystemWindows(false);
        qUSHalfScreenFloatingView.setQUSDragFloatController(new b(context));
        qUSHalfScreenFloatingView.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.qzone.reborn.widget.e
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                f.W(f.this);
            }
        });
        return qUSHalfScreenFloatingView;
    }
}
