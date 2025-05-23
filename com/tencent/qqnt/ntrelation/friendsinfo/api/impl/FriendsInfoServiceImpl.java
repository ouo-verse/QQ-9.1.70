package com.tencent.qqnt.ntrelation.friendsinfo.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.y;
import com.tencent.qqnt.ntrelation.api.IFriendsTABService;
import com.tencent.qqnt.ntrelation.constant.RelationListReqType;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010$\n\u0002\b\u001a\u0018\u0000 h2\u00020\u0001:\u0001iB\u0007\u00a2\u0006\u0004\bf\u0010gJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\u001a\u0010\u000f\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J>\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\u00152\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0014j\b\u0012\u0004\u0012\u00020\u000b`\u00152\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J>\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\u00152\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0014j\b\u0012\u0004\u0012\u00020\u000b`\u00152\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J>\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00152\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0014j\b\u0012\u0004\u0012\u00020\u000b`\u00152\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J*\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001bH\u0016J:\u0010\u001d\u001a\u00020\u00062\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0014j\b\u0012\u0004\u0012\u00020\u0004`\u00152\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001bH\u0016J:\u0010 \u001a\u00020\u00062\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0014j\b\u0012\u0004\u0012\u00020\u0002`\u00152\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001bH\u0016J(\u0010&\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#H\u0016J8\u0010(\u001a\u00020\u00062\u0016\u0010'\u001a\u0012\u0012\u0004\u0012\u00020!0\u0014j\b\u0012\u0004\u0012\u00020!`\u00152\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#H\u0016J*\u0010+\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010)H\u0016J\u0018\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00040,2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010/\u001a\b\u0012\u0004\u0012\u00020.0,2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010/\u001a\u0004\u0018\u00010.2\u0006\u0010\"\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u00100\u001a\u0004\u0018\u00010$2\u0006\u0010\"\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J0\u00103\u001a\u00020\u00062\u0006\u00101\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u00102\u001a\u00020\r2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#H\u0017J \u00104\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#H\u0016J8\u00107\u001a\u00020\u00062\u0006\u00106\u001a\u0002052\u0006\u00101\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u00102\u001a\u00020\r2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#H\u0016J(\u00108\u001a\u00020\u00062\u0006\u00106\u001a\u0002052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#H\u0016J(\u00109\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020#H\u0016J8\u00109\u001a\u00020\u00062\u0016\u0010:\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0014j\b\u0012\u0004\u0012\u00020\u000b`\u00152\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020#H\u0016J0\u00109\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020#H\u0016J \u0010;\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000b0#H\u0016J\u0012\u0010<\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J2\u0010?\u001a\u00020\u00062\u0006\u0010=\u001a\u00020!2\u0006\u0010>\u001a\u00020!2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010#H\u0016J4\u0010C\u001a\u00020\u00062\b\u0010@\u001a\u0004\u0018\u00010\u000b2\u0006\u0010A\u001a\u00020!2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u000e\u0010B\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u001bH\u0016J:\u0010F\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010D\u001a\u00020!2\u0006\u0010E\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010#H\u0016J \u0010G\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020!0#H\u0016J \u0010H\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\r0#H\u0016J*\u0010I\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010#H\u0016J:\u0010J\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0016\u0010:\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0014j\b\u0012\u0004\u0012\u00020\u000b`\u00152\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010#H\u0016J0\u0010K\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000b0,2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010#H\u0016J\u001a\u0010L\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010M\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010N\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J4\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\r0P2\u0006\u0010O\u001a\u00020\u000b2\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0014j\b\u0012\u0004\u0012\u00020\u000b`\u0015H\u0016J&\u0010N\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010R\u001a\u00020\u000b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\r0#H\u0016J\u0018\u0010S\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010R\u001a\u00020\u000bH\u0016J\u0018\u0010T\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010R\u001a\u00020\u000bH\u0016J(\u0010V\u001a\u00020\u00062\u0006\u0010U\u001a\u00020\u000b2\u0006\u0010R\u001a\u00020\u000b2\u000e\u0010B\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010\u001bH\u0016J\u0018\u0010W\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0012\u0010X\u001a\u00020!2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J!\u0010Y\u001a\u0004\u0018\u00010!2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a2\u0006\u0004\bY\u0010ZJ(\u0010[\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020#H\u0016R\u0016\u0010\\\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0017\u0010^\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b^\u0010_\u001a\u0004\b^\u0010`R\"\u0010a\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\ba\u0010_\u001a\u0004\ba\u0010`\"\u0004\bb\u0010cR\"\u0010d\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bd\u0010_\u001a\u0004\bd\u0010`\"\u0004\be\u0010c\u00a8\u0006j"}, d2 = {"Lcom/tencent/qqnt/ntrelation/friendsinfo/api/impl/FriendsInfoServiceImpl;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/api/IFriendsInfoService;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/c;", "ntFriendDetailInfo", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/d;", "ntFriendSimpleInfo", "", "simpleInfo2DetailInfo", "Lcom/tencent/qqnt/ntrelation/friendsinfo/api/IQQFriendsInfoApi;", "getAbsServiceImpl", "getReverseServiceImpl", "", "trace", "", "forceInit", "initFriendsInfoListener", "uin", "getUidFromUin", "uid", "getUinFromUid", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "uids", "getNickWithUid", "getRemarkWithUid", "getFriendSimpleInfoWithUid", "getFriendsSimpleInfoWithUid", "Lhx3/c;", "updateCallback", "accurateUpdateNTFriendSimpleInfo", "ntFriendSimpleInfoList", "ntFriendDetailInfoList", "accurateUpdateNTFriendDetailInfo", "", "categoryId", "Lhx3/b;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/b;", "iQueryGeneralDataCallback", "getCategoryInfoWithCategoryId", "categoryIds", "getCategoryInfoListWithCategoryId", "Lhx3/a;", "iDeleteGeneralDataCallback", "deleteNTFriendSimpleInfo", "", "getAllFriend", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/a;", "getFriendsCategoryBaseInfo", "getFriendsCategoryInfo", "isObserver", "forceUpdate", "friendsCategoryInfo", "unregisterFriendCategoryInfoCallback", "Lcom/tencent/qqnt/ntrelation/constant/RelationListReqType;", "reqType", "friendsCategoryCacheInfoV2", "unregisterFriendCategoryInfoV2Callback", "getFriendsDetailInfoWithUid", "uidList", "addChangeFriendUidsCallBack", "requestAllCategoriesInfo", "srcGroupId", "dstGroupId", "moveGroup", "friendUid", "newGroupId", "iUpdateGeneralDataCallback", "moveFriendToNewGroup", "groupId", "uncommonlyUsedFrd", "addFriendToFriendList", "getGatheredFriendsCount", "isGetFriendListSuc", "changeBuddyOnline", "doUnComUsed2Normal", "normal2UnComUsed", "isValidUin", "isValidUid", IProfileProtocolConst.PARAM_IS_FRIEND, "callFrom", "", "isFriends", "tag", "isShieldFriend", "getSpecialCareGlobalSwitch", "categoryName", "addCategory", "isHasFriend", "getFriendCount", "getRingId", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Integer;", "getControlGroupFriendsDetailInfoWithUid", "absApiImpl", "Lcom/tencent/qqnt/ntrelation/friendsinfo/api/IQQFriendsInfoApi;", "isNew", "Z", "()Z", "isLogOpen", "setLogOpen", "(Z)V", "isOptSourceFrom", "setOptSourceFrom", "<init>", "()V", "Companion", "a", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class FriendsInfoServiceImpl implements IFriendsInfoService {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final int MULTI_FLAGS_MASK_OLYMPICTORCH;
    private static final int MULTI_FLAGS_MASK_SHIELD;

    @NotNull
    public static final String TAG = "FriendsServiceImpl";
    private static final Pattern uidPattern;

    @NotNull
    private IQQFriendsInfoApi absApiImpl;
    private boolean isLogOpen;
    private final boolean isNew;
    private boolean isOptSourceFrom;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/ntrelation/friendsinfo/api/impl/FriendsInfoServiceImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.ntrelation.friendsinfo.api.impl.FriendsInfoServiceImpl$a, reason: from kotlin metadata */
    /* loaded from: classes22.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/ntrelation/friendsinfo/api/impl/FriendsInfoServiceImpl$b", "Lhx3/c;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/c;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/e;", WebViewPlugin.KEY_RESPONSE, "", "onUpdateResult", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b implements hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> f359920a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> f359921b;

        b(hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> cVar, ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> arrayList) {
            this.f359920a = cVar;
            this.f359921b = arrayList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar, (Object) arrayList);
            }
        }

        @Override // hx3.c
        public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> responseData) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) responseData);
                return;
            }
            if (responseData == null) {
                hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> cVar = this.f359920a;
                if (cVar != null) {
                    cVar.onUpdateResult(null);
                    return;
                }
                return;
            }
            com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> eVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.e<>();
            eVar.f(responseData.c());
            eVar.d(responseData.a());
            eVar.e(this.f359921b);
            hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> cVar2 = this.f359920a;
            if (cVar2 != null) {
                cVar2.onUpdateResult(eVar);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/ntrelation/friendsinfo/api/impl/FriendsInfoServiceImpl$c", "Lhx3/b;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/b;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/e;", WebViewPlugin.KEY_RESPONSE, "", "onQueryResult", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class c implements hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // hx3.b
        public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> responseData) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) responseData);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36674);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 55)) {
            redirector.redirect((short) 55);
            return;
        }
        INSTANCE = new Companion(null);
        MULTI_FLAGS_MASK_SHIELD = 1;
        MULTI_FLAGS_MASK_OLYMPICTORCH = 2;
        uidPattern = Pattern.compile("^[a-zA-Z0-9_-]*$");
    }

    public FriendsInfoServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.absApiImpl = new NTFriendsInfoApiImpl();
        this.isNew = ((IFriendsTABService) QRoute.api(IFriendsTABService.class)).isNtDataService();
        this.isLogOpen = ((IFriendsTABService) QRoute.api(IFriendsTABService.class)).getIsLogOpen();
        this.isOptSourceFrom = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("103276", true);
    }

    private final IQQFriendsInfoApi getAbsServiceImpl() {
        IQQFriendsInfoApi iQQFriendsInfoApi;
        NTFriendsInfoApiImpl nTFriendsInfoApiImpl;
        if (this.isOptSourceFrom) {
            IQQFriendsInfoApi iQQFriendsInfoApi2 = this.absApiImpl;
            if (iQQFriendsInfoApi2 != null) {
                if (iQQFriendsInfoApi2 instanceof NTFriendsInfoApiImpl) {
                    return iQQFriendsInfoApi2;
                }
                nTFriendsInfoApiImpl = new NTFriendsInfoApiImpl();
            } else {
                nTFriendsInfoApiImpl = new NTFriendsInfoApiImpl();
            }
            this.absApiImpl = nTFriendsInfoApiImpl;
            return nTFriendsInfoApiImpl;
        }
        IQQFriendsInfoApi iQQFriendsInfoApi3 = this.absApiImpl;
        if (iQQFriendsInfoApi3 != null) {
            boolean z16 = this.isNew;
            if (z16 && (iQQFriendsInfoApi3 instanceof NTFriendsInfoApiImpl)) {
                return iQQFriendsInfoApi3;
            }
            if (!z16 && !(iQQFriendsInfoApi3 instanceof NTFriendsInfoApiImpl)) {
                return iQQFriendsInfoApi3;
            }
        }
        if (this.isNew) {
            iQQFriendsInfoApi = new NTFriendsInfoApiImpl();
        } else {
            iQQFriendsInfoApi = (IQQFriendsInfoApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IQQFriendsInfoApi.class);
        }
        this.absApiImpl = iQQFriendsInfoApi;
        return iQQFriendsInfoApi;
    }

    private final IQQFriendsInfoApi getReverseServiceImpl() {
        if (!this.isNew) {
            return new NTFriendsInfoApiImpl();
        }
        return (IQQFriendsInfoApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IQQFriendsInfoApi.class);
    }

    private final void simpleInfo2DetailInfo(com.tencent.qqnt.ntrelation.friendsinfo.bean.c ntFriendDetailInfo, com.tencent.qqnt.ntrelation.friendsinfo.bean.d ntFriendSimpleInfo) {
        ntFriendDetailInfo.v0(ntFriendSimpleInfo.getUid());
        ntFriendDetailInfo.w0(ntFriendSimpleInfo.x());
        ntFriendDetailInfo.k0(ntFriendSimpleInfo.p());
        ntFriendDetailInfo.m0(ntFriendSimpleInfo.r());
        ntFriendDetailInfo.u0(ntFriendSimpleInfo.w());
        ntFriendDetailInfo.c0(ntFriendSimpleInfo.e());
        ntFriendDetailInfo.d0(ntFriendSimpleInfo.f());
        ntFriendDetailInfo.g0(ntFriendSimpleInfo.l());
        ntFriendDetailInfo.Z(ntFriendSimpleInfo.c());
        ntFriendDetailInfo.h0(ntFriendSimpleInfo.n());
        ntFriendDetailInfo.V(ntFriendSimpleInfo.b());
        ntFriendDetailInfo.q0(ntFriendSimpleInfo.v());
        ntFriendDetailInfo.l0(ntFriendSimpleInfo.q());
        ntFriendDetailInfo.e0(ntFriendSimpleInfo.j());
        ntFriendDetailInfo.f0(ntFriendSimpleInfo.k());
        ntFriendDetailInfo.j0(ntFriendSimpleInfo.o());
        ntFriendDetailInfo.a0(ntFriendSimpleInfo.z());
        ntFriendDetailInfo.b0(ntFriendSimpleInfo.A());
        ntFriendDetailInfo.o0(ntFriendSimpleInfo.t());
        ntFriendDetailInfo.n0(ntFriendSimpleInfo.s());
        ntFriendDetailInfo.N(ntFriendSimpleInfo.y());
        ntFriendDetailInfo.i0(ntFriendSimpleInfo.C());
        ntFriendDetailInfo.p0(ntFriendSimpleInfo.u());
        ntFriendDetailInfo.s0(ntFriendSimpleInfo.F());
        ntFriendDetailInfo.t0(ntFriendSimpleInfo.G());
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    public void accurateUpdateNTFriendDetailInfo(@NotNull ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> ntFriendDetailInfoList, @Nullable String trace, @Nullable hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> updateCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, ntFriendDetailInfoList, trace, updateCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(ntFriendDetailInfoList, "ntFriendDetailInfoList");
        getAbsServiceImpl().accurateUpdateNTFriendDetailInfo(ntFriendDetailInfoList, trace, updateCallback);
        getReverseServiceImpl().accurateUpdateNTFriendDetailInfo(ntFriendDetailInfoList, trace, null);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    public void accurateUpdateNTFriendSimpleInfo(@NotNull com.tencent.qqnt.ntrelation.friendsinfo.bean.d ntFriendSimpleInfo, @Nullable String trace, @Nullable hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> updateCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, ntFriendSimpleInfo, trace, updateCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(ntFriendSimpleInfo, "ntFriendSimpleInfo");
        ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> arrayList = new ArrayList<>();
        arrayList.add(ntFriendSimpleInfo);
        accurateUpdateNTFriendSimpleInfo(arrayList, trace, updateCallback);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    public void addCategory(@NotNull String categoryName, @NotNull String tag, @Nullable hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.a> iUpdateGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, this, categoryName, tag, iUpdateGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(categoryName, "categoryName");
        Intrinsics.checkNotNullParameter(tag, "tag");
        getAbsServiceImpl().addCategoryV2(categoryName, tag, iUpdateGeneralDataCallback);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    public void addChangeFriendUidsCallBack(@Nullable String trace, @NotNull hx3.b<String> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) trace, (Object) iQueryGeneralDataCallback);
        } else {
            Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
            getAbsServiceImpl().addChangeFriendUidsCallBack(trace, iQueryGeneralDataCallback);
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    public void addFriendToFriendList(@NotNull String uid, int groupId, boolean uncommonlyUsedFrd, @Nullable String trace, @Nullable hx3.b<Boolean> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, this, uid, Integer.valueOf(groupId), Boolean.valueOf(uncommonlyUsedFrd), trace, iQueryGeneralDataCallback);
        } else {
            Intrinsics.checkNotNullParameter(uid, "uid");
            getAbsServiceImpl().addFriendToFriendList(uid, groupId, uncommonlyUsedFrd, trace, iQueryGeneralDataCallback);
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    public void changeBuddyOnline(@Nullable String trace, @NotNull String uid, @Nullable hx3.b<Boolean> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, this, trace, uid, iQueryGeneralDataCallback);
        } else {
            Intrinsics.checkNotNullParameter(uid, "uid");
            getAbsServiceImpl().changeBuddyOnline(trace, uid, iQueryGeneralDataCallback);
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    public void deleteNTFriendSimpleInfo(@NotNull String uid, @Nullable String trace, @Nullable hx3.a<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> iDeleteGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, uid, trace, iDeleteGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        getAbsServiceImpl().deleteNTFriendSimpleInfo(uid, trace, iDeleteGeneralDataCallback);
        getReverseServiceImpl().deleteNTFriendSimpleInfo(uid, trace, iDeleteGeneralDataCallback);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    public void doUnComUsed2Normal(@Nullable String trace, @NotNull ArrayList<String> uidList, @Nullable hx3.b<Boolean> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, this, trace, uidList, iQueryGeneralDataCallback);
        } else {
            Intrinsics.checkNotNullParameter(uidList, "uidList");
            getAbsServiceImpl().doUnComUsed2Normal(trace, uidList, iQueryGeneralDataCallback);
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    public void friendsCategoryCacheInfoV2(@NotNull RelationListReqType reqType, boolean isObserver, @Nullable String trace, boolean forceUpdate, @NotNull hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, reqType, Boolean.valueOf(isObserver), trace, Boolean.valueOf(forceUpdate), iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(reqType, "reqType");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        getAbsServiceImpl().friendsCategoryCacheInfoV2(reqType, isObserver, trace, forceUpdate, iQueryGeneralDataCallback);
        if (this.isNew && forceUpdate) {
            getReverseServiceImpl().friendsCategoryCacheInfoV2(reqType, false, trace, true, new c());
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    @Deprecated(level = DeprecationLevel.WARNING, message = TAG, replaceWith = @ReplaceWith(expression = "friendsCategoryCacheInfoV2", imports = {}))
    public void friendsCategoryInfo(boolean isObserver, @Nullable String trace, boolean forceUpdate, @NotNull hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, Boolean.valueOf(isObserver), trace, Boolean.valueOf(forceUpdate), iQueryGeneralDataCallback);
        } else {
            Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
            friendsCategoryCacheInfoV2(RelationListReqType.NORMAL, isObserver, trace, forceUpdate, iQueryGeneralDataCallback);
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    @NotNull
    public List<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> getAllFriend(@Nullable String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (List) iPatchRedirector.redirect((short) 22, (Object) this, (Object) trace);
        }
        return getAbsServiceImpl().getAllFriend(trace);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    public void getCategoryInfoListWithCategoryId(@NotNull ArrayList<Integer> categoryIds, @Nullable String trace, @NotNull hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, categoryIds, trace, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(categoryIds, "categoryIds");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        getAbsServiceImpl().getCategoryInfoListWithCategoryId(categoryIds, trace, iQueryGeneralDataCallback);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    public void getCategoryInfoWithCategoryId(int categoryId, @Nullable String trace, @NotNull hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Integer.valueOf(categoryId), trace, iQueryGeneralDataCallback);
        } else {
            Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
            getAbsServiceImpl().getCategoryInfoWithCategoryId(categoryId, trace, iQueryGeneralDataCallback);
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    public void getControlGroupFriendsDetailInfoWithUid(@NotNull String uid, @Nullable String trace, @NotNull hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, this, uid, trace, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        getReverseServiceImpl().getFriendsDetailInfoWithUid(uid, trace, iQueryGeneralDataCallback);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    public int getFriendCount(@Nullable String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return ((Integer) iPatchRedirector.redirect((short) 52, (Object) this, (Object) trace)).intValue();
        }
        return getAbsServiceImpl().getFriendCount(trace);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    @Nullable
    public ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> getFriendSimpleInfoWithUid(@NotNull ArrayList<String> uids, @Nullable String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (ArrayList) iPatchRedirector.redirect((short) 14, (Object) this, (Object) uids, (Object) trace);
        }
        Intrinsics.checkNotNullParameter(uids, "uids");
        return getAbsServiceImpl().getFriendSimpleInfoWithUid(uids, trace);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    @NotNull
    public List<com.tencent.qqnt.ntrelation.friendsinfo.bean.a> getFriendsCategoryBaseInfo(@Nullable String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 23)) ? getAbsServiceImpl().getFriendsCategoryBaseInfo(trace) : (List) iPatchRedirector.redirect((short) 23, (Object) this, (Object) trace);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    @Nullable
    public com.tencent.qqnt.ntrelation.friendsinfo.bean.b getFriendsCategoryInfo(@NotNull String categoryId, @Nullable String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (com.tencent.qqnt.ntrelation.friendsinfo.bean.b) iPatchRedirector.redirect((short) 25, (Object) this, (Object) categoryId, (Object) trace);
        }
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        return getAbsServiceImpl().getFriendsCategoryInfo(categoryId, trace);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    public void getFriendsDetailInfoWithUid(@NotNull String uid, @Nullable String trace, @NotNull hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, uid, trace, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        getAbsServiceImpl().getFriendsDetailInfoWithUid(uid, trace, iQueryGeneralDataCallback);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    @Nullable
    public com.tencent.qqnt.ntrelation.friendsinfo.bean.d getFriendsSimpleInfoWithUid(@NotNull String uid, @Nullable String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (com.tencent.qqnt.ntrelation.friendsinfo.bean.d) iPatchRedirector.redirect((short) 15, (Object) this, (Object) uid, (Object) trace);
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(uid);
        ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> friendSimpleInfoWithUid = getFriendSimpleInfoWithUid(arrayList, trace);
        if (friendSimpleInfoWithUid != null && (!friendSimpleInfoWithUid.isEmpty())) {
            return friendSimpleInfoWithUid.get(0);
        }
        return null;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    public void getGatheredFriendsCount(@Nullable String trace, @NotNull hx3.b<Integer> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) trace, (Object) iQueryGeneralDataCallback);
        } else {
            Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
            getAbsServiceImpl().getGatheredFriendsCount(trace, iQueryGeneralDataCallback);
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    @Nullable
    public ArrayList<String> getNickWithUid(@NotNull ArrayList<String> uids, @Nullable String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ArrayList) iPatchRedirector.redirect((short) 10, (Object) this, (Object) uids, (Object) trace);
        }
        Intrinsics.checkNotNullParameter(uids, "uids");
        return getAbsServiceImpl().getNickWithUid(uids, trace);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    @Nullable
    public ArrayList<String> getRemarkWithUid(@NotNull ArrayList<String> uids, @Nullable String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (ArrayList) iPatchRedirector.redirect((short) 12, (Object) this, (Object) uids, (Object) trace);
        }
        Intrinsics.checkNotNullParameter(uids, "uids");
        return getAbsServiceImpl().getRemarkWithUid(uids, trace);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    @Nullable
    public Integer getRingId(@NotNull String uid, @NotNull String trace) {
        String u16;
        Integer intOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return (Integer) iPatchRedirector.redirect((short) 53, (Object) this, (Object) uid, (Object) trace);
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(trace, "trace");
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = getFriendsSimpleInfoWithUid(uid, trace);
        if (friendsSimpleInfoWithUid != null && (u16 = friendsSimpleInfoWithUid.u()) != null) {
            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(u16);
            return intOrNull;
        }
        return null;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    public boolean getSpecialCareGlobalSwitch(@NotNull String uid, @NotNull String tag) {
        Boolean F;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return ((Boolean) iPatchRedirector.redirect((short) 49, (Object) this, (Object) uid, (Object) tag)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(tag, "tag");
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uid, tag);
        if (friendsSimpleInfoWithUid == null || (F = friendsSimpleInfoWithUid.F()) == null) {
            return false;
        }
        return F.booleanValue();
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    @Nullable
    public String getUidFromUin(@NotNull String uin) {
        List listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, (Object) uin);
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (!isValidUin(uin, TAG)) {
            if (com.tencent.qqnt.util.b.f362976b.isDebugVersion()) {
                new Exception(" getUidFromUin not valid uin:" + uin);
            }
            return null;
        }
        y f16 = com.tencent.qqnt.msg.f.f();
        if (f16 == null) {
            return null;
        }
        long parseLong = Long.parseLong(uin);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(Long.valueOf(parseLong));
        HashMap<Long, String> uidByUin = f16.getUidByUin(TAG, new ArrayList<>(listOf));
        if (uidByUin == null || !uidByUin.containsKey(Long.valueOf(parseLong))) {
            return null;
        }
        String str = uidByUin.get(Long.valueOf(parseLong));
        if (QLog.isColorLevel() && str == null) {
            QLog.d(TAG, 2, "uid == null uin " + uin);
        }
        return str;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    @Nullable
    public String getUinFromUid(@NotNull String uid) {
        List listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this, (Object) uid);
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        if (!isValidUid(uid, TAG)) {
            if (com.tencent.qqnt.util.b.f362976b.isDebugVersion()) {
                new Exception(" getUinFromUid not valid uid:" + uid);
            }
            return null;
        }
        y f16 = com.tencent.qqnt.msg.f.f();
        if (f16 != null) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(uid);
            HashMap<String, Long> uinByUid = f16.getUinByUid(TAG, new ArrayList<>(listOf));
            if (uinByUid == null || !uinByUid.containsKey(uid)) {
                return null;
            }
            Long l3 = uinByUid.get(uid);
            if (QLog.isColorLevel() && l3 == null) {
                QLog.d(TAG, 2, "uinL == null uid " + uid);
            }
            if (l3 == null) {
                return null;
            }
            return l3.toString();
        }
        return null;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    public void initFriendsInfoListener(@Nullable String trace, boolean forceInit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, trace, Boolean.valueOf(forceInit));
        } else {
            com.tencent.qqnt.ntrelation.friendsinfo.manager.c.f360050a.k(trace, forceInit);
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    public boolean isFriend(@NotNull String uid, @Nullable String trace) {
        Boolean isBuddy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return ((Boolean) iPatchRedirector.redirect((short) 45, (Object) this, (Object) uid, (Object) trace)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        QLog.i(TAG, 1, "isFriend trace " + trace);
        com.tencent.qqnt.kernel.api.m b16 = com.tencent.qqnt.msg.f.b();
        if (b16 == null || (isBuddy = b16.isBuddy(uid)) == null) {
            return false;
        }
        return isBuddy.booleanValue();
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    @NotNull
    public Map<String, Boolean> isFriends(@NotNull String callFrom, @NotNull ArrayList<String> uids) {
        Map<String, Boolean> emptyMap;
        Map<String, Boolean> areBuddies;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return (Map) iPatchRedirector.redirect((short) 46, (Object) this, (Object) callFrom, (Object) uids);
        }
        Intrinsics.checkNotNullParameter(callFrom, "callFrom");
        Intrinsics.checkNotNullParameter(uids, "uids");
        com.tencent.qqnt.kernel.api.m b16 = com.tencent.qqnt.msg.f.b();
        if (b16 == null || (areBuddies = b16.areBuddies(callFrom, uids)) == null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            return emptyMap;
        }
        return areBuddies;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    public void isGetFriendListSuc(@Nullable String trace, @NotNull hx3.b<Boolean> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, (Object) trace, (Object) iQueryGeneralDataCallback);
        } else {
            Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
            getAbsServiceImpl().isGetFriendListSuc(trace, iQueryGeneralDataCallback);
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    public boolean isHasFriend(@NotNull String uid, @NotNull String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return ((Boolean) iPatchRedirector.redirect((short) 51, (Object) this, (Object) uid, (Object) trace)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(trace, "trace");
        return getAbsServiceImpl().isHasFriend(uid, trace);
    }

    public final boolean isLogOpen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.isLogOpen;
    }

    public final boolean isNew() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.isNew;
    }

    public final boolean isOptSourceFrom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.isOptSourceFrom;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    public boolean isShieldFriend(@NotNull String uid, @NotNull String tag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return ((Boolean) iPatchRedirector.redirect((short) 48, (Object) this, (Object) uid, (Object) tag)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(tag, "tag");
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uid, tag);
        if (friendsSimpleInfoWithUid == null || (friendsSimpleInfoWithUid.o() & MULTI_FLAGS_MASK_SHIELD) <= 0) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    public boolean isValidUid(@NotNull String uid, @Nullable String trace) {
        boolean startsWith$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return ((Boolean) iPatchRedirector.redirect((short) 44, (Object) this, (Object) uid, (Object) trace)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        if (!TextUtils.isEmpty(uid)) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(uid, "u_", false, 2, null);
            if (!startsWith$default || !uidPattern.matcher(uid).matches()) {
                return false;
            }
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    public boolean isValidUin(@NotNull String uin, @Nullable String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return ((Boolean) iPatchRedirector.redirect((short) 43, (Object) this, (Object) uin, (Object) trace)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        try {
            if (Long.parseLong(uin) <= 10000) {
                return false;
            }
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    public void moveFriendToNewGroup(@Nullable String friendUid, int newGroupId, @Nullable String trace, @Nullable hx3.c<Boolean> iUpdateGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, this, friendUid, Integer.valueOf(newGroupId), trace, iUpdateGeneralDataCallback);
        } else {
            getAbsServiceImpl().moveFriendToNewGroup(friendUid, newGroupId, trace, iUpdateGeneralDataCallback);
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    public void moveGroup(int srcGroupId, int dstGroupId, @Nullable String trace, @Nullable hx3.b<Boolean> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, this, Integer.valueOf(srcGroupId), Integer.valueOf(dstGroupId), trace, iQueryGeneralDataCallback);
        } else {
            getAbsServiceImpl().moveGroup(srcGroupId, dstGroupId, trace, iQueryGeneralDataCallback);
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    public void normal2UnComUsed(@Nullable String trace, @NotNull List<String> uidList, @Nullable hx3.b<Boolean> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, this, trace, uidList, iQueryGeneralDataCallback);
        } else {
            Intrinsics.checkNotNullParameter(uidList, "uidList");
            getAbsServiceImpl().normal2UnComUsed(trace, uidList, iQueryGeneralDataCallback);
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    public void requestAllCategoriesInfo(@Nullable String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) trace);
        } else {
            getAbsServiceImpl().requestAllCategoriesInfo(trace);
            getReverseServiceImpl().requestAllCategoriesInfo(trace);
        }
    }

    public final void setLogOpen(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.isLogOpen = z16;
        }
    }

    public final void setOptSourceFrom(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.isOptSourceFrom = z16;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    public void unregisterFriendCategoryInfoCallback(@Nullable String trace, @NotNull hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) trace, (Object) iQueryGeneralDataCallback);
        } else {
            Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
            unregisterFriendCategoryInfoV2Callback(RelationListReqType.NORMAL, trace, iQueryGeneralDataCallback);
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    public void unregisterFriendCategoryInfoV2Callback(@NotNull RelationListReqType reqType, @Nullable String trace, @NotNull hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, reqType, trace, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(reqType, "reqType");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        getAbsServiceImpl().unregisterFriendCategoryInfoV2Callback(reqType, trace, iQueryGeneralDataCallback);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    @Nullable
    public com.tencent.qqnt.ntrelation.friendsinfo.bean.a getFriendsCategoryBaseInfo(@NotNull String categoryId, @Nullable String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (com.tencent.qqnt.ntrelation.friendsinfo.bean.a) iPatchRedirector.redirect((short) 24, (Object) this, (Object) categoryId, (Object) trace);
        }
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        return getAbsServiceImpl().getFriendsCategoryBaseInfo(categoryId, trace);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    public void getFriendsDetailInfoWithUid(@NotNull ArrayList<String> uidList, @Nullable String trace, @NotNull hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, uidList, trace, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uidList, "uidList");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        getAbsServiceImpl().getFriendsDetailInfoWithUid(uidList, trace, iQueryGeneralDataCallback);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    @Nullable
    public String getNickWithUid(@NotNull String uid, @Nullable String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this, (Object) uid, (Object) trace);
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        return getAbsServiceImpl().getNickWithUid(uid, trace);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    @Nullable
    public String getRemarkWithUid(@NotNull String uid, @Nullable String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this, (Object) uid, (Object) trace);
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        return getAbsServiceImpl().getRemarkWithUid(uid, trace);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    public void getFriendsDetailInfoWithUid(@NotNull String uid, boolean isObserver, @Nullable String trace, @NotNull hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, uid, Boolean.valueOf(isObserver), trace, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        if (isObserver) {
            com.tencent.qqnt.ntrelation.friendsinfo.manager.c.f360050a.m(uid, trace, iQueryGeneralDataCallback);
        }
        getAbsServiceImpl().getFriendsDetailInfoWithUid(uid, trace, iQueryGeneralDataCallback);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    public void isFriend(@NotNull String uid, @NotNull String tag, @NotNull hx3.b<Boolean> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, this, uid, tag, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        getAbsServiceImpl().isFriend(uid, tag, iQueryGeneralDataCallback);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService
    public void accurateUpdateNTFriendSimpleInfo(@NotNull ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> ntFriendSimpleInfoList, @Nullable String trace, @Nullable hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> updateCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, ntFriendSimpleInfoList, trace, updateCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(ntFriendSimpleInfoList, "ntFriendSimpleInfoList");
        ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> arrayList = new ArrayList<>();
        for (com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar : ntFriendSimpleInfoList) {
            com.tencent.qqnt.ntrelation.friendsinfo.bean.c cVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.c();
            cVar.M();
            simpleInfo2DetailInfo(cVar, dVar);
            arrayList.add(cVar);
        }
        accurateUpdateNTFriendDetailInfo(arrayList, trace, new b(updateCallback, ntFriendSimpleInfoList));
    }
}
