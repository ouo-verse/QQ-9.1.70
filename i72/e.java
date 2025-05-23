package i72;

import com.tencent.aio.data.AIOContact;
import com.tencent.input.base.panelcontainer.keyboard.KeyboardMsgIntent;
import com.tencent.luggage.wxa.yf.e0;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qqnt.aio.api.IAIOEmoApi;
import com.tencent.qqnt.aio.api.IMsgSendHelper;
import com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import j72.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016R\u0016\u0010\u0014\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Li72/e;", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/processor/BottomSectionBarBaseProcessor;", "Li72/i;", "model", "", "t", "", ReportConstant.COSTREPORT_PREFIX, "", "f", "e", "l", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", tl.h.F, "Lol3/b;", "i", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "isKeyboardShow", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class e extends BottomSectionBarBaseProcessor {
    private static final List<com.tencent.qqnt.aio.bottombar.sectionbar.model.a> D;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isKeyboardShow;

    static {
        ArrayList arrayListOf;
        int collectionSizeOrDefault;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new QQStrangerQuickEmojiModel(397, "\u9001\u4f60\u82b1\u82b1"), new QQStrangerQuickEmojiModel(403, "\u51fa\u6765\u73a9"), new QQStrangerQuickEmojiModel(e0.CTRL_INDEX, "\u592a\u8d5e\u4e86"), new QQStrangerQuickEmojiModel(412, "\u8d85\u5f00\u5fc3"), new QQStrangerQuickEmojiModel(413, "\u4e00\u8d77\u55e8"), new QQStrangerQuickEmojiModel(425, "\u5df2\u8001\u5b9e"), new QQStrangerQuickEmojiModel(386, "\u5624\u5624\u5624"));
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayListOf, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayListOf.iterator();
        while (it.hasNext()) {
            arrayList.add(new com.tencent.qqnt.aio.bottombar.sectionbar.model.a(8, "", "", (QQStrangerQuickEmojiModel) it.next()));
        }
        D = arrayList;
    }

    private final boolean s() {
        return d().g().r().c().e() == 104;
    }

    private final void t(final QQStrangerQuickEmojiModel model) {
        ThreadManagerV2.excute(new Runnable() { // from class: i72.d
            @Override // java.lang.Runnable
            public final void run() {
                e.u(e.this, model);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(e this$0, QQStrangerQuickEmojiModel model) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(model, "$model");
        AIOContact c16 = this$0.d().g().r().c();
        Contact contact = new Contact(c16.e(), c16.j(), "");
        QRouteApi api = QRoute.api(IAIOEmoApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAIOEmoApi::class.java)");
        IAIOEmoApi.a.c((IAIOEmoApi) api, model.getEmojiId(), contact, true, null, 8, null);
        ((IMsgSendHelper) QRoute.api(IMsgSendHelper.class)).syncSendText(c16.j(), c16.e(), model.getDesc());
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor
    public int e() {
        return 2;
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor
    public int f() {
        return 8;
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.input.base.panelcontainer.keyboard.KeyboardMsgIntent.OnKeyboardStateChanged");
        return hashSet;
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        return new HashSet();
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor
    public boolean h(MsgIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (!(intent instanceof KeyboardMsgIntent.OnKeyboardStateChanged)) {
            return false;
        }
        KeyboardMsgIntent.OnKeyboardStateChanged onKeyboardStateChanged = (KeyboardMsgIntent.OnKeyboardStateChanged) intent;
        if (this.isKeyboardShow == onKeyboardStateChanged.b()) {
            return true;
        }
        this.isKeyboardShow = onKeyboardStateChanged.b();
        return true;
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor
    public void i(ol3.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.OnClickItemIntent) {
            t(((a.OnClickItemIntent) intent).getQuickEmojiModel());
        }
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor
    public boolean j() {
        return s() && !this.isKeyboardShow;
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor
    public void l() {
        super.l();
        if (s()) {
            int f16 = f();
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(D);
            Unit unit = Unit.INSTANCE;
            p(new com.tencent.qqnt.aio.bottombar.sectionbar.model.b(f16, arrayList));
        }
    }
}
