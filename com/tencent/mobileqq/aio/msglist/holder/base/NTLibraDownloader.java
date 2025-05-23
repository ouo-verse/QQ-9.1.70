package com.tencent.mobileqq.aio.msglist.holder.base;

import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.libra.download.ILibraDownloader;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.base.AIOPicDownloader;
import com.tencent.mobileqq.aio.msglist.holder.component.pic.PicUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.data.t;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.IAccountCallback;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u00017B\t\b\u0002\u00a2\u0006\u0004\b5\u00106J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u001e\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0012\u0010\u0019\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u001a\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u001d\u001a\u00020\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016R\u001b\u0010\"\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001f\u0010!R\u0014\u0010$\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010#R#\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020&0%8\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R*\u00104\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/base/NTLibraDownloader;", "Lcom/tencent/libra/download/ILibraDownloader;", "Lmqq/app/IAccountCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "fileInfo", "", "picSize", "", "b", "Lcom/tencent/mobileqq/aio/msglist/holder/base/PicSize;", "f", "id", "Lkotlin/Pair;", "", "", "c", "Lcom/tencent/libra/request/Option;", "option", "canDownload", "Lcom/tencent/libra/download/ILibraDownloader$PicDownLoadListener;", "listener", "", "downLoad", "Lmqq/app/AppRuntime;", "newRuntime", "onAccountChanged", "onAccountChangeFailed", "Lmqq/app/Constants$LogoutReason;", "reason", "onLogout", "Lcom/tencent/mobileqq/aio/msglist/holder/base/NTLibraDownloader$a;", "e", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/aio/msglist/holder/base/NTLibraDownloader$a;", "mTroopFileObserver", "Z", "enableDispatchAll", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/aio/msglist/holder/base/h;", tl.h.F, "Ljava/util/concurrent/ConcurrentHashMap;", "d", "()Ljava/util/concurrent/ConcurrentHashMap;", "allFileDownloadContext", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/common/app/AppInterface;", "i", "Ljava/lang/ref/WeakReference;", "getPreRuntimeWrf", "()Ljava/lang/ref/WeakReference;", "setPreRuntimeWrf", "(Ljava/lang/ref/WeakReference;)V", "preRuntimeWrf", "<init>", "()V", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class NTLibraDownloader implements ILibraDownloader, IAccountCallback {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final NTLibraDownloader f190586d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy mTroopFileObserver;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final boolean enableDispatchAll;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<Long, h> allFileDownloadContext;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static WeakReference<AppInterface> preRuntimeWrf;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/base/NTLibraDownloader$a;", "Lcom/tencent/mobileqq/app/c;", "", "data", "", "g", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a extends com.tencent.mobileqq.app.c {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.app.c
        protected void g(@Nullable Object data) {
            ILibraDownloader.PicDownLoadListener a16;
            FileElement fileElement;
            ILibraDownloader.PicDownLoadListener a17;
            MsgElement b16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, data);
                return;
            }
            if (data instanceof t) {
                t tVar = (t) data;
                int i3 = tVar.f294972f;
                if (i3 == 11) {
                    NTLibraDownloader nTLibraDownloader = NTLibraDownloader.f190586d;
                    h hVar = nTLibraDownloader.d().get(Long.valueOf(tVar.K));
                    Option option = null;
                    if (hVar != null && (b16 = hVar.b()) != null) {
                        fileElement = b16.fileElement;
                    } else {
                        fileElement = null;
                    }
                    if (fileElement != null) {
                        fileElement.filePath = tVar.f294978l;
                    }
                    if (hVar != null) {
                        option = hVar.c();
                    }
                    if (option != null) {
                        option.setLocalPath(tVar.f294978l);
                    }
                    if (hVar != null && (a17 = hVar.a()) != null) {
                        a17.onResult(true, 0);
                    }
                    nTLibraDownloader.d().remove(Long.valueOf(tVar.K));
                    return;
                }
                if (i3 == 12 || i3 == 10) {
                    NTLibraDownloader nTLibraDownloader2 = NTLibraDownloader.f190586d;
                    h hVar2 = nTLibraDownloader2.d().get(Long.valueOf(tVar.K));
                    if (hVar2 != null && (a16 = hVar2.a()) != null) {
                        a16.onResult(false, tVar.f294974h);
                    }
                    nTLibraDownloader2.d().remove(Long.valueOf(tVar.K));
                }
            }
        }
    }

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59817);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        NTLibraDownloader nTLibraDownloader = new NTLibraDownloader();
        f190586d = nTLibraDownloader;
        lazy = LazyKt__LazyJVMKt.lazy(NTLibraDownloader$mTroopFileObserver$2.INSTANCE);
        mTroopFileObserver = lazy;
        enableDispatchAll = RFWConfig.getConfigValue("DISPATCH_ALL", false);
        allFileDownloadContext = new ConcurrentHashMap<>();
        MobileQQ.sMobileQQ.registerAccountCallback(nTLibraDownloader);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            ((AppInterface) peekAppRuntime).addObserver(nTLibraDownloader.e());
            preRuntimeWrf = new WeakReference<>(peekAppRuntime);
        }
    }

    NTLibraDownloader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean b(FileTransNotifyInfo fileInfo, String picSize) {
        if (enableDispatchAll || fileInfo.fileDownType == 0 || TextUtils.isEmpty(picSize)) {
            return true;
        }
        if (Intrinsics.areEqual("ORIGIN", picSize) && fileInfo.fileDownType == 1) {
            return true;
        }
        if ((Intrinsics.areEqual("LARGE", picSize) || Intrinsics.areEqual("THUMB", picSize)) && fileInfo.fileDownType == 2) {
            return true;
        }
        return false;
    }

    private final Pair<Long, Integer> c(String id5) {
        boolean contains$default;
        int i3;
        long parseLong;
        List split$default;
        try {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) id5, (CharSequence) "_", false, 2, (Object) null);
            if (contains$default) {
                split$default = StringsKt__StringsKt.split$default((CharSequence) id5, new String[]{"_"}, false, 0, 6, (Object) null);
                Object[] array = split$default.toArray(new String[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                String[] strArr = (String[]) array;
                if (strArr.length != 2) {
                    return null;
                }
                parseLong = Long.parseLong(strArr[0]);
                i3 = Integer.parseInt(strArr[1]);
            } else {
                i3 = 0;
                parseLong = Long.parseLong(id5);
            }
            return new Pair<>(Long.valueOf(parseLong), Integer.valueOf(i3));
        } catch (Exception unused) {
            QLog.e("NTLibraDownloader", 1, "generateMainAndSubId error:" + id5);
            return null;
        }
    }

    private final a e() {
        return (a) mTroopFileObserver.getValue();
    }

    private final PicSize f(String picSize) {
        if (picSize != null) {
            int hashCode = picSize.hashCode();
            if (hashCode != -1955290330) {
                if (hashCode != 72205083) {
                    if (hashCode == 79804854 && picSize.equals("THUMB")) {
                        return PicSize.PIC_DOWNLOAD_THUMB;
                    }
                } else if (picSize.equals("LARGE")) {
                    return PicSize.PIC_DOWNLOAD_BIG_THUMB;
                }
            } else if (picSize.equals("ORIGIN")) {
                return PicSize.PIC_DOWNLOAD_ORI;
            }
        }
        return PicSize.PIC_DOWNLOAD_ORI;
    }

    @Override // com.tencent.libra.download.ILibraDownloader
    public boolean canDownload(@NotNull Option option) {
        AIOMsgItem aIOMsgItem;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) option)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(option, "option");
        Object obj = option.getExtraData().get("aioMsgItem");
        AIOMsgItem aIOMsgItem2 = null;
        if (obj instanceof AIOMsgItem) {
            aIOMsgItem = (AIOMsgItem) obj;
        } else {
            aIOMsgItem = null;
        }
        if (aIOMsgItem == null) {
            Object obj2 = option.getExtraData().get(WadlProxyConsts.EXTRA_DATA);
            if (obj2 instanceof AIOMsgItem) {
                aIOMsgItem2 = (AIOMsgItem) obj2;
            }
            if (aIOMsgItem2 == null) {
                return false;
            }
        }
        return true;
    }

    @Override // com.tencent.libra.download.ILibraDownloader
    public /* synthetic */ void cancel(Option option) {
        com.tencent.libra.download.a.a(this, option);
    }

    @NotNull
    public final ConcurrentHashMap<Long, h> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return allFileDownloadContext;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem, T] */
    /* JADX WARN: Type inference failed for: r7v12, types: [com.tencent.mobileqq.aio.msg.AIOMsgItem, T] */
    /* JADX WARN: Type inference failed for: r7v2, types: [T, java.lang.String] */
    @Override // com.tencent.libra.download.ILibraDownloader
    public void downLoad(@NotNull final Option option, @NotNull final ILibraDownloader.PicDownLoadListener listener) {
        int i3;
        int i16;
        T t16;
        boolean contains$default;
        Integer num;
        T t17;
        MsgElement firstTypeElement;
        PicElement picElement;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) option, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(option, "option");
        Intrinsics.checkNotNullParameter(listener, "listener");
        MsgElement msgElement = (MsgElement) option.getExtraData().get("picMsgElement");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = (AIOMsgItem) option.getExtraData().get("aioMsgItem");
        String str = (String) option.getExtraData().get("id");
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = (String) option.getExtraData().get("picType");
        if (objectRef.element == 0) {
            objectRef.element = (AIOMsgItem) option.getExtraData().get(WadlProxyConsts.EXTRA_DATA);
            if (Intrinsics.areEqual(objectRef2.element, "LARGE") && (t17 = objectRef.element) != 0 && (firstTypeElement = ((AIOMsgItem) t17).getFirstTypeElement(2)) != null && (picElement = firstTypeElement.picElement) != null && !picElement.original) {
                objectRef2.element = "ORIGIN";
            }
            i3 = 2;
            i16 = 0;
        } else {
            i3 = 1;
            i16 = 1;
        }
        DefaultConstructorMarker defaultConstructorMarker = null;
        if (msgElement == null && str != null) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "_", false, 2, (Object) null);
            if (contains$default && objectRef.element != 0) {
                Pair<Long, Integer> c16 = c(str);
                if (c16 != null) {
                    num = c16.getSecond();
                } else {
                    num = null;
                }
                MsgRecord msgRecord = ((AIOMsgItem) objectRef.element).getMsgRecord();
                if (num != null && !msgRecord.elements.isEmpty() && num.intValue() <= msgRecord.elements.size()) {
                    msgElement = msgRecord.elements.get(num.intValue());
                } else {
                    listener.onResult(false, -1);
                    QLog.i("LibraPicLoader", 1, "seq = " + option.getSeq() + " can't find target element");
                    return;
                }
            }
        }
        if (msgElement != null && (t16 = objectRef.element) != 0) {
            QLog.i("LibraPicLoader", 1, "[downloadImage] start, msgId=" + ((AIOMsgItem) t16).getMsgId() + "} picMsgElementId=" + msgElement.elementId + " picType: " + objectRef2.element);
            AIOPicDownloader.f190570a.e(msgElement, f((String) objectRef2.element), new AIOPicDownloader.a((AIOMsgItem) objectRef.element, 0, 2, defaultConstructorMarker), i3, i16, new Function1<FileTransNotifyInfo, Unit>(objectRef, option, objectRef2, listener) { // from class: com.tencent.mobileqq.aio.msglist.holder.base.NTLibraDownloader$downLoad$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ Ref.ObjectRef<AIOMsgItem> $aioMsgItem;
                final /* synthetic */ ILibraDownloader.PicDownLoadListener $listener;
                final /* synthetic */ Option $option;
                final /* synthetic */ Ref.ObjectRef<String> $picType;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$aioMsgItem = objectRef;
                    this.$option = option;
                    this.$picType = objectRef2;
                    this.$listener = listener;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, objectRef, option, objectRef2, listener);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(FileTransNotifyInfo fileTransNotifyInfo) {
                    invoke2(fileTransNotifyInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull FileTransNotifyInfo fileInfo) {
                    boolean b16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) fileInfo);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(fileInfo, "fileInfo");
                    if (QLog.isColorLevel()) {
                        QLog.i("NTLibraDownloader", 2, "[downloadImage] complete, msgId=" + this.$aioMsgItem.element.getMsgId() + ", fileInfo=" + fileInfo);
                    }
                    if (fileInfo.trasferStatus == 4 && !TextUtils.isEmpty(fileInfo.filePath)) {
                        QLog.i("LibraPicLoader", 1, "seq = " + this.$option.getSeq() + " [downloadImage] complete fileExist:" + RFWFileUtils.fileExists(fileInfo.filePath) + ", msgId=" + this.$aioMsgItem.element.getMsgId() + ", fileInfo=" + fileInfo);
                        b16 = NTLibraDownloader.f190586d.b(fileInfo, this.$picType.element);
                        if (b16) {
                            if (!Objects.equals(this.$option.getLocalPath(), fileInfo.filePath)) {
                                this.$option.setLocalPath(fileInfo.filePath);
                                QLog.i("LibraPicLoader", 1, "seq = " + this.$option.getSeq() + " changeLocalPath:" + this.$option.getLocalPath());
                            }
                            this.$listener.onResult(true, 0);
                            return;
                        }
                        return;
                    }
                    int i17 = fileInfo.trasferStatus;
                    if (i17 == 5 || i17 == 6) {
                        QLog.w("NTLibraDownloader", 1, "[downloadImage] fail, msgId=" + fileInfo.msgId + " elementId=" + fileInfo.msgElementId + " fileId=" + fileInfo.fileId + "-" + fileInfo.fileModelId + " errorCode=" + fileInfo.fileErrCode + " serverCode=" + fileInfo.fileSrvErrCode);
                        long j3 = fileInfo.fileErrCode;
                        if (((int) j3) == 2006021) {
                            Option option2 = this.$option;
                            option2.setFailedDrawable(PicUtil.f191410a.a(option2.getRequestWidth(), this.$option.getRequestHeight()));
                        } else if (((int) j3) == 2006040) {
                            Option option3 = this.$option;
                            option3.setFailedDrawable(PicUtil.f191410a.h(option3.getRequestWidth(), this.$option.getRequestHeight()));
                        }
                        this.$listener.onResult(false, (int) fileInfo.fileErrCode);
                    }
                }
            });
            return;
        }
        QLog.i("LibraPicLoader", 1, "seq = " + option.getSeq() + " can't find target element or msgItem");
        listener.onResult(false, -1);
    }

    @Override // com.tencent.libra.download.ILibraDownloader
    public /* synthetic */ boolean needDownloadOnWorkThread() {
        return com.tencent.libra.download.a.b(this);
    }

    @Override // mqq.app.IAccountCallback
    public void onAccountChangeFailed(@Nullable AppRuntime newRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) newRuntime);
        }
    }

    @Override // mqq.app.IAccountCallback
    public void onAccountChanged(@Nullable AppRuntime newRuntime) {
        AppInterface appInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) newRuntime);
            return;
        }
        if (newRuntime instanceof AppInterface) {
            ((AppInterface) newRuntime).addObserver(e());
            WeakReference<AppInterface> weakReference = preRuntimeWrf;
            if (weakReference != null && (appInterface = weakReference.get()) != null) {
                appInterface.removeObserver(e());
            }
        }
    }

    @Override // mqq.app.IAccountCallback
    public void onLogout(@Nullable Constants.LogoutReason reason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) reason);
        }
    }
}
