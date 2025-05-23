package com.tencent.qqnt.kernel.api;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.qqnt.kernel.nativeinterface.AnchorPointContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.ContactThirdPartyBusinessInfos;
import com.tencent.qqnt.kernel.nativeinterface.ContactTopData;
import com.tencent.qqnt.kernel.nativeinterface.EnterOrExitMsgListInfo;
import com.tencent.qqnt.kernel.nativeinterface.GameMsgBoxConfig;
import com.tencent.qqnt.kernel.nativeinterface.IGetContactsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactListener;
import com.tencent.qqnt.kernel.nativeinterface.IKernelRecentGetContactCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelRecentJumpCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelRecentSnapShotCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactData;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactJumpInfoVer2;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactListChangedInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.raft.codegenmeta.utils.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00d4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 X2\u00020\u0001:\u00015J:\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH&J\u001a\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000fH&J$\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000b0\u0011H&J$\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000b0\u0011H&J$\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000b0\u0011H&J$\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000b0\u0011H&J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0018H&J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0018H&J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u001bH&J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u001bH&J*\u0010#\u001a\u00020\u000b2\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` 2\b\u0010\"\u001a\u0004\u0018\u00010\tH'J*\u0010%\u001a\u00020\u000b2\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020$0\u001ej\b\u0012\u0004\u0012\u00020$` 2\b\u0010\"\u001a\u0004\u0018\u00010\tH&J\u0012\u0010&\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010\tH&J\u0012\u0010(\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010'H&J\u001c\u0010+\u001a\u00020\u000b2\b\u0010)\u001a\u0004\u0018\u00010$2\b\u0010*\u001a\u0004\u0018\u00010\tH&J\u001c\u0010.\u001a\u00020\u000b2\b\u0010-\u001a\u0004\u0018\u00010,2\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\u001a\u00103\u001a\u00020\u000b2\u0006\u00100\u001a\u00020/2\b\u00102\u001a\u0004\u0018\u000101H&J\u0010\u00105\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u000104H'J\u0018\u00106\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u0001042\u0006\u0010\u0007\u001a\u00020\u0006H'J\u0012\u00107\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u00109\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u000208H&J\u0018\u0010;\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020:H&J\u0010\u0010<\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010>\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\u0006H\u0016J\u0014\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060?H&J\u0018\u0010B\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020$2\u0006\u0010\n\u001a\u00020AH&J\u001e\u0010D\u001a\u00020\u000b2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020$042\u0006\u0010\n\u001a\u00020AH&J\u001a\u0010G\u001a\u00020\u000b2\u0006\u0010F\u001a\u00020E2\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\u0019\u0010H\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a2\u0006\u0004\bH\u0010IJ$\u0010L\u001a\u00020\u000b2\u0010\u0010K\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010J\u0018\u00010\u001e2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J2\u0010P\u001a\u00020\u000b2\u0006\u0010M\u001a\u00020\u00042\u0016\u0010O\u001a\u0012\u0012\u0004\u0012\u00020N0\u001ej\b\u0012\u0004\u0012\u00020N` 2\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\u0012\u0010Q\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u000e\u0010T\u001a\b\u0012\u0004\u0012\u00020S0RH&J2\u0010W\u001a\u00020\u000b2\u001e\u0010V\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010U\u0018\u00010\u001ej\f\u0012\u0006\u0012\u0004\u0018\u00010U\u0018\u0001` 2\b\u0010\n\u001a\u0004\u0018\u00010\tH&\u00a8\u0006Y"}, d2 = {"Lcom/tencent/qqnt/kernel/api/aa;", "Lcom/tencent/qqnt/kernel/api/j;", "Lcom/tencent/qqnt/kernel/nativeinterface/AnchorPointContactInfo;", "anchor", "", "fetchOld", "", "listType", "count", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "callback", "", "v", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactJumpInfoVer2;", "lastInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelRecentJumpCallback;", "jumpToSpecifyRecentContactVer2", "Lkotlin/Function1;", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactListChangedInfo;", "listener", "g0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "s0", "u0", "Lcom/tencent/qqnt/kernel/invorker/d;", "addExpandRecentContactListener", "removeExpandRecentContactListener", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelRecentContactListener;", "l", "b0", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "Lkotlin/collections/ArrayList;", "deleteList", "cb", "deleteRecentContacts", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "a0", "clearRecentContacts", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelRecentGetContactCallback;", "getRecentContactInfos", "peer", "result", "addRecentContact", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactData;", "contact", "upsertRecentContactManually", "", "status", "", "guildId", "setGuildDisplayStatus", "", "a", "M", "i", "Lcom/tencent/qqnt/kernel/invorker/c;", "e0", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelRecentSnapShotCallback;", "getRecentContactListSnapShot", "getUnreadCountByListType", "chatType", "getUnreadCountNoiseByChatType", "", "getUnreadCountNoiseMap", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetContactsCallback;", "F0", "contacts", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/EnterOrExitMsgListInfo;", "enterOrExitInfo", "enterOrExitMsgList", "c0", "(Ljava/lang/Integer;)V", "Lcom/tencent/qqnt/kernel/nativeinterface/GameMsgBoxConfig;", Constants.Configs.CONFIGS, "updateGameMsgConfigs", "isTop", "Lcom/tencent/qqnt/kernel/nativeinterface/ContactTopData;", "contactList", "setContactListTop", "setAllGameMsgRead", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/qqnt/kernel/data/a;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/qqnt/kernel/nativeinterface/ContactThirdPartyBusinessInfos;", "contactsThirdPartyBusinessInfos", "setThirdPartyBusinessInfos", "w4", "kernel_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface aa extends j {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: w4, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/kernel/api/aa$a;", "", "<init>", "()V", "kernel_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.kernel.api.aa$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f357231a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40392);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f357231a = new Companion();
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public static final class b {
        public static /* synthetic */ void a(aa aaVar, AnchorPointContactInfo anchorPointContactInfo, boolean z16, int i3, int i16, IOperateCallback iOperateCallback, int i17, Object obj) {
            if (obj == null) {
                if ((i17 & 2) != 0) {
                    z16 = false;
                }
                boolean z17 = z16;
                if ((i17 & 4) != 0) {
                    i3 = 1;
                }
                int i18 = i3;
                if ((i17 & 8) != 0) {
                    i16 = 200;
                }
                int i19 = i16;
                if ((i17 & 16) != 0) {
                    iOperateCallback = null;
                }
                aaVar.v(anchorPointContactInfo, z17, i18, i19, iOperateCallback);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetchRecentContactInfo");
        }
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(40399), (Class<?>) aa.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            INSTANCE = Companion.f357231a;
        }
    }

    void F0(@NotNull Contact contact, @NotNull IGetContactsCallback callback);

    @Deprecated(message = "\u67e5\u627e\u8282\u70b9\u540e\u7eed\u901a\u8fc7findContact\u8fdb\u884c\uff0c\u6b64\u5904\u6570\u636e\u4e0d\u51c6", replaceWith = @ReplaceWith(expression = "findContact", imports = {}))
    @Nullable
    List<RecentContactInfo> M(int listType);

    @NotNull
    Flow<com.tencent.qqnt.kernel.data.a> Q();

    @Deprecated(message = "\u67e5\u627e\u8282\u70b9\u540e\u7eed\u901a\u8fc7findContact\u8fdb\u884c\uff0c\u6b64\u5904\u6570\u636e\u4e0d\u51c6", replaceWith = @ReplaceWith(expression = "findContact", imports = {}))
    @Nullable
    List<RecentContactInfo> a();

    void a0(@NotNull ArrayList<Contact> deleteList, @Nullable IOperateCallback cb5);

    void addExpandRecentContactListener(@NotNull com.tencent.qqnt.kernel.invorker.d listener);

    void addRecentContact(@Nullable Contact peer, @Nullable IOperateCallback result);

    void b0(@NotNull IKernelRecentContactListener listener);

    void c0(@Nullable Integer listType);

    void clearRecentContacts(@Nullable IOperateCallback cb5);

    void d(@NotNull List<Contact> contacts, @NotNull IGetContactsCallback callback);

    @Deprecated(message = "\u5e9f\u5f03, \u4f7f\u7528deleteRecentContactsV2")
    void deleteRecentContacts(@NotNull ArrayList<RecentContactInfo> deleteList, @Nullable IOperateCallback cb5);

    void e0(@NotNull com.tencent.qqnt.kernel.invorker.c listener);

    void enterOrExitMsgList(@NotNull EnterOrExitMsgListInfo enterOrExitInfo, @Nullable IOperateCallback callback);

    void g0(int listType, @NotNull Function1<? super RecentContactListChangedInfo, Unit> listener);

    void getRecentContactInfos(@Nullable IKernelRecentGetContactCallback cb5);

    void getRecentContactListSnapShot(int count, @NotNull IKernelRecentSnapShotCallback callback);

    int getUnreadCountByListType(int listType);

    int getUnreadCountNoiseByChatType(int chatType);

    @NotNull
    Map<Integer, Integer> getUnreadCountNoiseMap();

    @Nullable
    RecentContactListChangedInfo i(int listType);

    void jumpToSpecifyRecentContactVer2(@NotNull RecentContactJumpInfoVer2 lastInfo, @Nullable IKernelRecentJumpCallback callback);

    void l(@NotNull IKernelRecentContactListener listener);

    void m(int listType, @NotNull Function1<? super RecentContactListChangedInfo, Unit> listener);

    void removeExpandRecentContactListener(@NotNull com.tencent.qqnt.kernel.invorker.d listener);

    void s0(int listType, @NotNull Function1<? super RecentContactListChangedInfo, Unit> listener);

    void setAllGameMsgRead(@Nullable IOperateCallback callback);

    void setContactListTop(boolean isTop, @NotNull ArrayList<ContactTopData> contactList, @Nullable IOperateCallback callback);

    void setGuildDisplayStatus(long status, @Nullable String guildId);

    void setThirdPartyBusinessInfos(@Nullable ArrayList<ContactThirdPartyBusinessInfos> contactsThirdPartyBusinessInfos, @Nullable IOperateCallback callback);

    void u0(int listType, @NotNull Function1<? super RecentContactListChangedInfo, Unit> listener);

    void updateGameMsgConfigs(@Nullable ArrayList<GameMsgBoxConfig> configs, @Nullable IOperateCallback callback);

    void upsertRecentContactManually(@Nullable RecentContactData contact, @Nullable IOperateCallback callback);

    void v(@NotNull AnchorPointContactInfo anchor, boolean fetchOld, int listType, int count, @Nullable IOperateCallback callback);
}
