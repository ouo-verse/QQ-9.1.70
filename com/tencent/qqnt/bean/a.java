package com.tencent.qqnt.bean;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.data.TroopCreateInfo;
import com.tencent.qqnt.kernel.nativeinterface.CreateGroupChannelInfo;
import com.tencent.qqnt.kernel.nativeinterface.CreateGroupGeoInfo;
import com.tencent.qqnt.kernel.nativeinterface.CreateGroupInfo;
import com.tencent.qqnt.kernel.nativeinterface.CreateGroupReq;
import com.tencent.qqnt.kernel.nativeinterface.InviteMemberInfo;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u0012\n\u0002\b\n\u0018\u0000 12\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b/\u00100J\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u000e\u001a\u00020\nH\u0016R\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0013R\u0016\u0010\u001b\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0013R\u0016\u0010\u001d\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0010R\u0016\u0010\u001f\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0010R\u0016\u0010!\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u0013R\u0016\u0010#\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0016R\u0018\u0010%\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\u0016R\u0018\u0010'\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010\u0016R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R&\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00062"}, d2 = {"Lcom/tencent/qqnt/bean/a;", "", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/InviteMemberInfo;", "Lkotlin/collections/ArrayList;", "c", "Lcom/tencent/mobileqq/troop/data/TroopCreateInfo;", "createInfo", "", "a", "", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/CreateGroupReq;", "b", "toString", "", "J", "troopUin", "", "I", "groupSize", "groupOption", "Ljava/lang/String;", "groupFingerMemo", "e", "groupClass", "f", "troopType", "g", QCircleSchemeAttr.Polymerize.LAT, h.F, "lon", "i", "cityId", "j", "location", "k", "createScene", "l", "sceneTargetId", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "[B", "sign", DomainData.DOMAIN_NAME, "Ljava/util/ArrayList;", "inviteMembers", "<init>", "()V", "o", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long troopUin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int groupSize;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int groupOption;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String groupFingerMemo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int groupClass;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int troopType;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private long lat;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long lon;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int cityId;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String location;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String createScene;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String sceneTargetId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private byte[] sign;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<InviteMemberInfo> inviteMembers;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/bean/a$a;", "", "", "DEFAULT_CREATE_APPID", "I", "<init>", "()V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.bean.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes23.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27403);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.groupFingerMemo = "";
        this.location = "";
        this.inviteMembers = new ArrayList<>();
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0105 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(@NotNull TroopCreateInfo createInfo) {
        List emptyList;
        long j3;
        Long longOrNull;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) createInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(createInfo, "createInfo");
        this.troopUin = createInfo.groupUin;
        this.groupSize = createInfo.troopSize;
        this.groupOption = createInfo.verifyType;
        String str = createInfo.introduction;
        Intrinsics.checkNotNullExpressionValue(str, "createInfo.introduction");
        this.groupFingerMemo = str;
        this.groupClass = createInfo.classify;
        this.createScene = createInfo.createScene;
        this.sceneTargetId = createInfo.sceneTargetId;
        this.sign = createInfo.signOriginal;
        int i3 = createInfo.troopType;
        if (i3 == 2) {
            i3++;
        }
        this.troopType = i3;
        String str2 = createInfo.location;
        Intrinsics.checkNotNullExpressionValue(str2, "createInfo.location");
        List<String> split = new Regex("\\|").split(str2, 0);
        if (!split.isEmpty()) {
            ListIterator<String> listIterator = split.listIterator(split.size());
            while (listIterator.hasPrevious()) {
                if (listIterator.previous().length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    emptyList = CollectionsKt___CollectionsKt.take(split, listIterator.nextIndex() + 1);
                    break;
                }
            }
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        Object[] array = emptyList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String[] strArr = (String[]) array;
        if (strArr.length == 4) {
            try {
                this.cityId = Integer.parseInt(strArr[0]);
                float f16 = 1000000;
                this.lat = Float.parseFloat(strArr[1]) * f16;
                this.lon = Float.parseFloat(strArr[2]) * f16;
            } catch (NumberFormatException unused) {
            }
            this.location = strArr[3];
        }
        this.inviteMembers.clear();
        List<TroopCreateInfo.a> list = createInfo.inviteMembers;
        Intrinsics.checkNotNullExpressionValue(list, "createInfo.inviteMembers");
        for (TroopCreateInfo.a aVar : list) {
            String groupUin = aVar.f294792f;
            long j16 = 0;
            if (groupUin != null) {
                Intrinsics.checkNotNullExpressionValue(groupUin, "groupUin");
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(groupUin);
                if (longOrNull != null) {
                    j3 = longOrNull.longValue();
                    if (j3 < 0) {
                        j16 = j3;
                    }
                    ArrayList<InviteMemberInfo> arrayList = this.inviteMembers;
                    InviteMemberInfo inviteMemberInfo = new InviteMemberInfo();
                    inviteMemberInfo.uid = aVar.f294788b;
                    inviteMemberInfo.groupCode = j16;
                    arrayList.add(inviteMemberInfo);
                }
            }
            j3 = 0;
            if (j3 < 0) {
            }
            ArrayList<InviteMemberInfo> arrayList2 = this.inviteMembers;
            InviteMemberInfo inviteMemberInfo2 = new InviteMemberInfo();
            inviteMemberInfo2.uid = aVar.f294788b;
            inviteMemberInfo2.groupCode = j16;
            arrayList2.add(inviteMemberInfo2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x006e, code lost:
    
        r7 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r7);
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final CreateGroupReq b() {
        long j3;
        Long longOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (CreateGroupReq) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        String currentUid = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUid();
        CreateGroupReq createGroupReq = new CreateGroupReq();
        createGroupReq.createOption = 1;
        CreateGroupInfo createGroupInfo = createGroupReq.createGroupInfo;
        createGroupInfo.groupCode = (int) this.troopUin;
        createGroupInfo.groupSize = this.groupSize;
        createGroupInfo.ownerUid = currentUid;
        createGroupInfo.groupOption = this.groupOption;
        String str = this.groupFingerMemo;
        Charset charset = Charsets.UTF_8;
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        createGroupInfo.stringGroupFingerMemo = bytes;
        byte[] bytes2 = this.groupFingerMemo.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
        createGroupInfo.stringGroupRichFingerMemo = bytes2;
        createGroupInfo.groupClass = 0;
        createGroupInfo.groupClassExt = this.groupClass;
        createGroupInfo.groupTypeFlag = this.troopType;
        if (Intrinsics.areEqual("guild", this.createScene)) {
            createGroupInfo.sourceId = 1;
            CreateGroupChannelInfo createGroupChannelInfo = createGroupInfo.msgChannelInfo;
            String str2 = this.sceneTargetId;
            if (str2 != null && longOrNull != null) {
                j3 = longOrNull.longValue();
            } else {
                j3 = 0;
            }
            createGroupChannelInfo.channelId = j3;
        }
        CreateGroupGeoInfo createGroupGeoInfo = createGroupInfo.groupGeoInfo;
        createGroupGeoInfo.cityId = this.cityId;
        createGroupGeoInfo.longtitude = this.lon;
        createGroupGeoInfo.latitude = this.lat;
        byte[] bytes3 = this.location.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes3, "this as java.lang.String).getBytes(charset)");
        createGroupGeoInfo.stringGeoContent = bytes3;
        createGroupInfo.stringSign = this.sign;
        createGroupInfo.createFlag = 16L;
        createGroupInfo.groupFaceFlag = 0;
        createGroupInfo.appId = 200000007;
        createGroupReq.selectGroupCodeInfo.ownerUid = currentUid;
        return createGroupReq;
    }

    @NotNull
    public final ArrayList<InviteMemberInfo> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.inviteMembers;
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return String.valueOf(this.troopUin);
    }

    @NotNull
    public String toString() {
        int collectionSizeOrDefault;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        long j3 = this.troopUin;
        int i3 = this.groupSize;
        int i16 = this.groupOption;
        String str = this.groupFingerMemo;
        int i17 = this.groupClass;
        int i18 = this.troopType;
        long j16 = this.lat;
        long j17 = this.lon;
        int i19 = this.cityId;
        String str2 = this.location;
        String str3 = this.createScene;
        String str4 = this.sceneTargetId;
        ArrayList<InviteMemberInfo> arrayList = this.inviteMembers;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            InviteMemberInfo inviteMemberInfo = (InviteMemberInfo) it.next();
            Iterator it5 = it;
            int i26 = i19;
            arrayList2.add(inviteMemberInfo.uid + "-" + inviteMemberInfo.groupCode);
            it = it5;
            i19 = i26;
            str2 = str2;
        }
        return "tUin:" + j3 + ", gSize:" + i3 + ", gOption:" + i16 + ", gFMemo:" + str + ", class:" + i17 + ", type:" + i18 + ", lat:" + j16 + ", lon:" + j17 + ", cityId:" + i19 + ", loc:" + str2 + ", scene:" + str3 + ", sceneTId:" + str4 + ", inviteMembers:" + arrayList2;
    }
}
