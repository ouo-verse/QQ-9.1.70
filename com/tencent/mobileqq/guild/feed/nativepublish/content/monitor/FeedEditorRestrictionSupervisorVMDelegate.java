package com.tencent.mobileqq.guild.feed.nativepublish.content.monitor;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.input.base.mvicompat.f;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedPreloadConfigAPi;
import com.tencent.mobileqq.guild.feed.nativepublish.content.monitor.FeedEditorRestrictionSupervisorMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.edittext.GuildFeedEditTextMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.FeedEditorMediaMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.publish.msgintent.PublishFeedMsgIntent;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.base.route.k;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import yl1.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\b\b*\u0001&\b\u0007\u0018\u00002\u00020\u0001:\u0002\u001e,B#\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0016\u0012\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\"\u0010\u0010\u001a\u00020\u00042\u0010\u0010\u000e\u001a\f\u0012\u0004\u0012\u00020\f0\u000bj\u0002`\r2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R \u0010 \u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010%\u001a\u00020!8\u0014X\u0094D\u00a2\u0006\f\n\u0004\b\n\u0010\"\u001a\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/content/monitor/FeedEditorRestrictionSupervisorVMDelegate;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/vmdelegate/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMsgIntent$OnTextChanged;", "msg", "", "k", "", "needRemindUser", "l", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/base/api/runtime/a;", "Lzl1/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/FeedEditorContext;", "context", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "e", "Lcom/tencent/mvi/base/route/MsgIntent;", "event", "Lcom/tencent/mvi/base/route/k;", "I", "E", "", h.F, "Ljava/lang/Integer;", "maxContentLengthInitialValue", "", "Lcom/tencent/mobileqq/guild/feed/nativepublish/content/monitor/FeedEditorRestrictionSupervisorVMDelegate$a;", "i", "Ljava/util/List;", "a", "()Ljava/util/List;", Node.CHILDREN_ATTR, "", "Ljava/lang/String;", "getLogTag", "()Ljava/lang/String;", "logTag", "com/tencent/mobileqq/guild/feed/nativepublish/content/monitor/FeedEditorRestrictionSupervisorVMDelegate$c", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/feed/nativepublish/content/monitor/FeedEditorRestrictionSupervisorVMDelegate$c;", "attachInfo", "<init>", "(Ljava/lang/Integer;Ljava/util/List;)V", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedEditorRestrictionSupervisorVMDelegate extends com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.a {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final c attachInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Integer maxContentLengthInitialValue;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<a> children;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String logTag;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b&\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u00040\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&R*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00078&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/content/monitor/FeedEditorRestrictionSupervisorVMDelegate$a;", "Lcom/tencent/input/base/mvicompat/f;", "Lcom/tencent/base/api/runtime/a;", "Lzl1/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/FeedEditorContext;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/content/monitor/FeedEditorRestrictionSupervisorVMDelegate$b;", "attachInfo", "", "needRemindUser", "a", "Lkotlin/Function0;", "", "d", "Lkotlin/jvm/functions/Function0;", "getCheckTrigger", "()Lkotlin/jvm/functions/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "checkTrigger", "c", "()Z", "hasSomethingToSave", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static abstract class a implements f<com.tencent.base.api.runtime.a<zl1.a>> {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Function0<Unit> checkTrigger;

        public abstract boolean a(@NotNull b attachInfo, boolean needRemindUser);

        public abstract boolean c();

        public final void d(@Nullable Function0<Unit> function0) {
            this.checkTrigger = function0;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u00028\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001a\u0010\t\u001a\u00020\u00028\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0005R\"\u0010\u000f\u001a\u00020\n8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u000b\u001a\u0004\b\u0007\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/content/monitor/FeedEditorRestrictionSupervisorVMDelegate$b;", "Lcom/tencent/mvi/base/route/k;", "", "a", "I", "()I", "contentLength", "b", "c", "mediaCount", "", "Z", "()Z", "setHasSomethingToSave", "(Z)V", "hasSomethingToSave", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static class b implements k {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int contentLength;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int mediaCount;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private boolean hasSomethingToSave;

        /* renamed from: a, reason: from getter */
        public int getContentLength() {
            return this.contentLength;
        }

        /* renamed from: b, reason: from getter */
        public boolean getHasSomethingToSave() {
            return this.hasSomethingToSave;
        }

        /* renamed from: c, reason: from getter */
        public int getMediaCount() {
            return this.mediaCount;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004R+\u0010\u0010\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00048V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR+\u0010\u0012\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00048V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\b\u0010\u000b\u001a\u0004\b\n\u0010\r\"\u0004\b\u0011\u0010\u000fR+\u0010\u0015\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00048V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000fR\"\u0010\u001c\u001a\u00020\u00168\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u0017\u0010\u001b\u00a8\u0006\u001d"}, d2 = {"com/tencent/mobileqq/guild/feed/nativepublish/content/monitor/FeedEditorRestrictionSupervisorVMDelegate$c", "Lcom/tencent/mobileqq/guild/feed/nativepublish/content/monitor/FeedEditorRestrictionSupervisorVMDelegate$b;", "Lkotlin/reflect/KProperty;", "property", "", QCircleDaTongConstant.ElementParamValue.XSJ_SHARE_PANEL_STYLE_OLD, QCircleDaTongConstant.ElementParamValue.NEW, "", "e", "<set-?>", "d", "Lkotlin/properties/ReadWriteProperty;", "a", "()I", "f", "(I)V", "contentLength", h.F, "maxLength", "c", "i", "mediaCount", "", "g", "Z", "b", "()Z", "(Z)V", "hasSomethingToSave", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c extends b {

        /* renamed from: i, reason: collision with root package name */
        static final /* synthetic */ KProperty<Object>[] f221813i = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(c.class, "contentLength", "getContentLength()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(c.class, "maxLength", "getMaxLength()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(c.class, "mediaCount", "getMediaCount()I", 0))};

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ReadWriteProperty contentLength;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ReadWriteProperty maxLength;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ReadWriteProperty mediaCount;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private boolean hasSomethingToSave;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J+\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H\u0014\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "Lkotlin/reflect/KProperty;", "property", "oldValue", "newValue", "", "afterChange", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes13.dex */
        public static final class a extends ObservableProperty<Integer> {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ c f221819b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Object obj, c cVar) {
                super(obj);
                this.f221819b = cVar;
            }

            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(@NotNull KProperty<?> property, Integer oldValue, Integer newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                int intValue = newValue.intValue();
                this.f221819b.e(property, oldValue.intValue(), intValue);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J+\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H\u0014\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "Lkotlin/reflect/KProperty;", "property", "oldValue", "newValue", "", "afterChange", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes13.dex */
        public static final class b extends ObservableProperty<Integer> {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ c f221820b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(Object obj, c cVar) {
                super(obj);
                this.f221820b = cVar;
            }

            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(@NotNull KProperty<?> property, Integer oldValue, Integer newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                int intValue = newValue.intValue();
                this.f221820b.e(property, oldValue.intValue(), intValue);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J+\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H\u0014\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "Lkotlin/reflect/KProperty;", "property", "oldValue", "newValue", "", "afterChange", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.feed.nativepublish.content.monitor.FeedEditorRestrictionSupervisorVMDelegate$c$c, reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public static final class C7763c extends ObservableProperty<Integer> {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ c f221821b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C7763c(Object obj, c cVar) {
                super(obj);
                this.f221821b = cVar;
            }

            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(@NotNull KProperty<?> property, Integer oldValue, Integer newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                int intValue = newValue.intValue();
                this.f221821b.e(property, oldValue.intValue(), intValue);
            }
        }

        c() {
            Delegates delegates = Delegates.INSTANCE;
            this.contentLength = new a(0, this);
            Integer num = FeedEditorRestrictionSupervisorVMDelegate.this.maxContentLengthInitialValue;
            this.maxLength = new b(Integer.valueOf(num != null ? num.intValue() : 0), this);
            this.mediaCount = new C7763c(0, this);
        }

        @Override // com.tencent.mobileqq.guild.feed.nativepublish.content.monitor.FeedEditorRestrictionSupervisorVMDelegate.b
        /* renamed from: a */
        public int getContentLength() {
            return ((Number) this.contentLength.getValue(this, f221813i[0])).intValue();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativepublish.content.monitor.FeedEditorRestrictionSupervisorVMDelegate.b
        /* renamed from: b, reason: from getter */
        public boolean getHasSomethingToSave() {
            return this.hasSomethingToSave;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativepublish.content.monitor.FeedEditorRestrictionSupervisorVMDelegate.b
        /* renamed from: c */
        public int getMediaCount() {
            return ((Number) this.mediaCount.getValue(this, f221813i[2])).intValue();
        }

        public int d() {
            return ((Number) this.maxLength.getValue(this, f221813i[1])).intValue();
        }

        public final void e(@NotNull KProperty<?> property, int old, int r36) {
            Intrinsics.checkNotNullParameter(property, "property");
            FeedEditorRestrictionSupervisorVMDelegate.this.j();
        }

        public void f(int i3) {
            this.contentLength.setValue(this, f221813i[0], Integer.valueOf(i3));
        }

        public void g(boolean z16) {
            this.hasSomethingToSave = z16;
        }

        public void h(int i3) {
            this.maxLength.setValue(this, f221813i[1], Integer.valueOf(i3));
        }

        public void i(int i3) {
            this.mediaCount.setValue(this, f221813i[2], Integer.valueOf(i3));
        }
    }

    public /* synthetic */ FeedEditorRestrictionSupervisorVMDelegate(Integer num, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        j e16;
        m();
        boolean l3 = l(false);
        com.tencent.base.api.runtime.a<zl1.a> d16 = d();
        if (d16 != null && (e16 = d16.e()) != null) {
            e16.h(new FeedEditorRestrictionSupervisorMsgIntent.ContentStatisticChangeMsgIntent(this.attachInfo, l3));
        }
    }

    private final void k(GuildFeedEditTextMsgIntent.OnTextChanged msg2) {
        this.attachInfo.f(msg2.getLength());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean l(boolean needRemindUser) {
        if (this.attachInfo.getContentLength() > this.attachInfo.d()) {
            if (needRemindUser) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String qqStr = HardCodeUtil.qqStr(R.string.f144940q5);
                Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.guild_feed_publish_length_exceed)");
                String format = String.format(qqStr, Arrays.copyOf(new Object[]{Integer.valueOf(this.attachInfo.d())}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                n.A(0, format);
            }
            return false;
        }
        if (this.attachInfo.getContentLength() <= 0 && this.attachInfo.getMediaCount() <= 0) {
            if (needRemindUser) {
                n.z(0, R.string.f144890q0);
            }
            return false;
        }
        List<a> a16 = a();
        if ((a16 instanceof Collection) && a16.isEmpty()) {
            return true;
        }
        Iterator<T> it = a16.iterator();
        while (it.hasNext()) {
            if (!((a) it.next()).a(this.attachInfo, needRemindUser)) {
                return false;
            }
        }
        return true;
    }

    private final void m() {
        boolean z16;
        c cVar = this.attachInfo;
        boolean z17 = true;
        if (cVar.getContentLength() <= 0 && cVar.getMediaCount() <= 0) {
            List<a> a16 = a();
            if (!(a16 instanceof Collection) || !a16.isEmpty()) {
                Iterator<T> it = a16.iterator();
                while (it.hasNext()) {
                    if (((a) it.next()).c()) {
                        z16 = true;
                        break;
                    }
                }
            }
            z16 = false;
            if (!z16) {
                z17 = false;
            }
        }
        cVar.g(z17);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.a, com.tencent.mobileqq.guild.feed.util.bf
    public void E(@NotNull MsgIntent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof GuildFeedEditTextMsgIntent.OnTextChanged) {
            k((GuildFeedEditTextMsgIntent.OnTextChanged) event);
        } else if (event instanceof FeedEditorMediaMsgIntent.OnMediaChanged) {
            this.attachInfo.i(((FeedEditorMediaMsgIntent.OnMediaChanged) event).getMediaCount());
        } else if (event instanceof PublishFeedMsgIntent.FindPublishInterceptor) {
            ((PublishFeedMsgIntent.FindPublishInterceptor) event).a(1, new FeedEditorRestrictionSupervisorVMDelegate$handleAction$1(this, null));
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.a, com.tencent.mobileqq.guild.feed.util.bf
    @NotNull
    public k I(@NotNull MsgIntent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event, FeedEditorRestrictionSupervisorMsgIntent.FetchContentStatisticMsgIntent.f221805d)) {
            return this.attachInfo;
        }
        return new com.tencent.input.base.utils.a();
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.a
    @NotNull
    protected List<a> a() {
        return this.children;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.a, com.tencent.input.base.mvicompat.f
    /* renamed from: e */
    public void b(@NotNull com.tencent.base.api.runtime.a<zl1.a> context, boolean reuse) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.b(context, reuse);
        if (this.maxContentLengthInitialValue == null) {
            this.attachInfo.h(((IGuildFeedPreloadConfigAPi) QRoute.api(IGuildFeedPreloadConfigAPi.class)).getFeedPublishMaxLimit());
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.a, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.guild.feed.nativepublish.edittext.GuildFeedEditTextMsgIntent.OnTextChanged");
        hashSet.add("com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.FeedEditorMediaMsgIntent.OnMediaChanged");
        hashSet.add("com.tencent.mobileqq.guild.feed.nativepublish.publish.msgintent.PublishFeedMsgIntent.FindPublishInterceptor");
        return hashSet;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.a, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.guild.feed.nativepublish.content.monitor.FeedEditorRestrictionSupervisorMsgIntent.FetchContentStatisticMsgIntent");
        return hashSet;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FeedEditorRestrictionSupervisorVMDelegate(@Nullable Integer num, @NotNull List<? extends a> children) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(children, "children");
        this.maxContentLengthInitialValue = num;
        this.children = children;
        this.logTag = "FeedEditor.ContentMonitor";
        this.attachInfo = new c();
        Iterator<T> it = a().iterator();
        while (it.hasNext()) {
            ((a) it.next()).d(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.content.monitor.FeedEditorRestrictionSupervisorVMDelegate$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    FeedEditorRestrictionSupervisorVMDelegate.this.j();
                }
            });
        }
    }
}
