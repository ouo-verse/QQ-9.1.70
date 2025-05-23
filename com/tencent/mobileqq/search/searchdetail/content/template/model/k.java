package com.tencent.mobileqq.search.searchdetail.content.template.model;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.addfriend.api.IAddFriendServiceApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.SearchButton;
import com.tencent.qqnt.kernel.nativeinterface.SearchGuildJump;
import com.tencent.qqnt.kernel.nativeinterface.SearchJump;
import com.tencent.qqnt.kernel.nativeinterface.SearchReportInfo;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 A2\u00020\u0001:\u0003\u000b\b\nB\u0007\u00a2\u0006\u0004\b?\u0010@J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006J\b\u0010\u000b\u001a\u00020\u0000H\u0016R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\"\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R#\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\u0015\u0010&R\u0017\u0010,\u001a\u00020(8\u0006\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b\u001c\u0010+R\"\u0010.\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\r\u0010\u001f\"\u0004\b-\u0010!R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010\u001d\u001a\u0004\b$\u0010\u001f\"\u0004\b0\u0010!R\"\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010\u001d\u001a\u0004\b)\u0010\u001f\"\u0004\b2\u0010!R\"\u00106\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010\u000e\u001a\u0004\b4\u0010\u0010\"\u0004\b5\u0010\u0012R$\u0010>\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/model/k;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchButton;", "searchButton", "", "o", "", "joinGroupStatus", "b", "joinGuildStatus", "c", "a", "", "d", "Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ljava/lang/String;", IECSearchBar.METHOD_SET_TEXT, "(Ljava/lang/String;)V", "text", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchJump;", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchJump;", "j", "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchJump;", "setJumpInfo", "(Lcom/tencent/qqnt/kernel/nativeinterface/SearchJump;)V", "jumpInfo", "f", "I", "l", "()I", "setStatus", "(I)V", "status", "", tl.h.F, "Ljava/util/Map;", "()Ljava/util/Map;", "extensionMap", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/k$b;", "i", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/k$b;", "()Lcom/tencent/mobileqq/search/searchdetail/content/template/model/k$b;", "extras", "setButtonType", "buttonType", BdhLogUtil.LogTag.Tag_Conn, "setJoinGroupStatus", "D", "setJoinGuildStatus", "E", DomainData.DOMAIN_NAME, "setTroopUin", "troopUin", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchReportInfo;", UserInfo.SEX_FEMALE, "Lcom/tencent/qqnt/kernel/nativeinterface/SearchReportInfo;", "k", "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchReportInfo;", "setReportInfo", "(Lcom/tencent/qqnt/kernel/nativeinterface/SearchReportInfo;)V", CacheTable.TABLE_NAME, "<init>", "()V", "G", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class k implements Cloneable {

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private int joinGroupStatus;

    /* renamed from: D, reason: from kotlin metadata */
    private int joinGuildStatus;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private String troopUin;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private SearchReportInfo reportInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String text = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SearchJump jumpInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int status;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, String> extensionMap;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b extras;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int buttonType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\bR\u0014\u0010\u0010\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\bR\u0014\u0010\u0011\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\bR\u0014\u0010\u0012\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\bR\u0014\u0010\u0013\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\bR\u0014\u0010\u0014\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\bR\u0014\u0010\u0015\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\bR\u0014\u0010\u0016\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\bR\u0014\u0010\u0017\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\bR\u0014\u0010\u0018\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\r\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/model/k$a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchButton;", "button", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/k;", "a", "", "ADD_STATUS_ALREADY_ADD", "I", "ADD_STATUS_NOT_ADD", "ADD_STATUS_WAIT_FOR_CONFIRM", "", "EXTENSION_KEY_NAME", "Ljava/lang/String;", "EXTENSION_KEY_UIN", "JOIN_GROUP_STATUS_ALREADY_JOIN", "JOIN_GROUP_STATUS_NOT_JOIN", "JOIN_GROUP_STATUS_WAIT_FOR_CONFIRM", "JOIN_GUILD_STATUS_JOIN", "JOIN_GUILD_STATUS_NOT_JOIN", "JOIN_GUILD_STATUS_UNKNOW", "STATUS_DISABLE", "STATUS_NORMAL", "STATUS_PROCESS", "TAG", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.searchdetail.content.template.model.k$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final k a(@Nullable SearchButton button) {
            boolean z16;
            if (button == null) {
                return null;
            }
            int i3 = button.buttonType;
            boolean z17 = false;
            if (i3 != 1 && i3 != 2 && i3 != 3) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                String str = button.title;
                Intrinsics.checkNotNullExpressionValue(str, "button.title");
                if (str.length() > 0) {
                    z17 = true;
                }
                if (!z17) {
                    return null;
                }
            }
            k kVar = new k();
            kVar.o(button);
            return kVar;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018R#\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R+\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000b\u0010\u000fR+\u0010\u0016\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0004\u0010\u0013*\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/model/k$b;", "", "", "", "a", "Ljava/util/Map;", "getMap", "()Ljava/util/Map;", "map", "", "<set-?>", "b", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/k$c;", "getSubSourceId", "()I", "(I)V", "subSourceId", "getSubSource", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "getSubSource$delegate", "(Lcom/tencent/mobileqq/search/searchdetail/content/template/model/k$b;)Ljava/lang/Object;", "subSource", "<init>", "(Ljava/util/Map;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b {

        /* renamed from: c, reason: collision with root package name */
        static final /* synthetic */ KProperty<Object>[] f284227c = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(b.class, "subSource", "getSubSource()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(b.class, "subSourceId", "getSubSourceId()I", 0))};

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Map<String, String> map;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final c subSourceId;

        public b(@NotNull Map<String, String> map) {
            Intrinsics.checkNotNullParameter(map, "map");
            this.map = map;
            this.subSourceId = new c(map, "subSourceId");
        }

        public final void a(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.map.put(f284227c[0].getName(), str);
        }

        public final void b(int i3) {
            this.subSourceId.a(this, f284227c[1], i3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J'\u0010\b\u001a\u00020\u00072\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0086\u0002R \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/model/k$c;", "", "thisRef", "Lkotlin/reflect/KProperty;", "property", "", "value", "", "a", "", "", "Ljava/util/Map;", "map", "b", "Ljava/lang/String;", "key", "<init>", "(Ljava/util/Map;Ljava/lang/String;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    private static final class c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Map<String, String> map;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String key;

        public c(@NotNull Map<String, String> map, @NotNull String key) {
            Intrinsics.checkNotNullParameter(map, "map");
            Intrinsics.checkNotNullParameter(key, "key");
            this.map = map;
            this.key = key;
        }

        public final void a(@Nullable Object thisRef, @NotNull KProperty<?> property, int value) {
            Intrinsics.checkNotNullParameter(property, "property");
            this.map.put(this.key, String.valueOf(value));
        }
    }

    public k() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.extensionMap = linkedHashMap;
        this.extras = new b(linkedHashMap);
        this.joinGroupStatus = 1;
        this.troopUin = "";
    }

    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public k clone() {
        Object clone = super.clone();
        Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type com.tencent.mobileqq.search.searchdetail.content.template.model.NetSearchTemplateButton");
        return (k) clone;
    }

    public final void b(int joinGroupStatus) {
        if (joinGroupStatus != 0) {
            if (joinGroupStatus != 1) {
                this.text = "\u7b49\u5f85\u9a8c\u8bc1";
                this.status = 2;
            } else {
                this.text = "\u52a0\u5165";
                this.status = 0;
            }
        } else {
            this.text = "\u5df2\u52a0\u5165";
            this.status = 2;
        }
        this.joinGroupStatus = joinGroupStatus;
    }

    public final void c(int joinGuildStatus) {
        if (joinGuildStatus != 0) {
            if (joinGuildStatus != 1) {
                this.text = "";
                this.status = 1;
            } else {
                this.text = "\u5df2\u52a0\u5165";
                this.status = 2;
            }
        } else {
            this.text = "\u52a0\u5165";
            this.status = 0;
        }
        this.joinGuildStatus = joinGuildStatus;
    }

    /* renamed from: d, reason: from getter */
    public final int getButtonType() {
        return this.buttonType;
    }

    @NotNull
    public final Map<String, String> e() {
        return this.extensionMap;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final b getExtras() {
        return this.extras;
    }

    /* renamed from: h, reason: from getter */
    public final int getJoinGroupStatus() {
        return this.joinGroupStatus;
    }

    /* renamed from: i, reason: from getter */
    public final int getJoinGuildStatus() {
        return this.joinGuildStatus;
    }

    @Nullable
    /* renamed from: j, reason: from getter */
    public final SearchJump getJumpInfo() {
        return this.jumpInfo;
    }

    @Nullable
    /* renamed from: k, reason: from getter */
    public final SearchReportInfo getReportInfo() {
        return this.reportInfo;
    }

    /* renamed from: l, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final String getText() {
        return this.text;
    }

    @NotNull
    /* renamed from: n, reason: from getter */
    public final String getTroopUin() {
        return this.troopUin;
    }

    public final void o(@NotNull SearchButton searchButton) {
        int i3;
        SearchGuildJump searchGuildJump;
        String stringExtension;
        Intrinsics.checkNotNullParameter(searchButton, "searchButton");
        this.reportInfo = searchButton.reportInfo;
        SearchJump searchJump = searchButton.jumpLink;
        this.jumpInfo = searchJump;
        String str = "";
        int i16 = 1;
        if (searchJump != null && (stringExtension = searchJump.getStringExtension()) != null) {
            try {
                JSONObject jSONObject = new JSONObject(stringExtension);
                Iterator keys = jSONObject.keys();
                Intrinsics.checkNotNullExpressionValue(keys, "extensionObj.keys()");
                while (keys.hasNext()) {
                    String it = (String) keys.next();
                    Map<String, String> map = this.extensionMap;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    String optString = jSONObject.optString(it, "");
                    Intrinsics.checkNotNullExpressionValue(optString, "extensionObj.optString(it, \"\")");
                    map.put(it, optString);
                }
            } catch (JSONException e16) {
                QLog.i("NetSearchTemplateButton", 1, "parseSearchButton jumpExtension(" + stringExtension + "): " + e16);
            }
        }
        int i17 = searchButton.buttonType;
        this.buttonType = i17;
        if (i17 != 1) {
            int i18 = -1;
            if (i17 != 2) {
                if (i17 != 3) {
                    String str2 = searchButton.title;
                    Intrinsics.checkNotNullExpressionValue(str2, "searchButton.title");
                    this.text = str2;
                    this.status = 0;
                    return;
                }
                SearchJump searchJump2 = searchButton.jumpLink;
                if (searchJump2 != null && (searchGuildJump = searchJump2.guildJump) != null) {
                    int i19 = searchGuildJump.joinStatus;
                    if (i19 != 1) {
                        if (i19 != 2) {
                            i16 = -1;
                        }
                    } else {
                        i16 = 0;
                    }
                    i18 = i16;
                }
                c(i18);
                return;
            }
            String str3 = this.extensionMap.get("join_group_flag");
            if (str3 != null) {
                i3 = Integer.parseInt(str3);
            } else {
                i3 = 0;
            }
            if (i3 > -1) {
                i16 = 0;
            }
            b(i16);
            String str4 = this.extensionMap.get("group_code");
            if (str4 != null) {
                str = str4;
            }
            this.troopUin = str;
            return;
        }
        String str5 = this.extensionMap.get("uin");
        if (str5 == null) {
            str5 = searchButton.title;
        }
        String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str5);
        IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        boolean isFriend = iFriendsInfoService.isFriend(uid, "NetSearchTemplateButton$parseSearchButton");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.business.BaseQQAppInterface");
        boolean hasSendAddFriendReq = ((IAddFriendServiceApi) ((BaseQQAppInterface) peekAppRuntime).getRuntimeService(IAddFriendServiceApi.class)).hasSendAddFriendReq(str5, false);
        if (isFriend) {
            this.text = "\u5df2\u6dfb\u52a0";
            this.status = 1;
        } else if (hasSendAddFriendReq) {
            this.text = "\u7b49\u5f85\u786e\u8ba4";
            this.status = 2;
        } else {
            this.text = "\u6dfb\u52a0";
            this.status = 0;
        }
    }
}
