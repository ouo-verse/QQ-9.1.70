package com.tencent.mobileqq.flock.feeddetail.ioc;

import android.content.Context;
import android.graphics.Color;
import com.tencent.mobileqq.flock.ktx.e;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.topicaggregation.bean.TopicAggregationSource;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u001a\u0010\u0013\u001a\u00020\u000e8\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u000e8\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u000e8\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/flock/feeddetail/ioc/a;", "Lcom/tencent/mobileqq/flock/feedcommon/ioc/a;", "", "y8", "Landroid/content/Context;", "context", "Lkotlin/Pair;", "", "Z5", "Ly45/b;", "feed", "C8", "Lcom/tencent/mobileqq/topicaggregation/bean/TopicAggregationSource;", "b", "", BdhLogUtil.LogTag.Tag_Conn, "Z", "c6", "()Z", "isPoiClickable", "D", "t3", "isPublisherClickable", "E", ICustomDataEditor.STRING_ARRAY_PARAM_8, "isParticipantClickable", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a extends com.tencent.mobileqq.flock.feedcommon.ioc.a {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    private final boolean isPoiClickable;

    /* renamed from: D, reason: from kotlin metadata */
    private final boolean isPublisherClickable;

    /* renamed from: E, reason: from kotlin metadata */
    private final boolean isParticipantClickable;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.isPoiClickable = true;
        this.isPublisherClickable = true;
        this.isParticipantClickable = true;
    }

    @Override // com.tencent.mobileqq.flock.feedcommon.ioc.a, com.tencent.mobileqq.flock.feedcommon.ioc.b
    @Nullable
    public String C8(@NotNull y45.b feed) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) feed);
        }
        Intrinsics.checkNotNullParameter(feed, "feed");
        return e.c(feed.f449374i);
    }

    @Override // com.tencent.mobileqq.flock.feedcommon.ioc.a, com.tencent.mobileqq.flock.feedcommon.ioc.b
    @NotNull
    public Pair<Integer, Integer> Z5(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Pair) iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return new Pair<>(Integer.valueOf(Color.parseColor("#FF000000")), Integer.valueOf(Color.parseColor("#FFFFFFFF")));
    }

    @Override // com.tencent.mobileqq.flock.feedcommon.ioc.a, com.tencent.mobileqq.flock.feedcommon.ioc.b
    public boolean a8() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.isParticipantClickable;
    }

    @Override // com.tencent.mobileqq.flock.feedcommon.ioc.a
    @NotNull
    public TopicAggregationSource b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (TopicAggregationSource) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return TopicAggregationSource.FEED_DETAIL;
    }

    @Override // com.tencent.mobileqq.flock.feedcommon.ioc.a, com.tencent.mobileqq.flock.feedcommon.ioc.b
    public boolean c6() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.isPoiClickable;
    }

    @Override // com.tencent.mobileqq.flock.feedcommon.ioc.a, com.tencent.mobileqq.flock.feedcommon.ioc.b
    public boolean t3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.isPublisherClickable;
    }

    @Override // com.tencent.mobileqq.flock.feedcommon.ioc.a, com.tencent.mobileqq.flock.feedcommon.ioc.b
    @NotNull
    public String y8() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "\u5171%s\u4eba\u60f3\u53c2\u4e0e";
    }
}
