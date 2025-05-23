package com.google.android.apps.internal.games.memoryadvice;

import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/* compiled from: P */
/* loaded from: classes2.dex */
class b {

    /* renamed from: b, reason: collision with root package name */
    private static final String f32926b = "b";

    /* renamed from: a, reason: collision with root package name */
    private MappedByteBuffer f32927a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(File file) {
        try {
            File createTempFile = File.createTempFile("mapped", ".txt", file);
            FileWriter fileWriter = new FileWriter(createTempFile);
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                try {
                    bufferedWriter.write("_");
                    bufferedWriter.close();
                    fileWriter.close();
                    FileInputStream fileInputStream = new FileInputStream(createTempFile);
                    try {
                        FileChannel channel = fileInputStream.getChannel();
                        try {
                            this.f32927a = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                            channel.close();
                            fileInputStream.close();
                            a();
                        } finally {
                        }
                    } finally {
                    }
                } finally {
                }
            } finally {
            }
        } catch (IOException e16) {
            Log.w(f32926b, e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        MappedByteBuffer mappedByteBuffer = this.f32927a;
        if (mappedByteBuffer != null) {
            mappedByteBuffer.load();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        if (this.f32927a == null) {
            return false;
        }
        return !r0.isLoaded();
    }
}
