package androidx.core.net;

import android.net.TrafficStats;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;

/* compiled from: P */
/* loaded from: classes.dex */
public final class TrafficStatsCompat {
    TrafficStatsCompat() {
    }

    @Deprecated
    public static void clearThreadStatsTag() {
        TrafficStats.clearThreadStatsTag();
    }

    @Deprecated
    public static int getThreadStatsTag() {
        return TrafficStats.getThreadStatsTag();
    }

    @Deprecated
    public static void incrementOperationCount(int i3) {
        TrafficStats.incrementOperationCount(i3);
    }

    @Deprecated
    public static void setThreadStatsTag(int i3) {
        TrafficStats.setThreadStatsTag(i3);
    }

    public static void tagDatagramSocket(@NonNull DatagramSocket datagramSocket) throws SocketException {
        if (Build.VERSION.SDK_INT >= 24) {
            TrafficStats.tagDatagramSocket(datagramSocket);
            return;
        }
        ParcelFileDescriptor fromDatagramSocket = ParcelFileDescriptor.fromDatagramSocket(datagramSocket);
        TrafficStats.tagSocket(new DatagramSocketWrapper(datagramSocket, fromDatagramSocket.getFileDescriptor()));
        fromDatagramSocket.detachFd();
    }

    @Deprecated
    public static void tagSocket(Socket socket) throws SocketException {
        TrafficStats.tagSocket(socket);
    }

    public static void untagDatagramSocket(@NonNull DatagramSocket datagramSocket) throws SocketException {
        if (Build.VERSION.SDK_INT >= 24) {
            TrafficStats.untagDatagramSocket(datagramSocket);
            return;
        }
        ParcelFileDescriptor fromDatagramSocket = ParcelFileDescriptor.fromDatagramSocket(datagramSocket);
        TrafficStats.untagSocket(new DatagramSocketWrapper(datagramSocket, fromDatagramSocket.getFileDescriptor()));
        fromDatagramSocket.detachFd();
    }

    @Deprecated
    public static void untagSocket(Socket socket) throws SocketException {
        TrafficStats.untagSocket(socket);
    }

    @Deprecated
    public static void incrementOperationCount(int i3, int i16) {
        TrafficStats.incrementOperationCount(i3, i16);
    }
}
