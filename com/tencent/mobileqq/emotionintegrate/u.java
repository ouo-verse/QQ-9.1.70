package com.tencent.mobileqq.emotionintegrate;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase;
import com.tencent.mobileqq.emosm.api.ICameraEmotionRoamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emoticonview.CameraEmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.IFavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.GenericDeclaration;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes12.dex */
public class u extends p {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public EmoticonInfo f205296a;

    public u(EmoticonInfo emoticonInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) emoticonInfo);
        } else {
            this.f205296a = emoticonInfo;
        }
    }

    public p A(Bundle bundle) {
        GenericDeclaration genericDeclaration;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (p) iPatchRedirector.redirect((short) 23, (Object) this, (Object) bundle);
        }
        if (bundle.containsKey("cur_emotion_id")) {
            QLog.d("FavEmoticonPreviewData", 1, "doRestoreSaveInstanceState");
            int i3 = bundle.getInt("cur_emotion_type");
            int i16 = bundle.getInt("cur_emotion_id");
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime instanceof QQAppInterface) {
                QQAppInterface qQAppInterface = (QQAppInterface) runtime;
                if (i3 == 1) {
                    genericDeclaration = ICameraEmotionRoamingDBManagerService.class;
                } else {
                    genericDeclaration = IFavroamingDBManagerService.class;
                }
                CustomEmotionRoamingDBManagerBase customEmotionRoamingDBManagerBase = (CustomEmotionRoamingDBManagerBase) qQAppInterface.getRuntimeService(genericDeclaration);
                List<CustomEmotionBase> emoticonDataList = customEmotionRoamingDBManagerBase.getEmoticonDataList();
                if (emoticonDataList != null && !emoticonDataList.isEmpty()) {
                    for (CustomEmotionBase customEmotionBase : emoticonDataList) {
                        if (customEmotionBase.emoId == i16) {
                            return new u(customEmotionRoamingDBManagerBase.convertEmotionDataToInfo(customEmotionBase, qQAppInterface));
                        }
                    }
                    return null;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.emotionintegrate.p
    public CustomEmotionData a() {
        List<CustomEmotionData> emoticonDataList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (CustomEmotionData) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        Parcelable parcelable = this.f205296a;
        if ((parcelable instanceof FavoriteEmoticonInfo) && ((IFavoriteEmoticonInfo) parcelable).getResID() != null) {
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if ((runtime instanceof QQAppInterface) && (emoticonDataList = ((IFavroamingDBManagerService) ((QQAppInterface) runtime).getRuntimeService(IFavroamingDBManagerService.class)).getEmoticonDataList()) != null) {
                for (CustomEmotionData customEmotionData : emoticonDataList) {
                    if (((IFavoriteEmoticonInfo) this.f205296a).getResID().equalsIgnoreCase(customEmotionData.resid)) {
                        return customEmotionData;
                    }
                }
                return null;
            }
            return null;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.emotionintegrate.p
    public int b(List<p> list) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) list)).intValue();
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            p pVar = list.get(i3);
            if (pVar instanceof u) {
                Parcelable parcelable = ((u) pVar).f205296a;
                if ((parcelable instanceof FavoriteEmoticonInfo) && (this.f205296a instanceof FavoriteEmoticonInfo)) {
                    IFavoriteEmoticonInfo iFavoriteEmoticonInfo = (IFavoriteEmoticonInfo) parcelable;
                    String url = iFavoriteEmoticonInfo.getUrl();
                    String url2 = ((IFavoriteEmoticonInfo) this.f205296a).getUrl();
                    if (url != null && url.equals(url2)) {
                        return i3;
                    }
                    String path = iFavoriteEmoticonInfo.getPath();
                    String path2 = ((IFavoriteEmoticonInfo) this.f205296a).getPath();
                    if (path != null && path.equals(path2)) {
                        return i3;
                    }
                } else if ((parcelable instanceof IPicEmoticonInfo) && (this.f205296a instanceof IPicEmoticonInfo)) {
                    Emoticon emoticon = ((IPicEmoticonInfo) parcelable).getEmoticon();
                    Emoticon emoticon2 = ((IPicEmoticonInfo) this.f205296a).getEmoticon();
                    if (emoticon != null && emoticon2 != null && (str = emoticon.eId) != null && str.equals(emoticon2.eId)) {
                        return i3;
                    }
                } else if (parcelable instanceof CameraEmoticonInfo) {
                    EmoticonInfo emoticonInfo = this.f205296a;
                    if ((emoticonInfo instanceof CameraEmoticonInfo) && ((CameraEmoticonInfo) parcelable).emoId == ((CameraEmoticonInfo) emoticonInfo).emoId) {
                        return i3;
                    }
                } else {
                    continue;
                }
            }
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.emotionintegrate.p
    public Drawable c(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Drawable) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        }
        return this.f205296a.getBigDrawable(context, context.getResources().getDisplayMetrics().density);
    }

    @Override // com.tencent.mobileqq.emotionintegrate.p
    public String d() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        EmoticonInfo emoticonInfo = this.f205296a;
        if (emoticonInfo != null && (i3 = emoticonInfo.emoId) >= 0) {
            return String.valueOf(i3);
        }
        CustomEmotionData a16 = a();
        if (a16 != null) {
            int i16 = a16.emoId;
            if (i16 >= 0) {
                return String.valueOf(i16);
            }
            return a16.md5;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.emotionintegrate.p
    public String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        CustomEmotionData a16 = a();
        if (a16 != null) {
            return a16.eId;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.emotionintegrate.p
    public EmoticonInfo f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (EmoticonInfo) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f205296a;
    }

    @Override // com.tencent.mobileqq.emotionintegrate.p
    public String g() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        EmoticonInfo emoticonInfo = this.f205296a;
        if ((emoticonInfo instanceof FavoriteEmoticonInfo) && (str = ((FavoriteEmoticonInfo) emoticonInfo).emojiMd5) != null) {
            return str;
        }
        return "";
    }

    @Override // com.tencent.mobileqq.emotionintegrate.p
    public String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        EmoticonInfo emoticonInfo = this.f205296a;
        if (emoticonInfo instanceof FavoriteEmoticonInfo) {
            return String.valueOf(((FavoriteEmoticonInfo) emoticonInfo).jumpId);
        }
        return "";
    }

    @Override // com.tencent.mobileqq.emotionintegrate.p
    public long k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        if (this.f205296a instanceof IFavoriteEmoticonInfo) {
            return ((IFavoriteEmoticonInfo) r0).getEmoId();
        }
        return 0L;
    }

    @Override // com.tencent.mobileqq.emotionintegrate.p
    public boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.emotionintegrate.p
    public boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.emotionintegrate.p
    public boolean o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.emotionintegrate.p
    public boolean r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.f205296a instanceof IPicEmoticonInfo;
    }

    @Override // com.tencent.mobileqq.emotionintegrate.p
    public boolean s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.emotionintegrate.p
    public boolean t(p pVar) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) pVar)).booleanValue();
        }
        if (!(pVar instanceof u)) {
            return false;
        }
        Parcelable parcelable = ((u) pVar).f205296a;
        if ((parcelable instanceof FavoriteEmoticonInfo) && (this.f205296a instanceof FavoriteEmoticonInfo)) {
            String resID = ((IFavoriteEmoticonInfo) parcelable).getResID();
            String resID2 = ((IFavoriteEmoticonInfo) this.f205296a).getResID();
            if (resID == null || !resID.equals(resID2)) {
                return false;
            }
            return true;
        }
        if (!(parcelable instanceof IPicEmoticonInfo) || !(this.f205296a instanceof IPicEmoticonInfo)) {
            return false;
        }
        Emoticon emoticon = ((IPicEmoticonInfo) parcelable).getEmoticon();
        Emoticon emoticon2 = ((IPicEmoticonInfo) this.f205296a).getEmoticon();
        if (emoticon == null || emoticon2 == null || (str = emoticon.eId) == null || !str.equals(emoticon2.eId) || (str2 = emoticon.epId) == null || !str2.equals(emoticon2.epId)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.emotionintegrate.p
    public boolean u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.emotionintegrate.p
    public boolean v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.emotionintegrate.p
    public boolean x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.emotionintegrate.p
    public void y(Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) bundle, i3);
            return;
        }
        super.y(bundle, i3);
        bundle.putInt("cur_emotion_id", (int) k());
        bundle.putInt("cur_emotion_type", this.f205296a instanceof CameraEmoticonInfo ? 1 : 0);
    }
}
