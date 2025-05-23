package com.qq.wx.voice.embedqqegg.recognizer;

import com.qq.wx.voice.embedqqegg.util.Common;
import com.qq.wx.voice.embedqqegg.util.LogTool;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes3.dex */
public class InnerSender implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private boolean f40931a = false;

    /* renamed from: b, reason: collision with root package name */
    private Grammar f40932b = new Grammar();

    /* renamed from: c, reason: collision with root package name */
    private boolean f40933c = false;

    /* renamed from: d, reason: collision with root package name */
    private InnerAudioList f40934d = null;

    private synchronized void e() {
        wait(100L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int a() {
        if (this.f40932b.init(InfoRecognizer.f40910a) < 0) {
            InfoRecognizer.f40913d.b(-201);
            return -1;
        }
        SDKVersion sDKVersion = new SDKVersion();
        a(sDKVersion);
        LogTool.d("soVer: " + sDKVersion.soVer + " binVer: " + sDKVersion.binVer);
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b() {
        this.f40931a = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c() {
        if (this.f40932b.destroy() < 0) {
            InfoRecognizer.f40913d.b(-206);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final synchronized void d() {
        notify();
    }

    @Override // java.lang.Runnable
    public void run() {
        VoiceRecognizerResult voiceRecognizerResult;
        int recognize;
        this.f40933c = false;
        boolean z16 = false;
        while (this.f40931a) {
            b b16 = this.f40934d.b();
            if (b16 != null) {
                InnerAudioState innerAudioState = b16.f40942b;
                if (innerAudioState == InnerAudioState.cancel) {
                    a(new VoiceRecognizerResult(true));
                } else {
                    if (innerAudioState == InnerAudioState.begin) {
                        if (this.f40932b.begin() < 0) {
                            InfoRecognizer.f40913d.b(-202);
                            return;
                        }
                        z16 = false;
                    }
                    if (z16) {
                        continue;
                    } else {
                        try {
                            LogTool.d("Recognize " + b16.f40941a.length + " bytes begin");
                            Grammar grammar = this.f40932b;
                            byte[] bArr = b16.f40941a;
                            recognize = grammar.recognize(bArr, bArr.length);
                            LogTool.d("Recognize " + b16.f40941a.length + " bytes finished");
                        } catch (Exception e16) {
                            e16.printStackTrace();
                        }
                        if (recognize < 0) {
                            InfoRecognizer.f40913d.b(-203);
                            return;
                        }
                        if (recognize == 1) {
                            GrammarResult grammarResult = new GrammarResult();
                            if (this.f40932b.getResult(grammarResult) < 0) {
                                InfoRecognizer.f40913d.b(-205);
                                return;
                            }
                            String str = grammarResult.text;
                            if (str != null && !str.isEmpty()) {
                                VoiceRecognizerResult voiceRecognizerResult2 = new VoiceRecognizerResult(true);
                                voiceRecognizerResult2.text = grammarResult.text;
                                a(voiceRecognizerResult2);
                                z16 = true;
                            }
                        }
                        InnerAudioState innerAudioState2 = b16.f40942b;
                        InnerAudioState innerAudioState3 = InnerAudioState.end;
                        if (innerAudioState2 == innerAudioState3 || innerAudioState2 == InnerAudioState.stop) {
                            if (this.f40932b.end() < 0) {
                                InfoRecognizer.f40913d.b(-204);
                                return;
                            }
                            if (!z16) {
                                GrammarResult grammarResult2 = new GrammarResult();
                                if (this.f40932b.getResult(grammarResult2) < 0) {
                                    InfoRecognizer.f40913d.b(-205);
                                    return;
                                }
                                if (InfoRecognizer.f40915f) {
                                    String str2 = grammarResult2.text;
                                    if (str2 != null && !str2.isEmpty()) {
                                        voiceRecognizerResult = new VoiceRecognizerResult(true);
                                    }
                                } else {
                                    voiceRecognizerResult = new VoiceRecognizerResult(false);
                                    String str3 = grammarResult2.text;
                                    if (str3 != null && !str3.isEmpty()) {
                                        voiceRecognizerResult.isEnd = true;
                                    }
                                }
                                voiceRecognizerResult.text = grammarResult2.text;
                                a(voiceRecognizerResult);
                            }
                            z16 = false;
                        }
                        try {
                            if (InfoRecognizer.f40916g || InfoRecognizer.f40917h) {
                                if (b16.f40942b == InnerAudioState.begin) {
                                    InfoRecognizer.f40919j.reset();
                                }
                                InfoRecognizer.f40919j.write(b16.f40941a);
                                InnerAudioState innerAudioState4 = b16.f40942b;
                                if (innerAudioState4 == innerAudioState3 || innerAudioState4 == InnerAudioState.stop || z16) {
                                    InfoRecognizer.f40919j.flush();
                                    if (InfoRecognizer.f40917h) {
                                        Common.saveFile(InfoRecognizer.f40919j.toByteArray(), "pcm", this.f40933c);
                                    }
                                }
                            }
                        } catch (IOException e17) {
                            e17.printStackTrace();
                        }
                        if (b16.f40942b == InnerAudioState.stop) {
                            return;
                        }
                    }
                }
            } else {
                try {
                    e();
                } catch (InterruptedException e18) {
                    e18.printStackTrace();
                }
            }
        }
    }

    public int setKeywordSetIndex(int i3) {
        return this.f40932b.setKeywordSetIndex(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int a(SDKVersion sDKVersion) {
        if (this.f40932b.getVersion(sDKVersion) >= 0) {
            return 0;
        }
        InfoRecognizer.f40913d.b(-208);
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(InnerAudioList innerAudioList) {
        this.f40934d = innerAudioList;
        InfoRecognizer.f40919j.reset();
        this.f40931a = true;
    }

    private void a(VoiceRecognizerResult voiceRecognizerResult) {
        String str = voiceRecognizerResult.text;
        if (str != null && !str.isEmpty()) {
            this.f40933c = true;
        }
        try {
            InfoRecognizer.f40919j.flush();
            voiceRecognizerResult.voiceRecordPCMData = InfoRecognizer.f40919j.toByteArray();
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        InfoRecognizer.f40913d.a(voiceRecognizerResult);
    }
}
