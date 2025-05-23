package com.tencent.mobileqq.flock.feedcommon.ioc;

import android.content.Context;
import android.net.Uri;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.flock.ktx.e;
import com.tencent.mobileqq.flock.repeat.FlockRepeatType;
import com.tencent.mobileqq.flock.utils.DateTimeUtils;
import com.tencent.mobileqq.flock.utils.FlockJumpHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.topicaggregation.bean.FlockTopicAggregationInitBean;
import com.tencent.mobileqq.topicaggregation.bean.TopicAggregationSource;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import y45.l;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0016\u0018\u0000 +2\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b)\u0010*J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\u001c\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u00142\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\bH\u0016R\u001a\u0010\u001c\u001a\u00020\u00178\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001f\u001a\u00020\u00178\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001bR\u001a\u0010\"\u001a\u00020\u00178\u0016X\u0096D\u00a2\u0006\f\n\u0004\b \u0010\u0019\u001a\u0004\b!\u0010\u001bR\u001a\u0010%\u001a\u00020\u00178\u0016X\u0096D\u00a2\u0006\f\n\u0004\b#\u0010\u0019\u001a\u0004\b$\u0010\u001bR\u001a\u0010(\u001a\u00020\u00178\u0016X\u0096D\u00a2\u0006\f\n\u0004\b&\u0010\u0019\u001a\u0004\b'\u0010\u001b\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/flock/feedcommon/ioc/a;", "Lcom/tencent/mobileqq/flock/feedcommon/ioc/b;", "Ly45/l;", "poiInfo", "", "a", "Landroid/content/Context;", "context", "Ly45/b;", "feed", "", ICustomDataEditor.NUMBER_PARAM_2, "S4", "Z8", "", "tagId", "j3", "Lcom/tencent/mobileqq/topicaggregation/bean/TopicAggregationSource;", "b", "y8", "Lkotlin/Pair;", "Z5", "C8", "", "d", "Z", "c6", "()Z", "isPoiClickable", "e", "t3", "isPublisherClickable", "f", ICustomDataEditor.STRING_ARRAY_PARAM_8, "isParticipantClickable", h.F, "T1", "isTopicClickable", "i", ICustomDataEditor.STRING_PARAM_1, "isTopicVisible", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public class a implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean isPoiClickable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean isPublisherClickable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean isParticipantClickable;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final boolean isTopicClickable;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final boolean isTopicVisible;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/flock/feedcommon/ioc/a$a;", "", "", "MAP_SCHEMA", "Ljava/lang/String;", "MAP_URL", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.feedcommon.ioc.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes12.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24877);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.isTopicClickable = true;
            this.isTopicVisible = true;
        }
    }

    private final String a(l poiInfo) {
        if (poiInfo == null) {
            return null;
        }
        float f16 = 1000000;
        return "mqqapi://map/openmap?miniMapUrl=" + Uri.parse("https://mapdownload.map.qq.com/qqark?modules/poi/pages/index/index?").buildUpon().appendQueryParameter("strName", poiInfo.f449420b).appendQueryParameter("address", poiInfo.f449423e).appendQueryParameter("latitude", String.valueOf(((float) poiInfo.f449425g.f449393a) / f16)).appendQueryParameter("longitude", String.valueOf(((float) poiInfo.f449425g.f449394b) / f16)).build();
    }

    @Override // com.tencent.mobileqq.flock.feedcommon.ioc.b
    @Nullable
    public String C8(@NotNull y45.b feed) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this, (Object) feed);
        }
        Intrinsics.checkNotNullParameter(feed, "feed");
        String d16 = e.d(feed.f449374i);
        y45.a aVar = feed.f449374i;
        if (aVar != null) {
            String f16 = DateTimeUtils.f210478a.f(FlockRepeatType.INSTANCE.b(aVar.f449363c), aVar.f449361a, 0L, true);
            if (f16.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return ((Object) d16) + "\uff0c" + f16;
            }
            return d16;
        }
        return d16;
    }

    @Override // com.tencent.mobileqq.flock.feedcommon.ioc.b
    public void S4(@NotNull Context context, @NotNull y45.b feed) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) context, (Object) feed);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(feed, "feed");
        FlockJumpHelper.Companion companion = FlockJumpHelper.INSTANCE;
        String str = feed.f449369d.f449449a;
        Intrinsics.checkNotNullExpressionValue(str, "feed.publisher.id");
        companion.f(context, str);
    }

    @Override // com.tencent.mobileqq.flock.feedcommon.ioc.b
    public boolean T1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.isTopicClickable;
    }

    @Override // com.tencent.mobileqq.flock.feedcommon.ioc.b
    @NotNull
    public Pair<Integer, Integer> Z5(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Pair) iPatchRedirector.redirect((short) 13, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        int color = context.getResources().getColor(R.color.qui_common_icon_secondary);
        return new Pair<>(Integer.valueOf(color), Integer.valueOf(color));
    }

    @Override // com.tencent.mobileqq.flock.feedcommon.ioc.b
    public void Z8(@NotNull Context context, @NotNull y45.b feed) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) context, (Object) feed);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(feed, "feed");
        com.tencent.mobileqq.flock.a.f209993a.b(context, feed);
    }

    @Override // com.tencent.mobileqq.flock.feedcommon.ioc.b
    public boolean a8() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.isParticipantClickable;
    }

    @NotNull
    public TopicAggregationSource b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (TopicAggregationSource) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return TopicAggregationSource.FEED_LIST;
    }

    @Override // com.tencent.mobileqq.flock.feedcommon.ioc.b
    public boolean c6() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.isPoiClickable;
    }

    @Override // com.tencent.mobileqq.flock.feedcommon.ioc.b
    public void j3(@NotNull Context context, int tagId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) context, tagId);
        } else {
            Intrinsics.checkNotNullParameter(context, "context");
            com.tencent.mobileqq.flock.a.f209993a.j(context, new FlockTopicAggregationInitBean(tagId, b()));
        }
    }

    @Override // com.tencent.mobileqq.flock.feedcommon.ioc.b
    public void n2(@NotNull Context context, @NotNull y45.b feed) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) context, (Object) feed);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(feed, "feed");
        String a16 = a(feed.f449376k);
        if (a16 != null) {
            com.tencent.mobileqq.flock.scheme.b.INSTANCE.b(context, a16);
        }
    }

    @Override // com.tencent.mobileqq.flock.feedcommon.ioc.b
    public boolean s1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.isTopicVisible;
    }

    @Override // com.tencent.mobileqq.flock.feedcommon.ioc.b
    public boolean t3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.isPublisherClickable;
    }

    @Override // com.tencent.mobileqq.flock.feedcommon.ioc.b
    @NotNull
    public String y8() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return "%s\u4eba\u53c2\u4e0e";
    }
}
