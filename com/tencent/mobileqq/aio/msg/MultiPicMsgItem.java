package com.tencent.mobileqq.aio.msg;

import android.content.Context;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msglist.holder.component.pic.PicUtil;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.aio.msglist.payload.a;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOFileManagerApi;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.RichMediaElementGetReq;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u0000 A2\u00020\u0001:\u0001BB\u000f\u0012\u0006\u0010>\u001a\u00020$\u00a2\u0006\u0004\b?\u0010@J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0002J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0002J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J&\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0016\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\tH\u0002J$\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000eH\u0002J\u0014\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\rH\u0002J(\u0010\u0019\u001a\u00020\u0007*\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017H\u0002J\n\u0010\u001a\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u001bH\u0016J\u001c\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00110\r2\u0006\u0010\u0002\u001a\u00020\u001bH\u0014J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0001H\u0016J\u0012\u0010#\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010&\u001a\u00020\u00012\u0006\u0010%\u001a\u00020$H\u0016J\b\u0010'\u001a\u00020\u000eH\u0016J\f\u0010*\u001a\b\u0012\u0004\u0012\u00020)0(J\u0010\u0010,\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\u000eH\u0016J\b\u0010-\u001a\u00020\u0011H\u0016J\b\u0010.\u001a\u00020\u0011H\u0016R\u0014\u00101\u001a\u00020\u000e8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b/\u00100R\"\u00107\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u00100\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010:\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u00100\u001a\u0004\b8\u00104\"\u0004\b9\u00106R\u0016\u0010=\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/MultiPicMsgItem;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "target", "", ICustomDataEditor.STRING_PARAM_2, "t2", "v2", "", "r2", "Lcom/tencent/qqnt/kernel/nativeinterface/FileElement;", "fileElement", "", "fileElemId", "Lkotlin/Pair;", "", "o2", "p2", "", "q2", "width", "height", "k2", "m2", "Lkotlin/Function0;", "block", "u2", ICustomDataEditor.NUMBER_PARAM_2, "Lcom/tencent/aio/data/msglist/a;", "", "getChangePayload", "o", "newMsgItem", "l", "Landroid/content/Context;", "context", "Y0", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "targetMsgRecord", "b0", "getViewType", "", "Lcom/tencent/qqnt/kernel/nativeinterface/RichMediaElementGetReq;", "l2", "viewType", "getSubViewType", "toString", "f1", "W0", "I", TagName.FILE_TYPE, "X0", "getThumbHeight", "()I", "setThumbHeight", "(I)V", "thumbHeight", "getThumbWidth", "setThumbWidth", "thumbWidth", "Z0", "Z", "isInitThumbSize", "msgRecord", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", ICustomDataEditor.STRING_ARRAY_PARAM_1, "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class MultiPicMsgItem extends AIOMsgItem {
    static IPatchRedirector $redirector_;

    /* renamed from: a1, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: W0, reason: from kotlin metadata */
    private final int fileType;

    /* renamed from: X0, reason: from kotlin metadata */
    private int thumbHeight;

    /* renamed from: Y0, reason: from kotlin metadata */
    private int thumbWidth;

    /* renamed from: Z0, reason: from kotlin metadata */
    private boolean isInitThumbSize;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/MultiPicMsgItem$a;", "", "", "DISPLAY_THUMB_COUNT", "I", "SUB_VIEW_TYPE", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msg.MultiPicMsgItem$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57248);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiPicMsgItem(@NotNull MsgRecord msgRecord) {
        super(msgRecord);
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgRecord);
        }
    }

    private final Pair<Integer, Integer> k2(int width, int height) {
        if (width > 0 && height > 0) {
            this.isInitThumbSize = true;
            return PicUtil.f191410a.p(width, height, false, false);
        }
        this.isInitThumbSize = false;
        return m2();
    }

    private final Pair<Integer, Integer> m2() {
        if (this.fileType == 0) {
            return ((IAIOFileManagerApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOFileManagerApi.class)).getPicFileDefaultSize();
        }
        return new Pair<>(Integer.valueOf(com.tencent.mobileqq.aio.utils.p.c(100)), Integer.valueOf(com.tencent.mobileqq.aio.utils.p.c(100)));
    }

    private final FileElement n2() {
        MsgElement firstTypeElement = getFirstTypeElement(3);
        if (firstTypeElement != null) {
            return firstTypeElement.fileElement;
        }
        return null;
    }

    private final Pair<Integer, Integer> o2(FileElement fileElement, long fileElemId) {
        return ((IAIOFileManagerApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOFileManagerApi.class)).fixFileThumbSize(this, fileElement, fileElemId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<Integer, Integer> p2() {
        IAIOFileManagerApi iAIOFileManagerApi = (IAIOFileManagerApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOFileManagerApi.class);
        FileElement n26 = n2();
        Intrinsics.checkNotNull(n26);
        return iAIOFileManagerApi.fixFileThumbSizeFromFile(q2(n26));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String q2(FileElement fileElement) {
        HashMap<Integer, String> hashMap = fileElement.picThumbPath;
        if (hashMap == null || hashMap.isEmpty()) {
            return "";
        }
        Pair pair = new Pair(0, "");
        for (Map.Entry<Integer, String> entry : fileElement.picThumbPath.entrySet()) {
            Integer key = entry.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "entry.key");
            if (key.intValue() > ((Number) pair.getFirst()).intValue()) {
                pair = new Pair(entry.getKey(), entry.getValue());
            }
        }
        return (String) pair.getSecond();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, kotlin.Pair] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    private final void r2() {
        ?? r26;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        FileElement n26 = n2();
        if (n26 != null) {
            Integer num = n26.picWidth;
            Intrinsics.checkNotNullExpressionValue(num, "it.picWidth");
            if (num.intValue() > 0) {
                Integer num2 = n26.picHeight;
                Intrinsics.checkNotNullExpressionValue(num2, "it.picHeight");
                if (num2.intValue() > 0) {
                    r26 = new Pair(n26.picWidth, n26.picHeight);
                }
            }
            MsgElement firstTypeElement = getFirstTypeElement(3);
            Intrinsics.checkNotNull(firstTypeElement);
            r26 = o2(n26, firstTypeElement.elementId);
        } else {
            r26 = 0;
        }
        objectRef.element = r26;
        u2(r26, new Function0<Unit>(objectRef, this) { // from class: com.tencent.mobileqq.aio.msg.MultiPicMsgItem$initThumbSize$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Ref.ObjectRef<Pair<Integer, Integer>> $sizePair;
            final /* synthetic */ MultiPicMsgItem this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$sizePair = objectRef;
                this.this$0 = this;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) objectRef, (Object) this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [T, kotlin.Pair] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ?? p26;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                Ref.ObjectRef<Pair<Integer, Integer>> objectRef2 = this.$sizePair;
                p26 = this.this$0.p2();
                objectRef2.element = p26;
            }
        });
        Pair pair = (Pair) objectRef.element;
        if (pair == null) {
            pair = new Pair(0, 0);
        }
        Pair<Integer, Integer> k26 = k2(((Number) pair.getFirst()).intValue(), ((Number) pair.getSecond()).intValue());
        this.thumbWidth = k26.getFirst().intValue();
        this.thumbHeight = k26.getSecond().intValue();
    }

    private final boolean s2(MultiPicMsgItem target) {
        Object obj;
        boolean z16;
        ArrayList<MsgElement> arrayList = getMsgRecord().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgRecord.elements");
        for (MsgElement msgElement : arrayList) {
            ArrayList<MsgElement> arrayList2 = target.getMsgRecord().elements;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "target.msgRecord.elements");
            Iterator<T> it = arrayList2.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (msgElement.elementId == ((MsgElement) obj).elementId) {
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
            MsgElement msgElement2 = (MsgElement) obj;
            if (msgElement2 == null || !Intrinsics.areEqual(msgElement.fileElement.transferStatus, msgElement2.fileElement.transferStatus)) {
                return false;
            }
        }
        return true;
    }

    private final boolean t2(MultiPicMsgItem target) {
        if (target.getFileTransNotifyInfo().fileDownType == 1 && target.getFileTransNotifyInfo().trasferStatus == 4) {
            return true;
        }
        return false;
    }

    private final void u2(Pair<Integer, Integer> pair, Function0<Unit> function0) {
        if (pair == null || pair.getFirst().intValue() <= 0 || pair.getSecond().intValue() <= 0) {
            function0.invoke();
        }
    }

    private final boolean v2(MultiPicMsgItem target) {
        if (target.getFileTransNotifyInfo().fileDownType == 2 && target.getFileTransNotifyInfo().trasferStatus == 4) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void Y0(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) context);
            return;
        }
        super.Y0(context);
        Y1(com.tencent.mobileqq.aio.utils.n.f194168a.f(context, this));
        r2();
        if (QLog.isColorLevel()) {
            QLog.i("MultiPicMsgItem", 2, "onTransform msgId: " + getMsgRecord().msgId + ", thumbWidth:" + this.thumbWidth + ", thumbHeight:" + this.thumbHeight);
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public AIOMsgItem b0(@NotNull MsgRecord targetMsgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (AIOMsgItem) iPatchRedirector.redirect((short) 10, (Object) this, (Object) targetMsgRecord);
        }
        Intrinsics.checkNotNullParameter(targetMsgRecord, "targetMsgRecord");
        return new MultiPicMsgItem(targetMsgRecord);
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public String f1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        if (isSelf()) {
            return HardCodeUtil.qqStr(R.string.ypb) + HardCodeUtil.qqStr(R.string.ypd) + HardCodeUtil.qqStr(R.string.yp6) + HardCodeUtil.qqStr(R.string.f170198yp1);
        }
        CharSequence x16 = x();
        return ((Object) x16) + HardCodeUtil.qqStr(R.string.ypc) + HardCodeUtil.qqStr(R.string.yp6) + HardCodeUtil.qqStr(R.string.f170198yp1);
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a
    @NotNull
    public Object getChangePayload(@NotNull com.tencent.aio.data.msglist.a target) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return iPatchRedirector.redirect((short) 6, (Object) this, (Object) target);
        }
        Intrinsics.checkNotNullParameter(target, "target");
        HashMap hashMap = new HashMap();
        Object changePayload = super.getChangePayload(target);
        try {
            if (changePayload instanceof Map) {
                hashMap.putAll((Map) changePayload);
            }
        } catch (Exception e16) {
            QLog.e("MultiPicMsgItem", 1, e16, new Object[0]);
            if (!com.tencent.qqnt.util.b.f362976b.isPublicVersion()) {
                throw e16;
            }
        }
        if (!(target instanceof MultiPicMsgItem)) {
            QLog.i("MultiPicMsgItem", 1, "getChangePayload  target is not MultiPicMsgItem, " + target);
            return hashMap;
        }
        MultiPicMsgItem multiPicMsgItem = (MultiPicMsgItem) target;
        if (t2(multiPicMsgItem)) {
            QLog.i("MultiPicMsgItem", 1, multiPicMsgItem.getFileTransNotifyInfo().filePath + " trans status: " + multiPicMsgItem.getFileTransNotifyInfo().trasferStatus);
            hashMap.put(AIOMsgItemPayloadType.FILE_TRANSFER_END_PAYLOAD, a.n.f192667a);
        }
        if (v2(multiPicMsgItem)) {
            hashMap.put(AIOMsgItemPayloadType.FILE_THUMB_TRANSFER_END_PAYLOAD, a.n.f192667a);
        }
        return hashMap;
    }

    @Override // com.tencent.aio.data.msglist.a
    public int getSubViewType(int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this, viewType)).intValue();
        }
        return 1;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a
    public int getViewType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        if (MsgExtKt.B(getMsgRecord())) {
            if (isSelf()) {
                return 96;
            }
            return 97;
        }
        return super.getViewType();
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void l(@NotNull AIOMsgItem newMsgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) newMsgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(newMsgItem, "newMsgItem");
        super.l(newMsgItem);
        MultiPicMsgItem multiPicMsgItem = (MultiPicMsgItem) newMsgItem;
        multiPicMsgItem.thumbWidth = this.thumbWidth;
        multiPicMsgItem.thumbHeight = this.thumbHeight;
    }

    @NotNull
    public final List<RichMediaElementGetReq> l2() {
        Sequence asSequence;
        Sequence filter;
        Sequence map;
        List<RichMediaElementGetReq> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (List) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        ArrayList<MsgElement> arrayList = getMsgRecord().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgRecord.elements");
        asSequence = CollectionsKt___CollectionsKt.asSequence(arrayList);
        filter = SequencesKt___SequencesKt.filter(asSequence, new Function1<MsgElement, Boolean>() { // from class: com.tencent.mobileqq.aio.msg.MultiPicMsgItem$createAllThumbDownloadRequest$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MultiPicMsgItem.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(MsgElement msgElement) {
                boolean z16;
                String q26;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Boolean) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) msgElement);
                }
                Integer num = msgElement.fileElement.fileGroupIndex;
                Intrinsics.checkNotNullExpressionValue(num, "it.fileElement.fileGroupIndex");
                if (num.intValue() < 3) {
                    MultiPicMsgItem multiPicMsgItem = MultiPicMsgItem.this;
                    FileElement fileElement = msgElement.fileElement;
                    Intrinsics.checkNotNullExpressionValue(fileElement, "it.fileElement");
                    q26 = multiPicMsgItem.q2(fileElement);
                    if (!new File(q26).exists()) {
                        z16 = true;
                        return Boolean.valueOf(z16);
                    }
                }
                z16 = false;
                return Boolean.valueOf(z16);
            }
        });
        map = SequencesKt___SequencesKt.map(filter, new Function1<MsgElement, RichMediaElementGetReq>() { // from class: com.tencent.mobileqq.aio.msg.MultiPicMsgItem$createAllThumbDownloadRequest$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MultiPicMsgItem.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final RichMediaElementGetReq invoke(MsgElement msgElement) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (RichMediaElementGetReq) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) msgElement);
                }
                RichMediaElementGetReq richMediaElementGetReq = new RichMediaElementGetReq();
                MultiPicMsgItem multiPicMsgItem = MultiPicMsgItem.this;
                richMediaElementGetReq.msgId = multiPicMsgItem.q0();
                richMediaElementGetReq.peerUid = multiPicMsgItem.r0();
                richMediaElementGetReq.chatType = multiPicMsgItem.p0();
                richMediaElementGetReq.elementId = msgElement.elementId;
                richMediaElementGetReq.downloadType = 2;
                richMediaElementGetReq.thumbSize = 750;
                richMediaElementGetReq.downSourceType = 1;
                richMediaElementGetReq.triggerType = 1;
                return richMediaElementGetReq;
            }
        });
        list = SequencesKt___SequencesKt.toList(map);
        return list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public Pair<Boolean, String> o(@NotNull com.tencent.aio.data.msglist.a target) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Pair) iPatchRedirector.redirect((short) 7, (Object) this, (Object) target);
        }
        Intrinsics.checkNotNullParameter(target, "target");
        if ((target instanceof MultiPicMsgItem) && !s2((MultiPicMsgItem) target)) {
            return new Pair<>(Boolean.FALSE, "transferStatus");
        }
        return super.o(target);
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return MultiPicMsgItem.class.getSimpleName() + ":msgId=" + getMsgRecord().msgId + ",fileType=" + this.fileType + ",fileStatus=" + getFileTransNotifyInfo().trasferStatus;
    }
}
