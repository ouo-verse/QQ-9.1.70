package com.dataline.qqnt.activities;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.dataline.qqnt.widget.WaitTextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.aio.msg.element.AIOElementType;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.RichMediaElementGetReq;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u0000 02\u00020\u0001:\u00011B\u0007\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0002H\u0002J\b\u0010\u0018\u001a\u00020\u0002H\u0002J\b\u0010\u0019\u001a\u00020\u0002H\u0002J\b\u0010\u001a\u001a\u00020\u0002H\u0002J\b\u0010\u001b\u001a\u0004\u0018\u00010\u000bJ\u0012\u0010\u001e\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0014R\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00100#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00062"}, d2 = {"Lcom/dataline/qqnt/activities/MultiPicViewerActivity;", "Lcom/tencent/mobileqq/app/QIphoneTitleBarActivity;", "", "initView", "", "c3", "Z2", "d3", "j3", "h3", "g3", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", QQPermissionConstants.Permission.AUIDO_GROUP, "i3", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", DTConstants.TAG.ELEMENT, "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$MultiPicElement;", "multiPicElement", "b3", "Lcom/tencent/qqnt/kernel/nativeinterface/FileElement;", "fileElement", "", "V2", "T2", "f3", "S2", "e3", "U2", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Ldb1/b;", "a0", "Ldb1/b;", "binding", "", "b0", "Ljava/util/List;", "dataList", "", "c0", "J", "msgId", "d0", "Z", "isUpload", "<init>", "()V", "e0", "a", "qq_nt_dataline_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes2.dex */
public final class MultiPicViewerActivity extends QIphoneTitleBarActivity {

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f0, reason: collision with root package name */
    @NotNull
    private static SoftReference<MsgRecord> f32321f0 = new SoftReference<>(null);

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private db1.b binding;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private List<AIOElementType.MultiPicElement> dataList;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private long msgId;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private boolean isUpload;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013R(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\f\u00a8\u0006\u0014"}, d2 = {"Lcom/dataline/qqnt/activities/MultiPicViewerActivity$a;", "", "Ljava/lang/ref/SoftReference;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Ljava/lang/ref/SoftReference;", "a", "()Ljava/lang/ref/SoftReference;", "b", "(Ljava/lang/ref/SoftReference;)V", "", "IS_UPLOAD_KEY", "Ljava/lang/String;", "MSG_ID", "", "SPAN_COUNT", "I", "TAG", "<init>", "()V", "qq_nt_dataline_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.dataline.qqnt.activities.MultiPicViewerActivity$a, reason: from kotlin metadata */
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SoftReference<MsgRecord> a() {
            return MultiPicViewerActivity.f32321f0;
        }

        public final void b(@NotNull SoftReference<MsgRecord> softReference) {
            Intrinsics.checkNotNullParameter(softReference, "<set-?>");
            MultiPicViewerActivity.f32321f0 = softReference;
        }

        Companion() {
        }
    }

    private final void S2() {
        MsgRecord msgRecord = f32321f0.get();
        if (msgRecord != null) {
            QLog.i("MultiPicViewerActivity", 1, "cancelDownloadFile " + msgRecord);
            ((IMsgService) QRoute.api(IMsgService.class)).cancelGetRichMediaElement(new RichMediaElementGetReq(msgRecord.getMsgId(), msgRecord.peerUid, msgRecord.chatType, msgRecord.elements.get(0).elementId, 1, 0, "", 0L, 0, 0));
        }
    }

    private final void T2() {
        MsgRecord msgRecord = f32321f0.get();
        if (msgRecord != null) {
            IMsgService iMsgService = (IMsgService) QRoute.api(IMsgService.class);
            long msgId = msgRecord.getMsgId();
            String str = msgRecord.peerUid;
            Intrinsics.checkNotNullExpressionValue(str, "it.peerUid");
            iMsgService.cancelSendMsg(msgId, str, msgRecord.chatType);
        }
    }

    private final String V2(FileElement fileElement) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W2(MultiPicViewerActivity this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (f32321f0.get() != null) {
            if (this$0.isUpload) {
                this$0.T2();
            } else {
                this$0.S2();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y2(MultiPicViewerActivity this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (f32321f0.get() != null) {
            if (this$0.isUpload) {
                this$0.f3();
            } else {
                this$0.e3();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Z2() {
        boolean z16;
        List<AIOElementType.MultiPicElement> list = this.dataList;
        Object obj = null;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataList");
            list = null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            AIOElementType.MultiPicElement multiPicElement = (AIOElementType.MultiPicElement) next;
            if (multiPicElement.e() != 6 && multiPicElement.e() != 5 && multiPicElement.e() != 1) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                obj = next;
                break;
            }
        }
        if (obj == null) {
            return false;
        }
        return true;
    }

    private final boolean b3(MsgElement element, AIOElementType.MultiPicElement multiPicElement) {
        if (element.elementId == multiPicElement.a() && Intrinsics.areEqual(element.fileElement.filePath, multiPicElement.b())) {
            Integer num = element.fileElement.transferStatus;
            int e16 = multiPicElement.e();
            if (num != null && num.intValue() == e16) {
                FileElement fileElement = element.fileElement;
                Intrinsics.checkNotNullExpressionValue(fileElement, "element.fileElement");
                if (Intrinsics.areEqual(V2(fileElement), multiPicElement.c())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean c3() {
        boolean z16;
        boolean z17;
        boolean z18;
        List<AIOElementType.MultiPicElement> list = this.dataList;
        Object obj = null;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataList");
            list = null;
        }
        List<AIOElementType.MultiPicElement> list2 = list;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                if (((AIOElementType.MultiPicElement) it.next()).e() == 4) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    z17 = false;
                    break;
                }
            }
        }
        z17 = true;
        if (!z17) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("is not completed! ");
            List<AIOElementType.MultiPicElement> list3 = this.dataList;
            if (list3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataList");
                list3 = null;
            }
            Iterator<T> it5 = list3.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                Object next = it5.next();
                if (((AIOElementType.MultiPicElement) next).e() != 4) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    obj = next;
                    break;
                }
            }
            sb5.append(obj);
            QLog.i("MultiPicViewerActivity", 1, sb5.toString());
        }
        return z17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean d3() {
        boolean z16;
        List<AIOElementType.MultiPicElement> list = this.dataList;
        Object obj = null;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataList");
            list = null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            AIOElementType.MultiPicElement multiPicElement = (AIOElementType.MultiPicElement) next;
            if (multiPicElement.e() != 2 && multiPicElement.e() != 3) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                obj = next;
                break;
            }
        }
        if (obj == null) {
            return false;
        }
        return true;
    }

    private final void e3() {
        Sequence asSequence;
        Sequence filter;
        Sequence map;
        final MsgRecord msgRecord = f32321f0.get();
        if (msgRecord != null) {
            QLog.i("MultiPicViewerActivity", 1, "reDownloadFile " + msgRecord);
            List<AIOElementType.MultiPicElement> list = this.dataList;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataList");
                list = null;
            }
            asSequence = CollectionsKt___CollectionsKt.asSequence(list);
            filter = SequencesKt___SequencesKt.filter(asSequence, new Function1<AIOElementType.MultiPicElement, Boolean>() { // from class: com.dataline.qqnt.activities.MultiPicViewerActivity$reDownloadFile$1$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull AIOElementType.MultiPicElement it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(it.e() != 4);
                }
            });
            map = SequencesKt___SequencesKt.map(filter, new Function1<AIOElementType.MultiPicElement, RichMediaElementGetReq>() { // from class: com.dataline.qqnt.activities.MultiPicViewerActivity$reDownloadFile$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final RichMediaElementGetReq invoke(@NotNull AIOElementType.MultiPicElement it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    long msgId = MsgRecord.this.getMsgId();
                    MsgRecord msgRecord2 = MsgRecord.this;
                    return new RichMediaElementGetReq(msgId, msgRecord2.peerUid, msgRecord2.chatType, it.a(), 1, 0, "", 0L, 0, 0);
                }
            });
            Iterator it = map.iterator();
            while (it.hasNext()) {
                ((IMsgService) QRoute.api(IMsgService.class)).getRichMediaElement((RichMediaElementGetReq) it.next());
            }
        }
    }

    private final void f3() {
        MsgRecord msgRecord = f32321f0.get();
        if (msgRecord != null) {
            ((IMsgService) QRoute.api(IMsgService.class)).resendMsg(new Contact(msgRecord.chatType, msgRecord.peerUid, ""), msgRecord.getMsgId(), null);
        }
    }

    private final void g3() {
        FlowKt.launchIn(FlowKt.onEach(((IMsgService) QRoute.api(IMsgService.class)).registerMsgStatusUpdateNotificationFlow(), new MultiPicViewerActivity$registerFileNotify$1(this, null)), CoroutineScopeKt.plus(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h3() {
        db1.b bVar = this.binding;
        db1.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bVar = null;
        }
        bVar.f393505b.setVisibility(8);
        db1.b bVar3 = this.binding;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bVar3 = null;
        }
        bVar3.f393506c.setVisibility(8);
        db1.b bVar4 = this.binding;
        if (bVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bVar4 = null;
        }
        bVar4.f393508e.setVisibility(8);
        db1.b bVar5 = this.binding;
        if (bVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            bVar2 = bVar5;
        }
        bVar2.f393507d.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i3(MsgRecord record) {
        f32321f0 = new SoftReference<>(record);
        Iterator<MsgElement> it = record.elements.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            int i16 = i3 + 1;
            MsgElement msgElement = it.next();
            List<AIOElementType.MultiPicElement> list = this.dataList;
            db1.b bVar = null;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataList");
                list = null;
            }
            Integer num = msgElement.fileElement.fileGroupIndex;
            Intrinsics.checkNotNullExpressionValue(num, "msgElement.fileElement.fileGroupIndex");
            AIOElementType.MultiPicElement multiPicElement = list.get(num.intValue());
            Intrinsics.checkNotNullExpressionValue(msgElement, "msgElement");
            if (!b3(msgElement, multiPicElement)) {
                multiPicElement.f(msgElement.elementId);
                String str = msgElement.fileElement.filePath;
                Intrinsics.checkNotNullExpressionValue(str, "msgElement.fileElement.filePath");
                multiPicElement.g(str);
                Integer num2 = msgElement.fileElement.transferStatus;
                Intrinsics.checkNotNullExpressionValue(num2, "msgElement.fileElement.transferStatus");
                multiPicElement.l(num2.intValue());
                multiPicElement.k(msgElement.fileElement.fileSize);
                FileElement fileElement = msgElement.fileElement;
                Intrinsics.checkNotNullExpressionValue(fileElement, "msgElement.fileElement");
                multiPicElement.j(V2(fileElement));
                db1.b bVar2 = this.binding;
                if (bVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    bVar = bVar2;
                }
                RecyclerView.Adapter adapter = bVar.f393510g.getAdapter();
                if (adapter != null) {
                    adapter.notifyItemChanged(i3);
                }
            }
            i3 = i16;
        }
    }

    private final void initView() {
        db1.b bVar = this.binding;
        db1.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bVar = null;
        }
        bVar.f393510g.setLayoutManager(new StaggeredGridLayoutManager(3, 1));
        db1.b bVar3 = this.binding;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bVar3 = null;
        }
        RecyclerView recyclerView = bVar3.f393510g;
        com.dataline.qqnt.widget.b bVar4 = new com.dataline.qqnt.widget.b();
        List<AIOElementType.MultiPicElement> list = this.dataList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataList");
            list = null;
        }
        bVar4.setDataList(list);
        recyclerView.setAdapter(bVar4);
        db1.b bVar5 = this.binding;
        if (bVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bVar5 = null;
        }
        WaitTextView waitTextView = bVar5.f393511h;
        StringBuilder sb5 = new StringBuilder();
        sb5.append('\u5171');
        List<AIOElementType.MultiPicElement> list2 = this.dataList;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataList");
            list2 = null;
        }
        sb5.append(list2.size());
        sb5.append("\u5f20\u56fe\u7247");
        waitTextView.setText(sb5.toString());
        if (this.isUpload) {
            db1.b bVar6 = this.binding;
            if (bVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                bVar6 = null;
            }
            bVar6.f393507d.setText("\u6062\u590d\u53d1\u9001");
        } else {
            db1.b bVar7 = this.binding;
            if (bVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                bVar7 = null;
            }
            bVar7.f393507d.setText("\u6062\u590d\u63a5\u6536");
        }
        if (c3()) {
            db1.b bVar8 = this.binding;
            if (bVar8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                bVar8 = null;
            }
            bVar8.f393509f.setVisibility(8);
        } else {
            db1.b bVar9 = this.binding;
            if (bVar9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                bVar9 = null;
            }
            bVar9.f393509f.setVisibility(0);
            g3();
        }
        if (d3()) {
            j3();
        } else if (Z2()) {
            h3();
        }
        db1.b bVar10 = this.binding;
        if (bVar10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bVar10 = null;
        }
        bVar10.f393505b.setOnClickListener(new View.OnClickListener() { // from class: com.dataline.qqnt.activities.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MultiPicViewerActivity.W2(MultiPicViewerActivity.this, view);
            }
        });
        db1.b bVar11 = this.binding;
        if (bVar11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            bVar2 = bVar11;
        }
        bVar2.f393507d.setOnClickListener(new View.OnClickListener() { // from class: com.dataline.qqnt.activities.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MultiPicViewerActivity.Y2(MultiPicViewerActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j3() {
        String sb5;
        boolean z16;
        db1.b bVar = this.binding;
        List<AIOElementType.MultiPicElement> list = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bVar = null;
        }
        bVar.f393505b.setVisibility(0);
        db1.b bVar2 = this.binding;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bVar2 = null;
        }
        bVar2.f393506c.setVisibility(0);
        db1.b bVar3 = this.binding;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bVar3 = null;
        }
        bVar3.f393508e.setVisibility(0);
        db1.b bVar4 = this.binding;
        if (bVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bVar4 = null;
        }
        bVar4.f393507d.setVisibility(8);
        List<AIOElementType.MultiPicElement> list2 = this.dataList;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataList");
            list2 = null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list2) {
            if (((AIOElementType.MultiPicElement) obj).e() == 4) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        int size = arrayList.size();
        db1.b bVar5 = this.binding;
        if (bVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bVar5 = null;
        }
        ProgressBar progressBar = bVar5.f393506c;
        float f16 = size;
        List<AIOElementType.MultiPicElement> list3 = this.dataList;
        if (list3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataList");
            list3 = null;
        }
        progressBar.setProgress((int) ((f16 / list3.size()) * 100));
        db1.b bVar6 = this.binding;
        if (bVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bVar6 = null;
        }
        TextView textView = bVar6.f393508e;
        if (this.isUpload) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("\u53d1\u9001\u4e2d... ");
            sb6.append(size);
            sb6.append('/');
            List<AIOElementType.MultiPicElement> list4 = this.dataList;
            if (list4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataList");
            } else {
                list = list4;
            }
            sb6.append(list.size());
            sb5 = sb6.toString();
        } else {
            StringBuilder sb7 = new StringBuilder();
            sb7.append("\u63a5\u6536\u4e2d... ");
            sb7.append(size);
            sb7.append('/');
            List<AIOElementType.MultiPicElement> list5 = this.dataList;
            if (list5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataList");
            } else {
                list = list5;
            }
            sb7.append(list.size());
            sb5 = sb7.toString();
        }
        textView.setText(sb5);
    }

    @Nullable
    public final MsgRecord U2() {
        return f32321f0.get();
    }

    @Override // com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db1.b g16 = db1.b.g(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(layoutInflater)");
        this.binding = g16;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            g16 = null;
        }
        setContentView(g16.getRoot());
        setTitle(R.string.c3x);
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("ALBUM_RESULT");
        Intrinsics.checkNotNull(parcelableArrayListExtra);
        this.dataList = parcelableArrayListExtra;
        this.isUpload = getIntent().getBooleanExtra("IS_UPLOAD_KEY", false);
        this.msgId = getIntent().getLongExtra("MSG_ID", 0L);
        initView();
    }
}
