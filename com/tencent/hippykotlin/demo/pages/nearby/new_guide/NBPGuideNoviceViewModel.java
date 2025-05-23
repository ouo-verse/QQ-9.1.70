package com.tencent.hippykotlin.demo.pages.nearby.new_guide;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.BaseObject;
import f35.g;
import f35.j;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import t35.a;

/* loaded from: classes31.dex */
public final class NBPGuideNoviceViewModel extends BaseObject {
    public static final List<String> CONSTELLATION_LIST;
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPGuideNoviceViewModel.class, "loginRsp", "getLoginRsp()Lkuikly/com/tencent/trpcprotocol/lplan/user_manager_svr/user_manager_svr/LoginRsp;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPGuideNoviceViewModel.class, "avatar", "getAvatar()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPGuideNoviceViewModel.class, "gender", "getGender()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPGuideNoviceViewModel.class, "nick", "getNick()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPGuideNoviceViewModel.class, "birthdayYear", "getBirthdayYear()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPGuideNoviceViewModel.class, "birthdayMonth", "getBirthdayMonth()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPGuideNoviceViewModel.class, "birthdayDay", "getBirthdayDay()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPGuideNoviceViewModel.class, "tagList", "getTagList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPGuideNoviceViewModel.class, "selectedTagList", "getSelectedTagList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPGuideNoviceViewModel.class, "isEntering", "isEntering()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPGuideNoviceViewModel.class, "currentPageIndex", "getCurrentPageIndex()I", 0)};
    public static final Companion Companion = new Companion();
    public final ReadWriteProperty loginRsp$delegate = c.a(null);
    public final ReadWriteProperty avatar$delegate = c.a("");
    public final ReadWriteProperty gender$delegate = c.a(1);
    public final ReadWriteProperty nick$delegate = c.a("");
    public final ReadWriteProperty birthdayYear$delegate = c.a(2000);
    public final ReadWriteProperty birthdayMonth$delegate = c.a(2);
    public final ReadWriteProperty birthdayDay$delegate = c.a(23);
    public final ReadWriteProperty tagList$delegate = c.b();
    public final ReadWriteProperty selectedTagList$delegate = c.b();
    public final ReadWriteProperty isEntering$delegate = c.a(Boolean.FALSE);
    public final ReadWriteProperty currentPageIndex$delegate = c.a(0);

    /* loaded from: classes31.dex */
    public static final class Companion {
    }

    public final List<String> getAvatarUrls() {
        j jVar;
        j jVar2;
        if (getGender() == 1) {
            g loginRsp = getLoginRsp();
            if (loginRsp != null && (jVar2 = loginRsp.E) != null) {
                return jVar2.f397811e;
            }
        } else {
            g loginRsp2 = getLoginRsp();
            if (loginRsp2 != null && (jVar = loginRsp2.E) != null) {
                return jVar.f397812f;
            }
        }
        return null;
    }

    public final int getBirthdayDay() {
        return ((Number) this.birthdayDay$delegate.getValue(this, $$delegatedProperties[6])).intValue();
    }

    public final int getBirthdayMonth() {
        return ((Number) this.birthdayMonth$delegate.getValue(this, $$delegatedProperties[5])).intValue();
    }

    public final String getConstellation() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        switch (getBirthdayMonth()) {
            case 1:
                if (getBirthdayDay() <= 19) {
                    str = CONSTELLATION_LIST.get(11);
                } else {
                    str = CONSTELLATION_LIST.get(0);
                }
                return str;
            case 2:
                if (getBirthdayDay() <= 18) {
                    str2 = CONSTELLATION_LIST.get(0);
                } else {
                    str2 = CONSTELLATION_LIST.get(1);
                }
                return str2;
            case 3:
                if (getBirthdayDay() <= 20) {
                    str3 = CONSTELLATION_LIST.get(1);
                } else {
                    str3 = CONSTELLATION_LIST.get(2);
                }
                return str3;
            case 4:
                if (getBirthdayDay() <= 19) {
                    str4 = CONSTELLATION_LIST.get(2);
                } else {
                    str4 = CONSTELLATION_LIST.get(3);
                }
                return str4;
            case 5:
                if (getBirthdayDay() <= 20) {
                    str5 = CONSTELLATION_LIST.get(3);
                } else {
                    str5 = CONSTELLATION_LIST.get(4);
                }
                return str5;
            case 6:
                if (getBirthdayDay() <= 20) {
                    str6 = CONSTELLATION_LIST.get(4);
                } else {
                    str6 = CONSTELLATION_LIST.get(5);
                }
                return str6;
            case 7:
                if (getBirthdayDay() <= 22) {
                    str7 = CONSTELLATION_LIST.get(5);
                } else {
                    str7 = CONSTELLATION_LIST.get(6);
                }
                return str7;
            case 8:
                if (getBirthdayDay() <= 22) {
                    str8 = CONSTELLATION_LIST.get(6);
                } else {
                    str8 = CONSTELLATION_LIST.get(7);
                }
                return str8;
            case 9:
                if (getBirthdayDay() <= 22) {
                    str9 = CONSTELLATION_LIST.get(7);
                } else {
                    str9 = CONSTELLATION_LIST.get(8);
                }
                return str9;
            case 10:
                if (getBirthdayDay() <= 22) {
                    str10 = CONSTELLATION_LIST.get(8);
                } else {
                    str10 = CONSTELLATION_LIST.get(9);
                }
                return str10;
            case 11:
                if (getBirthdayDay() <= 21) {
                    str11 = CONSTELLATION_LIST.get(9);
                } else {
                    str11 = CONSTELLATION_LIST.get(10);
                }
                return str11;
            case 12:
                if (getBirthdayDay() <= 21) {
                    str12 = CONSTELLATION_LIST.get(10);
                } else {
                    str12 = CONSTELLATION_LIST.get(11);
                }
                return str12;
            default:
                return CONSTELLATION_LIST.get(0);
        }
    }

    public final int getCurrentPageIndex() {
        return ((Number) this.currentPageIndex$delegate.getValue(this, $$delegatedProperties[10])).intValue();
    }

    public final int getGender() {
        return ((Number) this.gender$delegate.getValue(this, $$delegatedProperties[2])).intValue();
    }

    public final g getLoginRsp() {
        return (g) this.loginRsp$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final String getNick() {
        return (String) this.nick$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final com.tencent.kuikly.core.reactive.collection.c<a> getSelectedTagList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.selectedTagList$delegate.getValue(this, $$delegatedProperties[8]);
    }

    public final com.tencent.kuikly.core.reactive.collection.c<a> getTagList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.tagList$delegate.getValue(this, $$delegatedProperties[7]);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("loginRsp: ");
        m3.append(getLoginRsp());
        m3.append(", tagList: ");
        m3.append(getTagList().size());
        m3.append(", avatarUrls: ");
        List<String> avatarUrls = getAvatarUrls();
        m3.append(avatarUrls != null ? Integer.valueOf(avatarUrls.size()) : null);
        m3.append(", gender: ");
        m3.append(getGender());
        m3.append(", nick: ");
        m3.append(getNick());
        m3.append(", constellation: ");
        m3.append(getConstellation());
        return m3.toString();
    }

    static {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"\u6c34\u74f6\u5ea7", "\u53cc\u9c7c\u5ea7", "\u767d\u7f8a\u5ea7", "\u91d1\u725b\u5ea7", "\u53cc\u5b50\u5ea7", "\u5de8\u87f9\u5ea7", "\u72ee\u5b50\u5ea7", "\u5904\u5973\u5ea7", "\u5929\u79e4\u5ea7", "\u5929\u874e\u5ea7", "\u5c04\u624b\u5ea7", "\u6469\u7faf\u5ea7"});
        CONSTELLATION_LIST = listOf;
    }
}
