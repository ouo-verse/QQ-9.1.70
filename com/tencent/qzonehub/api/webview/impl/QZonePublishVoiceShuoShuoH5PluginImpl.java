package com.tencent.qzonehub.api.webview.impl;

import com.tencent.qzonehub.api.webview.IQZonePublishVoiceShuoShuoH5Plugin;
import cooperation.qzone.webviewplugin.QZonePublishVoiceShuoShuoH5Plugin;

/* loaded from: classes34.dex */
public class QZonePublishVoiceShuoShuoH5PluginImpl implements IQZonePublishVoiceShuoShuoH5Plugin {
    @Override // com.tencent.qzonehub.api.webview.IQZonePublishVoiceShuoShuoH5Plugin
    public void onDeleteAudioVoice(String str) {
        QZonePublishVoiceShuoShuoH5Plugin.onDeleteAudioVoice(str);
    }

    @Override // com.tencent.qzonehub.api.webview.IQZonePublishVoiceShuoShuoH5Plugin
    public void onNotifyH5CutCancel() {
        QZonePublishVoiceShuoShuoH5Plugin.onNotifyH5CutCancel();
    }
}
