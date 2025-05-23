package com.tencent.guild.aio.halfpop.menu;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.halfpop.menu.t;
import com.tencent.guild.aio.util.ui.GuildChatPicDownloader;
import com.tencent.guild.aio.util.ui.PicSize;
import com.tencent.guild.api.aio.panel.UpdateFavEmoPageEvent;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.emoji.ILottieEmoProxyApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\t\b\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/guild/aio/halfpop/menu/SaveToEmojiMenuItem;", "Lcom/tencent/guild/aio/halfpop/menu/t;", "", "L", "M", "", "sourcePath", "J", "path", "", "K", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "data", "t", "Landroid/view/View;", "view", UserInfo.SEX_FEMALE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "<init>", "()V", "g", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class SaveToEmojiMenuItem extends t {
    public SaveToEmojiMenuItem() {
        super(new t.ItemData(R.drawable.qui_add_emoji, R.string.f1650027c));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(String sourcePath) {
        Unit unit;
        Context v3 = v();
        if (v3 != null) {
            ((ILottieEmoProxyApi) QRoute.api(ILottieEmoProxyApi.class)).addToCustomEmotion(v3, sourcePath);
            h().e().h(new UpdateFavEmoPageEvent());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.e("SaveToEmojiMenuItem", 1, "getContext() is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean K(String path) {
        return new File(path).exists();
    }

    private final void L() {
        MarketFaceElement marketFaceElement;
        Context v3;
        MsgElement firstTypeElement = i().getFirstTypeElement(11);
        if (firstTypeElement != null) {
            marketFaceElement = firstTypeElement.marketFaceElement;
        } else {
            marketFaceElement = null;
        }
        if (marketFaceElement == null || (v3 = v()) == null) {
            return;
        }
        Fragment c16 = h().c();
        Intrinsics.checkNotNullExpressionValue(c16, "aioContext.fragment");
        CorountineFunKt.e(LifecycleOwnerKt.getLifecycleScope(c16), "SaveToEmojiMenuItem", null, null, null, new SaveToEmojiMenuItem$handleFavEmoForMarketFaceMsg$1(v3, marketFaceElement, null), 14, null);
    }

    private final void M() {
        final String b16 = qr0.d.b(i());
        QLog.i("SaveToEmojiMenuItem", 1, "handleFavEmoForPicMsg path=" + b16);
        if (K(b16)) {
            QLog.i("SaveToEmojiMenuItem", 1, "handleFavEmoForPicMsg====addFav");
            J(b16);
        } else {
            QLog.i("SaveToEmojiMenuItem", 1, "handleFavEmoForPicMsg====download pic");
            GuildChatPicDownloader.f112420a.h(PicSize.PIC_DOWNLOAD_ORI, i().getMsgRecord(), new Function1<FileTransNotifyInfo, Unit>() { // from class: com.tencent.guild.aio.halfpop.menu.SaveToEmojiMenuItem$handleFavEmoForPicMsg$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(FileTransNotifyInfo fileTransNotifyInfo) {
                    invoke2(fileTransNotifyInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull FileTransNotifyInfo it) {
                    boolean K;
                    Intrinsics.checkNotNullParameter(it, "it");
                    long j3 = it.fileErrCode;
                    K = SaveToEmojiMenuItem.this.K(b16);
                    QLog.i("SaveToEmojiMenuItem", 1, "handleFavEmoForPicMsg====download result:" + j3 + " sourceExist=" + K);
                    SaveToEmojiMenuItem.this.J(b16);
                }
            });
        }
    }

    @Override // com.tencent.guild.aio.halfpop.menu.a, com.tencent.guild.aio.halfpop.menu.b, com.tencent.guild.aio.halfpop.menu.n
    /* renamed from: F */
    public void b(@NotNull View view, @NotNull GuildMsgItem data) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
        if (qr0.d.m(data)) {
            M();
        } else if (qr0.d.i(data)) {
            L();
        } else {
            QLog.i("SaveToEmojiMenuItem", 4, "unknown type");
        }
        j().o8();
    }

    @Override // com.tencent.guild.aio.halfpop.menu.a, com.tencent.guild.aio.halfpop.menu.b, com.tencent.guild.aio.halfpop.menu.n
    public void onDestroy() {
        QLog.i("SaveToEmojiMenuItem", 4, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        super.onDestroy();
    }

    @Override // com.tencent.guild.aio.halfpop.menu.t, com.tencent.guild.aio.halfpop.menu.b, com.tencent.guild.aio.halfpop.menu.n
    /* renamed from: t */
    public boolean a(@NotNull GuildMsgItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (!D()) {
            QLog.i("SaveToEmojiMenuItem", 4, "msgSend not success");
            return false;
        }
        if (qr0.d.m(data) && (B() || A())) {
            QLog.i("SaveToEmojiMenuItem", 4, "pic msg");
            return true;
        }
        if (!qr0.d.i(data)) {
            return false;
        }
        QLog.i("SaveToEmojiMenuItem", 4, "isMarketFaceMsg msg");
        return true;
    }
}
