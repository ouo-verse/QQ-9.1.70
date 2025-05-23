package com.tencent.guildmedia.aio.msglist.item.excellent;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.aio.data.AIOParam;
import com.tencent.guild.aio.component.combinestyle.GuildMediaItemBaseVM;
import com.tencent.guild.aio.msglist.reply.GuildUpdateReplyMsgOnMsgRevoke;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import ol3.b;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000eH\u0016R\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/guildmedia/aio/msglist/item/excellent/GuildMediaAnnounceContentComponentVM;", "Lcom/tencent/guild/aio/component/combinestyle/GuildMediaItemBaseVM;", "", "seq", "", "B", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "", "y", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "u", "Lol3/b;", "handleIntent", h.F, "J", "targetMsgSeq", "<init>", "()V", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildMediaAnnounceContentComponentVM extends GuildMediaItemBaseVM {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long targetMsgSeq = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final Contact A() {
        Contact contact = new Contact();
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        contact.chatType = com.tencent.guild.aio.util.a.e(g16);
        AIOParam g17 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g17, "mContext.aioParam");
        contact.guildId = com.tencent.guild.aio.util.a.g(g17);
        AIOParam g18 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g18, "mContext.aioParam");
        contact.peerUid = com.tencent.guild.aio.util.a.b(g18);
        return contact;
    }

    private final void B(long seq) {
        BuildersKt__Builders_commonKt.launch$default(vmScope(), null, null, new GuildMediaAnnounceContentComponentVM$getMsgBySeq$1(this, seq, null), 3, null);
    }

    @Override // com.tencent.guild.aio.component.combinestyle.GuildMediaItemBaseVM, com.tencent.guild.aio.msglist.holder.component.t, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void handleIntent(@NotNull b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.handleIntent(intent);
        if (intent instanceof LiveAnnounceContentGetRealMsg) {
            LiveAnnounceContentGetRealMsg liveAnnounceContentGetRealMsg = (LiveAnnounceContentGetRealMsg) intent;
            this.targetMsgSeq = liveAnnounceContentGetRealMsg.getSeq();
            B(liveAnnounceContentGetRealMsg.getSeq());
        }
    }

    @Override // com.tencent.guild.aio.component.combinestyle.GuildMediaItemBaseVM
    public void u(@NotNull MsgIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.u(intent);
        if ((intent instanceof GuildUpdateReplyMsgOnMsgRevoke) && ((GuildUpdateReplyMsgOnMsgRevoke) intent).a().contains(Long.valueOf(this.targetMsgSeq))) {
            updateUI(new LiveAnnounceRealMsgRemoved());
        }
    }

    @Override // com.tencent.guild.aio.component.combinestyle.GuildMediaItemBaseVM
    @NotNull
    public List<String> y() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(Reflection.getOrCreateKotlinClass(GuildUpdateReplyMsgOnMsgRevoke.class).getQualifiedName());
        return listOf;
    }
}
