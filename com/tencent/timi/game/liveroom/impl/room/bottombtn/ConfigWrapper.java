package com.tencent.timi.game.liveroom.impl.room.bottombtn;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.storage.util.GsonHelper;
import com.tencent.trpcprotocol.qlive.trpc_room_global_config.trpc_room_global_config.trpcRoomGlobalConfig$BottomItem;
import com.tencent.trpcprotocol.qlive.trpc_room_global_config.trpc_room_global_config.trpcRoomGlobalConfig$GetBottomConfigRsp;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class ConfigWrapper implements Serializable {
    public a btnItemWrapper;
    public String errMsg;
    public List<a> innerBtnItemWrapperList;
    public int retCode;
    public int roomType;
    public int version;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f377528a;

        /* renamed from: b, reason: collision with root package name */
        public String f377529b;

        /* renamed from: c, reason: collision with root package name */
        public String f377530c;

        /* renamed from: d, reason: collision with root package name */
        public float f377531d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f377532e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f377533f;
    }

    private static ConfigWrapper a(trpcRoomGlobalConfig$GetBottomConfigRsp trpcroomglobalconfig_getbottomconfigrsp) {
        ConfigWrapper configWrapper = new ConfigWrapper();
        configWrapper.retCode = trpcroomglobalconfig_getbottomconfigrsp.retcode.get();
        configWrapper.errMsg = trpcroomglobalconfig_getbottomconfigrsp.errmsg.get();
        configWrapper.version = trpcroomglobalconfig_getbottomconfigrsp.version.get();
        configWrapper.roomType = trpcroomglobalconfig_getbottomconfigrsp.roomType.get();
        configWrapper.btnItemWrapper = c(trpcroomglobalconfig_getbottomconfigrsp.outer_item);
        configWrapper.innerBtnItemWrapperList = new ArrayList();
        for (int i3 = 0; i3 < trpcroomglobalconfig_getbottomconfigrsp.inner_item.get().size(); i3++) {
            configWrapper.innerBtnItemWrapperList.add(c(trpcroomglobalconfig_getbottomconfigrsp.inner_item.get(i3).get()));
        }
        return configWrapper;
    }

    private static String b(int i3) {
        return "GetBottomConfigRsp-" + i3;
    }

    private static a c(trpcRoomGlobalConfig$BottomItem trpcroomglobalconfig_bottomitem) {
        a aVar = new a();
        aVar.f377531d = trpcroomglobalconfig_bottomitem.height.get();
        aVar.f377528a = trpcroomglobalconfig_bottomitem.icon.get();
        aVar.f377529b = trpcroomglobalconfig_bottomitem.text.get();
        aVar.f377530c = trpcroomglobalconfig_bottomitem.url.get();
        aVar.f377532e = trpcroomglobalconfig_bottomitem.visible.get();
        aVar.f377533f = trpcroomglobalconfig_bottomitem.showRedPoint.get();
        return aVar;
    }

    private static trpcRoomGlobalConfig$BottomItem d(a aVar) {
        trpcRoomGlobalConfig$BottomItem trpcroomglobalconfig_bottomitem = new trpcRoomGlobalConfig$BottomItem();
        trpcroomglobalconfig_bottomitem.height.set(aVar.f377531d);
        trpcroomglobalconfig_bottomitem.icon.set(aVar.f377528a);
        trpcroomglobalconfig_bottomitem.text.set(aVar.f377529b);
        trpcroomglobalconfig_bottomitem.url.set(aVar.f377530c);
        trpcroomglobalconfig_bottomitem.visible.set(aVar.f377532e);
        trpcroomglobalconfig_bottomitem.showRedPoint.set(aVar.f377533f);
        return trpcroomglobalconfig_bottomitem;
    }

    public static trpcRoomGlobalConfig$GetBottomConfigRsp format2Rsp(ConfigWrapper configWrapper) {
        if (configWrapper == null) {
            return null;
        }
        trpcRoomGlobalConfig$GetBottomConfigRsp trpcroomglobalconfig_getbottomconfigrsp = new trpcRoomGlobalConfig$GetBottomConfigRsp();
        trpcroomglobalconfig_getbottomconfigrsp.get().retcode.set(configWrapper.retCode);
        trpcroomglobalconfig_getbottomconfigrsp.errmsg.set(configWrapper.errMsg);
        trpcroomglobalconfig_getbottomconfigrsp.version.set(configWrapper.version);
        trpcroomglobalconfig_getbottomconfigrsp.roomType.set(configWrapper.roomType);
        trpcroomglobalconfig_getbottomconfigrsp.outer_item = d(configWrapper.btnItemWrapper);
        trpcroomglobalconfig_getbottomconfigrsp.inner_item.set(new ArrayList());
        for (int i3 = 0; i3 < configWrapper.innerBtnItemWrapperList.size(); i3++) {
            trpcroomglobalconfig_getbottomconfigrsp.inner_item.add(d(configWrapper.innerBtnItemWrapperList.get(i3)));
        }
        return trpcroomglobalconfig_getbottomconfigrsp;
    }

    public static ConfigWrapper getFromSp(int i3) {
        String b16 = b(i3);
        String f16 = rm4.a.f(b16, "");
        ConfigWrapper configWrapper = (ConfigWrapper) GsonHelper.build().fromJson(f16, ConfigWrapper.class);
        QLog.i("ConfigWrapper", 1, "get key:" + b16 + ", value:" + f16);
        return configWrapper;
    }

    public static void putIntoSp(trpcRoomGlobalConfig$GetBottomConfigRsp trpcroomglobalconfig_getbottomconfigrsp) {
        String json = GsonHelper.build().toJson(a(trpcroomglobalconfig_getbottomconfigrsp));
        String b16 = b(trpcroomglobalconfig_getbottomconfigrsp.roomType.get());
        rm4.a.k(b16, json);
        QLog.i("ConfigWrapper", 1, "put key:" + b16 + ", value:" + json);
    }
}
