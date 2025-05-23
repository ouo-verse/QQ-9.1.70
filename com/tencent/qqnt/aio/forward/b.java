package com.tencent.qqnt.aio.forward;

import android.content.Intent;
import com.tencent.aio.data.AIOContact;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.nt.NTFileUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IMsgConverterUtilsApi;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/aio/forward/b;", "Lcom/tencent/qqnt/aio/forward/c;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "Lcom/tencent/aio/data/AIOContact;", "contact", "Landroid/content/Intent;", "intent", "", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/FileElement;", "fileElem", "", "fileElemId", "Lcom/tencent/mobileqq/filemanager/data/ForwardFileInfo;", "b", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class b implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/forward/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.forward.b$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.qqnt.aio.forward.b$b, reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public static final class C9474b<T> implements Comparator {
        static IPatchRedirector $redirector_;

        public C9474b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(((MsgElement) t16).fileElement.fileGroupIndex, ((MsgElement) t17).fileElement.fileGroupIndex);
                return compareValues;
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, (Object) t17)).intValue();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63445);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.forward.c
    public boolean a(@NotNull AIOMsgItem msgItem, @NotNull AIOContact contact, @NotNull Intent intent) {
        List sortedWith;
        MsgElement msgElement;
        boolean z16;
        String stringExtra;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, msgItem, contact, intent)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(intent, "intent");
        boolean z17 = false;
        intent.putExtra("forward_type", 0);
        intent.putExtra("forward _key_nojump", true);
        int intExtra = intent.getIntExtra(AppConstants.Key.FORWARD_NT_FILE_INDEX, 0);
        if (intExtra == 0) {
            msgElement = ((IMsgConverterUtilsApi) QRoute.api(IMsgConverterUtilsApi.class)).getFileMsgElem(msgItem.getMsgRecord());
        } else {
            ArrayList<MsgElement> arrayList = msgItem.getMsgRecord().elements;
            Intrinsics.checkNotNullExpressionValue(arrayList, "msgItem.msgRecord.elements");
            sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList, new C9474b());
            msgElement = (MsgElement) sortedWith.get(intExtra);
        }
        if (msgElement == null) {
            QLog.e("FileMsgForwardHandler", 1, "file element not exist");
            return true;
        }
        FileElement fileElem = msgElement.fileElement;
        intent.putExtra("not_forward", true);
        MsgRecord msgRecord = msgItem.getMsgRecord();
        Intrinsics.checkNotNullExpressionValue(fileElem, "fileElem");
        ForwardFileInfo b16 = b(msgRecord, fileElem, msgElement.elementId);
        String l3 = b16.l();
        if (l3 != null && l3.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 && (stringExtra = intent.getStringExtra(AppConstants.Key.FORWARD_FILE_SAVED_OREDIT)) != null) {
            if (stringExtra.length() > 0) {
                z17 = true;
            }
            if (!z17) {
                stringExtra = null;
            }
            if (stringExtra != null) {
                b16.C(stringExtra);
                QLog.i("FileMsgForwardHandler", 1, "forward file is not exist replace to temp path [" + stringExtra + "]");
            }
        }
        intent.putExtra("fileinfo", b16);
        intent.putExtra(AppConstants.Key.FORWARD_TEXT, HardCodeUtil.qqStr(R.string.f201304ug) + FileManagerUtil.cutLongName(fileElem.fileName) + HardCodeUtil.qqStr(R.string.f201314uh) + q.g(fileElem.fileSize) + "\u3002");
        intent.putExtra(AppConstants.Key.FORWARD_FILEPATH, b16.l());
        intent.putExtra("direct_send_if_dataline_forward", true);
        return true;
    }

    @NotNull
    public final ForwardFileInfo b(@NotNull MsgRecord msgRecord, @NotNull FileElement fileElem, long fileElemId) {
        Object first;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ForwardFileInfo) iPatchRedirector.redirect((short) 4, this, msgRecord, fileElem, Long.valueOf(fileElemId));
        }
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(fileElem, "fileElem");
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        Intrinsics.checkNotNull(waitAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ForwardFileInfo e16 = NTFileUtils.e((QQAppInterface) waitAppRuntime, msgRecord, fileElemId);
        if (e16 != null) {
            return e16;
        }
        ForwardFileInfo forwardFileInfo = new ForwardFileInfo();
        forwardFileInfo.N(10000);
        forwardFileInfo.V(msgRecord.msgId);
        forwardFileInfo.y(fileElem.fileName);
        forwardFileInfo.z(fileElem.fileSize);
        forwardFileInfo.C(fileElem.filePath);
        HashMap<Integer, String> hashMap = fileElem.picThumbPath;
        if (hashMap != null && hashMap.size() > 0) {
            Collection<String> values = fileElem.picThumbPath.values();
            Intrinsics.checkNotNullExpressionValue(values, "fileElem.picThumbPath.values");
            first = CollectionsKt___CollectionsKt.first(values);
            forwardFileInfo.G((String) first);
        }
        return forwardFileInfo;
    }
}
