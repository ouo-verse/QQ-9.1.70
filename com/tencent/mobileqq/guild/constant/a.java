package com.tencent.mobileqq.guild.constant;

import com.tencent.mobileqq.qqguildsdk.data.type.IChannelType;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/constant/a;", "", "", "appId", "", "a", "", "b", "[I", "chatPieApplicationIds", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f216293a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static final int[] chatPieApplicationIds = {1000001, IChannelType.APP_SUB_CHANNEL_TYPE_GAMECENTER_QA};

    a() {
    }

    @JvmStatic
    public static final boolean a(int appId) {
        boolean contains;
        contains = ArraysKt___ArraysKt.contains(chatPieApplicationIds, appId);
        return contains;
    }
}
