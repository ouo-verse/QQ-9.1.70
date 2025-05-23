package com.tencent.mobileqq.guild.feed.publish.widget;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b5\u00106J\u001f\u0010\u0007\u001a\u00020\u00062\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0002\b\u0004R\"\u0010\u000e\u001a\u00020\b8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0015\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010 \u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\"\u0010#\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u0018\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR\"\u0010*\u001a\u00020$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010-\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\u0018\u001a\u0004\b+\u0010\u001a\"\u0004\b,\u0010\u001cR(\u00104\u001a\b\u0012\u0004\u0012\u00020/0.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u00100\u001a\u0004\b\u0017\u00101\"\u0004\b2\u00103\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/publish/widget/l;", "", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "initFunc", "Lcom/tencent/mobileqq/guild/feed/publish/widget/GuildFeedPublishLinkInsertPop;", "a", "Landroid/content/Context;", "Landroid/content/Context;", "b", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "context", "", "Ljava/lang/String;", "i", "()Ljava/lang/String;", DomainData.DOMAIN_NAME, "(Ljava/lang/String;)V", "sourcePageId", "", "c", "I", "d", "()I", "k", "(I)V", "popTitleResId", "f", "setPrimaryInputHintRes", "primaryInputHintRes", "e", "l", "primaryInputDesRes", "", "Z", tl.h.F, "()Z", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Z)V", "showSecondInput", "g", "setSecondInputHintRes", "secondInputHintRes", "", "Lcom/tencent/mobileqq/guild/feed/video/f;", "Ljava/util/List;", "()Ljava/util/List;", "j", "(Ljava/util/List;)V", "insertTipConfigList", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int primaryInputDesRes;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean showSecondInput;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<? extends com.tencent.mobileqq.guild.feed.video.f> insertTipConfigList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String sourcePageId = "pg_sgrp_forum_short_editor";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int popTitleResId = R.string.f143680mq;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int primaryInputHintRes = R.string.f144280oc;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int secondInputHintRes = R.string.f144290od;

    public l() {
        List<? extends com.tencent.mobileqq.guild.feed.video.f> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.insertTipConfigList = emptyList;
    }

    @NotNull
    public final GuildFeedPublishLinkInsertPop a(@NotNull Function1<? super l, Unit> initFunc) {
        Intrinsics.checkNotNullParameter(initFunc, "initFunc");
        initFunc.invoke(this);
        if (this.context != null) {
            return new GuildFeedPublishLinkInsertPop(b(), this);
        }
        QLog.e("LinkInsertPopBuilder", 1, "build error, need init context");
        throw new IllegalArgumentException("build error, need init context");
    }

    @NotNull
    public final Context b() {
        Context context = this.context;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("context");
        return null;
    }

    @NotNull
    public final List<com.tencent.mobileqq.guild.feed.video.f> c() {
        return this.insertTipConfigList;
    }

    /* renamed from: d, reason: from getter */
    public final int getPopTitleResId() {
        return this.popTitleResId;
    }

    /* renamed from: e, reason: from getter */
    public final int getPrimaryInputDesRes() {
        return this.primaryInputDesRes;
    }

    /* renamed from: f, reason: from getter */
    public final int getPrimaryInputHintRes() {
        return this.primaryInputHintRes;
    }

    /* renamed from: g, reason: from getter */
    public final int getSecondInputHintRes() {
        return this.secondInputHintRes;
    }

    /* renamed from: h, reason: from getter */
    public final boolean getShowSecondInput() {
        return this.showSecondInput;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getSourcePageId() {
        return this.sourcePageId;
    }

    public final void j(@NotNull List<? extends com.tencent.mobileqq.guild.feed.video.f> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.insertTipConfigList = list;
    }

    public final void k(int i3) {
        this.popTitleResId = i3;
    }

    public final void l(int i3) {
        this.primaryInputDesRes = i3;
    }

    public final void m(boolean z16) {
        this.showSecondInput = z16;
    }

    public final void n(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sourcePageId = str;
    }
}
