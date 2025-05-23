package com.tencent.qqnt.chathistory.datatracker;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.transaction.Tracker;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.adinfo.QAdPlayStrategyDefine$PlayStrategyKey;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.aio.element.file.util.a;
import com.tencent.qqnt.chathistory.ui.base.BaseHistoryViewModel;
import com.tencent.qqnt.chathistory.ui.base.e;
import com.tencent.qqnt.chathistory.ui.file.c2c.adapter.ChatHistoryFileAdapter;
import com.tencent.qqnt.chathistory.ui.file.c2c.data.model.FileItemModel;
import com.tencent.qqnt.expandRecyclerView.adapter.provider.b;
import com.tencent.qqnt.kernel.api.IUixConvertAdapterApi;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u00067>?@ABB\u0007\u00a2\u0006\u0004\b<\u0010=J(\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002H\u0002J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002J,\u0010\f\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00032\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002J:\u0010\u000e\u001a\u00020\n2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u00032\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003J:\u0010\u000f\u001a\u00020\n2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u00032\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003J*\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002J,\u0010\u0014\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0002J,\u0010\u0015\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0002J4\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0002J,\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0002JL\u0010\u001e\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u001b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003J\u000e\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0001J\u0016\u0010\"\u001a\u00020\u00032\u000e\u0010!\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030 J\u0016\u0010&\u001a\u00020\u00032\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u0003J\\\u00101\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u00032\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020#2\u0006\u0010/\u001a\u00020#2\u0014\b\u0002\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002JD\u00104\u001a\u00020\n2\u0006\u0010)\u001a\u00020(2\u0006\u00102\u001a\u00020#2\u0006\u0010/\u001a\u00020#2\u0006\u0010'\u001a\u00020\u00032\u0006\u00103\u001a\u00020#2\u0014\b\u0002\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002J\u001e\u00105\u001a\u00020\n2\u0006\u0010)\u001a\u00020(2\u0006\u00102\u001a\u00020#2\u0006\u00103\u001a\u00020#R@\u0010;\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00022\u0014\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\u00a8\u0006C"}, d2 = {"Lcom/tencent/qqnt/chathistory/datatracker/HistoryDtReportHelper;", "", "", "", "businessParams", "b", "id", "Landroid/view/View;", "view", "extras", "", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, IECDtReport.ACTION_IDENTIFIER, "o", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "eventID", "obj", "l", ISchemeApi.KEY_PAGE_ID, "u", HippyTKDListViewAdapter.X, "target", "v", "targetView", "w", "elementID", "", "onlyClick", "isAsync", ReportConstant.COSTREPORT_PREFIX, "y", "Lcom/tencent/qqnt/chathistory/ui/base/BaseHistoryViewModel;", "viewModel", "d", "", "chatType", "peerUid", "e", "elementId", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "direction", "mFirstPosition", "firstVisiblePosition", "mLastPosition", "lastVisiblePosition", "legalCode", "params", "g", DownloaderConstant.KEY_RANGE, "implType", "i", "f", "<set-?>", "a", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "curPageParam", "<init>", "()V", "FileThumbContent", "MediaType", "OperationBar", "OperationContent", "SearchEntry", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class HistoryDtReportHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: c */
    @NotNull
    private static final Lazy<HistoryDtReportHelper> f353319c;

    /* renamed from: a, reason: from kotlin metadata */
    @Nullable
    private Map<String, Object> curPageParam;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/chathistory/datatracker/HistoryDtReportHelper$FileThumbContent;", "", "(Ljava/lang/String;I)V", "UPLOAD", "DOWNLOAD", Tracker.PAUSE, "CONTINUE", "OTHER", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class FileThumbContent extends Enum<FileThumbContent> {
        private static final /* synthetic */ FileThumbContent[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final FileThumbContent CONTINUE;
        public static final FileThumbContent DOWNLOAD;
        public static final FileThumbContent OTHER;
        public static final FileThumbContent PAUSE;
        public static final FileThumbContent UPLOAD;

        private static final /* synthetic */ FileThumbContent[] $values() {
            return new FileThumbContent[]{UPLOAD, DOWNLOAD, PAUSE, CONTINUE, OTHER};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31535);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            UPLOAD = new FileThumbContent("UPLOAD", 0);
            DOWNLOAD = new FileThumbContent("DOWNLOAD", 1);
            PAUSE = new FileThumbContent(Tracker.PAUSE, 2);
            CONTINUE = new FileThumbContent("CONTINUE", 3);
            OTHER = new FileThumbContent("OTHER", 4);
            $VALUES = $values();
        }

        FileThumbContent(String str, int i3) {
            super(str, i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static FileThumbContent valueOf(String str) {
            return (FileThumbContent) Enum.valueOf(FileThumbContent.class, str);
        }

        public static FileThumbContent[] values() {
            return (FileThumbContent[]) $VALUES.clone();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/chathistory/datatracker/HistoryDtReportHelper$MediaType;", "", "(Ljava/lang/String;I)V", "NONE", "PIC", "VIDEO", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class MediaType extends Enum<MediaType> {
        private static final /* synthetic */ MediaType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final MediaType NONE;
        public static final MediaType PIC;
        public static final MediaType VIDEO;

        private static final /* synthetic */ MediaType[] $values() {
            return new MediaType[]{NONE, PIC, VIDEO};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31544);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            NONE = new MediaType("NONE", 0);
            PIC = new MediaType("PIC", 1);
            VIDEO = new MediaType("VIDEO", 2);
            $VALUES = $values();
        }

        MediaType(String str, int i3) {
            super(str, i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static MediaType valueOf(String str) {
            return (MediaType) Enum.valueOf(MediaType.class, str);
        }

        public static MediaType[] values() {
            return (MediaType[]) $VALUES.clone();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/chathistory/datatracker/HistoryDtReportHelper$OperationBar;", "", "(Ljava/lang/String;I)V", "FORWARD", "DOWNLOAD", "FAVORITE", "WEIYUN", "DELETE", "OTHER", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class OperationBar extends Enum<OperationBar> {
        private static final /* synthetic */ OperationBar[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final OperationBar DELETE;
        public static final OperationBar DOWNLOAD;
        public static final OperationBar FAVORITE;
        public static final OperationBar FORWARD;
        public static final OperationBar OTHER;
        public static final OperationBar WEIYUN;

        private static final /* synthetic */ OperationBar[] $values() {
            return new OperationBar[]{FORWARD, DOWNLOAD, FAVORITE, WEIYUN, DELETE, OTHER};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31550);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            FORWARD = new OperationBar("FORWARD", 0);
            DOWNLOAD = new OperationBar("DOWNLOAD", 1);
            FAVORITE = new OperationBar("FAVORITE", 2);
            WEIYUN = new OperationBar("WEIYUN", 3);
            DELETE = new OperationBar("DELETE", 4);
            OTHER = new OperationBar("OTHER", 5);
            $VALUES = $values();
        }

        OperationBar(String str, int i3) {
            super(str, i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static OperationBar valueOf(String str) {
            return (OperationBar) Enum.valueOf(OperationBar.class, str);
        }

        public static OperationBar[] values() {
            return (OperationBar[]) $VALUES.clone();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/chathistory/datatracker/HistoryDtReportHelper$OperationContent;", "", "(Ljava/lang/String;I)V", "NONE", "SELECT", QAdPlayStrategyDefine$PlayStrategyKey.NORMAL, "chathistory_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class OperationContent extends Enum<OperationContent> {
        private static final /* synthetic */ OperationContent[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final OperationContent NONE;
        public static final OperationContent NORMAL;
        public static final OperationContent SELECT;

        private static final /* synthetic */ OperationContent[] $values() {
            return new OperationContent[]{NONE, SELECT, NORMAL};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31559);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            NONE = new OperationContent("NONE", 0);
            SELECT = new OperationContent("SELECT", 1);
            NORMAL = new OperationContent(QAdPlayStrategyDefine$PlayStrategyKey.NORMAL, 2);
            $VALUES = $values();
        }

        OperationContent(String str, int i3) {
            super(str, i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static OperationContent valueOf(String str) {
            return (OperationContent) Enum.valueOf(OperationContent.class, str);
        }

        public static OperationContent[] values() {
            return (OperationContent[]) $VALUES.clone();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/chathistory/datatracker/HistoryDtReportHelper$SearchEntry;", "", "(Ljava/lang/String;I)V", "MENU", "FILE", "DOCUMENT", "LINK", "OTHER", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class SearchEntry extends Enum<SearchEntry> {
        private static final /* synthetic */ SearchEntry[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final SearchEntry DOCUMENT;
        public static final SearchEntry FILE;
        public static final SearchEntry LINK;
        public static final SearchEntry MENU;
        public static final SearchEntry OTHER;

        private static final /* synthetic */ SearchEntry[] $values() {
            return new SearchEntry[]{MENU, FILE, DOCUMENT, LINK, OTHER};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31567);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            MENU = new SearchEntry("MENU", 0);
            FILE = new SearchEntry("FILE", 1);
            DOCUMENT = new SearchEntry("DOCUMENT", 2);
            LINK = new SearchEntry("LINK", 3);
            OTHER = new SearchEntry("OTHER", 4);
            $VALUES = $values();
        }

        SearchEntry(String str, int i3) {
            super(str, i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static SearchEntry valueOf(String str) {
            return (SearchEntry) Enum.valueOf(SearchEntry.class, str);
        }

        public static SearchEntry[] values() {
            return (SearchEntry[]) $VALUES.clone();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\b\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/chathistory/datatracker/HistoryDtReportHelper$a;", "", "Lcom/tencent/qqnt/chathistory/datatracker/HistoryDtReportHelper;", "a", "sInstance$delegate", "Lkotlin/Lazy;", "b", "()Lcom/tencent/qqnt/chathistory/datatracker/HistoryDtReportHelper;", "sInstance", "", "EXPOSURE_RATE", "D", "", "TAG", "Ljava/lang/String;", "", "TypeImpl", "I", "TypeImplEnd", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chathistory.datatracker.HistoryDtReportHelper$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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

        private final HistoryDtReportHelper b() {
            return (HistoryDtReportHelper) HistoryDtReportHelper.f353319c.getValue();
        }

        @NotNull
        public final HistoryDtReportHelper a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (HistoryDtReportHelper) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return b();
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
        Lazy<HistoryDtReportHelper> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31571);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(HistoryDtReportHelper$Companion$sInstance$2.INSTANCE);
        f353319c = lazy;
    }

    public HistoryDtReportHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ void h(HistoryDtReportHelper historyDtReportHelper, String str, RecyclerView recyclerView, boolean z16, int i3, int i16, int i17, int i18, int i19, Map map, int i26, Object obj) {
        Map map2;
        if ((i26 & 256) != 0) {
            map2 = new LinkedHashMap();
        } else {
            map2 = map;
        }
        historyDtReportHelper.g(str, recyclerView, z16, i3, i16, i17, i18, i19, map2);
    }

    public static /* synthetic */ void j(HistoryDtReportHelper historyDtReportHelper, RecyclerView recyclerView, int i3, int i16, String str, int i17, Map map, int i18, Object obj) {
        if ((i18 & 32) != 0) {
            map = new LinkedHashMap();
        }
        historyDtReportHelper.i(recyclerView, i3, i16, str, i17, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void n(HistoryDtReportHelper historyDtReportHelper, View view, String str, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = new LinkedHashMap();
        }
        historyDtReportHelper.m(view, str, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void p(HistoryDtReportHelper historyDtReportHelper, View view, String str, Map map, String str2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = new LinkedHashMap();
        }
        if ((i3 & 8) != 0) {
            str2 = null;
        }
        historyDtReportHelper.o(view, str, map, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void r(HistoryDtReportHelper historyDtReportHelper, View view, String str, Map map, String str2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = new LinkedHashMap();
        }
        if ((i3 & 8) != 0) {
            str2 = null;
        }
        historyDtReportHelper.q(view, str, map, str2);
    }

    public static /* synthetic */ void t(HistoryDtReportHelper historyDtReportHelper, View view, String str, Map map, boolean z16, boolean z17, String str2, int i3, Object obj) {
        boolean z18;
        boolean z19;
        if ((i3 & 4) != 0) {
            map = new LinkedHashMap();
        }
        Map map2 = map;
        if ((i3 & 8) != 0) {
            z18 = false;
        } else {
            z18 = z16;
        }
        if ((i3 & 16) != 0) {
            z19 = false;
        } else {
            z19 = z17;
        }
        if ((i3 & 32) != 0) {
            str2 = null;
        }
        historyDtReportHelper.s(view, str, map2, z18, z19, str2);
    }

    @Nullable
    public final Map<String, Object> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Map) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.curPageParam;
    }

    @NotNull
    public final String d(@NotNull BaseHistoryViewModel<?, ?> viewModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this, (Object) viewModel);
        }
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        if (viewModel.M1() == 2) {
            return viewModel.N1();
        }
        try {
            return String.valueOf(((IUixConvertAdapterApi) QRoute.api(IUixConvertAdapterApi.class)).getUinFromUid(viewModel.N1()));
        } catch (Exception unused) {
            return "";
        }
    }

    @NotNull
    public final String e(int chatType, @NotNull String peerUid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this, chatType, (Object) peerUid);
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        if (chatType != 2) {
            try {
                return String.valueOf(((IUixConvertAdapterApi) QRoute.api(IUixConvertAdapterApi.class)).getUinFromUid(peerUid));
            } catch (Exception unused) {
                return "";
            }
        }
        return peerUid;
    }

    public final void f(@NotNull RecyclerView recyclerView, int r122, int implType) {
        ChatHistoryFileAdapter chatHistoryFileAdapter;
        String valueOf;
        Map<String, Object> mutableMapOf;
        Map<String, Object> mutableMapOf2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, recyclerView, Integer.valueOf(r122), Integer.valueOf(implType));
            return;
        }
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        for (int i3 = 0; i3 < r122 && i3 < recyclerView.getChildCount(); i3++) {
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            View view = null;
            if (adapter instanceof ChatHistoryFileAdapter) {
                chatHistoryFileAdapter = (ChatHistoryFileAdapter) adapter;
            } else {
                chatHistoryFileAdapter = null;
            }
            if (chatHistoryFileAdapter == null) {
                return;
            }
            if (i3 >= chatHistoryFileAdapter.m0().size()) {
                valueOf = String.valueOf(chatHistoryFileAdapter.m0().size() + i3);
            } else {
                valueOf = String.valueOf(chatHistoryFileAdapter.m0().get(i3).hashCode());
            }
            if (chatHistoryFileAdapter.getItemViewType(i3) == 1) {
                if (implType == 0) {
                    HistoryDtReportHelper a16 = INSTANCE.a();
                    RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                    if (layoutManager != null) {
                        view = layoutManager.findViewByPosition(i3);
                    }
                    mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("butten_content", chatHistoryFileAdapter.a1(i3)));
                    a16.o(view, "em_bas_file_entry", mutableMapOf2, valueOf);
                } else {
                    HistoryDtReportHelper a17 = INSTANCE.a();
                    RecyclerView.LayoutManager layoutManager2 = recyclerView.getLayoutManager();
                    if (layoutManager2 != null) {
                        view = layoutManager2.findViewByPosition(i3);
                    }
                    mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("butten_content", chatHistoryFileAdapter.a1(i3)));
                    a17.q(view, "em_bas_file_entry", mutableMapOf, valueOf);
                }
            }
        }
    }

    public final void g(@NotNull String elementId, @NotNull RecyclerView recyclerView, boolean direction, int mFirstPosition, int firstVisiblePosition, int mLastPosition, int lastVisiblePosition, int legalCode, @NotNull Map<String, Object> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, elementId, recyclerView, Boolean.valueOf(direction), Integer.valueOf(mFirstPosition), Integer.valueOf(firstVisiblePosition), Integer.valueOf(mLastPosition), Integer.valueOf(lastVisiblePosition), Integer.valueOf(legalCode), params);
            return;
        }
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(params, "params");
        if (direction) {
            i(recyclerView, firstVisiblePosition - mFirstPosition, legalCode, elementId, 1, params);
            i(recyclerView, lastVisiblePosition - mLastPosition, legalCode, elementId, 0, params);
        } else {
            i(recyclerView, mFirstPosition - firstVisiblePosition, legalCode, elementId, 0, params);
            i(recyclerView, mLastPosition - lastVisiblePosition, legalCode, elementId, 1, params);
        }
    }

    public final void i(@NotNull RecyclerView recyclerView, int r85, int legalCode, @NotNull String elementId, int implType, @NotNull Map<String, Object> params) {
        b bVar;
        String valueOf;
        FileItemModel fileItemModel;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, recyclerView, Integer.valueOf(r85), Integer.valueOf(legalCode), elementId, Integer.valueOf(implType), params);
            return;
        }
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Intrinsics.checkNotNullParameter(params, "params");
        for (int i3 = 0; i3 < r85 && i3 < recyclerView.getChildCount(); i3++) {
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            View view = null;
            if (adapter instanceof b) {
                bVar = (b) adapter;
            } else {
                bVar = null;
            }
            if (bVar == null) {
                return;
            }
            if (i3 >= bVar.m0().size()) {
                valueOf = String.valueOf(bVar.m0().size() + i3);
            } else {
                valueOf = String.valueOf(bVar.m0().get(i3).hashCode());
            }
            if (bVar.getItemViewType(i3) == legalCode) {
                com.tencent.qqnt.expandRecyclerView.adapter.node.b bVar2 = bVar.m0().get(i3);
                if (bVar2 instanceof FileItemModel) {
                    fileItemModel = (FileItemModel) bVar2;
                } else {
                    fileItemModel = null;
                }
                if (fileItemModel != null) {
                    params.put("file_size", Long.valueOf(fileItemModel.q().fileSize));
                    params.put("filetype", a.c(fileItemModel.q().fileName));
                    params.put("is_expired", Integer.valueOf(fileItemModel.z() ? 1 : 0));
                    params.put("is_downloaded", Integer.valueOf(Intrinsics.areEqual(fileItemModel.I(), e.d.f353349a) ? 1 : 0));
                }
                if (implType == 0) {
                    HistoryDtReportHelper a16 = INSTANCE.a();
                    RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                    if (layoutManager != null) {
                        view = layoutManager.findViewByPosition(i3);
                    }
                    a16.o(view, elementId, params, valueOf);
                } else {
                    HistoryDtReportHelper a17 = INSTANCE.a();
                    RecyclerView.LayoutManager layoutManager2 = recyclerView.getLayoutManager();
                    if (layoutManager2 != null) {
                        view = layoutManager2.findViewByPosition(i3);
                    }
                    a17.q(view, elementId, params, valueOf);
                }
            }
        }
    }

    public final void k(@NotNull String id5, @NotNull View view, @NotNull Map<String, Object> extras) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, id5, view, extras);
            return;
        }
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(extras, "extras");
        VideoReport.reportEvent("clck", view, extras);
    }

    public final synchronized void l(@NotNull String eventID, @NotNull Object obj, @NotNull Map<String, Object> businessParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, eventID, obj, businessParams);
            return;
        }
        Intrinsics.checkNotNullParameter(eventID, "eventID");
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        try {
            b(businessParams);
            VideoReport.reportEvent(eventID, obj, businessParams);
        } catch (Exception e16) {
            QLog.e("HistoryDtReportHelper", 1, "reportEvent throw e: " + e16.getMessage());
        }
    }

    public final void m(@NotNull View view, @NotNull String id5, @NotNull Map<String, Object> extras) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, view, id5, extras);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(extras, "extras");
        b(extras);
        VideoReport.setElementId(view, id5);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementParams(view, extras);
        l("clck", view, extras);
    }

    public final void o(@Nullable View view, @NotNull String id5, @NotNull Map<String, Object> extras, @Nullable String r122) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, view, id5, extras, r122);
            return;
        }
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(extras, "extras");
        if (view == null) {
            return;
        }
        s(view, id5, extras, true, false, r122);
        l("imp", view, extras);
    }

    public final void q(@Nullable View view, @NotNull String id5, @NotNull Map<String, Object> extras, @Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, view, id5, extras, str);
            return;
        }
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(extras, "extras");
        if (view == null) {
            return;
        }
        s(view, id5, extras, true, false, str);
        l("imp_end", view, extras);
    }

    public final synchronized void s(@NotNull View view, @NotNull String elementID, @NotNull Map<String, Object> businessParams, boolean z16, boolean z17, @Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, view, elementID, businessParams, Boolean.valueOf(z16), Boolean.valueOf(z17), str);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        b(businessParams);
        VideoReport.setElementId(view, elementID);
        if (z16) {
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
            VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        } else {
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        }
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementParams(view, businessParams);
        if (str != null) {
            VideoReport.setElementReuseIdentifier(view, str);
        }
        if (z17) {
            VideoReport.traverseExposure();
        }
    }

    public final synchronized void u(@NotNull Object view, @NotNull String r85, @Nullable Map<String, Object> businessParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, view, r85, businessParams);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(r85, "pageID");
        w(view, r85, businessParams);
        VideoReport.reportPgIn(view);
    }

    public final synchronized void v(@NotNull Object target, @NotNull Object view, @NotNull String r75, @Nullable Map<String, Object> businessParams) {
        Map<String, Object> map;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, target, view, r75, businessParams);
            return;
        }
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(r75, "pageID");
        if ((target instanceof Activity) || (target instanceof Fragment) || (target instanceof View) || (target instanceof Dialog)) {
            if (target instanceof Fragment) {
                VideoReport.addToDetectionWhitelist(((Fragment) target).getActivity());
            }
            if (target instanceof Activity) {
                VideoReport.addToDetectionWhitelist((Activity) target);
            }
        }
        if (businessParams != null) {
            map = MapsKt__MapsKt.toMutableMap(businessParams);
        } else {
            map = null;
        }
        this.curPageParam = map;
        if (map != null) {
            map.put("pgid", r75);
        }
        w(view, r75, businessParams);
    }

    public final synchronized void w(@NotNull Object targetView, @NotNull String r85, @Nullable Map<String, Object> businessParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, targetView, r85, businessParams);
            return;
        }
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        Intrinsics.checkNotNullParameter(r85, "pageID");
        if (!(targetView instanceof Activity) && !(targetView instanceof Fragment) && !(targetView instanceof View) && !(targetView instanceof Dialog)) {
            QLog.e("HistoryDtReportHelper", 1, "setPageInfo targetView \u4e0d\u662fActivity Fragment\u6216\u8005View");
        }
        if (targetView instanceof Fragment) {
            VideoReport.addToDetectionWhitelist(((Fragment) targetView).getActivity());
        }
        if (targetView instanceof Activity) {
            VideoReport.addToDetectionWhitelist((Activity) targetView);
        }
        if (businessParams == null) {
            businessParams = new LinkedHashMap<>();
        }
        PageParams pageParams = new PageParams((Map<String, ?>) b(businessParams));
        VideoReport.setPageId(targetView, r85);
        VideoReport.setPageParams(targetView, pageParams);
    }

    public final synchronized void x(@NotNull Object view, @NotNull String pageID, @Nullable Map<String, Object> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, view, pageID, map);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(pageID, "pageID");
        VideoReport.reportPgOut(view);
    }

    public final synchronized void y(@NotNull Object target) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, target);
        } else {
            Intrinsics.checkNotNullParameter(target, "target");
            VideoReport.ignorePageInOutEvent(target, true);
        }
    }

    private final Map<String, Object> b(Map<String, Object> businessParams) {
        return businessParams;
    }
}
