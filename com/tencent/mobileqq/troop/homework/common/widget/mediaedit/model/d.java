package com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model;

import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolNoticeContent;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolNoticeMediaContent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0016\u0018\u0000 \u00122\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b7\u00108J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\rJ\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000fJ\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0013\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u000bJ\u0006\u0010\u0016\u001a\u00020\u0015R\u0017\u0010\u001b\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010 \u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010%\u001a\u00020!8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\f\u0010\"\u001a\u0004\b#\u0010$R*\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\n0&j\b\u0012\u0004\u0012\u00020\n`'8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010(\u001a\u0004\b)\u0010*R*\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\r0&j\b\u0012\u0004\u0012\u00020\r`'8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010(\u001a\u0004\b,\u0010*R*\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\u000f0&j\b\u0012\u0004\u0012\u00020\u000f`'8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0007\u0010(\u001a\u0004\b.\u0010*R\u0011\u00102\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b0\u00101R\u0011\u00104\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b3\u00101R\u0011\u00106\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b5\u00101\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/d;", "", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/BaseItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", ReportConstant.COSTREPORT_PREFIX, TagName.FILE_TYPE, "f", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/BaseMediaItem;", "", "c", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/AudioItem;", "a", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/FileItem;", "b", "", "g", h.F, "d", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolNoticeContent;", "e", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/TitleItem;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/TitleItem;", "r", "()Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/TitleItem;", "titleItem", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/ContentItem;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/ContentItem;", "k", "()Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/ContentItem;", "contentItem", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/MediaListItem;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/MediaListItem;", "p", "()Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/MediaListItem;", "mediaListItem", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "o", "()Ljava/util/ArrayList;", "mediaList", "j", "audioList", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "fileList", "i", "()I", "audioItemSize", DomainData.DOMAIN_NAME, "mediaItemSize", "l", "fileItemSize", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TitleItem titleItem;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ContentItem contentItem;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MediaListItem mediaListItem;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<BaseMediaItem> mediaList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<AudioItem> audioList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<FileItem> fileList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/d$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.d$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49495);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        TitleItem titleItem = new TitleItem("");
        titleItem.setEditText(true);
        titleItem.setReqFocus(false);
        titleItem.setHintText("\u8f93\u5165\u6807\u9898");
        this.titleItem = titleItem;
        ContentItem contentItem = new ContentItem(null, 1, null);
        contentItem.setEditText(true);
        contentItem.setReqFocus(true);
        contentItem.setHintText("\u8f93\u5165\u5185\u5bb9");
        contentItem.setShowInputMethodOnce(true);
        this.contentItem = contentItem;
        this.mediaListItem = new MediaListItem(0, 0, 3, null);
        this.mediaList = new ArrayList<>();
        this.audioList = new ArrayList<>(2);
        this.fileList = new ArrayList<>(2);
    }

    private final int f(int fileType) {
        if (fileType != 9 && fileType != 10) {
            if (fileType != 16) {
                switch (fileType) {
                    case 0:
                        return 1;
                    case 1:
                        return 3;
                    case 2:
                        return 2;
                    case 3:
                    case 6:
                    case 7:
                        break;
                    case 4:
                        return 4;
                    case 5:
                        break;
                    default:
                        return 20;
                }
            }
            return 6;
        }
        return 5;
    }

    private final int s(BaseItem item) {
        if (item instanceof ImageItem) {
            return 1;
        }
        if (item instanceof AudioItem) {
            return 3;
        }
        if (item instanceof VideoItem) {
            return 2;
        }
        if (item instanceof FileItem) {
            return f(((FileItem) item).getFileType());
        }
        return 20;
    }

    public final boolean a(@NotNull AudioItem item) {
        String str;
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) item)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(item, "item");
        String localPath = item.getLocalPath();
        if (localPath == null) {
            return false;
        }
        Iterator<T> it = this.audioList.iterator();
        while (true) {
            str = null;
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((AudioItem) obj).getLocalPath(), localPath)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        AudioItem audioItem = (AudioItem) obj;
        if (audioItem != null) {
            str = audioItem.getLocalPath();
        }
        if (Intrinsics.areEqual(str, localPath)) {
            QLog.w("HW.MediaEdit.HWPublishMediaDataModel", 1, "addAudioItemFilterByLocalPath, is exist path.");
            return false;
        }
        this.audioList.add(item);
        return true;
    }

    public final boolean b(@NotNull FileItem item) {
        String str;
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) item)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(item, "item");
        String localPath = item.getLocalPath();
        if (localPath == null) {
            return false;
        }
        Iterator<T> it = this.fileList.iterator();
        while (true) {
            str = null;
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((FileItem) obj).getLocalPath(), localPath)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        FileItem fileItem = (FileItem) obj;
        if (fileItem != null) {
            str = fileItem.getLocalPath();
        }
        if (Intrinsics.areEqual(str, localPath)) {
            QLog.w("HW.MediaEdit.HWPublishMediaDataModel", 1, "addFileItemFilterByLocalPath, is exist path.");
            return false;
        }
        this.fileList.add(item);
        return true;
    }

    public final boolean c(@NotNull BaseMediaItem item) {
        String str;
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) item)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(item, "item");
        String localPath = item.getLocalPath();
        if (localPath == null) {
            return false;
        }
        Iterator<T> it = this.mediaList.iterator();
        while (true) {
            str = null;
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((BaseMediaItem) obj).getLocalPath(), localPath)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        BaseMediaItem baseMediaItem = (BaseMediaItem) obj;
        if (baseMediaItem != null) {
            str = baseMediaItem.getLocalPath();
        }
        if (Intrinsics.areEqual(str, localPath)) {
            QLog.w("HW.MediaEdit.HWPublishMediaDataModel", 1, "addMediaItemFilterByLocalPath, is exist path.");
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("HW.MediaEdit.HWPublishMediaDataModel", 4, "addMediaItemFilterByLocalPath, w:" + item.getWidth() + ", h:" + item.getHeight());
        }
        this.mediaList.add(item);
        return true;
    }

    public final boolean d() {
        Object obj;
        Object obj2;
        Object obj3;
        boolean z16;
        boolean z17;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        Iterator<T> it = this.mediaList.iterator();
        while (true) {
            obj = null;
            if (it.hasNext()) {
                obj2 = it.next();
                if (((BaseMediaItem) obj2).getState() != UploadOrDownloadState.UPLOAD_SUC) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    break;
                }
            } else {
                obj2 = null;
                break;
            }
        }
        Object obj4 = (BaseMediaItem) obj2;
        if (obj4 == null) {
            Iterator<T> it5 = this.audioList.iterator();
            while (true) {
                if (it5.hasNext()) {
                    obj3 = it5.next();
                    if (((AudioItem) obj3).getState() != UploadOrDownloadState.UPLOAD_SUC) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        break;
                    }
                } else {
                    obj3 = null;
                    break;
                }
            }
            obj4 = (AudioItem) obj3;
            if (obj4 == null) {
                Iterator<T> it6 = this.fileList.iterator();
                while (true) {
                    if (!it6.hasNext()) {
                        break;
                    }
                    Object next = it6.next();
                    if (((FileItem) next).getState() != UploadOrDownloadState.UPLOAD_SUC) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        obj = next;
                        break;
                    }
                }
                obj4 = (BaseItem) obj;
            }
        }
        if (obj4 == null) {
            return true;
        }
        return false;
    }

    @NotNull
    public final GroupSchoolNoticeContent e() {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        int collectionSizeOrDefault3;
        int collectionSizeOrDefault4;
        CharSequence trim;
        CharSequence trim2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (GroupSchoolNoticeContent) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        ArrayList<BaseMediaItem> arrayList = this.mediaList;
        ArrayList<BaseItem> arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (obj instanceof ImageItem) {
                arrayList2.add(obj);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
        for (BaseItem baseItem : arrayList2) {
            arrayList3.add(new GroupSchoolNoticeMediaContent(baseItem.getHttpUrl(), baseItem.getFileMd5(), "", baseItem.getFileSize(), 0L, "", s(baseItem), baseItem.getHeight(), baseItem.getWidth()));
        }
        ArrayList<AudioItem> arrayList4 = this.audioList;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList4, 10);
        ArrayList arrayList5 = new ArrayList(collectionSizeOrDefault2);
        for (Iterator it = arrayList4.iterator(); it.hasNext(); it = it) {
            AudioItem audioItem = (AudioItem) it.next();
            arrayList5.add(new GroupSchoolNoticeMediaContent(audioItem.getHttpUrl(), audioItem.getFileMd5(), "", audioItem.getFileSize(), audioItem.getCountTime() / 1000, "", s(audioItem), 0, 0));
        }
        ArrayList<BaseMediaItem> arrayList6 = this.mediaList;
        ArrayList<VideoItem> arrayList7 = new ArrayList();
        for (Object obj2 : arrayList6) {
            if (obj2 instanceof VideoItem) {
                arrayList7.add(obj2);
            }
        }
        collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList7, 10);
        ArrayList arrayList8 = new ArrayList(collectionSizeOrDefault3);
        for (VideoItem videoItem : arrayList7) {
            arrayList8.add(new GroupSchoolNoticeMediaContent(videoItem.getHttpUrl(), videoItem.getFileMd5(), "", videoItem.getFileSize(), 0L, videoItem.getPosterHttpUrl(), s(videoItem), videoItem.getHeight(), videoItem.getWidth()));
        }
        ArrayList<FileItem> arrayList9 = this.fileList;
        collectionSizeOrDefault4 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList9, 10);
        ArrayList arrayList10 = new ArrayList(collectionSizeOrDefault4);
        for (BaseItem baseItem2 : arrayList9) {
            arrayList10.add(new GroupSchoolNoticeMediaContent(baseItem2.getHttpUrl(), baseItem2.getFileMd5(), baseItem2.getFileName(), baseItem2.getFileSize(), 0L, "", s(baseItem2), 0, 0));
        }
        trim = StringsKt__StringsKt.trim((CharSequence) this.titleItem.getTitle());
        String obj3 = trim.toString();
        trim2 = StringsKt__StringsKt.trim((CharSequence) this.contentItem.getContent());
        String obj4 = trim2.toString();
        ArrayList arrayList11 = new ArrayList();
        arrayList11.addAll(arrayList3);
        Unit unit = Unit.INSTANCE;
        ArrayList arrayList12 = new ArrayList();
        arrayList12.addAll(arrayList5);
        ArrayList arrayList13 = new ArrayList();
        arrayList13.addAll(arrayList8);
        ArrayList arrayList14 = new ArrayList();
        arrayList14.addAll(arrayList10);
        return new GroupSchoolNoticeContent(obj3, obj4, arrayList11, arrayList12, arrayList13, arrayList14, false);
    }

    public final void g(@NotNull BaseItem item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        if (item instanceof BaseMediaItem) {
            this.mediaList.remove(item);
        } else if (item instanceof AudioItem) {
            this.audioList.remove(item);
        } else if (item instanceof FileItem) {
            this.fileList.remove(item);
        }
    }

    public final void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        Iterator<T> it = this.mediaList.iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.troop.homework.common.widget.mediaedit.utils.a.f296840a.a((BaseMediaItem) it.next());
        }
    }

    public final int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.audioList.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final ArrayList<AudioItem> j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ArrayList) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.audioList;
    }

    @NotNull
    public final ContentItem k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ContentItem) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.contentItem;
    }

    public final int l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.fileList.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final ArrayList<FileItem> m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ArrayList) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.fileList;
    }

    public final int n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.mediaList.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final ArrayList<BaseMediaItem> o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ArrayList) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mediaList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final MediaListItem p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MediaListItem) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mediaListItem;
    }

    @NotNull
    public List<BaseItem> q() {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(this.titleItem, this.contentItem);
            arrayListOf.add(this.mediaListItem.resetData(this.mediaList));
            arrayListOf.addAll(this.audioList);
            arrayListOf.addAll(this.fileList);
            return arrayListOf;
        }
        return (List) iPatchRedirector.redirect((short) 11, (Object) this);
    }

    @NotNull
    public final TitleItem r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TitleItem) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.titleItem;
    }
}
