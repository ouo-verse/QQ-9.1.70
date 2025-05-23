package com.tencent.mobileqq.wink.editor.tts.source;

import camera.MOBILE_QQ_MATERIAL_INTERFACE.AudioInfo;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.TTSInterfaceRsp;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.remote.FromServiceMsg;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u001b\b\u0016\u0012\b\u0010\r\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/tts/source/b;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "", "type", "", "isSuccess", "", "data", "", "onUpdate", "Lcom/tencent/mobileqq/wink/editor/tts/source/a;", "d", "Lcom/tencent/mobileqq/wink/editor/tts/source/a;", "callback", "e", "I", "hashcode", "<init>", "(Lcom/tencent/mobileqq/wink/editor/tts/source/a;I)V", "f", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b implements BusinessObserver {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a callback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int hashcode;

    public b(@Nullable a aVar, int i3) {
        this.callback = aVar;
        this.hashcode = i3;
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int type, boolean isSuccess, @Nullable Object data) {
        Pair pair;
        FromServiceMsg fromServiceMsg;
        AudioInfo[] audioInfoArr;
        w53.b.c("TTSInterfaceDataSource", "download result: " + type);
        if (type == this.hashcode) {
            com.tencent.mobileqq.wink.b.a().removeObserver(this);
            if (data instanceof Pair) {
                pair = (Pair) data;
            } else {
                pair = null;
            }
            if (pair != null) {
                fromServiceMsg = (FromServiceMsg) pair.getFirst();
            } else {
                fromServiceMsg = null;
            }
            if (fromServiceMsg == null) {
                w53.b.c("TTSInterfaceDataSource", "query result null");
                a aVar = this.callback;
                if (aVar != null) {
                    aVar.a(1000002, null);
                    return;
                }
                return;
            }
            TTSInterfaceRsp tTSInterfaceRsp = (TTSInterfaceRsp) pair.getSecond();
            int i3 = 0;
            if (tTSInterfaceRsp != null && (audioInfoArr = tTSInterfaceRsp.AudioInfos) != null) {
                TTSAudioItem[] tTSAudioItemArr = new TTSAudioItem[audioInfoArr.length];
                int length = audioInfoArr.length;
                int i16 = 0;
                while (i3 < length) {
                    tTSAudioItemArr[i16] = new TTSAudioItem(audioInfoArr[i3]);
                    i3++;
                    i16++;
                }
                a aVar2 = this.callback;
                if (aVar2 != null) {
                    aVar2.a(1000001, tTSAudioItemArr);
                    return;
                }
                return;
            }
            a aVar3 = this.callback;
            if (aVar3 != null) {
                aVar3.a(1000002, new TTSAudioItem[0]);
            }
        }
    }
}
