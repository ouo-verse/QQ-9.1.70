package n82;

import com.tencent.aio.stranger.liteaction.QQStrangerLIAMsgIntent;
import com.tencent.input.base.panelcontainer.keyboard.KeyboardMsgIntent;
import com.tencent.mobileqq.matchfriend.reborn.liteinteraction.QQStrangerLIAHelper;
import com.tencent.mobileqq.matchfriend.reborn.liteinteraction.QQStrangerLIAItem;
import com.tencent.mobileqq.matchfriend.reborn.liteinteraction.e;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.j;
import com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016\u00a8\u0006\u0014"}, d2 = {"Ln82/b;", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/processor/BottomSectionBarBaseProcessor;", "", ReportConstant.COSTREPORT_PREFIX, "", "hide", "r", "t", "", "f", "e", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", h.F, "Lol3/b;", "i", "j", "l", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends BottomSectionBarBaseProcessor {
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0056, code lost:
    
        if ((r0.getResource().getLabel().length() == 0) != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void s() {
        List listOf;
        ArrayList arrayListOf;
        QQStrangerLIAItem u16 = QQStrangerLIAHelper.f245114a.u(new Contact(d().g().r().c().e(), d().g().r().c().j(), ""), 2);
        if (u16 != null) {
            if (e.c(u16.getResource()) == null) {
            }
            j e16 = d().e();
            listOf = CollectionsKt__CollectionsJVMKt.listOf(Integer.valueOf(u16.getResource().getEmojiId()));
            e16.h(new QQStrangerLIAMsgIntent.OnShowEmojiLIAMsgIntent(listOf));
            int f16 = f();
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new com.tencent.qqnt.aio.bottombar.sectionbar.model.a(f(), "", u16.getResource().getSummary().toString(), u16));
            p(new com.tencent.qqnt.aio.bottombar.sectionbar.model.b(f16, arrayListOf));
            return;
        }
        t();
    }

    private final void t() {
        p(new com.tencent.qqnt.aio.bottombar.sectionbar.model.b(f(), new ArrayList()));
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor
    public int e() {
        return 6;
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor
    public int f() {
        return 5;
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.input.base.panelcontainer.keyboard.KeyboardMsgIntent.OnKeyboardStateChanged");
        hashSet.add("com.tencent.aio.stranger.liteaction.QQStrangerLIAMsgIntent.RefreshQQStrangerBottomLIAMsgIntent");
        return hashSet;
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        return new HashSet();
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor
    public boolean h(MsgIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof QQStrangerLIAMsgIntent.RefreshQQStrangerBottomLIAMsgIntent) {
            s();
            return false;
        }
        if (!(intent instanceof KeyboardMsgIntent.OnKeyboardStateChanged)) {
            return false;
        }
        r(((KeyboardMsgIntent.OnKeyboardStateChanged) intent).b());
        return false;
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor
    public void i(ol3.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor
    public boolean j() {
        return true;
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor
    public void l() {
        super.l();
        s();
    }

    private final void r(boolean hide) {
        if (hide) {
            t();
        } else {
            s();
        }
    }
}
