package com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: P */
/* loaded from: classes31.dex */
public final class QQAudioFormat {
    public static final /* synthetic */ QQAudioFormat[] $VALUES;
    public static final QQAudioFormat WAV;

    static {
        QQAudioFormat qQAudioFormat = new QQAudioFormat();
        WAV = qQAudioFormat;
        $VALUES = new QQAudioFormat[]{qQAudioFormat};
    }

    public static QQAudioFormat valueOf(String str) {
        return (QQAudioFormat) Enum.valueOf(QQAudioFormat.class, str);
    }

    public static QQAudioFormat[] values() {
        return (QQAudioFormat[]) $VALUES.clone();
    }
}
