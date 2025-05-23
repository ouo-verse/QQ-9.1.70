package i72;

import com.tencent.aio.data.AIOContact;
import com.tencent.input.base.panelcontainer.keyboard.KeyboardMsgIntent;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.reborn.liteinteraction.QQStrangerLIAHelper;
import com.tencent.mobileqq.matchfriend.reborn.liteinteraction.QQStrangerLIAItem;
import com.tencent.mobileqq.matchfriend.reborn.liteinteraction.QQStrangerLIAResource;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.assistedchat.AssistedChatMsgIntent;
import com.tencent.qqnt.aio.assistedchat.api.IAssistedChatApi;
import com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016R\u0016\u0010\u0014\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013\u00a8\u0006\u001b"}, d2 = {"Li72/h;", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/processor/BottomSectionBarBaseProcessor;", "", "emojiId", "", ReportConstant.COSTREPORT_PREFIX, "r", "f", "e", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", tl.h.F, "Lol3/b;", "i", "j", "Z", "isKeyboardShow", BdhLogUtil.LogTag.Tag_Conn, "hasShow", "<init>", "()V", "D", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class h extends BottomSectionBarBaseProcessor {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean hasShow;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isKeyboardShow;

    private final void r() {
        p(new com.tencent.qqnt.aio.bottombar.sectionbar.model.b(f(), new ArrayList()));
        AIOContact c16 = d().g().r().c();
        ((IAssistedChatApi) QRoute.api(IAssistedChatApi.class)).setPrologueSayHiEmojiId(c16.e(), c16.j(), -1);
    }

    private final void s(int emojiId) {
        Map mapOf;
        ArrayList arrayListOf;
        QQStrangerLIAResource resource;
        if (this.hasShow || emojiId == -1) {
            return;
        }
        QQStrangerLIAItem u16 = QQStrangerLIAHelper.f245114a.u(new Contact(d().g().r().c().e(), d().g().r().c().j(), ""), 2);
        if ((u16 == null || (resource = u16.getResource()) == null || resource.getEmojiId() != emojiId) ? false : true) {
            return;
        }
        int f16 = f();
        int f17 = f();
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("emoji_id", Integer.valueOf(emojiId)));
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new com.tencent.qqnt.aio.bottombar.sectionbar.model.a(f17, "", "Hi", mapOf));
        p(new com.tencent.qqnt.aio.bottombar.sectionbar.model.b(f16, arrayListOf));
        this.hasShow = true;
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor
    public int e() {
        return 3;
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor
    public int f() {
        return 3;
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.input.base.panelcontainer.keyboard.KeyboardMsgIntent.OnKeyboardStateChanged");
        hashSet.add("com.tencent.qqnt.aio.assistedchat.AssistedChatMsgIntent.PrologueStatusChange");
        return hashSet;
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        return new HashSet();
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor
    public boolean h(MsgIntent intent) {
        int prologueSayHiEmojiId;
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof KeyboardMsgIntent.OnKeyboardStateChanged) {
            this.isKeyboardShow = ((KeyboardMsgIntent.OnKeyboardStateChanged) intent).b();
        } else {
            if (!(intent instanceof AssistedChatMsgIntent.PrologueStatusChange)) {
                return false;
            }
            AssistedChatMsgIntent.PrologueStatusChange prologueStatusChange = (AssistedChatMsgIntent.PrologueStatusChange) intent;
            if (prologueStatusChange.b()) {
                QLog.i("QQStrangerPrologueSayHiProcessor", 1, "SayHiVisibleUpdateIntent emojiId=" + prologueStatusChange.a());
                if (prologueStatusChange.a() != -1) {
                    prologueSayHiEmojiId = prologueStatusChange.a();
                } else {
                    AIOContact c16 = d().g().r().c();
                    prologueSayHiEmojiId = ((IAssistedChatApi) QRoute.api(IAssistedChatApi.class)).getPrologueSayHiEmojiId(c16.e(), c16.j());
                }
                s(prologueSayHiEmojiId);
            } else {
                r();
            }
        }
        return true;
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor
    public void i(ol3.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor
    public boolean j() {
        return !this.isKeyboardShow;
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor
    public List<String> m() {
        List<String> emptyList;
        int e16 = d().g().r().c().e();
        if (e16 != 104 && e16 != 119) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return super.m();
    }
}
