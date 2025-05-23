package com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.http.api.IHttpService;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolNoticeContent;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolNoticeMediaContent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a4\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 9*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u001eB\u0017\u0012\u0006\u0010\"\u001a\u00020\u001d\u0012\u0006\u0010(\u001a\u00020#\u00a2\u0006\u0004\bU\u0010VJ'\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00028\u00002\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H&\u00a2\u0006\u0004\b\u0007\u0010\bJ(\u0010\f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0004J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0004J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J \u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00132\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J2\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00162\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J\u0006\u0010\u001a\u001a\u00020\u0005J!\u0010\u001b\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0084@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\"\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010(\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R8\u00102\u001a&\u0012\f\u0012\n .*\u0004\u0018\u00010#0# .*\u0012\u0012\f\u0012\n .*\u0004\u0018\u00010#0#\u0018\u00010/0-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R \u00106\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u000204038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u00105R\u001b\u0010;\u001a\u0002078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u00108\u001a\u0004\b9\u0010:R\u001a\u0010@\u001a\u00020<8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010=\u001a\u0004\b>\u0010?R\u001a\u0010F\u001a\u00020A8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER*\u0010M\u001a\u0012\u0012\u0004\u0012\u00020H0Gj\b\u0012\u0004\u0012\u00020H`I8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0019\u0010J\u001a\u0004\bK\u0010LR*\u0010Q\u001a\u0012\u0012\u0004\u0012\u00020N0Gj\b\u0012\u0004\u0012\u00020N`I8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bO\u0010J\u001a\u0004\bP\u0010LR*\u0010R\u001a\u0012\u0012\u0004\u0012\u00020\u00130Gj\b\u0012\u0004\u0012\u00020\u0013`I8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bD\u0010J\u001a\u0004\bO\u0010LR*\u0010T\u001a\u0012\u0012\u0004\u0012\u00020\u00160Gj\b\u0012\u0004\u0012\u00020\u0016`I8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bS\u0010J\u001a\u0004\bS\u0010L\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006W"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/HWDetailMediaDataModel;", "T", "", "detail", "Lkotlin/Function0;", "", "callback", "t", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)V", "", "authorUin", "publishTime", "u", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolNoticeContent;", "content", ReportConstant.COSTREPORT_PREFIX, "", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/BaseItem;", "o", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/AudioItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "g", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/FileItem;", "openCallback", "updateCallback", "i", "f", "e", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CoroutineScope;", "a", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "scope", "", "b", "Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Ljava/lang/String;", "troopUin", "Ljava/text/SimpleDateFormat;", "c", "Ljava/text/SimpleDateFormat;", "pubTimeFormatter", "", "kotlin.jvm.PlatformType", "", "d", "Ljava/util/Set;", "downloadAudioTaskSet", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/qqnt/http/api/b;", "Ljava/util/concurrent/ConcurrentHashMap;", "downloadFileTaskMap", "Lcom/tencent/qqnt/http/api/IHttpService;", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/qqnt/http/api/IHttpService;", "httpService", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/TitleItem;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/TitleItem;", "p", "()Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/TitleItem;", "titleItem", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/ContentItem;", h.F, "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/ContentItem;", "k", "()Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/ContentItem;", "contentItem", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/ImageItem;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", DomainData.DOMAIN_NAME, "()Ljava/util/ArrayList;", "imgList", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/VideoItem;", "j", "r", "videoList", "audioList", "l", "fileList", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Ljava/lang/String;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public abstract class HWDetailMediaDataModel<T> {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope scope;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SimpleDateFormat pubTimeFormatter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Set<String> downloadAudioTaskSet;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, com.tencent.qqnt.http.api.b> downloadFileTaskMap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy httpService;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TitleItem titleItem;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ContentItem contentItem;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<ImageItem> imgList;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<VideoItem> videoList;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<AudioItem> audioList;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<FileItem> fileList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/HWDetailMediaDataModel$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.HWDetailMediaDataModel$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49485);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public HWDetailMediaDataModel(@NotNull CoroutineScope scope, @NotNull String troopUin) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) scope, (Object) troopUin);
            return;
        }
        this.scope = scope;
        this.troopUin = troopUin;
        this.pubTimeFormatter = new SimpleDateFormat("yyyy\u5e74MM\u6708dd\u65e5 HH:mm", Locale.getDefault());
        this.downloadAudioTaskSet = Collections.synchronizedSet(new HashSet());
        this.downloadFileTaskMap = new ConcurrentHashMap<>();
        lazy = LazyKt__LazyJVMKt.lazy(HWDetailMediaDataModel$httpService$2.INSTANCE);
        this.httpService = lazy;
        this.titleItem = new TitleItem(null, 1, null);
        this.contentItem = new ContentItem(null, 1, null);
        this.imgList = new ArrayList<>();
        this.videoList = new ArrayList<>();
        this.audioList = new ArrayList<>(2);
        this.fileList = new ArrayList<>(4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void h(HWDetailMediaDataModel hWDetailMediaDataModel, AudioItem audioItem, Function0 function0, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                function0 = null;
            }
            hWDetailMediaDataModel.g(audioItem, function0);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: downloadAudioItem");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IHttpService m() {
        return (IHttpService) this.httpService.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final Object e(@NotNull Function0<Unit> function0, @NotNull Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return iPatchRedirector.redirect((short) 16, (Object) this, (Object) function0, (Object) continuation);
        }
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new HWDetailMediaDataModel$callbackWithMainContext$2(function0, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (withContext == coroutine_suspended) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    public final void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        Collection<com.tencent.qqnt.http.api.b> values = this.downloadFileTaskMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "downloadFileTaskMap.values");
        for (com.tencent.qqnt.http.api.b it : values) {
            IHttpService m3 = m();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            m3.cancel(it);
        }
        this.downloadFileTaskMap.clear();
        this.downloadAudioTaskSet.clear();
        Iterator<T> it5 = this.imgList.iterator();
        while (it5.hasNext()) {
            com.tencent.mobileqq.troop.homework.common.widget.mediaedit.utils.a.f296840a.a((ImageItem) it5.next());
        }
        Iterator<T> it6 = this.videoList.iterator();
        while (it6.hasNext()) {
            com.tencent.mobileqq.troop.homework.common.widget.mediaedit.utils.a.f296840a.a((VideoItem) it6.next());
        }
    }

    public final void g(@NotNull AudioItem item, @Nullable Function0<Unit> callback) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) item, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        String httpUrl = item.getHttpUrl();
        if (httpUrl == null) {
            return;
        }
        if (httpUrl.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        if (!this.downloadAudioTaskSet.contains(httpUrl)) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, Dispatchers.getIO(), null, new HWDetailMediaDataModel$downloadAudioItem$1(item, callback, this, httpUrl, null), 2, null);
        } else {
            QLog.i("HW.MediaEdit.HWDetailMediaDataModel", 1, "downloadAudioFile, but downloadTaskSet contains it.");
        }
    }

    public final void i(@NotNull FileItem item, @Nullable Function0<Unit> openCallback, @Nullable Function0<Unit> updateCallback) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, item, openCallback, updateCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        String localPath = item.getLocalPath();
        boolean z18 = false;
        if (localPath != null && localPath.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 && item.getFileType() != 0 && item.getFileType() != 2) {
            String httpUrl = item.getHttpUrl();
            if (httpUrl == null) {
                return;
            }
            if (httpUrl.length() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                String fileName = item.getFileName();
                if (fileName == null || fileName.length() == 0) {
                    z18 = true;
                }
                if (!z18) {
                    if (!this.downloadFileTaskMap.contains(httpUrl)) {
                        BuildersKt__Builders_commonKt.launch$default(this.scope, Dispatchers.getIO(), null, new HWDetailMediaDataModel$downloadFileItem$1(item, openCallback, httpUrl, this, updateCallback, null), 2, null);
                        return;
                    } else {
                        QLog.i("HW.MediaEdit.HWDetailMediaDataModel", 1, "downloadFileItem, but downloadFileTaskMap contains it.");
                        return;
                    }
                }
                return;
            }
            return;
        }
        if (openCallback != null) {
            openCallback.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final ArrayList<AudioItem> j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ArrayList) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.audioList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final ContentItem k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ContentItem) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.contentItem;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final ArrayList<FileItem> l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (ArrayList) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.fileList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final ArrayList<ImageItem> n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ArrayList) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.imgList;
    }

    @NotNull
    public List<BaseItem> o() {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(this.titleItem, this.contentItem);
            arrayListOf.addAll(this.imgList);
            arrayListOf.addAll(this.videoList);
            arrayListOf.addAll(this.audioList);
            arrayListOf.addAll(this.fileList);
            return arrayListOf;
        }
        return (List) iPatchRedirector.redirect((short) 12, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final TitleItem p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TitleItem) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.titleItem;
    }

    @NotNull
    public final String q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.troopUin;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final ArrayList<VideoItem> r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ArrayList) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.videoList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void s(@NotNull GroupSchoolNoticeContent content) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        int collectionSizeOrDefault3;
        int collectionSizeOrDefault4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) content);
            return;
        }
        Intrinsics.checkNotNullParameter(content, "content");
        ContentItem contentItem = this.contentItem;
        String str = content.content;
        Intrinsics.checkNotNullExpressionValue(str, "content.content");
        contentItem.setContent(str);
        this.contentItem.setNotifyContentHeightOnce(true);
        this.imgList.clear();
        ArrayList<ImageItem> arrayList = this.imgList;
        ArrayList<GroupSchoolNoticeMediaContent> arrayList2 = content.pics;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "content.pics");
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
        for (GroupSchoolNoticeMediaContent groupSchoolNoticeMediaContent : arrayList2) {
            ImageItem imageItem = new ImageItem();
            imageItem.setHttpUrl(groupSchoolNoticeMediaContent.url);
            imageItem.setWidth(groupSchoolNoticeMediaContent.width);
            imageItem.setHeight(groupSchoolNoticeMediaContent.height);
            arrayList3.add(imageItem);
        }
        arrayList.addAll(arrayList3);
        this.videoList.clear();
        ArrayList<VideoItem> arrayList4 = this.videoList;
        ArrayList<GroupSchoolNoticeMediaContent> arrayList5 = content.videos;
        Intrinsics.checkNotNullExpressionValue(arrayList5, "content.videos");
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList5, 10);
        ArrayList arrayList6 = new ArrayList(collectionSizeOrDefault2);
        for (GroupSchoolNoticeMediaContent groupSchoolNoticeMediaContent2 : arrayList5) {
            VideoItem videoItem = new VideoItem();
            videoItem.setHttpUrl(groupSchoolNoticeMediaContent2.url);
            videoItem.setPosterHttpUrl(groupSchoolNoticeMediaContent2.coverUrl);
            videoItem.setWidth(groupSchoolNoticeMediaContent2.width);
            videoItem.setHeight(groupSchoolNoticeMediaContent2.height);
            arrayList6.add(videoItem);
        }
        arrayList4.addAll(arrayList6);
        this.audioList.clear();
        ArrayList<AudioItem> arrayList7 = this.audioList;
        ArrayList<GroupSchoolNoticeMediaContent> arrayList8 = content.audios;
        Intrinsics.checkNotNullExpressionValue(arrayList8, "content.audios");
        collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList8, 10);
        ArrayList arrayList9 = new ArrayList(collectionSizeOrDefault3);
        for (GroupSchoolNoticeMediaContent groupSchoolNoticeMediaContent3 : arrayList8) {
            AudioItem audioItem = new AudioItem();
            audioItem.setHttpUrl(groupSchoolNoticeMediaContent3.url);
            audioItem.setCountTime(groupSchoolNoticeMediaContent3.duration * 1000);
            h(this, audioItem, null, 2, null);
            arrayList9.add(audioItem);
        }
        arrayList7.addAll(arrayList9);
        this.fileList.clear();
        ArrayList<FileItem> arrayList10 = this.fileList;
        ArrayList<GroupSchoolNoticeMediaContent> arrayList11 = content.files;
        Intrinsics.checkNotNullExpressionValue(arrayList11, "content.files");
        collectionSizeOrDefault4 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList11, 10);
        ArrayList arrayList12 = new ArrayList(collectionSizeOrDefault4);
        for (GroupSchoolNoticeMediaContent groupSchoolNoticeMediaContent4 : arrayList11) {
            FileItem fileItem = new FileItem();
            fileItem.setHttpUrl(groupSchoolNoticeMediaContent4.url);
            fileItem.setFileName(groupSchoolNoticeMediaContent4.name);
            fileItem.setFileSize(groupSchoolNoticeMediaContent4.size);
            fileItem.setFileType(ah.o0(groupSchoolNoticeMediaContent4.url));
            fileItem.setFileMd5(groupSchoolNoticeMediaContent4.md5);
            arrayList12.add(fileItem);
        }
        arrayList10.addAll(arrayList12);
    }

    public abstract void t(T detail, @Nullable Function0<Unit> callback);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void u(long authorUin, long publishTime, @Nullable Function0<Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, Dispatchers.getIO(), null, new HWDetailMediaDataModel$updateSubTitle$1(this, authorUin, publishTime, callback, null), 2, null);
        } else {
            iPatchRedirector.redirect((short) 10, this, Long.valueOf(authorUin), Long.valueOf(publishTime), callback);
        }
    }
}
