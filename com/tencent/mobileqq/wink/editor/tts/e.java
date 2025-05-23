package com.tencent.mobileqq.wink.editor.tts;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.wink.edit.manager.h;
import com.tencent.mobileqq.wink.editor.tts.source.TTSAudioInfo;
import com.tencent.mobileqq.wink.editor.tts.source.TTSAudioItem;
import com.tencent.mobileqq.wink.editor.tts.source.TTSInterfaceDataSource;
import com.tencent.mobileqq.wink.editor.tts.source.a;
import com.tencent.tavcut.core.render.player.IPlayer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import u53.f;

/* compiled from: P */
/* loaded from: classes21.dex */
public class e extends BaseViewModel {
    private static final String L = "e";
    private String[] D;
    private MutableLiveData<Pair<TTSAudioInfo, Boolean>> E;
    private LiveData<Pair<TTSAudioInfo, Boolean>> F;
    private WinkTTSDataInfo G;
    private TTSInterfaceDataSource H;
    private TTSAudioInfo I;
    public MutableLiveData<Boolean> J;
    private boolean K;

    /* renamed from: i, reason: collision with root package name */
    private List<WinkTTSDataInfo> f322571i;

    /* renamed from: m, reason: collision with root package name */
    private int f322572m = 1;
    private float C = 1.0f;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a implements com.tencent.mobileqq.wink.editor.tts.source.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WinkTTSDataInfo f322573a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ a.InterfaceC9047a f322574b;

        a(WinkTTSDataInfo winkTTSDataInfo, a.InterfaceC9047a interfaceC9047a) {
            this.f322573a = winkTTSDataInfo;
            this.f322574b = interfaceC9047a;
        }

        @Override // com.tencent.mobileqq.wink.editor.tts.source.a
        public void a(int i3, TTSAudioItem[] tTSAudioItemArr) {
            if (i3 == 1000001 && tTSAudioItemArr != null) {
                e eVar = e.this;
                eVar.f2(eVar.H, this.f322573a, tTSAudioItemArr, this.f322574b);
            } else {
                a.InterfaceC9047a interfaceC9047a = this.f322574b;
                if (interfaceC9047a != null) {
                    interfaceC9047a.a(this.f322573a.getTemplateType(), null, 1000008);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class b implements a.InterfaceC9047a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WinkTTSDataInfo f322576a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ TTSAudioInfo f322577b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ a.InterfaceC9047a f322578c;

        b(WinkTTSDataInfo winkTTSDataInfo, TTSAudioInfo tTSAudioInfo, a.InterfaceC9047a interfaceC9047a) {
            this.f322576a = winkTTSDataInfo;
            this.f322577b = tTSAudioInfo;
            this.f322578c = interfaceC9047a;
        }

        @Override // com.tencent.mobileqq.wink.editor.tts.source.a.InterfaceC9047a
        public void a(int i3, boolean[] zArr, int i16) {
            if (this.f322576a.getDownloadStatus() != 1) {
                return;
            }
            if (zArr.length == 1 && zArr[0]) {
                this.f322576a.setDownloadStatus(2);
                e.this.t2(this.f322576a);
                e.this.v2(this.f322577b, false);
                a.InterfaceC9047a interfaceC9047a = this.f322578c;
                if (interfaceC9047a != null) {
                    interfaceC9047a.a(i3, zArr, i16);
                    return;
                }
                return;
            }
            this.f322576a.setDownloadStatus(0);
            a.InterfaceC9047a interfaceC9047a2 = this.f322578c;
            if (interfaceC9047a2 != null) {
                interfaceC9047a2.a(i3, null, i16);
            }
        }
    }

    public e() {
        MutableLiveData<Pair<TTSAudioInfo, Boolean>> mutableLiveData = new MutableLiveData<>();
        this.E = mutableLiveData;
        this.F = mutableLiveData;
        this.H = new TTSInterfaceDataSource();
        this.J = new MutableLiveData<>();
        this.K = true;
    }

    private WinkTTSDataInfo W1() {
        WinkTTSDataInfo winkTTSDataInfo = new WinkTTSDataInfo(0);
        winkTTSDataInfo.setTemplateType(TTSAudioInfo.TYPE_TEMPLATE_TYPE_PLACEHOLDER);
        winkTTSDataInfo.setDisplayName("\u65e0");
        winkTTSDataInfo.setzShowOrder(0);
        winkTTSDataInfo.setEditorOrder(0);
        winkTTSDataInfo.setSelected(false);
        return winkTTSDataInfo;
    }

    private boolean c2(long j3, TTSAudioItem tTSAudioItem) {
        long startTime = tTSAudioItem.getStartTime();
        long duration = tTSAudioItem.getDuration() + startTime;
        if (startTime <= j3 && duration >= j3) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f2(TTSInterfaceDataSource tTSInterfaceDataSource, WinkTTSDataInfo winkTTSDataInfo, TTSAudioItem[] tTSAudioItemArr, a.InterfaceC9047a interfaceC9047a) {
        if (tTSAudioItemArr != null && tTSAudioItemArr.length > 0) {
            TTSAudioItem tTSAudioItem = tTSAudioItemArr[0];
            if (tTSAudioItem.getAudioInfo() != null && tTSAudioItem.getAudioInfo().DataLen == 0) {
                v2(null, true);
                interfaceC9047a.a(winkTTSDataInfo.getTemplateType(), null, 1000009);
                return;
            } else {
                TTSAudioInfo tTSAudioInfo = new TTSAudioInfo(this.D, winkTTSDataInfo.getTemplateType(), winkTTSDataInfo.getVolume());
                tTSAudioInfo.setDisplayName(winkTTSDataInfo.getDisplayName());
                tTSAudioInfo.setAudioItems(tTSAudioItemArr);
                tTSInterfaceDataSource.l(tTSAudioInfo, new b(winkTTSDataInfo, tTSAudioInfo, interfaceC9047a));
                return;
            }
        }
        if (interfaceC9047a != null) {
            interfaceC9047a.a(winkTTSDataInfo.getTemplateType(), null, 1000006);
        }
    }

    private WinkTTSDataInfo k2(JSONObject jSONObject) {
        if (jSONObject != null) {
            WinkTTSDataInfo winkTTSDataInfo = new WinkTTSDataInfo(1);
            winkTTSDataInfo.setId(jSONObject.optString("id"));
            winkTTSDataInfo.setName(jSONObject.optString("name"));
            winkTTSDataInfo.setDisplayName(jSONObject.optString("display_name"));
            winkTTSDataInfo.setIcon(jSONObject.optString("icon"));
            winkTTSDataInfo.setCategory(jSONObject.optInt("category"));
            winkTTSDataInfo.setSpeed(jSONObject.optInt("speed"));
            winkTTSDataInfo.setVolume((float) jSONObject.optDouble(InnerAudioPlugin.AUDIO_PROPERTY_VOLUME));
            winkTTSDataInfo.setzShowOrder(jSONObject.optInt("z_show_order"));
            winkTTSDataInfo.setEditorOrder(jSONObject.optInt("editor_order"));
            winkTTSDataInfo.setLanguage(jSONObject.optString(IjkMediaMeta.IJKM_KEY_LANGUAGE));
            winkTTSDataInfo.setTemplateType(jSONObject.optInt("template_type"));
            return winkTTSDataInfo;
        }
        return null;
    }

    private JSONObject l2() {
        JSONObject jSONObject = new JSONObject();
        try {
            return new JSONObject(h.m(f.f438413z));
        } catch (Exception e16) {
            e16.printStackTrace();
            return jSONObject;
        }
    }

    private void o2() {
        int editorOrder;
        List<WinkTTSDataInfo> list = this.f322571i;
        if (list == null) {
            return;
        }
        WinkTTSDataInfo[] winkTTSDataInfoArr = new WinkTTSDataInfo[list.size()];
        for (WinkTTSDataInfo winkTTSDataInfo : this.f322571i) {
            if (this.K) {
                editorOrder = winkTTSDataInfo.getzShowOrder();
            } else {
                editorOrder = winkTTSDataInfo.getEditorOrder();
            }
            winkTTSDataInfoArr[editorOrder] = winkTTSDataInfo;
        }
        this.f322571i = Arrays.asList((WinkTTSDataInfo[]) winkTTSDataInfoArr.clone());
    }

    private boolean u2(long j3) {
        TTSAudioInfo tTSAudioInfo = this.I;
        if (tTSAudioInfo != null && tTSAudioInfo.getAudioItems() != null) {
            for (TTSAudioItem tTSAudioItem : this.I.getAudioItems()) {
                if (c2(j3, tTSAudioItem)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void N1(TTSAudioInfo tTSAudioInfo) {
        TTSInterfaceDataSource tTSInterfaceDataSource;
        String str;
        if (tTSAudioInfo != null && tTSAudioInfo.getAudioItems() != null) {
            for (int i3 = 0; i3 < tTSAudioInfo.getAudioItems().length; i3++) {
                TTSAudioItem tTSAudioItem = tTSAudioInfo.getAudioItems()[i3];
                if (tTSAudioItem != null && tTSAudioItem.getAudioInfo() != null && tTSAudioInfo.getTexts() != null && (tTSInterfaceDataSource = this.H) != null) {
                    int templateType = tTSAudioInfo.getTemplateType();
                    if (tTSAudioInfo.getTexts().length > i3) {
                        str = tTSAudioInfo.getTexts()[i3];
                    } else {
                        str = "";
                    }
                    tTSInterfaceDataSource.f(templateType, str, tTSAudioItem);
                }
            }
        }
    }

    public void O1(WinkTTSDataInfo winkTTSDataInfo) {
        v2(null, true);
        if (winkTTSDataInfo != null) {
            t2(winkTTSDataInfo);
        }
    }

    public Boolean P1(@NonNull WinkTTSDataInfo winkTTSDataInfo) {
        TTSAudioInfo tTSAudioInfo = new TTSAudioInfo(this.D, winkTTSDataInfo.getTemplateType(), winkTTSDataInfo.getVolume());
        tTSAudioInfo.setDisplayName(winkTTSDataInfo.getDisplayName());
        TTSAudioItem[] tTSAudioItemArr = new TTSAudioItem[this.D.length];
        for (int i3 = 0; i3 < this.D.length; i3++) {
            TTSAudioItem h16 = this.H.h(winkTTSDataInfo.getTemplateType(), this.D[i3]);
            if (h16 == null) {
                return Boolean.FALSE;
            }
            tTSAudioItemArr[i3] = h16;
        }
        tTSAudioInfo.setAudioItems(tTSAudioItemArr);
        winkTTSDataInfo.setDownloadStatus(2);
        t2(winkTTSDataInfo);
        v2(tTSAudioInfo, false);
        return Boolean.TRUE;
    }

    public LiveData<Pair<TTSAudioInfo, Boolean>> Q1() {
        return this.F;
    }

    public WinkTTSDataInfo R1() {
        return this.G;
    }

    public Long S1() {
        TTSAudioInfo tTSAudioInfo = this.I;
        if (tTSAudioInfo != null && tTSAudioInfo.getAudioItems() != null && this.I.getAudioItems().length > 0) {
            return Long.valueOf(this.I.getAudioItems()[0].getStartTime());
        }
        return -1L;
    }

    public int T1() {
        return this.f322572m;
    }

    public float U1() {
        return this.C;
    }

    public TTSInterfaceDataSource X1() {
        return this.H;
    }

    public WinkTTSDataInfo Z1(TTSAudioInfo tTSAudioInfo) {
        List<WinkTTSDataInfo> list;
        if (tTSAudioInfo != null && (list = this.f322571i) != null && !list.isEmpty()) {
            if (this.G == null) {
                this.G = this.f322571i.get(0);
            }
            Iterator<WinkTTSDataInfo> it = this.f322571i.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WinkTTSDataInfo next = it.next();
                if (next.getTemplateType() == tTSAudioInfo.getTemplateType()) {
                    tTSAudioInfo.setDisplayName(next.getDisplayName());
                    if (!tTSAudioInfo.isAudioAvailable() && next.getTemplateType() != TTSAudioInfo.TYPE_TEMPLATE_TYPE_PLACEHOLDER) {
                        next.setDownloadStatus(0);
                        next.setVolume(tTSAudioInfo.getVolume());
                        return next;
                    }
                    next.setDownloadStatus(2);
                    next.setVolume(tTSAudioInfo.getVolume());
                    t2(next);
                    N1(tTSAudioInfo);
                }
            }
            return this.G;
        }
        return null;
    }

    public List<WinkTTSDataInfo> a2() {
        return this.f322571i;
    }

    public void b2() {
        try {
            JSONArray optJSONArray = l2().optJSONArray("data");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                List<WinkTTSDataInfo> list = this.f322571i;
                if (list != null) {
                    try {
                        list.clear();
                    } catch (UnsupportedOperationException e16) {
                        w53.b.e("ttsMaterialList error", e16);
                    }
                }
                ArrayList arrayList = new ArrayList();
                this.f322571i = arrayList;
                arrayList.add(W1());
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    WinkTTSDataInfo k26 = k2(optJSONArray.getJSONObject(i3));
                    if (k26 != null) {
                        this.f322571i.add(k26);
                    }
                }
                if (!this.K) {
                    o2();
                }
            }
        } catch (JSONException e17) {
            e17.printStackTrace();
        }
    }

    public boolean d2() {
        String[] strArr = this.D;
        if (strArr != null && strArr.length != 0) {
            return false;
        }
        return true;
    }

    public void e2(@NonNull WinkTTSDataInfo winkTTSDataInfo, boolean z16, a.InterfaceC9047a interfaceC9047a) {
        String[] strArr = this.D;
        if (strArr != null) {
            this.H.u(strArr, winkTTSDataInfo.getTemplateType(), new a(winkTTSDataInfo, interfaceC9047a));
        } else if (interfaceC9047a != null) {
            interfaceC9047a.a(winkTTSDataInfo.getTemplateType(), null, 1000008);
        }
    }

    public void g2(TTSAudioInfo tTSAudioInfo, boolean z16) {
        this.E.postValue(new Pair<>(tTSAudioInfo, Boolean.valueOf(z16)));
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return L;
    }

    public void h2(boolean z16) {
        g2(this.I, z16);
    }

    public void i2(long j3, long j16, boolean z16) {
        boolean z17;
        if (u2(j3) && z16) {
            z17 = true;
        } else {
            z17 = false;
        }
        WinkTTSDataInfo winkTTSDataInfo = this.G;
        if (winkTTSDataInfo != null && z17 != winkTTSDataInfo.isPlaying()) {
            this.G.setIsPlayingState(z17);
            this.J.postValue(Boolean.valueOf(z17));
        }
    }

    public void j2(@Nullable IPlayer.PlayerStatus playerStatus) {
        boolean z16;
        WinkTTSDataInfo winkTTSDataInfo;
        if (playerStatus == IPlayer.PlayerStatus.PLAYING) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && (winkTTSDataInfo = this.G) != null) {
            winkTTSDataInfo.setIsPlayingState(false);
            this.J.postValue(Boolean.FALSE);
        }
    }

    public void m2() {
        TTSInterfaceDataSource tTSInterfaceDataSource = this.H;
        if (tTSInterfaceDataSource != null) {
            tTSInterfaceDataSource.i();
        }
    }

    public void n2() {
        List<WinkTTSDataInfo> list = this.f322571i;
        if (list == null) {
            return;
        }
        for (WinkTTSDataInfo winkTTSDataInfo : list) {
            if (winkTTSDataInfo.getDownloadStatus() == 1) {
                winkTTSDataInfo.setDownloadStatus(0);
            }
        }
    }

    public void p2(int i3, float f16) {
        this.f322572m = i3;
        this.C = f16;
    }

    public void q2(boolean z16) {
        if (this.K != z16) {
            this.K = z16;
            o2();
        }
    }

    public void r2(@NonNull TTSAudioInfo tTSAudioInfo) {
        this.I = tTSAudioInfo;
        s2(tTSAudioInfo.getTexts());
    }

    public void s2(String[] strArr) {
        this.D = strArr;
        w53.b.c(L, "setTexts--" + strArr.toString());
    }

    public void t2(WinkTTSDataInfo winkTTSDataInfo) {
        if (winkTTSDataInfo == null) {
            return;
        }
        WinkTTSDataInfo winkTTSDataInfo2 = this.G;
        if (winkTTSDataInfo2 != null) {
            winkTTSDataInfo2.setSelected(false);
        }
        winkTTSDataInfo.setSelected(true);
        this.G = winkTTSDataInfo;
    }

    public void v2(TTSAudioInfo tTSAudioInfo, boolean z16) {
        if (z16 && tTSAudioInfo == null) {
            tTSAudioInfo = new TTSAudioInfo(this.D, TTSAudioInfo.TYPE_TEMPLATE_TYPE_PLACEHOLDER, 0.0f);
            tTSAudioInfo.setDisplayName("\u65e0");
        }
        TTSAudioInfo tTSAudioInfo2 = this.I;
        if (tTSAudioInfo2 != null && tTSAudioInfo != null) {
            this.I = tTSAudioInfo2.copy(tTSAudioInfo.getTemplateType(), tTSAudioInfo.getDisplayName(), tTSAudioInfo.getAudioItems(), tTSAudioInfo.getVolume(), this.I.getStickerId());
        } else {
            this.I = tTSAudioInfo;
        }
        g2(this.I, true);
    }

    public void w2(float f16) {
        TTSAudioInfo tTSAudioInfo = this.I;
        if (tTSAudioInfo != null) {
            this.C = f16;
            tTSAudioInfo.setVolume(f16);
            this.G.setVolume(f16);
        }
    }
}
