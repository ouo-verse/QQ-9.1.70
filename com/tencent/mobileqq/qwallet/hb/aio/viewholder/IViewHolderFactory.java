package com.tencent.mobileqq.qwallet.hb.aio.viewholder;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import d4.f;
import vk2.QWalletMsgModel;
import vk2.QWalletSessionInfo;
import yk2.a;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IViewHolderFactory extends QRouteApi {
    public static final int REDPKG_TYPE_BIRTHDAY = 16;
    public static final int REDPKG_TYPE_DEFAULT = 0;
    public static final int REDPKG_TYPE_DRAW = 11;
    public static final int REDPKG_TYPE_EMOJI = 9;
    public static final int REDPKG_TYPE_ENTERPRISE = 7;
    public static final int REDPKG_TYPE_FESTIVAL = 18;
    public static final int REDPKG_TYPE_GOLD = 12;
    public static final int REDPKG_TYPE_KSONG = 8;
    public static final int REDPKG_TYPE_KUAKUA = 14;
    public static final int REDPKG_TYPE_LOCK = 1;
    public static final int REDPKG_TYPE_LOOK = 5;
    public static final int REDPKG_TYPE_SHENGPIZI = 15;
    public static final int REDPKG_TYPE_SOLITAIRE = 10;
    public static final int REDPKG_TYPE_SPECIFY = 6;
    public static final int REDPKG_TYPE_SPECIFY_GUILD = 17;
    public static final int REDPKG_TYPE_THEME = 3;
    public static final int REDPKG_TYPE_VIP = 4;
    public static final int REDPKG_TYPE_VOICE = 2;
    public static final String TAG = "ViewHolderFactoryImpl";

    a createViewHolderV2(@NonNull f fVar, @NonNull QWalletMsgModel qWalletMsgModel, @NonNull QWalletSessionInfo qWalletSessionInfo);

    int getRedPkgType(int i3);
}
