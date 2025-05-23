package com.tencent.guild.aio.msglist.markdown;

import android.text.TextUtils;
import android.text.style.DynamicDrawableSpan;
import android.view.View;
import com.tencent.guild.api.richmediabrowser.IGuildRichMediaBrowserApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.markdown.api.IMarkdownConfigApi;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/tencent/android/androidbypass/e;", "invoke", "()Lcom/tencent/android/androidbypass/e;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildMarkDownContentComponent$mImageSpanClickListener$2 extends Lambda implements Function0<com.tencent.android.androidbypass.e> {
    final /* synthetic */ GuildMarkDownContentComponent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMarkDownContentComponent$mImageSpanClickListener$2(GuildMarkDownContentComponent guildMarkDownContentComponent) {
        super(0);
        this.this$0 = guildMarkDownContentComponent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildMarkDownContentComponent this$0, View view, DynamicDrawableSpan dynamicDrawableSpan, String str) {
        MsgRecord msgRecord;
        MsgRecord msgRecord2;
        boolean B1;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        if (dynamicDrawableSpan instanceof com.tencent.android.androidbypass.span.a) {
            fq0.a aVar = fq0.a.f400309a;
            com.tencent.android.androidbypass.span.a aVar2 = (com.tencent.android.androidbypass.span.a) dynamicDrawableSpan;
            String e16 = aVar.e(aVar2);
            if (e16 != null) {
                B1 = this$0.B1(view, aVar2, e16);
                if (B1) {
                    QLog.d("GuildMarkDownContentComponent", 1, "handleImageScheme:" + e16);
                    return;
                }
            }
            if (!aVar2.c()) {
                QLog.e("GuildMarkDownContentComponent", 1, "loadImage failed when clicked:" + str);
                return;
            }
            String g16 = aVar.g(aVar2);
            if (!TextUtils.isEmpty(g16)) {
                msgRecord = this$0.msgRecord;
                if (msgRecord == null) {
                    QLog.i("GuildMarkDownContentComponent", 1, "click markdwon image, msgRecord is null!");
                    return;
                }
                Intrinsics.checkNotNull(g16);
                msgRecord2 = this$0.msgRecord;
                Intrinsics.checkNotNull(msgRecord2);
                MsgRecord d16 = aVar.d(g16, msgRecord2);
                if (d16.elements.size() > 0 && d16.elements.get(0).picElement != null) {
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (peekAppRuntime == null) {
                        return;
                    }
                    ((IGuildRichMediaBrowserApi) QRoute.api(IGuildRichMediaBrowserApi.class)).enterImagePreview(peekAppRuntime, view.getContext(), view, d16, d16.elements.get(0).picElement, true, null, null);
                    return;
                }
                QLog.i("GuildMarkDownContentComponent", 1, "click markdwon image, picRecord has no picElement!");
                return;
            }
            QLog.i("GuildMarkDownContentComponent", 1, "click markdwon image, localPath is Empty!");
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final com.tencent.android.androidbypass.e invoke() {
        IMarkdownConfigApi iMarkdownConfigApi = (IMarkdownConfigApi) QRoute.api(IMarkdownConfigApi.class);
        final GuildMarkDownContentComponent guildMarkDownContentComponent = this.this$0;
        return (com.tencent.android.androidbypass.e) iMarkdownConfigApi.getWhitelistedSchemeClickListener(new com.tencent.android.androidbypass.e() { // from class: com.tencent.guild.aio.msglist.markdown.a
            @Override // com.tencent.android.androidbypass.e
            public final void a(View view, DynamicDrawableSpan dynamicDrawableSpan, String str) {
                GuildMarkDownContentComponent$mImageSpanClickListener$2.b(GuildMarkDownContentComponent.this, view, dynamicDrawableSpan, str);
            }
        });
    }
}
