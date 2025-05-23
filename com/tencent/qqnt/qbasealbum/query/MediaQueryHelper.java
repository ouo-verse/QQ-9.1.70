package com.tencent.qqnt.qbasealbum.query;

import android.content.Context;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qqnt.qbasealbum.album.repository.PickerVideoCursor;
import com.tencent.qqnt.qbasealbum.datahub.LocalMediaDataHub;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.query.ICursor;
import com.tencent.qqnt.qbasealbum.utils.InitDataUtil;
import com.tencent.qqnt.qbasealbum.utils.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 ;2\u00020\u0001:\u0004\u0018\u000f\u0015!B\t\b\u0002\u00a2\u0006\u0004\b9\u0010:J&\u0010\t\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0005H\u0002J \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010\u0012\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u0005J\u0006\u0010\u0015\u001a\u00020\bR\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\"\u0010 \u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010#\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u001b\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u0016\u0010\u0007\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010$R\u0016\u0010%\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010$R\u0016\u0010&\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010$R\"\u0010)\u001a\u00020'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010\u0019R\u0018\u0010/\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010.R\u001e\u00103\u001a\n\u0012\u0004\u0012\u000201\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u00102R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010$R\u0016\u00106\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010$R\u0016\u00108\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010$\u00a8\u0006<"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/query/MediaQueryHelper;", "", "", "Lcom/tencent/qqnt/qbasealbum/query/ICursor;", "cursors", "", "limit", "eachCount", "", "f", "queryCnt", "i", "obtainCnt", "traverseCnt", "", "b", "Lcom/tencent/qqnt/qbasealbum/query/ICursor$b;", "filter", "j", "nextCount", "g", "c", "", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "a", "Ljava/util/List;", "mediaList", "Z", "e", "()Z", "setMTraversalDone", "(Z)V", "mTraversalDone", "d", "setIntercept", "intercept", "I", "mediaCount", MessageForQCircleFeed.MSG_QCIRCLE_FEED_KEY_VIDEO_COUNT, "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isQuerying", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setQuerying", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", h.F, "Lcom/tencent/qqnt/qbasealbum/query/ICursor$b;", "customizeFilter", "Ljava/util/PriorityQueue;", "Lcom/tencent/qqnt/qbasealbum/query/MediaQueryHelper$d;", "Ljava/util/PriorityQueue;", SemanticAttributes.MessagingDestinationKindValues.QUEUE, "k", "l", "fullDataCount", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "curCount", "<init>", "()V", DomainData.DOMAIN_NAME, "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class MediaQueryHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: n */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: from kotlin metadata */
    private List<LocalMediaInfo> mediaList;

    /* renamed from: b, reason: from kotlin metadata */
    private volatile boolean mTraversalDone;

    /* renamed from: c, reason: from kotlin metadata */
    private volatile boolean intercept;

    /* renamed from: d, reason: from kotlin metadata */
    private int eachCount;

    /* renamed from: e, reason: from kotlin metadata */
    private int mediaCount;

    /* renamed from: f, reason: from kotlin metadata */
    private int com.tencent.mobileqq.data.MessageForQCircleFeed.MSG_QCIRCLE_FEED_KEY_VIDEO_COUNT java.lang.String;

    /* renamed from: g, reason: from kotlin metadata */
    @NotNull
    private volatile AtomicBoolean isQuerying;

    /* renamed from: h */
    @Nullable
    private List<? extends ICursor> cursors;

    /* renamed from: i, reason: from kotlin metadata */
    @Nullable
    private ICursor.b customizeFilter;

    /* renamed from: j, reason: from kotlin metadata */
    @Nullable
    private PriorityQueue<d> com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes.MessagingDestinationKindValues.QUEUE java.lang.String;

    /* renamed from: k, reason: from kotlin metadata */
    private int limit;

    /* renamed from: l, reason: from kotlin metadata */
    private int fullDataCount;

    /* renamed from: m */
    private int curCount;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\nJ\u0016\u0010\u0012\u001a\u00020\u00002\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fJ\u0010\u0010\u0015\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u0014\u0010\u0019\u001a\u00020\u00182\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0007R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001cR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001dR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u001dR\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001eR\u0018\u0010 \u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/query/MediaQueryHelper$a;", "", "", "albumId", "e", "", "needImage", "c", "needVideo", "d", "", "limit", "i", "eachCount", h.F, "", "Lcom/tencent/qqnt/qbasealbum/query/ICursor;", "cursors", "f", "Lcom/tencent/qqnt/qbasealbum/query/ICursor$b;", "filter", "g", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/qbasealbum/query/MediaQueryHelper;", "a", "Ljava/lang/String;", "b", "Z", "I", "Ljava/util/List;", "Lcom/tencent/qqnt/qbasealbum/query/ICursor$b;", "customizeFilter", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: from kotlin metadata */
        @Nullable
        private String albumId;

        /* renamed from: b, reason: from kotlin metadata */
        private boolean needImage;

        /* renamed from: c, reason: from kotlin metadata */
        private boolean needVideo;

        /* renamed from: d, reason: from kotlin metadata */
        private int limit;

        /* renamed from: e, reason: from kotlin metadata */
        private int eachCount;

        /* renamed from: f, reason: from kotlin metadata */
        @Nullable
        private List<? extends ICursor> cursors;

        /* renamed from: g, reason: from kotlin metadata */
        @Nullable
        private ICursor.b customizeFilter;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.needImage = true;
            this.needVideo = true;
            this.limit = -1;
            this.eachCount = 100;
        }

        public static /* synthetic */ MediaQueryHelper b(a aVar, Context context, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                context = null;
            }
            return aVar.a(context);
        }

        @JvmOverloads
        @NotNull
        public final MediaQueryHelper a(@Nullable Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (MediaQueryHelper) iPatchRedirector.redirect((short) 9, (Object) this, (Object) context);
            }
            if (this.cursors == null && context != null && i.f361663a.a(context)) {
                this.cursors = new ArrayList();
                String str = this.albumId;
                if (str != null && Intrinsics.areEqual(str, com.tencent.qqnt.qbasealbum.model.a.f361348a.b())) {
                    this.needImage = false;
                }
                if (this.needImage) {
                    List<? extends ICursor> list = this.cursors;
                    Intrinsics.checkNotNull(list, "null cannot be cast to non-null type java.util.ArrayList<com.tencent.qqnt.qbasealbum.query.ICursor>");
                    ((ArrayList) list).add(new com.tencent.qqnt.qbasealbum.album.repository.a(context, this.albumId));
                }
                if (this.needVideo) {
                    List<? extends ICursor> list2 = this.cursors;
                    Intrinsics.checkNotNull(list2, "null cannot be cast to non-null type java.util.ArrayList<com.tencent.qqnt.qbasealbum.query.ICursor>");
                    ((ArrayList) list2).add(new PickerVideoCursor(context, this.albumId));
                }
            }
            if (this.cursors == null) {
                this.cursors = new ArrayList();
            }
            MediaQueryHelper mediaQueryHelper = new MediaQueryHelper(null);
            mediaQueryHelper.j(this.customizeFilter);
            List<? extends ICursor> list3 = this.cursors;
            Intrinsics.checkNotNull(list3);
            mediaQueryHelper.f(list3, this.limit, this.eachCount);
            return mediaQueryHelper;
        }

        @NotNull
        public final a c(boolean needImage) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (a) iPatchRedirector.redirect((short) 3, (Object) this, needImage);
            }
            this.needImage = needImage;
            return this;
        }

        @NotNull
        public final a d(boolean needVideo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (a) iPatchRedirector.redirect((short) 4, (Object) this, needVideo);
            }
            this.needVideo = needVideo;
            return this;
        }

        @NotNull
        public final a e(@Nullable String albumId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) albumId);
            }
            this.albumId = albumId;
            return this;
        }

        @NotNull
        public final a f(@Nullable List<? extends ICursor> cursors) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (a) iPatchRedirector.redirect((short) 7, (Object) this, (Object) cursors);
            }
            this.cursors = cursors;
            return this;
        }

        @NotNull
        public final a g(@Nullable ICursor.b filter) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (a) iPatchRedirector.redirect((short) 8, (Object) this, (Object) filter);
            }
            this.customizeFilter = filter;
            return this;
        }

        @NotNull
        public final a h(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (a) iPatchRedirector.redirect((short) 6, (Object) this, i3);
            }
            this.eachCount = i3;
            return this;
        }

        @NotNull
        public final a i(int limit) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (a) iPatchRedirector.redirect((short) 5, (Object) this, limit);
            }
            this.limit = limit;
            return this;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/query/MediaQueryHelper$b;", "", "", "MIN_EACH_COUNT", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.query.MediaQueryHelper$b */
    /* loaded from: classes25.dex */
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
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/query/MediaQueryHelper$c;", "Ljava/util/Comparator;", "Lcom/tencent/qqnt/qbasealbum/query/MediaQueryHelper$d;", "m1", "m2", "", "a", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c implements Comparator<d> {
        static IPatchRedirector $redirector_;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(@Nullable d m16, @Nullable d m26) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) m16, (Object) m26)).intValue();
            }
            if (m16 == null || m16.a() == null) {
                return 1;
            }
            if (m26 == null || m26.a() == null) {
                return -1;
            }
            LocalMediaInfo a16 = m26.a();
            Intrinsics.checkNotNull(a16);
            long modifiedDate = a16.getModifiedDate();
            LocalMediaInfo a17 = m16.a();
            Intrinsics.checkNotNull(a17);
            if (modifiedDate != a17.getModifiedDate()) {
                LocalMediaInfo a18 = m26.a();
                Intrinsics.checkNotNull(a18);
                long modifiedDate2 = a18.getModifiedDate();
                LocalMediaInfo a19 = m16.a();
                Intrinsics.checkNotNull(a19);
                if (modifiedDate2 - a19.getModifiedDate() > 0) {
                    return 1;
                }
            } else {
                LocalMediaInfo a26 = m26.a();
                Intrinsics.checkNotNull(a26);
                long addedDate = a26.getAddedDate();
                LocalMediaInfo a27 = m16.a();
                Intrinsics.checkNotNull(a27);
                if (addedDate - a27.getAddedDate() > 0) {
                    return 1;
                }
            }
            return -1;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u0086\u0002R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R$\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\t\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u0015\u0010\u0012\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/query/MediaQueryHelper$d;", "", "", "c", "Lcom/tencent/qqnt/qbasealbum/query/ICursor;", "a", "Lcom/tencent/qqnt/qbasealbum/query/ICursor;", "cursor", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "b", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "()Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "setMediaInfo", "(Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;)V", "mediaInfo", "Z", "()Z", "setNeed", "(Z)V", "need", "", "d", "I", "offset", "e", "getNeedSimpleData", "needSimpleData", "<init>", "(Lcom/tencent/qqnt/qbasealbum/query/ICursor;)V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: from kotlin metadata */
        @NotNull
        private final ICursor cursor;

        /* renamed from: b, reason: from kotlin metadata */
        @Nullable
        private LocalMediaInfo mediaInfo;

        /* renamed from: c, reason: from kotlin metadata */
        private boolean need;

        /* renamed from: d, reason: from kotlin metadata */
        private int offset;

        /* renamed from: e, reason: from kotlin metadata */
        private boolean needSimpleData;

        public d(@NotNull ICursor cursor) {
            Intrinsics.checkNotNullParameter(cursor, "cursor");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cursor);
            } else {
                this.cursor = cursor;
                this.offset = -1;
            }
        }

        @Nullable
        public final LocalMediaInfo a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (LocalMediaInfo) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.mediaInfo;
        }

        public final boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            return this.need;
        }

        public final boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
            }
            if (this.offset >= this.cursor.d() - 1) {
                return false;
            }
            ICursor iCursor = this.cursor;
            int i3 = this.offset + 1;
            this.offset = i3;
            boolean l3 = iCursor.l(i3);
            if (l3) {
                LocalMediaInfo k3 = this.cursor.k(this.needSimpleData);
                this.mediaInfo = k3;
                this.need = this.cursor.m(k3);
            }
            return l3;
        }

        public final void d(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, z16);
            } else {
                this.needSimpleData = z16;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44669);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public /* synthetic */ MediaQueryHelper(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) {
            return;
        }
        iPatchRedirector.redirect((short) 17, (Object) this, (Object) defaultConstructorMarker);
    }

    private final boolean b(int queryCnt, int obtainCnt, int traverseCnt) {
        if (!this.mTraversalDone && obtainCnt < queryCnt && (traverseCnt < queryCnt * 2 || obtainCnt < 50)) {
            return true;
        }
        return false;
    }

    public final void f(List<? extends ICursor> cursors, int limit, int eachCount) {
        int coerceAtLeast;
        this.cursors = cursors;
        this.limit = limit;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(eachCount, 100);
        this.eachCount = coerceAtLeast;
        List<LocalMediaInfo> synchronizedList = Collections.synchronizedList(new ArrayList());
        Intrinsics.checkNotNullExpressionValue(synchronizedList, "synchronizedList(ArrayList())");
        this.mediaList = synchronizedList;
        this.com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes.MessagingDestinationKindValues.QUEUE java.lang.String = new PriorityQueue<>(4, new c());
        List<? extends ICursor> list = this.cursors;
        Intrinsics.checkNotNull(list);
        for (ICursor iCursor : list) {
            iCursor.o(this.customizeFilter);
            d dVar = new d(iCursor);
            if (dVar.c()) {
                PriorityQueue<d> priorityQueue = this.com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes.MessagingDestinationKindValues.QUEUE java.lang.String;
                Intrinsics.checkNotNull(priorityQueue);
                priorityQueue.add(dVar);
            }
        }
    }

    public static /* synthetic */ boolean h(MediaQueryHelper mediaQueryHelper, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = mediaQueryHelper.eachCount;
        }
        return mediaQueryHelper.g(i3);
    }

    private final synchronized void i(int queryCnt) {
        List<LocalMediaInfo> list;
        LocalMediaInfo t06;
        try {
        } catch (Exception e16) {
            ox3.a.f("QBaseAlbum.MediaQuery", new Function0<String>(e16) { // from class: com.tencent.qqnt.qbasealbum.query.MediaQueryHelper$realQueryNext$5
                static IPatchRedirector $redirector_;
                final /* synthetic */ Exception $e;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$e = e16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) e16);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return "realQueryNext, " + this.$e;
                }
            });
        }
        if (this.mTraversalDone) {
            ox3.a.c("QBaseAlbum.MediaQuery", MediaQueryHelper$realQueryNext$1.INSTANCE);
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        int i16 = 0;
        while (true) {
            list = null;
            if (!b(queryCnt, i3, i16)) {
                break;
            }
            if (this.limit > 0) {
                List<LocalMediaInfo> list2 = this.mediaList;
                if (list2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaList");
                    list2 = null;
                }
                if (list2.size() >= this.limit) {
                    this.intercept = true;
                    ox3.a.c("QBaseAlbum.MediaQuery", MediaQueryHelper$realQueryNext$2.INSTANCE);
                    break;
                }
            }
            PriorityQueue<d> priorityQueue = this.com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes.MessagingDestinationKindValues.QUEUE java.lang.String;
            Intrinsics.checkNotNull(priorityQueue);
            d poll = priorityQueue.poll();
            i16++;
            if (poll == null) {
                this.mTraversalDone = true;
                ox3.a.c("MediaQueryHelper", MediaQueryHelper$realQueryNext$3.INSTANCE);
                break;
            }
            if (poll.b()) {
                i3++;
                this.curCount++;
                LocalMediaInfo a16 = poll.a();
                if (a16 != null && (t06 = LocalMediaDataHub.INSTANCE.a().t0(a16)) != null) {
                    arrayList.add(t06);
                }
            }
            if (this.curCount >= this.fullDataCount) {
                poll.d(true);
            }
            if (poll.c()) {
                PriorityQueue<d> priorityQueue2 = this.com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes.MessagingDestinationKindValues.QUEUE java.lang.String;
                Intrinsics.checkNotNull(priorityQueue2);
                priorityQueue2.add(poll);
            }
        }
        List<LocalMediaInfo> list3 = this.mediaList;
        if (list3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaList");
        } else {
            list = list3;
        }
        list.addAll(arrayList);
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        List<? extends ICursor> list = this.cursors;
        Intrinsics.checkNotNull(list);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((ICursor) it.next()).b();
        }
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.intercept;
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.mTraversalDone;
    }

    public final boolean g(int nextCount) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, nextCount)).booleanValue();
        }
        if (this.isQuerying.compareAndSet(false, true)) {
            i(nextCount);
            this.isQuerying.set(false);
        }
        return this.mTraversalDone;
    }

    public final void j(@Nullable ICursor.b filter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) filter);
            return;
        }
        this.customizeFilter = filter;
        List<? extends ICursor> list = this.cursors;
        if (list == null) {
            return;
        }
        Intrinsics.checkNotNull(list);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((ICursor) it.next()).o(filter);
        }
    }

    MediaQueryHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.eachCount = 100;
        this.mediaCount = -1;
        this.com.tencent.mobileqq.data.MessageForQCircleFeed.MSG_QCIRCLE_FEED_KEY_VIDEO_COUNT java.lang.String = -1;
        this.isQuerying = new AtomicBoolean(false);
        this.limit = -1;
        this.fullDataCount = InitDataUtil.f361625a.b();
    }
}
