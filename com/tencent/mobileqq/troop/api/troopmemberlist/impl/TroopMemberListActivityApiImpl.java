package com.tencent.mobileqq.troop.api.troopmemberlist.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.troop.EditUniqueTitleActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.profile.l;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi;
import com.tencent.mobileqq.troop.api.troopmemberlist.d;
import com.tencent.mobileqq.troop.file.api.ITroopFileApi;
import com.tencent.mobileqq.troop.selecttroopmember.ISelectTroopMemberStarter;
import com.tencent.mobileqq.troop.utils.ak;
import com.tencent.mobileqq.troop.utils.al;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.utils.ff;
import com.tencent.mobileqq.vas.f;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.widget.ListView;
import cooperation.qzone.QZoneHelper;
import n33.c;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopMemberListActivityApiImpl implements ITroopMemberListActivityApi {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a extends ak {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ITroopMemberListActivityApi.a f294332a;

        a(ITroopMemberListActivityApi.a aVar) {
            this.f294332a = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMemberListActivityApiImpl.this, (Object) aVar);
            }
        }

        @Override // com.tencent.mobileqq.troop.utils.ak
        public void a(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
                return;
            }
            ITroopMemberListActivityApi.a aVar = this.f294332a;
            if (aVar != null) {
                aVar.a(i3, str);
            }
        }

        @Override // com.tencent.mobileqq.troop.utils.ak
        public void e(long[] jArr, long[] jArr2, long[] jArr3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, jArr, jArr2, jArr3);
                return;
            }
            ITroopMemberListActivityApi.a aVar = this.f294332a;
            if (aVar != null) {
                aVar.b(jArr, jArr2, jArr3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class b extends ar {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f294334d;

        b(d dVar) {
            this.f294334d = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMemberListActivityApiImpl.this, (Object) dVar);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateAnswerAddedFriend(boolean z16, String str, int i3) {
            d dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, Integer.valueOf(i3));
            } else if (z16 && (dVar = this.f294334d) != null) {
                dVar.a(z16, str, i3);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onUpdateFriendList(boolean z16, boolean z17) {
            d dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            } else if (z16 && z17 && (dVar = this.f294334d) != null) {
                dVar.b(z16, z17);
            }
        }
    }

    public TroopMemberListActivityApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi
    public void clothEffectView(Context context, ViewGroup viewGroup, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, context, viewGroup, Integer.valueOf(i3), str);
        } else {
            new c().c(context, viewGroup, i3, str);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi
    public SpannableString createColorNickText(CharSequence charSequence, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (SpannableString) iPatchRedirector.redirect((short) 13, (Object) this, (Object) charSequence, i3);
        }
        return new com.tencent.mobileqq.text.c(charSequence, i3).j();
    }

    @Override // com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi
    public String getAccountNickName(AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this, (Object) appInterface, (Object) str);
        }
        return ac.f((QQAppInterface) appInterface, str);
    }

    @Override // com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi
    public com.tencent.mobileqq.troop.api.troopmemberlist.a getAddFrdStateMngProxy(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (com.tencent.mobileqq.troop.api.troopmemberlist.a) iPatchRedirector.redirect((short) 25, (Object) this, (Object) appInterface);
        }
        return new com.tencent.mobileqq.troop.api.troopmemberlist.impl.a((QQAppInterface) appInterface);
    }

    @Override // com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi
    public int getBigClubFlag(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this, i3)).intValue();
        }
        return ff.f(i3);
    }

    @Override // com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi
    public String getConfigContentForTag(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (String) iPatchRedirector.redirect((short) 26, (Object) this, (Object) str, (Object) str2);
        }
        return com.tencent.mobileqq.config.c.b(str, AppConstants.Preferences.TROOP_MEMBER_LIST_CONFIG);
    }

    @Override // com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi
    public int getCurrentUserVipType(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this, (Object) appInterface)).intValue();
        }
        return ((ISVIPHandler) appInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).getCurrentUserVipType();
    }

    @Override // com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi
    public Drawable getDefaultTroopFaceDrawableNew() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (Drawable) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return BaseImageUtil.getDefaultTroopFaceDrawableNew();
    }

    @Override // com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi
    public com.tencent.mobileqq.troop.api.troopmemberlist.c getFacePreloadBaseAdapterProxy(com.tencent.mobileqq.troop.api.troopmemberlist.b bVar, Context context, AppInterface appInterface, Object obj, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mobileqq.troop.api.troopmemberlist.c) iPatchRedirector.redirect((short) 6, this, bVar, context, appInterface, obj, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
        return new com.tencent.mobileqq.troop.api.troopmemberlist.impl.b(bVar, context, (QQAppInterface) appInterface, (ListView) obj, i3, z16);
    }

    @Override // com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi
    public Object getFriendListObserverForAddFrd(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return iPatchRedirector.redirect((short) 27, (Object) this, (Object) dVar);
        }
        return new b(dVar);
    }

    @Override // com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi
    public int getVipTypeByFlag(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this, i3)).intValue();
        }
        return ff.u(i3);
    }

    @Override // com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi
    public void handleRichLevel(int i3, byte b16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Integer.valueOf(i3), Byte.valueOf(b16), obj);
        } else {
            new c().d(i3, b16, (com.tencent.mobileqq.troop.troopmemberlevel.a) obj);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi
    public void handleRichLevelWithParsedTag(int i3, int i16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Integer.valueOf(i3), Integer.valueOf(i16), obj);
        } else {
            new c().e(i3, i16, (com.tencent.mobileqq.troop.troopmemberlevel.a) obj);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi
    public int hrExtra(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, j3)).intValue();
        }
        return QAVHrMeeting.j(j3);
    }

    @Override // com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi
    public boolean isHRConf(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, j3)).booleanValue();
        }
        return QAVHrMeeting.k(j3);
    }

    @Override // com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi
    public boolean isNoRight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, i3)).booleanValue();
        }
        return QAVHrMeeting.m(i3);
    }

    @Override // com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi
    public boolean isPSTNConf(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, j3)).booleanValue();
        }
        return QAVHrMeeting.n(j3);
    }

    @Override // com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi
    public void openTroopFileBrowserActivity(Activity activity, String str, String str2, String str3, String str4, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, activity, str, str2, str3, str4, Integer.valueOf(i3));
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(QZoneHelper.Constants.KEY_QUN_ID, str);
        intent.putExtra("filter_member_name", str2);
        intent.putExtra("filter_uin", Long.valueOf(str3));
        intent.putExtra("folderPath", "/");
        intent.putExtra(ISelectMemberActivityConstants.PARAM_FROM, 6000);
        intent.putExtra("key_source", i3);
        ((ITroopFileApi) QRoute.api(ITroopFileApi.class)).openTroopFileMainPage(activity, intent, 0);
    }

    @Override // com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi
    public void openTroopmemberCard(AppInterface appInterface, Context context, String str, String str2, int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, appInterface, context, str, str2, Integer.valueOf(i3), bundle);
        } else {
            l.e((QQAppInterface) appInterface, context, str, str2, 1, i3, bundle);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi
    public void reportDC00087(AppInterface appInterface, String str, String str2, String str3, String str4, String str5, String str6) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, appInterface, str, str2, str3, str4, str5, str6);
        } else {
            hl0.a.b(appInterface, str, str2, str3, str4, str5, str6);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi
    public void requestGiftMemberList(AppInterface appInterface, String str, ITroopMemberListActivityApi.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, appInterface, str, aVar);
        } else {
            ((al) appInterface.getManager(QQManagerFactory.TROOP_GIFT_MANAGER)).g(str, new a(aVar));
        }
    }

    @Override // com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi
    public void setColorText(AppInterface appInterface, TextView textView, Spannable spannable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, appInterface, textView, spannable);
        } else {
            f.s((QQAppInterface) appInterface, textView, spannable, 0, false, true);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi
    public void setCustomCloth(TextView textView, Context context, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, textView, context, Integer.valueOf(i3), Boolean.valueOf(z16));
        } else {
            com.tencent.mobileqq.vas.troopnick.a.c(textView, context, i3, z16, true);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi
    public void startEditUniqueTitleActivity(Activity activity, String str, String str2, int i3, String str3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, activity, str, str2, Integer.valueOf(i3), str3, Integer.valueOf(i16));
        } else {
            activity.startActivityForResult(EditUniqueTitleActivity.J2(activity, 1, str, str2, i3, str3), i16);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi
    public void startSelectMemberActivity(Activity activity, String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, activity, str, str2, Integer.valueOf(i3));
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(ISelectMemberActivityConstants.PARAM_FROM, 30);
        intent.putExtra("group_uin", str);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_GROUPCODE, str2);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_FROM, 30);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_SUBTYPE, 4);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_ENTRANCE, 30);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_MAX, i3);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_EXIT_ANIMATION, 3);
        ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivity(activity, intent);
    }

    @Override // com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi
    public void startSelectTroopMemberFragment(Activity activity, boolean z16, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) {
            startSelectTroopMemberFragment(activity, z16, 1, str, i3);
        } else {
            iPatchRedirector.redirect((short) 22, this, activity, Boolean.valueOf(z16), str, Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi
    public void startSelectTroopMemberFragment(Activity activity, boolean z16, int i3, String str, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 23)) {
            ((ISelectTroopMemberStarter) QRoute.api(ISelectTroopMemberStarter.class)).startForResult(activity, z16, i3, str, i16);
        } else {
            iPatchRedirector.redirect((short) 23, this, activity, Boolean.valueOf(z16), Integer.valueOf(i3), str, Integer.valueOf(i16));
        }
    }
}
