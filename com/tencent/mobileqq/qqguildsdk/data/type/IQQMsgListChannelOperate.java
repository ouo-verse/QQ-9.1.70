package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/data/type/IQQMsgListChannelOperate;", "", "Companion", "a", "qqguild-sdk-api_release"}, k = 1, mv = {1, 7, 1})
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: classes17.dex */
public @interface IQQMsgListChannelOperate {
    public static final int ADD_CHANNEL = 1;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f266743a;
    public static final int DELETE_CHANNEL = 2;
    public static final int REFRESH_CHANNEL = 4;
    public static final int SET_TOP_CHANNEL = 3;
    public static final int UNSET_TOP_CHANNEL = -1;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/data/type/IQQMsgListChannelOperate$a;", "", "<init>", "()V", "qqguild-sdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqguildsdk.data.type.IQQMsgListChannelOperate$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f266743a = new Companion();

        Companion() {
        }
    }
}
