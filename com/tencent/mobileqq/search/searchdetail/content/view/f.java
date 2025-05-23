package com.tencent.mobileqq.search.searchdetail.content.view;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.nt.misc.api.IJumpApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenTitleBarHeaderView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqnt.kernel.nativeinterface.SearchEmptyPageExtraInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchEmptyPageText;
import com.tencent.widget.immersive.ImmersiveUtils;
import hp2.j;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 +2\u00020\u0001:\u0001,B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010(\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/view/f;", "Landroid/app/Dialog;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchEmptyPageExtraInfo;", "emptyInfo", "", "U", "", "content", "", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchEmptyPageText;", "highlightList", "Landroid/text/SpannableString;", "a0", "Landroid/content/Context;", "ctx", "url", "Z", "X", "initWindow", ExifInterface.LATITUDE_SOUTH, "Landroid/app/Activity;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/app/Activity;", "W", "()Landroid/app/Activity;", "mActivity", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "D", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "mHalfScreenFloatingView", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenTitleBarHeaderView;", "E", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenTitleBarHeaderView;", "mHalfScreenFloatingHeader", "Lhp2/j;", UserInfo.SEX_FEMALE, "Lhp2/j;", "mContentViewBinding", "G", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchEmptyPageExtraInfo;", "mEmptyInfo", "<init>", "(Landroid/app/Activity;)V", "H", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class f extends ReportDialog {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Activity mActivity;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private QUSHalfScreenFloatingView mHalfScreenFloatingView;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private QUSHalfScreenTitleBarHeaderView mHalfScreenFloatingHeader;

    /* renamed from: F, reason: from kotlin metadata */
    private j mContentViewBinding;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private SearchEmptyPageExtraInfo mEmptyInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/search/searchdetail/content/view/f$b", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", "defaultHeight", NodeProps.MAX_HEIGHT, "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b extends com.tencent.mobileqq.widget.qus.e {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        @Nullable
        /* renamed from: createContentView */
        public View getF58528d() {
            j g16 = j.g(LayoutInflater.from(f.this.getMActivity()));
            Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(mActivity))");
            f.this.mContentViewBinding = g16;
            SearchEmptyPageExtraInfo searchEmptyPageExtraInfo = f.this.mEmptyInfo;
            if (searchEmptyPageExtraInfo != null) {
                f.this.U(searchEmptyPageExtraInfo);
            }
            return g16.getRoot();
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int defaultHeight() {
            return 0;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int maxHeight() {
            return ViewUtils.dip2px(400.0f);
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/search/searchdetail/content/view/f$c", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "Landroid/text/TextPaint;", "ds", "updateDrawState", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class c extends ClickableSpan {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ SearchEmptyPageText f284298e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f284299f;

        c(SearchEmptyPageText searchEmptyPageText, int i3) {
            this.f284298e = searchEmptyPageText;
            this.f284299f = i3;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            f fVar = f.this;
            Context context = fVar.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            String str = this.f284298e.jumpLink;
            Intrinsics.checkNotNullExpressionValue(str, "highlightText.jumpLink");
            fVar.Z(context, str);
            f.this.dismiss();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds5) {
            Intrinsics.checkNotNullParameter(ds5, "ds");
            super.updateDrawState(ds5);
            ds5.setColor(this.f284299f);
            ds5.setUnderlineText(false);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NotNull Activity mActivity) {
        super(mActivity, R.style.f173448dl);
        Intrinsics.checkNotNullParameter(mActivity, "mActivity");
        this.mActivity = mActivity;
        initWindow();
        setContentView(R.layout.hpv);
        View findViewById = findViewById(R.id.f66733bf);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<QUSHalfScre\u2026qus_floating_half_screen)");
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = (QUSHalfScreenFloatingView) findViewById;
        this.mHalfScreenFloatingView = qUSHalfScreenFloatingView;
        qUSHalfScreenFloatingView.setIsHeightWrapContent(true);
        QUSHalfScreenTitleBarHeaderView qUSHalfScreenTitleBarHeaderView = new QUSHalfScreenTitleBarHeaderView(getContext());
        qUSHalfScreenTitleBarHeaderView.setHalfScreenView(this.mHalfScreenFloatingView);
        this.mHalfScreenFloatingView.setHeaderView(qUSHalfScreenTitleBarHeaderView);
        this.mHalfScreenFloatingHeader = qUSHalfScreenTitleBarHeaderView;
        AccessibilityUtil.n(this.mHalfScreenFloatingView, true);
        AccessibilityUtil.c(this.mHalfScreenFloatingView, "\u5173\u95ed", Button.class.getName());
        X();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U(SearchEmptyPageExtraInfo emptyInfo) {
        this.mHalfScreenFloatingHeader.setTitle(emptyInfo.title);
        String str = emptyInfo.text;
        Intrinsics.checkNotNullExpressionValue(str, "emptyInfo.text");
        ArrayList<SearchEmptyPageText> arrayList = emptyInfo.richText.highlightTextList;
        Intrinsics.checkNotNullExpressionValue(arrayList, "emptyInfo.richText.highlightTextList");
        SpannableString a06 = a0(str, arrayList);
        j jVar = this.mContentViewBinding;
        j jVar2 = null;
        if (jVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentViewBinding");
            jVar = null;
        }
        jVar.f405675b.setText(a06);
        j jVar3 = this.mContentViewBinding;
        if (jVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentViewBinding");
        } else {
            jVar2 = jVar3;
        }
        jVar2.f405675b.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private final void X() {
        this.mHalfScreenFloatingView.setQUSDragFloatController(new b());
        this.mHalfScreenFloatingView.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.mobileqq.search.searchdetail.content.view.e
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                f.Y(f.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(f this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z(Context ctx, String url) {
        boolean startsWith$default;
        boolean startsWith$default2;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "http", false, 2, null);
        if (!startsWith$default) {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(url, "https", false, 2, null);
            if (!startsWith$default2) {
                ((IJumpApi) QRoute.api(IJumpApi.class)).doJumpAction(this.mActivity, url);
                Logger.f235387a.d().i("SearchEmptyHalfScreenFloatingDialog", 1, "jumpPage url=" + url);
            }
        }
        ((IReadInJoyUtils) QRoute.api(IReadInJoyUtils.class)).jumpTo(ctx, url, null);
        Logger.f235387a.d().i("SearchEmptyHalfScreenFloatingDialog", 1, "jumpPage url=" + url);
    }

    private final SpannableString a0(String content, List<SearchEmptyPageText> highlightList) {
        int indexOf$default;
        boolean isBlank;
        SpannableString spannableString = new SpannableString(content);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int color = context.getColor(R.color.qui_common_text_link);
        for (SearchEmptyPageText searchEmptyPageText : highlightList) {
            String str = searchEmptyPageText.text;
            Intrinsics.checkNotNullExpressionValue(str, "highlightText.text");
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) spannableString, str, 0, true, 2, (Object) null);
            while (indexOf$default >= 0) {
                int length = searchEmptyPageText.text.length() + indexOf$default;
                String str2 = searchEmptyPageText.jumpLink;
                Intrinsics.checkNotNullExpressionValue(str2, "highlightText.jumpLink");
                isBlank = StringsKt__StringsJVMKt.isBlank(str2);
                if (!isBlank) {
                    spannableString.setSpan(new c(searchEmptyPageText, color), indexOf$default, length, 33);
                } else {
                    spannableString.setSpan(new ForegroundColorSpan(color), indexOf$default, length, 33);
                }
                String str3 = searchEmptyPageText.text;
                Intrinsics.checkNotNullExpressionValue(str3, "highlightText.text");
                indexOf$default = StringsKt__StringsKt.indexOf((CharSequence) spannableString, str3, length, true);
            }
        }
        return spannableString;
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
            QLog.e("SearchEmptyHalfScreenFloatingDialog", 1, "clearCoverForStatus fail:" + e16.getMessage());
        }
    }

    public final void S(@NotNull SearchEmptyPageExtraInfo emptyInfo) {
        Intrinsics.checkNotNullParameter(emptyInfo, "emptyInfo");
        this.mEmptyInfo = emptyInfo;
        if (this.mContentViewBinding != null) {
            U(emptyInfo);
        }
    }

    @NotNull
    /* renamed from: W, reason: from getter */
    public final Activity getMActivity() {
        return this.mActivity;
    }
}
