package com.tencent.mobileqq.guild.media.thirdapp.container.plugin;

import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.GetAuthCodeMethod;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.JumpToUserAuthMethod;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.ShareAppMessageMethod;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.h;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.i;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.j;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.k;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.l;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.m;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.n;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.o;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.p;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.q;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.r;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.s;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.t;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.u;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.v;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.w;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.x;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.y;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.z;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005J\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005R!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\n\u001a\u0004\b\r\u0010\u000bR0\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000fR0\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/GuildOpenJsMethodProvider;", "", "Ljava/util/HashMap;", "", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/b;", "Lkotlin/collections/HashMap;", "b", "d", "", "a", "Lkotlin/Lazy;", "()Ljava/util/List;", "fragmentMethodList", "c", "globalMethodList", "Ljava/util/HashMap;", "fragmentMethodMap", "globalMethodMap", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildOpenJsMethodProvider {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy fragmentMethodList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy globalMethodList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, b> fragmentMethodMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, b> globalMethodMap;

    public GuildOpenJsMethodProvider() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<List<? extends o>>() { // from class: com.tencent.mobileqq.guild.media.thirdapp.container.plugin.GuildOpenJsMethodProvider$fragmentMethodList$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends o> invoke() {
                List<? extends o> listOf;
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new o[]{new h(), new u(), new n(), new JumpToUserAuthMethod(), new q(), new i(), new p(), new x(), new ShareAppMessageMethod(), new j()});
                return listOf;
            }
        });
        this.fragmentMethodList = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<List<? extends o>>() { // from class: com.tencent.mobileqq.guild.media.thirdapp.container.plugin.GuildOpenJsMethodProvider$globalMethodList$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends o> invoke() {
                List<? extends o> listOf;
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new o[]{new GetAuthCodeMethod(), new n(), new m(), new y(), new z(), new s(), new t(), new v(), new w(), new l(), new k(), new r()});
                return listOf;
            }
        });
        this.globalMethodList = lazy2;
        this.fragmentMethodMap = new HashMap<>();
        this.globalMethodMap = new HashMap<>();
    }

    private final List<b> a() {
        return (List) this.fragmentMethodList.getValue();
    }

    private final List<b> c() {
        return (List) this.globalMethodList.getValue();
    }

    @NotNull
    public final HashMap<String, b> b() {
        if (this.fragmentMethodMap.isEmpty()) {
            for (b bVar : a()) {
                this.fragmentMethodMap.put(bVar.b(), bVar);
            }
        }
        return this.fragmentMethodMap;
    }

    @NotNull
    public final HashMap<String, b> d() {
        if (this.globalMethodMap.isEmpty()) {
            for (b bVar : c()) {
                this.globalMethodMap.put(bVar.b(), bVar);
            }
        }
        return this.globalMethodMap;
    }
}
