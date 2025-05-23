package com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.FeedDetailMainData;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextCardContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProThirdBar;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qj1.b;
import qj1.u;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \b2\u00020\u0001:\u0003\u001b\u001a\u001cB\u0013\u0012\n\u0010\"\u001a\u00060\u001dj\u0002`\u001e\u00a2\u0006\u0004\b<\u0010=J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0002J\u001c\u0010\u0007\u001a\u00020\u0003*\u00060\u0005j\u0002`\u00062\n\u0010\u0002\u001a\u00060\u0005j\u0002`\u0006H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0002J(\u0010\r\u001a\u00020\u00032\u000e\u0010\f\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b2\u000e\u0010\u0002\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0002J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0002J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0002J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0002J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0002\u001a\u00020\u0000H\u0002J\u0006\u0010\u0015\u001a\u00020\u0000J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u0001H\u0016R\u001b\u0010\"\u001a\u00060\u001dj\u0002`\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001f\u001a\u0004\b \u0010!R\"\u0010(\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010.\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u00101\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010)\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-R$\u00104\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010)\u001a\u0004\b2\u0010+\"\u0004\b3\u0010-R$\u00107\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010)\u001a\u0004\b5\u0010+\"\u0004\b6\u0010-R\u001b\u0010;\u001a\u00060\u0005j\u0002`\u00068\u0006\u00a2\u0006\f\n\u0004\b\t\u00108\u001a\u0004\b9\u0010:\u00a8\u0006B\u00b2\u0006 \u0010A\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020@0?\u0012\u0004\u0012\u00020@0>8\nX\u008a\u0084\u0002"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData;", "Lhl1/g;", "newItem", "", "f", "Lqj1/b;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/IBottomInteractDisplayable;", "d", tl.h.F, "g", "Lqj1/u;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/pic/data/ITroopContentDisplayable;", "oldItem", "w", "e", "k", "j", "l", "i", "", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "getItemType", "", "getItemId", "b", "a", "c", "Lqj1/h;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/IFeedMainDisplayable;", "Lqj1/h;", "r", "()Lqj1/h;", "feedDetail", "J", "u", "()J", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(J)V", "seq", "Ljava/lang/Integer;", "v", "()Ljava/lang/Integer;", "B", "(Ljava/lang/Integer;)V", "sharedCount", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, HippyTKDListViewAdapter.X, "commentCount", "t", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "preferStatus", ReportConstant.COSTREPORT_PREFIX, "y", "preferCount", "Lqj1/b;", "p", "()Lqj1/b;", "bottomInteractiveDisplayable", "<init>", "(Lqj1/h;)V", "Landroidx/collection/ArrayMap;", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData$c;", "payloadMap", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class FeedDetailMainData implements hl1.g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final qj1.h feedDetail;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long seq;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer sharedCount;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer commentCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer preferStatus;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer preferCount;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final qj1.b bottomInteractiveDisplayable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData$a;", "Lqj1/b;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/IBottomInteractDisplayable;", "", "e", "getCommentCount", "d", "getPreferStatus", "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private final class a implements qj1.b {
        public a() {
        }

        @Override // qj1.b
        public boolean A() {
            return b.a.a(this);
        }

        @Override // qj1.b
        public int d() {
            Integer sharedCount = FeedDetailMainData.this.getSharedCount();
            if (sharedCount != null) {
                return sharedCount.intValue();
            }
            return FeedDetailMainData.this.getFeedDetail().d();
        }

        @Override // qj1.b
        public int e() {
            Integer preferCount = FeedDetailMainData.this.getPreferCount();
            if (preferCount != null) {
                return preferCount.intValue();
            }
            return FeedDetailMainData.this.getFeedDetail().e();
        }

        @Override // qj1.b
        public int getCommentCount() {
            Integer commentCount = FeedDetailMainData.this.getCommentCount();
            if (commentCount != null) {
                return commentCount.intValue();
            }
            return FeedDetailMainData.this.getFeedDetail().getCommentCount();
        }

        @Override // qj1.b
        public int getPreferStatus() {
            Integer preferStatus = FeedDetailMainData.this.getPreferStatus();
            if (preferStatus != null) {
                return preferStatus.intValue();
            }
            return FeedDetailMainData.this.getFeedDetail().getPreferStatus();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \t2\u00020\u0001:\u0004\u0003\t\n\u000bB\u0013\b\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u0082\u0001\u0002\f\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData$c;", "", "", "a", "I", "()I", "type", "<init>", "(I)V", "b", "c", "d", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData$c$a;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData$c$c;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static abstract class c {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int type;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData$c$a;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData$c;", "", "type", "<init>", "(I)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes13.dex */
        public static final class a extends c {
            public a(int i3) {
                super(i3, null);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0014\u0010\r\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0007R\u0014\u0010\u000f\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0007R\u0014\u0010\u0010\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData$c$b;", "", "it", "", "a", "", "ALL", "I", "DEFAULT", "Z", "PAYLOAD_TYPE_BUSINESS_CARD", "PAYLOAD_TYPE_GROUP_CONTENT_INFO", "PAYLOAD_TYPE_MAIN_BOTTOM", "PAYLOAD_TYPE_PREFER", "PAYLOAD_TYPE_SOURCE_CARD_INFO", "PAYLOAD_TYPE_TENCENT_DOC", "PAYLOAD_TYPE_THIRD_BAR", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.FeedDetailMainData$c$b, reason: from kotlin metadata */
        /* loaded from: classes13.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final boolean a(@NotNull Object it) {
                boolean z16;
                boolean z17;
                Intrinsics.checkNotNullParameter(it, "it");
                if (!(it instanceof Map)) {
                    return false;
                }
                Set keySet = ((Map) it).keySet();
                if (!(keySet instanceof Collection) || !keySet.isEmpty()) {
                    for (Object obj : keySet) {
                        if ((obj instanceof Class) && ((Class) obj).isAssignableFrom(C7755c.class)) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            z17 = true;
                            break;
                        }
                    }
                }
                z17 = false;
                if (!z17) {
                    return false;
                }
                return true;
            }

            Companion() {
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData$c$c;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData$c;", "", "type", "<init>", "(I)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.FeedDetailMainData$c$c, reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public static class C7755c extends c {
            public C7755c(int i3) {
                super(i3, null);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData$c$d;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData$c$c;", "", "type", "<init>", "(I)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes13.dex */
        public static final class d extends C7755c {
            public d(int i3) {
                super(i3);
            }
        }

        public /* synthetic */ c(int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3);
        }

        /* renamed from: a, reason: from getter */
        public final int getType() {
            return this.type;
        }

        c(int i3) {
            this.type = i3;
        }
    }

    public FeedDetailMainData(@NotNull qj1.h feedDetail) {
        Intrinsics.checkNotNullParameter(feedDetail, "feedDetail");
        this.feedDetail = feedDetail;
        this.bottomInteractiveDisplayable = new a();
    }

    private final boolean d(qj1.b bVar, qj1.b bVar2) {
        if (bVar.getPreferStatus() == bVar2.getPreferStatus() && bVar.e() == bVar2.e() && bVar.getCommentCount() == bVar2.getCommentCount() && bVar.d() == bVar2.d()) {
            return true;
        }
        return false;
    }

    private final boolean e(FeedDetailMainData newItem) {
        return Intrinsics.areEqual(this.feedDetail.l(), newItem.feedDetail.l());
    }

    private final boolean f(hl1.g newItem) {
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(this.feedDetail.getClass());
        Intrinsics.checkNotNull(newItem, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.FeedDetailMainData");
        FeedDetailMainData feedDetailMainData = (FeedDetailMainData) newItem;
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(feedDetailMainData.feedDetail.getClass())) && TextUtils.equals(this.feedDetail.getFeedId(), feedDetailMainData.feedDetail.getFeedId()) && this.feedDetail.m() == feedDetailMainData.feedDetail.m() && feedDetailMainData.seq == this.seq) {
            return true;
        }
        return false;
    }

    private final boolean g(FeedDetailMainData newItem) {
        Object orNull;
        Object orNull2;
        List<u> troopList = this.feedDetail.getTroopList();
        List<u> troopList2 = newItem.feedDetail.getTroopList();
        if (troopList.size() != troopList2.size()) {
            return false;
        }
        int size = troopList.size();
        for (int i3 = 0; i3 < size; i3++) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(troopList, i3);
            orNull2 = CollectionsKt___CollectionsKt.getOrNull(troopList2, i3);
            if (!w((u) orNull, (u) orNull2)) {
                return false;
            }
        }
        return true;
    }

    private final boolean h(FeedDetailMainData newItem) {
        if (this.feedDetail.getChannelId() == newItem.feedDetail.getChannelId() && this.feedDetail.getGuildId() == newItem.feedDetail.getGuildId() && Intrinsics.areEqual(this.feedDetail.q(), newItem.feedDetail.q()) && Intrinsics.areEqual(this.feedDetail.I(), newItem.feedDetail.I()) && Intrinsics.areEqual(this.feedDetail.J(), newItem.feedDetail.J()) && newItem.seq == this.seq) {
            return true;
        }
        return false;
    }

    private final boolean i(FeedDetailMainData newItem) {
        int preferStatus;
        int preferStatus2;
        Integer num;
        Integer num2 = this.preferCount;
        if (num2 != null && (num = newItem.preferCount) != null) {
            return Intrinsics.areEqual(num2, num);
        }
        if (newItem.getItemType() == 12 && newItem.preferStatus != null) {
            Integer num3 = this.preferStatus;
            if (num3 != null) {
                preferStatus2 = num3.intValue();
            } else {
                preferStatus2 = this.feedDetail.getPreferStatus();
            }
            Integer num4 = newItem.preferStatus;
            if (num4 == null || preferStatus2 != num4.intValue()) {
                return false;
            }
            return true;
        }
        if (!(newItem instanceof com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.a) || newItem.preferStatus != null) {
            return true;
        }
        Integer num5 = this.preferStatus;
        if (num5 != null) {
            preferStatus = num5.intValue();
        } else {
            preferStatus = this.feedDetail.getPreferStatus();
        }
        Integer num6 = newItem.preferStatus;
        if (num6 == null || preferStatus != num6.intValue()) {
            return false;
        }
        return true;
    }

    private final boolean j(FeedDetailMainData newItem) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        GProStRichTextCardContent D = this.feedDetail.D();
        GProStRichTextCardContent D2 = newItem.feedDetail.D();
        String str10 = null;
        if (D != null) {
            str = D.cardId;
        } else {
            str = null;
        }
        if (D2 != null) {
            str2 = D2.cardId;
        } else {
            str2 = null;
        }
        if (Intrinsics.areEqual(str, str2)) {
            if (D != null) {
                str3 = D.title;
            } else {
                str3 = null;
            }
            if (D2 != null) {
                str4 = D2.title;
            } else {
                str4 = null;
            }
            if (Intrinsics.areEqual(str3, str4)) {
                if (D != null) {
                    str5 = D.logoUrl;
                } else {
                    str5 = null;
                }
                if (D2 != null) {
                    str6 = D2.logoUrl;
                } else {
                    str6 = null;
                }
                if (Intrinsics.areEqual(str5, str6)) {
                    if (D != null) {
                        str7 = D.stringAbstract;
                    } else {
                        str7 = null;
                    }
                    if (D2 != null) {
                        str8 = D2.stringAbstract;
                    } else {
                        str8 = null;
                    }
                    if (Intrinsics.areEqual(str7, str8)) {
                        if (D != null) {
                            str9 = D.redirectUrl;
                        } else {
                            str9 = null;
                        }
                        if (D2 != null) {
                            str10 = D2.redirectUrl;
                        }
                        if (Intrinsics.areEqual(str9, str10)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private final boolean k(FeedDetailMainData newItem) {
        if (this.feedDetail.f().size() != newItem.feedDetail.f().size()) {
            return false;
        }
        int size = this.feedDetail.f().size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!Intrinsics.areEqual(this.feedDetail.f().get(i3), newItem.feedDetail.f().get(i3))) {
                return false;
            }
        }
        return true;
    }

    private final boolean l(FeedDetailMainData newItem) {
        GProThirdBar G = this.feedDetail.G();
        GProThirdBar G2 = newItem.feedDetail.G();
        if (G == null && G2 == null) {
            return true;
        }
        if (G == null || G2 == null) {
            return false;
        }
        if (Intrinsics.areEqual(G.f359315id, G2.f359315id) && Intrinsics.areEqual(G.title, G2.title) && Intrinsics.areEqual(G.desc, G2.desc) && Intrinsics.areEqual(G.icon, G2.icon) && Intrinsics.areEqual(G.buttonText, G2.buttonText) && Intrinsics.areEqual(G.contentScheme, G2.contentScheme) && Intrinsics.areEqual(G.buttonScheme, G2.buttonScheme)) {
            return true;
        }
        return false;
    }

    private final Object n(FeedDetailMainData newItem) {
        if (!f(newItem)) {
            return null;
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ArrayMap<Class<? extends c>, c>>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.FeedDetailMainData$computeChangePayloadInternal$payloadMap$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ArrayMap<Class<? extends FeedDetailMainData.c>, FeedDetailMainData.c> invoke() {
                Ref.BooleanRef.this.element = true;
                return new ArrayMap<>();
            }
        });
        if (!d(this.bottomInteractiveDisplayable, newItem.bottomInteractiveDisplayable)) {
            o(lazy).put(c.a.class, new c.a(0));
        }
        if (!h(newItem)) {
            o(lazy).put(c.C7755c.class, new c.C7755c(1));
        }
        if (!e(newItem)) {
            o(lazy).put(c.C7755c.class, new c.C7755c(2));
        }
        if (!k(newItem)) {
            o(lazy).put(c.C7755c.class, new c.C7755c(3));
        }
        if (!j(newItem)) {
            o(lazy).put(c.C7755c.class, new c.C7755c(5));
        }
        if (!g(newItem)) {
            o(lazy).put(c.C7755c.class, new c.C7755c(4));
        }
        if (!l(newItem)) {
            o(lazy).put(c.d.class, new c.d(6));
        }
        if (!i(newItem)) {
            o(lazy).put(c.C7755c.class, new c.C7755c(7));
        }
        if (!booleanRef.element) {
            return null;
        }
        return o(lazy);
    }

    private static final ArrayMap<Class<? extends c>, c> o(Lazy<? extends ArrayMap<Class<? extends c>, c>> lazy) {
        return lazy.getValue();
    }

    private final boolean w(u oldItem, u newItem) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6 = null;
        if (oldItem != null) {
            str = oldItem.getGroupAvatar();
        } else {
            str = null;
        }
        if (newItem != null) {
            str2 = newItem.getGroupAvatar();
        } else {
            str2 = null;
        }
        if (Intrinsics.areEqual(str, str2)) {
            if (oldItem != null) {
                str3 = oldItem.getGroupName();
            } else {
                str3 = null;
            }
            if (newItem != null) {
                str4 = newItem.getGroupName();
            } else {
                str4 = null;
            }
            if (Intrinsics.areEqual(str3, str4)) {
                if (oldItem != null) {
                    str5 = oldItem.getGroupJoinAuth();
                } else {
                    str5 = null;
                }
                if (newItem != null) {
                    str6 = newItem.getGroupJoinAuth();
                }
                if (Intrinsics.areEqual(str5, str6)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void A(long j3) {
        this.seq = j3;
    }

    public final void B(@Nullable Integer num) {
        this.sharedCount = num;
    }

    @Override // hl1.g
    public boolean a(@NotNull hl1.g newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (f(newItem)) {
            FeedDetailMainData feedDetailMainData = (FeedDetailMainData) newItem;
            if (d(this.bottomInteractiveDisplayable, feedDetailMainData.bottomInteractiveDisplayable) && h(feedDetailMainData) && i(feedDetailMainData) && g(feedDetailMainData) && e(feedDetailMainData) && k(feedDetailMainData) && l(feedDetailMainData)) {
                return true;
            }
        }
        return false;
    }

    @Override // hl1.g
    public boolean b(@NotNull hl1.g newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return newItem instanceof FeedDetailMainData;
    }

    @Override // hl1.g
    @NotNull
    public Object c(@NotNull hl1.g newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (!(newItem instanceof FeedDetailMainData)) {
            return Boolean.TRUE;
        }
        Object n3 = n((FeedDetailMainData) newItem);
        if (n3 == null) {
            return Boolean.TRUE;
        }
        return n3;
    }

    @Override // hl1.g
    public long getItemId() {
        return -1272167825;
    }

    @Override // hl1.g
    public int getItemType() {
        if (com.tencent.mobileqq.guild.discoveryv2.util.a.f217788a.a(this.feedDetail.getFeedType())) {
            return 12;
        }
        return 1;
    }

    @NotNull
    public final FeedDetailMainData m() {
        FeedDetailMainData feedDetailMainData = new FeedDetailMainData(this.feedDetail);
        feedDetailMainData.sharedCount = this.sharedCount;
        feedDetailMainData.commentCount = this.commentCount;
        feedDetailMainData.preferCount = this.preferCount;
        feedDetailMainData.preferStatus = this.preferStatus;
        return feedDetailMainData;
    }

    @NotNull
    /* renamed from: p, reason: from getter */
    public final qj1.b getBottomInteractiveDisplayable() {
        return this.bottomInteractiveDisplayable;
    }

    @Nullable
    /* renamed from: q, reason: from getter */
    public final Integer getCommentCount() {
        return this.commentCount;
    }

    @NotNull
    /* renamed from: r, reason: from getter */
    public final qj1.h getFeedDetail() {
        return this.feedDetail;
    }

    @Nullable
    /* renamed from: s, reason: from getter */
    public final Integer getPreferCount() {
        return this.preferCount;
    }

    @Nullable
    /* renamed from: t, reason: from getter */
    public final Integer getPreferStatus() {
        return this.preferStatus;
    }

    /* renamed from: u, reason: from getter */
    public final long getSeq() {
        return this.seq;
    }

    @Nullable
    /* renamed from: v, reason: from getter */
    public final Integer getSharedCount() {
        return this.sharedCount;
    }

    public final void x(@Nullable Integer num) {
        this.commentCount = num;
    }

    public final void y(@Nullable Integer num) {
        this.preferCount = num;
    }

    public final void z(@Nullable Integer num) {
        this.preferStatus = num;
    }
}
