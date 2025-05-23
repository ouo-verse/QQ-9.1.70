package com.tencent.hippykotlin.demo.pages.dataline;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailUserIntent;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.ntcompose.lifecycle.common.Lifecycle;
import com.tencent.ntcompose.lifecycle.common.a;
import com.tencent.ntcompose.lifecycle.viewmodel.g;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class DatalineDetailViewModel extends g implements a {
    public final MutableState<String> deviceImg;
    public final MutableState<String> deviceName;
    public final int deviceType;
    public final String deviceUin;
    public final Lazy fm$delegate;
    public final MutableState<String> introduce;
    public final MutableState<Boolean> isDeviceOnline;
    public final MutableState<Boolean> noWifiAutoRecvFile;
    public final MutableState<String> pcOnlineSwitchText;
    public final MutableState<String> pcOnlineSwitchTextDesc;
    public final MutableState<Boolean> pcQQMentionChecked;
    public final MutableState<String> recvFilePath;
    public final int selfDeviceType;
    public final MutableState<Boolean> topChecked;

    public DatalineDetailViewModel(String str, int i3, int i16) {
        MutableState<Boolean> mutableStateOf$default;
        MutableState<Boolean> mutableStateOf$default2;
        MutableState<Boolean> mutableStateOf$default3;
        MutableState<String> mutableStateOf$default4;
        MutableState<String> mutableStateOf$default5;
        MutableState<String> mutableStateOf$default6;
        MutableState<String> mutableStateOf$default7;
        MutableState<String> mutableStateOf$default8;
        MutableState<String> mutableStateOf$default9;
        MutableState<Boolean> mutableStateOf$default10;
        Lazy lazy;
        this.deviceUin = str;
        this.deviceType = i3;
        this.selfDeviceType = i16;
        Boolean bool = Boolean.FALSE;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.topChecked = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.noWifiAutoRecvFile = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.pcQQMentionChecked = mutableStateOf$default3;
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAJwAAACcBAMAAAB4lt9+AAAALVBMVEVHcEwAif8Ah/8AiP8Aif8Aif8AiP8AiP////9oxP/e8v8Amv+I0f+04f8vs/9y1WNsAAAAB3RSTlMA5haQwmlCeV8jPQAAA61JREFUaN7tms9OU0EUxmuLuCVVuNtrRNhWA7qtENJtERK3KAluvbT0SGq6tVJcl437RtBtjca1hCdAfYAmPoW9ghbunJk5M/NFu/BbNvDLnTNnZs6/XM6mubWFBxFRcmN5cSsXqLm1IWmk+sqTENgCKVre8ITl1yPitBL70G5XSKP6Q3faZkR63XNeKBk17Ua7QxZNx0ga0XU5bpUEEq/3MYk0I6PNklB3JbSrkRSXVAXbUCGx6jFmG8TbcYucZDFfPnLDJTHCR0ZqmGgFclbJgLvvjqtBP87weS4uJ3C+WfLSEvLjtJ83QZ4qo7bVsLkF8lYJ+XHs501SgNTI4GYIrhh6lVgulgIFKbsZj8JwO8i1KqudoECVkWvNrDZ0rZnVFoiQq30ajrv4BkXhuORCWEIAjQKWKwhc0XA3NU96bZOOBvpbSnWTXTNsqL2B1lUU0zVP21a97uuuAcV0H9sCHeqMp5ywngS3pztnWdO9aIv0Jfveal6JDzJch38xlAN7LMPt83sx72U6xnhFdieabaH67F5kI51dKW7A7UWefHHd7H/G3Jnwx1W5V8cfl97I13C4Inex++Ma3GXnj6sxfhKAqzN+EoAbesokErfBvGIBuCoT7ATgSljclOrFIbhnTHgSgNvG4hpMoBiA22ECigBcDY2rIHF1NC5C4hI0jpA4+o8bH9x4+914n9nxvu/Al7vs6fn6Rvj0zEtwh2yexuFEz3afTQ+4Z1vNtFtqspn+fCrAlZmah/odr9KfD6xpSopTA7Jmj82+jq1JVBqQMVXFY9li97kqoxrMMgnogLNoh5hgljm0anr8nuiHNT0+S8qYiqyagR6dtAWmq/H1J7/SwlmawpRk/QofqRfzhcWWvSzT1RTd2HpW68QMO+rrqlp5ginmkndv1UVl1Oanc/VF5VRbtf35b4u9tPzhtqiOKsaVRK0FMe68zVDB4BJZSVuK25F1PqS4KVlNW4qrCiruQ3f7c5t2jK43qrrrm1Cfs6f1u6AdpTce/2wYTWcqkkvuYKVIri/h98S4RNJgOGBfcFuDQdvqaX17e0nvupLWFrg5A24doRtb4LYbuCmIblmCG6rgdi+6GQ1ulaMb+eAxA/QQBHhEAzxAgh5vAQ/foEeD0INL7mNVM39z6As8koYemEOP84GHDR3Mt/QvBjXRY6S5nGTI1WVodhVJs6/XeSJ60+QhruPL8OFq7UR04jf6nUYG3GB60KT7+qUlJ4shsF/aGg3121k/AXrAFIXvMo3bAAAAAElFTkSuQmCC", null, 2, null);
        this.deviceImg = mutableStateOf$default4;
        mutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("\u6211\u7684\u7535\u8111", null, 2, null);
        this.deviceName = mutableStateOf$default5;
        mutableStateOf$default6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("\u65e0\u9700\u6570\u636e\u7ebf\uff0c\u7535\u8111\u4e0e\u624b\u673a\u8f7b\u677e\u4e92\u4f20\u6d88\u606f\uff0c\u652f\u6301\u6587\u5b57\u3001\u56fe\u7247\u3001\u97f3\u4e50\u3001\u89c6\u9891\u4ee5\u53ca\u5404\u79cd\u6587\u4ef6\u7c7b\u578b\u3002", null, 2, null);
        this.introduce = mutableStateOf$default6;
        mutableStateOf$default7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("\u7535\u8111QQ\u4e0a\u7ebf\u65f6\u81ea\u52a8\u63d0\u793a", null, 2, null);
        this.pcOnlineSwitchText = mutableStateOf$default7;
        mutableStateOf$default8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("\u5f00\u542f\u540e\uff0c\u7535\u8111QQ\u4e0a\u7ebf\u65f6\"\u6211\u7684\u7535\u8111\"\u4f1a\u81ea\u52a8\u51fa\u73b0\u5728\u6d88\u606f\u5217\u8868\u3002", null, 2, null);
        this.pcOnlineSwitchTextDesc = mutableStateOf$default8;
        mutableStateOf$default9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
        this.recvFilePath = mutableStateOf$default9;
        mutableStateOf$default10 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.isDeviceOnline = mutableStateOf$default10;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<DatalineModule>() { // from class: com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailViewModel$fm$2
            @Override // kotlin.jvm.functions.Function0
            public final DatalineModule invoke() {
                return (DatalineModule) c.f117352a.g().acquireModule("DatalineModule");
            }
        });
        this.fm$delegate = lazy;
    }

    public final DatalineModule getFm() {
        return (DatalineModule) this.fm$delegate.getValue();
    }

    @Override // com.tencent.ntcompose.lifecycle.common.a
    public final void onStateChanged(com.tencent.ntcompose.lifecycle.common.c cVar, Lifecycle.Event event) {
        String str;
        if (event == Lifecycle.Event.ON_CREATE) {
            KLog kLog = KLog.INSTANCE;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onCreate deviceUin: ");
            m3.append(this.deviceUin);
            m3.append(", deviceType: ");
            DatalineDetailViewModel$$ExternalSyntheticOutline0.m(m3, this.deviceType, kLog, "DatalineDetailViewModel");
            int i3 = this.deviceType;
            if (i3 != 0) {
                String str2 = "\u65e0\u9700\u6570\u636e\u7ebf\uff0ciPad\u4e0e\u624b\u673a\u8f7b\u677e\u4e92\u4f20\u6d88\u606f\uff0c\u652f\u6301\u6587\u5b57\u3001\u56fe\u7247\u3001\u97f3\u4e50\u3001\u89c6\u9891\u4ee5\u53ca\u5404\u79cd\u6587\u4ef6\u7c7b\u578b\u3002";
                if (i3 == 1) {
                    this.deviceImg.setValue("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAJwAAACcBAMAAAB4lt9+AAAAJ1BMVEVHcEwAiP8Ah/8AiP8Aif8Aif8AiP////8AiP9gwf/d8v8Amf+g2v8p7QVLAAAAB3RSTlMA5haQwmlCeV8jPQAAAyRJREFUaN7tmktOG0EQhgfbQSyRE9Asx+IhliaCiCUBIXnJa8GSBAnlBsYOiwy2USU+ACg5gIELACdgw6EwLBjjrp6u7vqdeJH/AJ+6u/pVVX8UubS4t/I5Jko/bK4eR0ot7vVJmdpbXzWwFTK0eRgIK+zHxGkrCaEt1Mii9q4/7Sgmuz55T5RyNeNHWyaHZhIkjei9HLdDAonn+4VEmpXR5kmojxLau1iKS7cFYaiRWO0EEwZxOObIS47lK8R+uDRB7JFM53m0InmrmoNb88e1oIPLGZ7PlhNsvnkK0gZycNbhlShQ66iw5gS3SMGqIgfHDm+SFDJ/BhUNrqy9ShwXS5FUGg7GgQ7XQc61rwRzIviTcaDFdaBzfRvbIhFytt/0uME3KNbj0oFvCQGUfVgmELgy4m5ibqlCjMC9bhXI0mXXALd09483vbpFzZvHPzmLZ56w7u+6Q9d31nNmLp2T1ueZ763tlfhZF+jS8mKYB/ZBgju1xGIpaHDM8Mp8JC5kuAYfi+GfTrcnwzXvuFgUAufKzDbhzsQvKe6Eu1SMV+dWivvO3chTgZFgYlHmLvYHKe6Uu+DXcLgWs0+oJ8U1mVNr7BMFrr9TJpG4Q+YqrovFvGYlJK6KxU2bu1iD+8F8TxS4MyzunHnGFLgO86FQ4FpoXA2Ja6NxMRKXonGExNF/3PjgxnvfjfeZHe/7Dny5g5+eJSwO/GxPIHHrTAqlwoE/ZODvIvgz6/xqN15Tr+6F+6vtTAQurdkamwi40pSBvLArSFMqjiTKjmuYu9id4tkny6Z4rgTUHoorLgEFp8fg5B1dWqigCh9noyjLgItGzFMbVNJKR1Nwq2DKgdO4mvZgpRdcSgUXenVto+GlgxfJwSV8dIOhpMdVR9ecAbeO0I0t7WyHm4zYpiC6ZQluqILbvehmNLhVjm7kg20GaBME2KIBNpCg7S1g8w3aGoQ2Lvnbqmb/pukLbElDG+bQdj6w2dBj+Tb+hVETbSONIonJ1cc0u4Okuefr7Yg+ytshvvZluLna6ohOw6zfzz8Dzpiucrrvv5lyuqqBveg4M/W7WU8o0yfFwFRgJQAAAABJRU5ErkJggg");
                    this.deviceName.setValue("\u6211\u7684iPad");
                    this.introduce.setValue("\u65e0\u9700\u6570\u636e\u7ebf\uff0ciPad\u4e0e\u624b\u673a\u8f7b\u677e\u4e92\u4f20\u6d88\u606f\uff0c\u652f\u6301\u6587\u5b57\u3001\u56fe\u7247\u3001\u97f3\u4e50\u3001\u89c6\u9891\u4ee5\u53ca\u5404\u79cd\u6587\u4ef6\u7c7b\u578b\u3002");
                    this.pcOnlineSwitchText.setValue("QQ iPad\u7248\u4e0a\u7ebf\u65f6\u81ea\u52a8\u63d0\u793a");
                    this.pcOnlineSwitchTextDesc.setValue("\u5f00\u542f\u540e\uff0cQQ iPad\u7248\u4e0a\u7ebf\u65f6\"\u6211\u7684iPad\"\u4f1a\u81ea\u52a8\u51fa\u73b0\u5728\u6d88\u606f\u5217\u8868\u3002");
                } else if (i3 == 2) {
                    this.deviceImg.setValue("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAJwAAACcBAMAAAB4lt9+AAAAJ1BMVEVHcEwAiP8Ah/8AiP8Aif8Aif8AiP////8AiP9gwf/d8v8Amf+g2v8p7QVLAAAAB3RSTlMA5haQwmlCeV8jPQAAAzBJREFUaN7tms9OU1EQxi+tJS5JFXKXtxEJy6sB4xIhJF0WYdElSkJ8g4bKgktvm9E+QAk+QJEXEJ+ADQ9lgcRWmJl75pyv2oXflubHOWfmnj8zXxQVaWV37V1MlD3fWj+MArWyOyKNlW9/DIGt0SNt7XvCSnsxcdpOfGgv6yQof2+nHcQk6415oqRq0UZ7RQVaTJA0omfuuB1ykPN8P5CTltxoy+So1y60SuyKyxoOYaiTs/IEEwbncLwgkwqWrxTbcFmCyJGxehqtTGalCu6tHdeBDk4ZniXlHJJvmby0iRycOLwn5KkNVFiV4JbJWylycOzw5ilAj28GtRBcNXQrKdhYyhSkh8FohuG6yLmOlGC+CP7LaIbiui5z/XlzOWxNqH15880htnxc++ctRt+vCmf7if0FSxvxCs8gdq5fWoLO2NlOXEvY/3ct4Y7Zn48vLHOmwQnDq+p700DGHam7FJsm/aGMa19pqVIxzlWYbaot3VcNd6EtHvuF/dBwn7XvLDZGQohFrp0S1xruWDkxyijcfSxW2b8NNVxbOYCaKNx9LOoo3F0sSvx+2FIlHxgVHK4hnzo+uNsd+SkOVxU3di9cT76I+eA6Yp544XIxT7xwo0yZR+L2pbTzwzXEy44XLsXiFqQs9sOdSFnshzvF4nriRdEL1xUfO164DhpXR+JyNC5G4jI0jpA4+o+bHdxs591sf7Ozvd+BN3fw0bOKxYGP7TkkbkOsZXniwBcy8HURfJkFX7XRDwHwM6WGw53gn3jgByj4eQx+vKNLCzUdd/S7HNYf6LhTl7LMGVM108oyBUWjiVpd36VoxMdiwAVRLWllTgU3brJqwa2mlgO5UFzwz0Wlpm0vVjamU0oFF3r5xbOWoRemVSQHl/DRDQZhR7a0P9LpNWfArSN0Yyu07fawyYhtCqJbluCGKrjdi25Gg1vl6EY+2GaANkGALRpgAwna3gI236CtQWjjkt1WtfQ3TV9gSxraMIe284HNhobl2/wXRk20jTSKXEyuFtPsDpJWPF+zI/pAyxCrfRlurhYd0Zmf9fv2ZsAZ04Oc7nt/TDlbD4Hd6XBs6i9m/QLpnTh7bqJb0AAAAABJRU5ErkJggg");
                    this.deviceName.setValue("\u6211\u7684\u624b\u673a");
                    MutableState<String> mutableState = this.introduce;
                    if (this.selfDeviceType != 1) {
                        str2 = "\u65e0\u9700\u6570\u636e\u7ebf\uff0cPad\u4e0e\u624b\u673a\u8f7b\u677e\u4e92\u4f20\u6d88\u606f\uff0c\u652f\u6301\u6587\u5b57\u3001\u56fe\u7247\u3001\u97f3\u4e50\u3001\u89c6\u9891\u4ee5\u53ca\u5404\u79cd\u6587\u4ef6\u7c7b\u578b\u3002";
                    }
                    mutableState.setValue(str2);
                    this.pcOnlineSwitchText.setValue("\u624b\u673a\u4e0a\u7ebf\u65f6\u81ea\u52a8\u63d0\u793a");
                    this.pcOnlineSwitchTextDesc.setValue("\u5f00\u542f\u540e\uff0c\u624b\u673aQQ\u4e0a\u7ebf\u65f6\"\u6211\u7684\u624b\u673a\"\u4f1a\u81ea\u52a8\u51fa\u73b0\u5728\u6d88\u606f\u5217\u8868\u3002");
                } else if (i3 == 3) {
                    this.deviceImg.setValue("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAJwAAACcBAMAAAB4lt9+AAAAJ1BMVEVHcEwAiP8Ah/8AiP8Aif8Aif8AiP////8AiP9gwf/d8v8Amf+g2v8p7QVLAAAAB3RSTlMA5haQwmlCeV8jPQAAAyRJREFUaN7tmktOG0EQhgfbQSyRE9Asx+IhliaCiCUBIXnJa8GSBAnlBsYOiwy2USU+ACg5gIELACdgw6EwLBjjrp6u7vqdeJH/AJ+6u/pVVX8UubS4t/I5Jko/bK4eR0ot7vVJmdpbXzWwFTK0eRgIK+zHxGkrCaEt1Mii9q4/7Sgmuz55T5RyNeNHWyaHZhIkjei9HLdDAonn+4VEmpXR5kmojxLau1iKS7cFYaiRWO0EEwZxOObIS47lK8R+uDRB7JFM53m0InmrmoNb88e1oIPLGZ7PlhNsvnkK0gZycNbhlShQ66iw5gS3SMGqIgfHDm+SFDJ/BhUNrqy9ShwXS5FUGg7GgQ7XQc61rwRzIviTcaDFdaBzfRvbIhFytt/0uME3KNbj0oFvCQGUfVgmELgy4m5ibqlCjMC9bhXI0mXXALd09483vbpFzZvHPzmLZ56w7u+6Q9d31nNmLp2T1ueZ763tlfhZF+jS8mKYB/ZBgju1xGIpaHDM8Mp8JC5kuAYfi+GfTrcnwzXvuFgUAufKzDbhzsQvKe6Eu1SMV+dWivvO3chTgZFgYlHmLvYHKe6Uu+DXcLgWs0+oJ8U1mVNr7BMFrr9TJpG4Q+YqrovFvGYlJK6KxU2bu1iD+8F8TxS4MyzunHnGFLgO86FQ4FpoXA2Ja6NxMRKXonGExNF/3PjgxnvfjfeZHe/7Dny5g5+eJSwO/GxPIHHrTAqlwoE/ZODvIvgz6/xqN15Tr+6F+6vtTAQurdkamwi40pSBvLArSFMqjiTKjmuYu9id4tkny6Z4rgTUHoorLgEFp8fg5B1dWqigCh9noyjLgItGzFMbVNJKR1Nwq2DKgdO4mvZgpRdcSgUXenVto+GlgxfJwSV8dIOhpMdVR9ecAbeO0I0t7WyHm4zYpiC6ZQluqILbvehmNLhVjm7kg20GaBME2KIBNpCg7S1g8w3aGoQ2Lvnbqmb/pukLbElDG+bQdj6w2dBj+Tb+hVETbSONIonJ1cc0u4Okuefr7Yg+ytshvvZluLna6ohOw6zfzz8Dzpiucrrvv5lyuqqBveg4M/W7WU8o0yfFwFRgJQAAAABJRU5ErkJggg");
                    this.deviceName.setValue("\u6211\u7684Pad");
                    this.introduce.setValue("\u65e0\u9700\u6570\u636e\u7ebf\uff0cPad\u4e0e\u624b\u673a\u8f7b\u677e\u4e92\u4f20\u6d88\u606f\uff0c\u652f\u6301\u6587\u5b57\u3001\u56fe\u7247\u3001\u97f3\u4e50\u3001\u89c6\u9891\u4ee5\u53ca\u5404\u79cd\u6587\u4ef6\u7c7b\u578b\u3002");
                    this.pcOnlineSwitchText.setValue("QQ Pad\u7248\u4e0a\u7ebf\u65f6\u81ea\u52a8\u63d0\u793a");
                    this.pcOnlineSwitchTextDesc.setValue("\u5f00\u542f\u540e\uff0cQQ Pad\u7248\u4e0a\u7ebf\u65f6\"\u6211\u7684Pad\"\u4f1a\u81ea\u52a8\u51fa\u73b0\u5728\u6d88\u606f\u5217\u8868\u3002");
                }
            } else {
                this.deviceImg.setValue("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAJwAAACcBAMAAAB4lt9+AAAALVBMVEVHcEwAif8Ah/8AiP8Aif8Aif8AiP8AiP////9oxP/e8v8Amv+I0f+04f8vs/9y1WNsAAAAB3RSTlMA5haQwmlCeV8jPQAAA61JREFUaN7tms9OU0EUxmuLuCVVuNtrRNhWA7qtENJtERK3KAluvbT0SGq6tVJcl437RtBtjca1hCdAfYAmPoW9ghbunJk5M/NFu/BbNvDLnTNnZs6/XM6mubWFBxFRcmN5cSsXqLm1IWmk+sqTENgCKVre8ITl1yPitBL70G5XSKP6Q3faZkR63XNeKBk17Ua7QxZNx0ga0XU5bpUEEq/3MYk0I6PNklB3JbSrkRSXVAXbUCGx6jFmG8TbcYucZDFfPnLDJTHCR0ZqmGgFclbJgLvvjqtBP87weS4uJ3C+WfLSEvLjtJ83QZ4qo7bVsLkF8lYJ+XHs501SgNTI4GYIrhh6lVgulgIFKbsZj8JwO8i1KqudoECVkWvNrDZ0rZnVFoiQq30ajrv4BkXhuORCWEIAjQKWKwhc0XA3NU96bZOOBvpbSnWTXTNsqL2B1lUU0zVP21a97uuuAcV0H9sCHeqMp5ywngS3pztnWdO9aIv0Jfveal6JDzJch38xlAN7LMPt83sx72U6xnhFdieabaH67F5kI51dKW7A7UWefHHd7H/G3Jnwx1W5V8cfl97I13C4Inex++Ma3GXnj6sxfhKAqzN+EoAbesokErfBvGIBuCoT7ATgSljclOrFIbhnTHgSgNvG4hpMoBiA22ECigBcDY2rIHF1NC5C4hI0jpA4+o8bH9x4+914n9nxvu/Al7vs6fn6Rvj0zEtwh2yexuFEz3afTQ+4Z1vNtFtqspn+fCrAlZmah/odr9KfD6xpSopTA7Jmj82+jq1JVBqQMVXFY9li97kqoxrMMgnogLNoh5hgljm0anr8nuiHNT0+S8qYiqyagR6dtAWmq/H1J7/SwlmawpRk/QofqRfzhcWWvSzT1RTd2HpW68QMO+rrqlp5ginmkndv1UVl1Oanc/VF5VRbtf35b4u9tPzhtqiOKsaVRK0FMe68zVDB4BJZSVuK25F1PqS4KVlNW4qrCiruQ3f7c5t2jK43qrrrm1Cfs6f1u6AdpTce/2wYTWcqkkvuYKVIri/h98S4RNJgOGBfcFuDQdvqaX17e0nvupLWFrg5A24doRtb4LYbuCmIblmCG6rgdi+6GQ1ulaMb+eAxA/QQBHhEAzxAgh5vAQ/foEeD0INL7mNVM39z6As8koYemEOP84GHDR3Mt/QvBjXRY6S5nGTI1WVodhVJs6/XeSJ60+QhruPL8OFq7UR04jf6nUYG3GB60KT7+qUlJ4shsF/aGg3121k/AXrAFIXvMo3bAAAAAElFTkSuQmCC");
                this.deviceName.setValue("\u6211\u7684\u7535\u8111");
                MutableState<String> mutableState2 = this.introduce;
                int i16 = this.selfDeviceType;
                if (i16 == 1) {
                    str = "\u65e0\u9700\u6570\u636e\u7ebf\uff0c\u7535\u8111\u4e0eiPad\u8f7b\u677e\u4e92\u4f20\u6d88\u606f\uff0c\u652f\u6301\u6587\u5b57\u3001\u56fe\u7247\u3001\u97f3\u4e50\u3001\u89c6\u9891\u4ee5\u53ca\u5404\u79cd\u6587\u4ef6\u7c7b\u578b\u3002";
                } else if (i16 != 3) {
                    str = "\u65e0\u9700\u6570\u636e\u7ebf\uff0c\u7535\u8111\u4e0e\u624b\u673a\u8f7b\u677e\u4e92\u4f20\u6d88\u606f\uff0c\u652f\u6301\u6587\u5b57\u3001\u56fe\u7247\u3001\u97f3\u4e50\u3001\u89c6\u9891\u4ee5\u53ca\u5404\u79cd\u6587\u4ef6\u7c7b\u578b\u3002";
                } else {
                    str = "\u65e0\u9700\u6570\u636e\u7ebf\uff0c\u7535\u8111\u4e0ePad\u8f7b\u677e\u4e92\u4f20\u6d88\u606f\uff0c\u652f\u6301\u6587\u5b57\u3001\u56fe\u7247\u3001\u97f3\u4e50\u3001\u89c6\u9891\u4ee5\u53ca\u5404\u79cd\u6587\u4ef6\u7c7b\u578b\u3002";
                }
                mutableState2.setValue(str);
                this.pcOnlineSwitchText.setValue("\u7535\u8111QQ\u4e0a\u7ebf\u65f6\u81ea\u52a8\u63d0\u793a");
                this.pcOnlineSwitchTextDesc.setValue("\u5f00\u542f\u540e\uff0c\u7535\u8111QQ\u4e0a\u7ebf\u65f6\"\u6211\u7684\u7535\u8111\"\u4f1a\u81ea\u52a8\u51fa\u73b0\u5728\u6d88\u606f\u5217\u8868\u3002");
            }
            DatalineModule fm5 = getFm();
            String str3 = this.deviceUin;
            int i17 = this.deviceType;
            Function1<e, Unit> function1 = new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailViewModel$initSwitchValue$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(e eVar) {
                    e eVar2 = eVar;
                    if (eVar2 != null) {
                        DatalineDetailViewModel datalineDetailViewModel = DatalineDetailViewModel.this;
                        datalineDetailViewModel.topChecked.setValue(Boolean.valueOf(eVar2.g("setTopChecked", false)));
                        datalineDetailViewModel.noWifiAutoRecvFile.setValue(Boolean.valueOf(eVar2.g("noWifiAutoRecvFileChecked", false)));
                        datalineDetailViewModel.pcQQMentionChecked.setValue(Boolean.valueOf(eVar2.g("pcOnlineMentionChecked", false)));
                        datalineDetailViewModel.isDeviceOnline.setValue(Boolean.valueOf(eVar2.g("deviceOnLineStatus", false)));
                    }
                    return Unit.INSTANCE;
                }
            };
            fm5.getClass();
            e m16 = AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0.m(IProfileProtocolConst.PARAM_TARGET_UIN, str3, "device_type", i17);
            kLog.d("DatalineModule", "getDatalineCheckedValue json: " + m16 + ", method: getDatalineCheckedValue");
            fm5.toNative(false, "getDatalineCheckedValue", m16.toString(), function1, false);
            getFm().toNative(false, "getRecvFilePath", null, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailViewModel$initRecvFilePath$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(e eVar) {
                    String q16;
                    e eVar2 = eVar;
                    String str4 = "";
                    if (eVar2 != null && (q16 = eVar2.q("recvFilePath", "")) != null) {
                        str4 = q16;
                    }
                    DatalineDetailViewModel.this.recvFilePath.setValue(str4);
                    return Unit.INSTANCE;
                }
            }, false);
        }
    }

    public final void sendIntent$qecommerce_biz_release(DatalineDetailUserIntent datalineDetailUserIntent) {
        if (datalineDetailUserIntent instanceof DatalineDetailUserIntent.CheckSetTop) {
            DatalineDetailUserIntent.CheckSetTop checkSetTop = (DatalineDetailUserIntent.CheckSetTop) datalineDetailUserIntent;
            this.topChecked.setValue(Boolean.valueOf(checkSetTop.isChecked));
            getFm().datalineCheckSwitch$qecommerce_biz_release("setTopChecked", this.deviceUin, this.deviceType, checkSetTop.isChecked);
            return;
        }
        if (datalineDetailUserIntent instanceof DatalineDetailUserIntent.CheckNoWifiAutoRecvFile) {
            DatalineDetailUserIntent.CheckNoWifiAutoRecvFile checkNoWifiAutoRecvFile = (DatalineDetailUserIntent.CheckNoWifiAutoRecvFile) datalineDetailUserIntent;
            this.noWifiAutoRecvFile.setValue(Boolean.valueOf(checkNoWifiAutoRecvFile.isChecked));
            getFm().datalineCheckSwitch$qecommerce_biz_release("noWifiAutoRecvFileChecked", this.deviceUin, this.deviceType, checkNoWifiAutoRecvFile.isChecked);
            return;
        }
        if (datalineDetailUserIntent instanceof DatalineDetailUserIntent.CheckPCQQOnlineMention) {
            DatalineDetailUserIntent.CheckPCQQOnlineMention checkPCQQOnlineMention = (DatalineDetailUserIntent.CheckPCQQOnlineMention) datalineDetailUserIntent;
            this.pcQQMentionChecked.setValue(Boolean.valueOf(checkPCQQOnlineMention.isChecked));
            getFm().datalineCheckSwitch$qecommerce_biz_release("pcOnlineMentionChecked", this.deviceUin, this.deviceType, checkPCQQOnlineMention.isChecked);
            return;
        }
        if (datalineDetailUserIntent instanceof DatalineDetailUserIntent.QueryDownloadedFiles) {
            getFm().toNative(false, "queryDownloadedFile", null, null, false);
            return;
        }
        if (datalineDetailUserIntent instanceof DatalineDetailUserIntent.AddDeskTopShortCut) {
            DatalineModule fm5 = getFm();
            int i3 = this.deviceType;
            fm5.getClass();
            e eVar = new e();
            eVar.t("device_type", i3);
            fm5.toNative(false, "addDesktopShortcut", eVar.toString(), null, false);
            return;
        }
        if (datalineDetailUserIntent instanceof DatalineDetailUserIntent.ClearMsgRecord) {
            DatalineModule fm6 = getFm();
            String str = this.deviceUin;
            fm6.getClass();
            e eVar2 = new e();
            eVar2.v(IProfileProtocolConst.PARAM_TARGET_UIN, str);
            fm6.toNative(false, "clearMsgRecord", eVar2.toString(), null, false);
            return;
        }
        if (datalineDetailUserIntent instanceof DatalineDetailUserIntent.ManagerDevice) {
            DatalineModule fm7 = getFm();
            String str2 = this.deviceUin;
            fm7.getClass();
            e eVar3 = new e();
            eVar3.v(IProfileProtocolConst.PARAM_TARGET_UIN, str2);
            fm7.toNative(false, "managerDevice", eVar3.toString(), null, false);
            return;
        }
        KLog.INSTANCE.e("DatalineDetailViewModel", "sendIntent invalid intent: " + datalineDetailUserIntent);
    }
}
