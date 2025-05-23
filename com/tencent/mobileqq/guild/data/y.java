package com.tencent.mobileqq.guild.data;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u000e2\u00020\u0001:\u0002\u0003\bB\u0019\b\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\u000b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\u0082\u0001\u0001\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/data/y;", "", "", "a", "I", "()I", WidgetCacheConstellationData.NUM, "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "text", "<init>", "(ILjava/lang/String;)V", "c", "Lcom/tencent/mobileqq/guild/data/y$b;", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class y {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int num;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String text;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/data/y$b;", "Lcom/tencent/mobileqq/guild/data/y;", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends y {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final b f216487d = new b();

        b() {
            super(990000, "99\u4e07+", null);
        }
    }

    public /* synthetic */ y(int i3, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str);
    }

    /* renamed from: a, reason: from getter */
    public final int getNum() {
        return this.num;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getText() {
        return this.text;
    }

    y(int i3, String str) {
        this.num = i3;
        this.text = str;
    }
}
