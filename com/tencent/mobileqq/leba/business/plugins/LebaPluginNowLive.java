package com.tencent.mobileqq.leba.business.plugins;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.leba.entity.BaseLebaPluginItem;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlivehall.iv.api.hall.IQQIvLiveEntranceApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.redtouch.RedTypeInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x791.oidb_0x791$RedDotInfo;

@KeepClassConstructor
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001*B\u0007\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J \u0010\u0011\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016Jb\u0010$\u001a\u00020\u00122\b\u0010\u0007\u001a\u0004\u0018\u00010\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0018\u0010!\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0012\u0006\u0012\u0004\u0018\u00010 \u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0012H\u0016R\u0014\u0010&\u001a\u00020\u001b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/leba/business/plugins/LebaPluginNowLive;", "Lcom/tencent/mobileqq/leba/entity/BaseLebaPluginItem;", "", ExifInterface.LATITUDE_SOUTH, "", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "redTouch", "T", "Landroid/view/View;", "v", "Lcom/tencent/mobileqq/leba/entity/n;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/leba/entity/f;", CacheTable.TABLE_NAME, "H", "", "tabChange", "style", "I", "Lcom/tencent/mobileqq/redtouch/RedTypeInfo;", "w", "Lmqq/app/AppRuntime;", "Landroid/content/Context;", "context", "", "resID", "", "resPkgName", "", "Lcom/tencent/mobileqq/leba/entity/g;", "redTouchHistory", "index", "isTableModel", "y", "()J", "resId", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class LebaPluginNowLive extends BaseLebaPluginItem {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/leba/business/plugins/LebaPluginNowLive$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.leba.business.plugins.LebaPluginNowLive$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58711);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public LebaPluginNowLive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final int R() {
        int i3;
        int coerceAtMost;
        Manager manager = MobileQQ.sMobileQQ.peekAppRuntime().getManager(QQManagerFactory.MGR_RED_TOUCH_EX);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.biz.TroopRedpoint.TroopRedTouchManager");
        oidb_0x791$RedDotInfo p16 = ((TroopRedTouchManager) manager).p();
        if (p16 != null && p16.uint32_appid.get() == 52) {
            i3 = p16.uint32_number.get();
        } else {
            i3 = 0;
        }
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(i3, 0);
        return coerceAtMost;
    }

    private final void S() {
        Manager manager = MobileQQ.sMobileQQ.peekAppRuntime().getManager(QQManagerFactory.MGR_RED_TOUCH_EX);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.biz.TroopRedpoint.TroopRedTouchManager");
        id0.a.n(TabPreloadItem.TAB_NAME_DYNAMIC, "clk_story", 0, ((TroopRedTouchManager) manager).r(), new String[0]);
    }

    private final void T(QQAppInterface app, RedTouch redTouch) {
        String str;
        String sb5;
        if (redTouch == null) {
            return;
        }
        Manager manager = app.getManager(QQManagerFactory.MGR_RED_TOUCH_EX);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.biz.TroopRedpoint.TroopRedTouchManager");
        TroopRedTouchManager troopRedTouchManager = (TroopRedTouchManager) manager;
        oidb_0x791$RedDotInfo p16 = troopRedTouchManager.p();
        if (p16 == null) {
            redTouch.clearRedTouch();
            return;
        }
        int i3 = 0;
        id0.a.n(TabPreloadItem.TAB_NAME_DYNAMIC, "exp_story", 0, troopRedTouchManager.q(), new String[0]);
        BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
        BusinessInfoCheckUpdate.AppInfo appInfo = new BusinessInfoCheckUpdate.AppInfo();
        int i16 = p16.uint32_appid.get();
        if (i16 != 8) {
            if (i16 != 11) {
                if (i16 != 35) {
                    if (i16 != 37) {
                        if (i16 != 52) {
                            i3 = -1;
                        } else {
                            PBStringField pBStringField = redTypeInfo.red_content;
                            if (p16.uint32_number.get() > 99) {
                                sb5 = "99+";
                            } else {
                                int i17 = p16.uint32_number.get();
                                StringBuilder sb6 = new StringBuilder();
                                sb6.append(i17);
                                sb5 = sb6.toString();
                            }
                            pBStringField.set(sb5);
                            redTypeInfo.red_desc.set("{'cn':'#FF0000'}");
                        }
                    } else {
                        try {
                            str = new JSONObject(p16.str_custom_buffer.get().toStringUtf8()).getString("red_word");
                        } catch (Exception e16) {
                            hd0.c.v("LebaPluginNowLive", "tag red dot json parse error , %s", e16.getMessage());
                            str = "New";
                        }
                        redTypeInfo.red_content.set(str);
                        redTypeInfo.red_desc.set("{'cn':'#00000000' ,'cr':'#777777'}");
                    }
                } else {
                    String stringUtf8 = p16.str_custom_buffer.get().toStringUtf8();
                    if (!TextUtils.isEmpty(stringUtf8)) {
                        try {
                            long optLong = new JSONObject(stringUtf8).optLong("image_red_display_780", 1L);
                            hd0.c.i("LebaPluginNowLive", "updateStoryRedTouch() APPID_STORY_IMG: red display=%d", Long.valueOf(optLong));
                            if (optLong == 0) {
                                redTouch.clearRedTouch();
                                return;
                            }
                        } catch (JSONException e17) {
                            hd0.c.h("LebaPluginNowLive", "updateStoryRedTouch() APPID_STORY_IMG: Error parse json: ", e17);
                        }
                    } else {
                        hd0.c.a("LebaPluginNowLive", "updateStoryRedTouch() APPID_STORY_IMG: str_custom_buffer is null");
                    }
                    int i18 = p16.uint32_cmd_uin_type.get();
                    String str2 = "{'av':1, 'dot':1}";
                    if (i18 != 0) {
                        if (i18 != 1) {
                            return;
                        }
                        redTypeInfo.red_content.set(ITroopAvatarUtilApi.REGEXP_URL_STRING + p16.uint64_cmd_uin.get() + "/" + p16.uint64_cmd_uin.get() + "/100?t=" + TroopRedTouchManager.F);
                        redTypeInfo.red_desc.set("{'av':1, 'dot':1}");
                    } else {
                        String stringUtf82 = p16.str_face_url.get().toStringUtf8();
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        long j3 = p16.uint64_cmd_uin.get();
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append(j3);
                        String format = String.format("{'uin':'%s','dot':1, 'av':1}", Arrays.copyOf(new Object[]{sb7.toString()}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                        if (!TextUtils.isEmpty(stringUtf82)) {
                            redTypeInfo.red_content.set(stringUtf82);
                        } else {
                            str2 = format;
                        }
                        redTypeInfo.red_desc.set(str2);
                    }
                    i3 = 3;
                }
            } else {
                redTypeInfo.red_content.set(p16.str_custom_buffer.get().toStringUtf8());
                redTypeInfo.red_desc.set("{'cn':'#FF0000'}");
            }
            i3 = 4;
        }
        if (i3 == -1) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("storyRedDotDebug", 2, "\u66f4\u65b0\u52a8\u6001\u7ea2\u70b9:" + TroopRedTouchManager.y(p16));
        }
        redTypeInfo.red_type.set(i3);
        appInfo.red_display_info.red_type_info.add(redTypeInfo);
        appInfo.iNewFlag.set(1);
        redTouch.parseRedTouch(redTypeInfo);
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public void H(@NotNull View v3, @NotNull com.tencent.mobileqq.leba.entity.n item, @NotNull com.tencent.mobileqq.leba.entity.f reportInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, v3, item, reportInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(reportInfo, "reportInfo");
        S();
        super.H(v3, item, reportInfo);
        BusinessInfoCheckUpdate.AppInfo n3 = n();
        if (n3 != null) {
            IQQIvLiveEntranceApi iQQIvLiveEntranceApi = (IQQIvLiveEntranceApi) QRoute.api(IQQIvLiveEntranceApi.class);
            Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
            iQQIvLiveEntranceApi.dealDynamicLiveRedTouch(applicationContext, (QQAppInterface) peekAppRuntime, n3);
        }
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public void I(boolean tabChange, int style) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(tabChange), Integer.valueOf(style));
            return;
        }
        super.I(tabChange, style);
        Manager manager = MobileQQ.sMobileQQ.peekAppRuntime().getManager(QQManagerFactory.MGR_RED_TOUCH_EX);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.biz.TroopRedpoint.TroopRedTouchManager");
        id0.a.n(TabPreloadItem.TAB_NAME_DYNAMIC, "exp_story", 0, ((TroopRedTouchManager) manager).r(), new String[0]);
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public long v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return 6282L;
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    @Nullable
    public RedTypeInfo w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (RedTypeInfo) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        int R = R();
        if (R > 0) {
            RedTypeInfo redTypeInfo = new RedTypeInfo();
            redTypeInfo.setRedType(5);
            redTypeInfo.setRedContent(String.valueOf(R));
            return redTypeInfo;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public boolean y(@Nullable AppRuntime app, @Nullable Context context, long resID, @Nullable RedTouch redTouch, @Nullable String resPkgName, @Nullable Map<Long, ? extends com.tencent.mobileqq.leba.entity.g> redTouchHistory, int index, boolean isTableModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, app, context, Long.valueOf(resID), redTouch, resPkgName, redTouchHistory, Integer.valueOf(index), Boolean.valueOf(isTableModel))).booleanValue();
        }
        if (!(app instanceof QQAppInterface)) {
            return false;
        }
        T((QQAppInterface) app, redTouch);
        L(v(), redTouch);
        return true;
    }
}
