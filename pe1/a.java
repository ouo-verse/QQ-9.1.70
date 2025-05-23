package pe1;

import android.app.Activity;
import android.view.View;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.guild.aio.component.combinestyle.GuildMediaAioAvatarComponent;
import com.tencent.guild.aio.component.combinestyle.GuildMediaAioCombineStyleChain;
import com.tencent.guild.aio.component.combinestyle.GuildMediaAioTextComponent;
import com.tencent.guild.aio.component.combinestyle.GuildMediaAioTextDrawableComponent;
import com.tencent.guild.aio.component.combinestyle.aa;
import com.tencent.guild.aio.component.combinestyle.af;
import com.tencent.guild.aio.component.combinestyle.ah;
import com.tencent.guild.aio.component.combinestyle.an;
import com.tencent.guild.aio.component.combinestyle.y;
import com.tencent.guild.aio.util.h;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.qqnt.kernel.nativeinterface.LiveGiftElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B*\u0012!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\u000e\u00a2\u0006\u0004\b\u0016\u0010\u0017J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u001a\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0006H\u0016R/\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lpe1/a;", "Lcom/tencent/guild/aio/component/combinestyle/af;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "Lcom/tencent/qqnt/kernel/nativeinterface/LiveGiftElement;", "giftInfo", "Lcom/tencent/guild/aio/component/combinestyle/aa;", "combineStyleComponent", "Lcom/tencent/guild/aio/component/combinestyle/i;", "b", "guildMsgItem", "c", "combineStyleAioItem", "a", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "Lcom/tencent/guild/aio/component/combinestyle/ah;", "Lkotlin/jvm/functions/Function1;", "loadImageStrategy", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a implements af {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<Integer, ah> loadImageStrategy;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001J\u0019\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u0096\u0002\u00a8\u0006\b"}, d2 = {"pe1/a$a", "Lkotlin/Function2;", "Landroid/view/View;", "Lcom/tencent/guild/aio/component/combinestyle/aa;", "", "view", "handleText", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: pe1.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static final class C11010a implements Function2<View, aa, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ aa f426048d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildMsgItem f426049e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ LiveGiftElement f426050f;

        C11010a(aa aaVar, GuildMsgItem guildMsgItem, LiveGiftElement liveGiftElement) {
            this.f426048d = aaVar;
            this.f426049e = guildMsgItem;
            this.f426050f = liveGiftElement;
        }

        public void a(@NotNull View view, @NotNull aa handleText) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(handleText, "handleText");
            h hVar = h.f112401a;
            Activity activity = this.f426048d.getActivity();
            String str = this.f426049e.getMsgRecord().guildId;
            Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.guildId");
            String str2 = this.f426049e.getMsgRecord().channelId;
            Intrinsics.checkNotNullExpressionValue(str2, "msgItem.msgRecord.channelId");
            hVar.z(activity, str, str2, this.f426050f.senderMemberInfo.tinyId.toString(), false);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(View view, aa aaVar) {
            a(view, aaVar);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001J\u0019\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u0096\u0002\u00a8\u0006\b"}, d2 = {"pe1/a$b", "Lkotlin/Function2;", "Landroid/view/View;", "Lcom/tencent/guild/aio/component/combinestyle/aa;", "", "view", "handleText", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements Function2<View, aa, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ aa f426051d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildMsgItem f426052e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ LiveGiftElement f426053f;

        b(aa aaVar, GuildMsgItem guildMsgItem, LiveGiftElement liveGiftElement) {
            this.f426051d = aaVar;
            this.f426052e = guildMsgItem;
            this.f426053f = liveGiftElement;
        }

        public void a(@NotNull View view, @NotNull aa handleText) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(handleText, "handleText");
            h hVar = h.f112401a;
            Activity activity = this.f426051d.getActivity();
            String str = this.f426052e.getMsgRecord().guildId;
            Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.guildId");
            String str2 = this.f426052e.getMsgRecord().channelId;
            Intrinsics.checkNotNullExpressionValue(str2, "msgItem.msgRecord.channelId");
            hVar.z(activity, str, str2, this.f426053f.senderMemberInfo.tinyId.toString(), false);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(View view, aa aaVar) {
            a(view, aaVar);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001J\u0019\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u0096\u0002\u00a8\u0006\b"}, d2 = {"pe1/a$c", "Lkotlin/Function2;", "Landroid/view/View;", "Lcom/tencent/guild/aio/component/combinestyle/aa;", "", "view", "handleText", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c implements Function2<View, aa, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ aa f426054d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildMsgItem f426055e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ LiveGiftElement f426056f;

        c(aa aaVar, GuildMsgItem guildMsgItem, LiveGiftElement liveGiftElement) {
            this.f426054d = aaVar;
            this.f426055e = guildMsgItem;
            this.f426056f = liveGiftElement;
        }

        public void a(@NotNull View view, @NotNull aa handleText) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(handleText, "handleText");
            h hVar = h.f112401a;
            Activity activity = this.f426054d.getActivity();
            String str = this.f426055e.getMsgRecord().guildId;
            Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.guildId");
            String str2 = this.f426055e.getMsgRecord().channelId;
            Intrinsics.checkNotNullExpressionValue(str2, "msgItem.msgRecord.channelId");
            hVar.z(activity, str, str2, this.f426056f.receiverMemberInfo.tinyId.toString(), false);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(View view, aa aaVar) {
            a(view, aaVar);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(@NotNull Function1<? super Integer, ? extends ah> loadImageStrategy) {
        Intrinsics.checkNotNullParameter(loadImageStrategy, "loadImageStrategy");
        this.loadImageStrategy = loadImageStrategy;
    }

    private final GuildMediaAioCombineStyleChain b(GuildMsgItem msgItem, LiveGiftElement giftInfo, aa combineStyleComponent) {
        y yVar = new y();
        String str = msgItem.getMsgRecord().senderUid;
        Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.senderUid");
        String str2 = msgItem.getMsgRecord().guildId;
        Intrinsics.checkNotNullExpressionValue(str2, "msgItem.msgRecord.guildId");
        y a16 = yVar.a(new GuildMediaAioAvatarComponent(new com.tencent.mobileqq.guild.aiocombinestyle.imagestrategy.b(str, str2), true, new C11010a(combineStyleComponent, msgItem, giftInfo), null, null, 24, null));
        String str3 = giftInfo.senderMemberInfo.nickName;
        Intrinsics.checkNotNullExpressionValue(str3, "giftInfo.senderMemberInfo.nickName");
        String str4 = combineStyleComponent.getNickName(str3) + " ";
        String valueOf = String.valueOf(giftInfo.senderMemberInfo.roleColor);
        String str5 = giftInfo.senderMemberInfo.tinyId;
        Intrinsics.checkNotNullExpressionValue(str5, "giftInfo.senderMemberInfo.tinyId");
        y a17 = a16.a(new GuildMediaAioTextComponent(str4, new an(valueOf, str5), true, 0, 0, 0, new b(combineStyleComponent, msgItem, giftInfo), null, null, false, 952, null));
        UIUtil uIUtil = UIUtil.f112434a;
        y a18 = a17.a(new GuildMediaAioTextComponent(uIUtil.x().getString(R.string.f14940127), null, false, 0, 0, 0, null, null, null, false, 1022, null));
        String str6 = giftInfo.receiverMemberInfo.nickName;
        Intrinsics.checkNotNullExpressionValue(str6, "giftInfo.receiverMemberInfo.nickName");
        String str7 = combineStyleComponent.getNickName(str6) + " ";
        String valueOf2 = String.valueOf(giftInfo.receiverMemberInfo.roleColor);
        String str8 = giftInfo.receiverMemberInfo.tinyId;
        Intrinsics.checkNotNullExpressionValue(str8, "giftInfo.receiverMemberInfo.tinyId");
        y a19 = a18.a(new GuildMediaAioTextComponent(str7, new an(valueOf2, str8), true, 0, 0, 0, new c(combineStyleComponent, msgItem, giftInfo), null, null, false, 952, null));
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = uIUtil.x().getString(R.string.f14939126);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.\u2026_gift_msg_send_gift_name)");
        String format = String.format(string, Arrays.copyOf(new Object[]{giftInfo.kStrGiftName}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        y a26 = a19.a(new GuildMediaAioTextComponent(format, null, false, 0, 0, 0, null, null, null, false, 1022, null)).a(new GuildMediaAioTextDrawableComponent(this.loadImageStrategy.invoke(Integer.valueOf(giftInfo.materialId)), 0, false, null, null, null, 62, null));
        long kUInt64GiftNum = giftInfo.getKUInt64GiftNum();
        if (kUInt64GiftNum > 1) {
            a26.a(new GuildMediaAioTextComponent(" x" + kUInt64GiftNum, null, false, 0, 0, 0, null, null, null, false, 1022, null));
        }
        return a26.i();
    }

    private final LiveGiftElement c(GuildMsgItem guildMsgItem) {
        Object obj;
        boolean z16;
        ArrayList<MsgElement> arrayList = guildMsgItem.getMsgRecord().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "guildMsgItem.msgRecord.elements");
        Iterator<T> it = arrayList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((MsgElement) obj).liveGiftElement != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        MsgElement msgElement = (MsgElement) obj;
        if (msgElement == null) {
            return null;
        }
        return msgElement.liveGiftElement;
    }

    @Override // com.tencent.guild.aio.component.combinestyle.af
    @Nullable
    public GuildMediaAioCombineStyleChain a(@NotNull GuildMsgItem guildMsgItem, @NotNull aa combineStyleAioItem) {
        Intrinsics.checkNotNullParameter(guildMsgItem, "guildMsgItem");
        Intrinsics.checkNotNullParameter(combineStyleAioItem, "combineStyleAioItem");
        LiveGiftElement c16 = c(guildMsgItem);
        if (c16 != null) {
            return b(guildMsgItem, c16, combineStyleAioItem);
        }
        return null;
    }
}
