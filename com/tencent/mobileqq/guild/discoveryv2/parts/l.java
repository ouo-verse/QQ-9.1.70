package com.tencent.mobileqq.guild.discoveryv2.parts;

import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statustitle.api.IBaseStatusTitleBarApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/parts/l;", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0003\u001a\u00020\u0002H\u0086\u0002\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/parts/l$a;", "", "Lcom/tencent/biz/richframework/part/Part;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.discoveryv2.parts.l$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Part a() {
            return ((IBaseStatusTitleBarApi) QRoute.api(IBaseStatusTitleBarApi.class)).createBaseStatusTitlePart(new ji1.a());
        }

        Companion() {
        }
    }
}
