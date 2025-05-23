package com.tencent.mobileqq.troop.aivoicechat.voicelist.config;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qui.toast.QUIStatusToast;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.VoiceItem;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import vr2.h;
import vr2.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 02\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00011B\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u0012\u0006\u0010-\u001a\u00020\u0006\u00a2\u0006\u0004\b.\u0010/J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ&\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0014J\u0006\u0010\u0015\u001a\u00020\bJ\u0006\u0010\u0016\u001a\u00020\bR\u0017\u0010\u001c\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u001b\u0010,\u001a\u00020'8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/troop/aivoicechat/voicelist/config/TroopAIVoiceChatListConfig;", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$a;", "Lcom/tencent/mobileqq/widget/listitem/x$c$i;", "Landroid/widget/ImageView;", "imageView", "", "url", "", "a0", "Landroid/content/Context;", "context", "b0", "Lcom/tencent/mobileqq/widget/listitem/QUISingleLineListItem;", "view", "", "position", "", "", "payloads", "P", "d0", "e0", "Lcom/tencent/qqnt/kernel/nativeinterface/VoiceItem;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/qqnt/kernel/nativeinterface/VoiceItem;", "Z", "()Lcom/tencent/qqnt/kernel/nativeinterface/VoiceItem;", "voiceItemInfo", "Landroid/widget/TextView;", "r", "Landroid/widget/TextView;", "textView", ReportConstant.COSTREPORT_PREFIX, "Landroid/widget/ImageView;", "iconView", "t", "Ljava/lang/String;", "staticIconUrl", "Lvr2/h;", "u", "Lkotlin/Lazy;", "Y", "()Lvr2/h;", "samplePlayer", "selectedId", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/VoiceItem;Ljava/lang/String;)V", "v", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TroopAIVoiceChatListConfig extends x<x.b.a, x.c.i> {

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private final VoiceItem voiceItemInfo;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private TextView textView;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private ImageView iconView;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private String staticIconUrl;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private final Lazy samplePlayer;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TroopAIVoiceChatListConfig(VoiceItem voiceItemInfo, String selectedId) {
        super(new x.b.a(r1, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9130/aishengliao/qecommerce_shengliao_icon_list_normal.png"), new x.c.i(Intrinsics.areEqual(selectedId, voiceItemInfo.voiceId), null, 2, null));
        Lazy lazy;
        Intrinsics.checkNotNullParameter(voiceItemInfo, "voiceItemInfo");
        Intrinsics.checkNotNullParameter(selectedId, "selectedId");
        String str = voiceItemInfo.displayName;
        Intrinsics.checkNotNullExpressionValue(str, "voiceItemInfo.displayName");
        this.voiceItemInfo = voiceItemInfo;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<h>() { // from class: com.tencent.mobileqq.troop.aivoicechat.voicelist.config.TroopAIVoiceChatListConfig$samplePlayer$2
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                return new h();
            }
        });
        this.samplePlayer = lazy;
    }

    private final h Y() {
        return (h) this.samplePlayer.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a0(ImageView imageView, String url) {
        try {
            Option option = Option.obtain().setTargetView(imageView).setUrl(url).setLoadingDrawableId(R.drawable.f13478);
            QQPicLoader qQPicLoader = QQPicLoader.f201806a;
            Intrinsics.checkNotNullExpressionValue(option, "option");
            qQPicLoader.e(option, null);
        } catch (Exception e16) {
            QLog.e("TroopAIVoiceChatListConfig", 1, "loadImage exception ", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(TroopAIVoiceChatListConfig this$0, MediaPlayer mediaPlayer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView imageView = this$0.iconView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iconView");
            imageView = null;
        }
        this$0.a0(imageView, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9130/aishengliao/qecommerce_shengliao_icon_list_secondary.png");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.x, com.tencent.mobileqq.widget.listitem.w
    /* renamed from: P */
    public void F(QUISingleLineListItem view, int position, List<? extends Object> payloads) {
        String str;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.F(view, position, payloads);
        if (!QQTheme.isNowThemeSimpleNight() && !QQTheme.isNowThemeIsNight()) {
            str = "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9130/aishengliao/qecommerce_shengliao_icon_list_normal.png";
        } else {
            str = "https://qq-ecommerce.cdn-go.cn/url/latest/darkmode/9130/aishengliao/qecommerce_shengliao_icon_list_normal.png";
        }
        this.staticIconUrl = str;
        View findViewById = view.findViewById(R.id.f66203a0);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.qui_list_item_left_text)");
        this.textView = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.f66153_v);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.qui_list_item_left_avatar)");
        ImageView imageView = (ImageView) findViewById2;
        this.iconView = imageView;
        String str2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iconView");
            imageView = null;
        }
        imageView.setBackgroundResource(R.drawable.f13478);
        ImageView imageView2 = this.iconView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iconView");
            imageView2 = null;
        }
        String str3 = this.staticIconUrl;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("staticIconUrl");
        } else {
            str2 = str3;
        }
        a0(imageView2, str2);
    }

    /* renamed from: Z, reason: from getter */
    public final VoiceItem getVoiceItemInfo() {
        return this.voiceItemInfo;
    }

    public final void d0() {
        Y().f();
    }

    public final void e0() {
        TextView textView = this.textView;
        String str = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
            textView = null;
        }
        TextView textView2 = this.textView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
            textView2 = null;
        }
        textView.setTextColor(textView2.getContext().getColor(R.color.qui_common_text_primary));
        ImageView imageView = this.iconView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iconView");
            imageView = null;
        }
        String str2 = this.staticIconUrl;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("staticIconUrl");
        } else {
            str = str2;
        }
        a0(imageView, str);
    }

    public final void b0(Context context) {
        if (context == null) {
            return;
        }
        TextView textView = this.textView;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
            textView = null;
        }
        TextView textView3 = this.textView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
        } else {
            textView2 = textView3;
        }
        textView.setTextColor(textView2.getContext().getColor(R.color.qui_common_brand_standard));
        if (i.f443207a.a(context)) {
            QUIStatusToast qUIStatusToast = new QUIStatusToast((Activity) context);
            qUIStatusToast.setIcon(R.drawable.qui_voice_mute_icon_white_primary);
            qUIStatusToast.P("\u8bf7\u8c03\u5927\u58f0\u97f3\u540e\u64ad\u653e");
            qUIStatusToast.show();
        }
        h Y = Y();
        String str = this.voiceItemInfo.exampleUrl;
        Intrinsics.checkNotNullExpressionValue(str, "voiceItemInfo.exampleUrl");
        Y.h(str, new Function0<Unit>() { // from class: com.tencent.mobileqq.troop.aivoicechat.voicelist.config.TroopAIVoiceChatListConfig$onSelected$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ImageView imageView;
                TroopAIVoiceChatListConfig troopAIVoiceChatListConfig = TroopAIVoiceChatListConfig.this;
                imageView = troopAIVoiceChatListConfig.iconView;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("iconView");
                    imageView = null;
                }
                troopAIVoiceChatListConfig.a0(imageView, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9130/aishengliao/qecommerce_shengliao_icon_list_selected_iSpt.png");
            }
        }, new Function0<Unit>() { // from class: com.tencent.mobileqq.troop.aivoicechat.voicelist.config.TroopAIVoiceChatListConfig$onSelected$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ImageView imageView;
                TroopAIVoiceChatListConfig troopAIVoiceChatListConfig = TroopAIVoiceChatListConfig.this;
                imageView = troopAIVoiceChatListConfig.iconView;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("iconView");
                    imageView = null;
                }
                troopAIVoiceChatListConfig.a0(imageView, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9130/aishengliao/qecommerce_shengliao_icon_list_secondary.png");
            }
        }, new MediaPlayer.OnCompletionListener() { // from class: com.tencent.mobileqq.troop.aivoicechat.voicelist.config.a
            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer mediaPlayer) {
                TroopAIVoiceChatListConfig.c0(TroopAIVoiceChatListConfig.this, mediaPlayer);
            }
        });
    }
}
