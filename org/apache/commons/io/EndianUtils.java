package org.apache.commons.io;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes29.dex */
public class EndianUtils {
    private static int read(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (-1 != read) {
            return read;
        }
        throw new EOFException("Unexpected EOF reached");
    }

    public static double readSwappedDouble(byte[] bArr, int i3) {
        return Double.longBitsToDouble(readSwappedLong(bArr, i3));
    }

    public static float readSwappedFloat(byte[] bArr, int i3) {
        return Float.intBitsToFloat(readSwappedInteger(bArr, i3));
    }

    public static int readSwappedInteger(byte[] bArr, int i3) {
        return ((bArr[i3 + 0] & 255) << 0) + ((bArr[i3 + 1] & 255) << 8) + ((bArr[i3 + 2] & 255) << 16) + ((bArr[i3 + 3] & 255) << 24);
    }

    public static long readSwappedLong(byte[] bArr, int i3) {
        return (readSwappedInteger(bArr, i3 + 4) << 32) + (readSwappedInteger(bArr, i3) & 4294967295L);
    }

    public static short readSwappedShort(byte[] bArr, int i3) {
        return (short) (((bArr[i3 + 0] & 255) << 0) + ((bArr[i3 + 1] & 255) << 8));
    }

    public static long readSwappedUnsignedInteger(byte[] bArr, int i3) {
        return ((bArr[i3 + 3] & 255) << 24) + ((((bArr[i3 + 0] & 255) << 0) + ((bArr[i3 + 1] & 255) << 8) + ((bArr[i3 + 2] & 255) << 16)) & 4294967295L);
    }

    public static int readSwappedUnsignedShort(byte[] bArr, int i3) {
        return ((bArr[i3 + 0] & 255) << 0) + ((bArr[i3 + 1] & 255) << 8);
    }

    public static double swapDouble(double d16) {
        return Double.longBitsToDouble(swapLong(Double.doubleToLongBits(d16)));
    }

    public static float swapFloat(float f16) {
        return Float.intBitsToFloat(swapInteger(Float.floatToIntBits(f16)));
    }

    public static int swapInteger(int i3) {
        return (((i3 >> 0) & 255) << 24) + (((i3 >> 8) & 255) << 16) + (((i3 >> 16) & 255) << 8) + (((i3 >> 24) & 255) << 0);
    }

    public static long swapLong(long j3) {
        return (((j3 >> 0) & 255) << 56) + (((j3 >> 8) & 255) << 48) + (((j3 >> 16) & 255) << 40) + (((j3 >> 24) & 255) << 32) + (((j3 >> 32) & 255) << 24) + (((j3 >> 40) & 255) << 16) + (((j3 >> 48) & 255) << 8) + (((j3 >> 56) & 255) << 0);
    }

    public static short swapShort(short s16) {
        return (short) ((((s16 >> 0) & 255) << 8) + (((s16 >> 8) & 255) << 0));
    }

    public static void writeSwappedDouble(byte[] bArr, int i3, double d16) {
        writeSwappedLong(bArr, i3, Double.doubleToLongBits(d16));
    }

    public static void writeSwappedFloat(byte[] bArr, int i3, float f16) {
        writeSwappedInteger(bArr, i3, Float.floatToIntBits(f16));
    }

    public static void writeSwappedInteger(byte[] bArr, int i3, int i16) {
        bArr[i3 + 0] = (byte) ((i16 >> 0) & 255);
        bArr[i3 + 1] = (byte) ((i16 >> 8) & 255);
        bArr[i3 + 2] = (byte) ((i16 >> 16) & 255);
        bArr[i3 + 3] = (byte) ((i16 >> 24) & 255);
    }

    public static void writeSwappedLong(byte[] bArr, int i3, long j3) {
        bArr[i3 + 0] = (byte) ((j3 >> 0) & 255);
        bArr[i3 + 1] = (byte) ((j3 >> 8) & 255);
        bArr[i3 + 2] = (byte) ((j3 >> 16) & 255);
        bArr[i3 + 3] = (byte) ((j3 >> 24) & 255);
        bArr[i3 + 4] = (byte) ((j3 >> 32) & 255);
        bArr[i3 + 5] = (byte) ((j3 >> 40) & 255);
        bArr[i3 + 6] = (byte) ((j3 >> 48) & 255);
        bArr[i3 + 7] = (byte) ((j3 >> 56) & 255);
    }

    public static void writeSwappedShort(byte[] bArr, int i3, short s16) {
        bArr[i3 + 0] = (byte) ((s16 >> 0) & 255);
        bArr[i3 + 1] = (byte) ((s16 >> 8) & 255);
    }

    public static double readSwappedDouble(InputStream inputStream) throws IOException {
        return Double.longBitsToDouble(readSwappedLong(inputStream));
    }

    public static float readSwappedFloat(InputStream inputStream) throws IOException {
        return Float.intBitsToFloat(readSwappedInteger(inputStream));
    }

    public static int readSwappedInteger(InputStream inputStream) throws IOException {
        return ((read(inputStream) & 255) << 0) + ((read(inputStream) & 255) << 8) + ((read(inputStream) & 255) << 16) + ((read(inputStream) & 255) << 24);
    }

    public static short readSwappedShort(InputStream inputStream) throws IOException {
        return (short) (((read(inputStream) & 255) << 0) + ((read(inputStream) & 255) << 8));
    }

    public static int readSwappedUnsignedShort(InputStream inputStream) throws IOException {
        return ((read(inputStream) & 255) << 0) + ((read(inputStream) & 255) << 8);
    }

    public static void writeSwappedDouble(OutputStream outputStream, double d16) throws IOException {
        writeSwappedLong(outputStream, Double.doubleToLongBits(d16));
    }

    public static void writeSwappedFloat(OutputStream outputStream, float f16) throws IOException {
        writeSwappedInteger(outputStream, Float.floatToIntBits(f16));
    }

    public static long readSwappedLong(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[8];
        for (int i3 = 0; i3 < 8; i3++) {
            bArr[i3] = (byte) read(inputStream);
        }
        return readSwappedLong(bArr, 0);
    }

    public static long readSwappedUnsignedInteger(InputStream inputStream) throws IOException {
        return ((read(inputStream) & 255) << 24) + ((((read(inputStream) & 255) << 0) + ((read(inputStream) & 255) << 8) + ((read(inputStream) & 255) << 16)) & 4294967295L);
    }

    public static void writeSwappedShort(OutputStream outputStream, short s16) throws IOException {
        outputStream.write((byte) ((s16 >> 0) & 255));
        outputStream.write((byte) ((s16 >> 8) & 255));
    }

    public static void writeSwappedInteger(OutputStream outputStream, int i3) throws IOException {
        outputStream.write((byte) ((i3 >> 0) & 255));
        outputStream.write((byte) ((i3 >> 8) & 255));
        outputStream.write((byte) ((i3 >> 16) & 255));
        outputStream.write((byte) ((i3 >> 24) & 255));
    }

    public static void writeSwappedLong(OutputStream outputStream, long j3) throws IOException {
        outputStream.write((byte) ((j3 >> 0) & 255));
        outputStream.write((byte) ((j3 >> 8) & 255));
        outputStream.write((byte) ((j3 >> 16) & 255));
        outputStream.write((byte) ((j3 >> 24) & 255));
        outputStream.write((byte) ((j3 >> 32) & 255));
        outputStream.write((byte) ((j3 >> 40) & 255));
        outputStream.write((byte) ((j3 >> 48) & 255));
        outputStream.write((byte) ((j3 >> 56) & 255));
    }
}
