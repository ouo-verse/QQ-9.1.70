package com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 -2\u00020\u0001:\u0001.B\u0007\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u001a\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010\u001eR\u0016\u0010$\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u0016\u0010(\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010#R\u0016\u0010*\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010#\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/LivePCAssistantFragment;", "Lcom/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/LiveReadyBaseFrag;", "Landroid/view/View;", "view", "", "Hi", "Landroid/widget/ImageView;", "imageView", "", "drawableUrl", "Gi", "originStr", "formatStr", "Landroid/text/SpannableString;", "Fi", "", "getLayoutId", "initView", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "isFirstCreate", "onSelected", "d6", "ei", "onDestroyView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/widget/TextView;", "Z", "Landroid/widget/TextView;", "guideTipFirst", "a0", "guideTipThird", "b0", "Landroid/widget/ImageView;", "guidePicFirst", "c0", "guidePicSecond", "d0", "guidePicThird", "e0", "guidePicForth", "<init>", "()V", "f0", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class LivePCAssistantFragment extends LiveReadyBaseFrag {

    /* renamed from: Z, reason: from kotlin metadata */
    private TextView guideTipFirst;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private TextView guideTipThird;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private ImageView guidePicFirst;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private ImageView guidePicSecond;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private ImageView guidePicThird;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private ImageView guidePicForth;

    private final SpannableString Fi(String originStr, String formatStr) {
        int indexOf$default;
        if (!TextUtils.isEmpty(originStr) && !TextUtils.isEmpty(formatStr)) {
            try {
                indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) originStr, formatStr, 0, false, 6, (Object) null);
                int length = formatStr.length();
                SpannableString spannableString = new SpannableString(originStr);
                int i3 = length + indexOf$default;
                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#E0E0E0")), indexOf$default, i3, 33);
                spannableString.setSpan(new AbsoluteSizeSpan(17, true), indexOf$default, i3, 33);
                return spannableString;
            } catch (RuntimeException e16) {
                QLog.e("QGL.LivePCAssistantFragment", 1, "formatText error: " + e16);
                return new SpannableString("");
            }
        }
        return new SpannableString("");
    }

    private final void Gi(ImageView imageView, String drawableUrl) {
        com.tencent.mobileqq.guild.picload.e.a().e(Option.obtain().setTargetView(imageView).setUrl(drawableUrl));
    }

    private final void Hi(View view) {
        View findViewById = view.findViewById(R.id.wmq);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.g\u2026ve_pc_assistant_guide1_1)");
        this.guidePicFirst = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.wmr);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.g\u2026ve_pc_assistant_guide1_2)");
        this.guidePicSecond = (ImageView) findViewById2;
        View findViewById3 = view.findViewById(R.id.wms);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.g\u2026live_pc_assistant_guide2)");
        this.guidePicThird = (ImageView) findViewById3;
        View findViewById4 = view.findViewById(R.id.wmt);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.g\u2026live_pc_assistant_guide3)");
        this.guidePicForth = (ImageView) findViewById4;
        ImageView imageView = this.guidePicFirst;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guidePicFirst");
            imageView = null;
        }
        Gi(imageView, "https://downv6.qq.com/innovate/guild/live_channel/guild_live_pc_assistant_guide1_1.png");
        ImageView imageView3 = this.guidePicSecond;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guidePicSecond");
            imageView3 = null;
        }
        Gi(imageView3, "https://downv6.qq.com/innovate/guild/live_channel/guild_live_pc_assistant_guide1_2.png");
        ImageView imageView4 = this.guidePicThird;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guidePicThird");
            imageView4 = null;
        }
        Gi(imageView4, "https://downv6.qq.com/innovate/guild/live_channel/guild_live_pc_assistant_guide2.png");
        ImageView imageView5 = this.guidePicForth;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guidePicForth");
        } else {
            imageView2 = imageView5;
        }
        Gi(imageView2, "https://downv6.qq.com/innovate/guild/live_channel/guild_live_pc_assistant_guide3.png");
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag, com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.e
    public void d6() {
        super.d6();
        QLog.d("QGL.LivePCAssistantFragment", 1, "onUnSelected removeObserver");
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag
    public void ei(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ch.f235509b.setElementReport(view, "em_stream_pc_page", ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_ALL);
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag, com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment
    protected int getLayoutId() {
        return R.layout.f168118ex0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag, com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment
    public void initView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.wmu);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.g\u2026_pc_assistant_guide_tip1)");
        this.guideTipFirst = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.wmv);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.g\u2026_pc_assistant_guide_tip3)");
        this.guideTipThird = (TextView) findViewById2;
        TextView textView = this.guideTipFirst;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guideTipFirst");
            textView = null;
        }
        String string = getString(R.string.f148120yq);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.guild\u2026_pc_assistant_guide_tip1)");
        String string2 = getString(R.string.f148130yr);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.guild\u2026assistant_guide_tip1_key)");
        textView.setText(Fi(string, string2));
        TextView textView3 = this.guideTipThird;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guideTipThird");
        } else {
            textView2 = textView3;
        }
        String string3 = getString(R.string.f148150yt);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.guild\u2026_pc_assistant_guide_tip3)");
        String string4 = getString(R.string.f148160yu);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(R.string.guild\u2026assistant_guide_tip3_key)");
        textView2.setText(Fi(string3, string4));
        Hi(view);
        fi(view, 4);
        ei(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        QLog.i("QGL.LivePCAssistantFragment", 1, "onDestroy.");
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        QLog.i("QGL.LivePCAssistantFragment", 1, "onDestroyView.");
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag, com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.e
    public void onSelected(boolean isFirstCreate) {
        super.onSelected(isFirstCreate);
        QLog.i("QGL.LivePCAssistantFragment", 1, "onSelected, isFirstCreate[" + isFirstCreate + "]");
        LiveReadyBaseFrag.INSTANCE.a(3);
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
    }
}
