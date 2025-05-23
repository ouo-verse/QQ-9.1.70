package com.tencent.mobileqq.data;

import android.content.res.AssetManager;
import android.util.Log;
import android.util.Pair;
import androidx.exifinterface.media.ExifInterface;
import com.gcloudsdk.gcloud.voice.GCloudVoiceErrorCode;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.view.FilterEnum;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Pattern;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ExpandExifInterface {
    private static final Charset ASCII;
    private static final short BYTE_ALIGN_II = 18761;
    private static final short BYTE_ALIGN_MM = 19789;
    private static final boolean DEBUG = false;
    private static final ExifTag[][] EXIF_TAGS;
    private static final byte[] IDENTIFIER_EXIF_APP1;
    private static final int IFD_EXIF_HINT = 1;
    private static final ExifTag[] IFD_EXIF_TAGS;
    private static final int IFD_FORMAT_BYTE = 1;
    private static final int IFD_FORMAT_DOUBLE = 12;
    private static final int IFD_FORMAT_SBYTE = 6;
    private static final int IFD_FORMAT_SINGLE = 11;
    private static final int IFD_FORMAT_SLONG = 9;
    private static final int IFD_FORMAT_SRATIONAL = 10;
    private static final int IFD_FORMAT_SSHORT = 8;
    private static final int IFD_FORMAT_STRING = 2;
    private static final int IFD_FORMAT_ULONG = 4;
    private static final int IFD_FORMAT_UNDEFINED = 7;
    private static final int IFD_FORMAT_URATIONAL = 5;
    private static final int IFD_FORMAT_USHORT = 3;
    private static final int IFD_GPS_HINT = 2;
    private static final ExifTag[] IFD_GPS_TAGS;
    private static final int IFD_INTEROPERABILITY_HINT = 3;
    private static final ExifTag[] IFD_INTEROPERABILITY_TAGS;
    private static final ExifTag[] IFD_POINTER_TAGS;
    private static final int[] IFD_POINTER_TAG_HINTS;
    private static final int IFD_THUMBNAIL_HINT = 4;
    private static final ExifTag[] IFD_THUMBNAIL_TAGS;
    private static final int IFD_TIFF_HINT = 0;
    private static final ExifTag[] IFD_TIFF_TAGS;
    private static final ExifTag JPEG_INTERCHANGE_FORMAT_LENGTH_TAG;
    private static final ExifTag JPEG_INTERCHANGE_FORMAT_TAG;
    private static final int JPEG_SIGNATURE_SIZE = 3;
    private static final byte MARKER = -1;
    private static final byte MARKER_APP1 = -31;
    private static final byte MARKER_COM = -2;
    private static final byte MARKER_EOI = -39;
    private static final byte MARKER_SOF0 = -64;
    private static final byte MARKER_SOF1 = -63;
    private static final byte MARKER_SOF10 = -54;
    private static final byte MARKER_SOF11 = -53;
    private static final byte MARKER_SOF13 = -51;
    private static final byte MARKER_SOF14 = -50;
    private static final byte MARKER_SOF15 = -49;
    private static final byte MARKER_SOF2 = -62;
    private static final byte MARKER_SOF3 = -61;
    private static final byte MARKER_SOF5 = -59;
    private static final byte MARKER_SOF6 = -58;
    private static final byte MARKER_SOF7 = -57;
    private static final byte MARKER_SOF9 = -55;
    private static final byte MARKER_SOS = -38;
    public static final int ORIENTATION_FLIP_HORIZONTAL = 2;
    public static final int ORIENTATION_FLIP_VERTICAL = 4;
    public static final int ORIENTATION_NORMAL = 1;
    public static final int ORIENTATION_ROTATE_180 = 3;
    public static final int ORIENTATION_ROTATE_270 = 8;
    public static final int ORIENTATION_ROTATE_90 = 6;
    public static final int ORIENTATION_TRANSPOSE = 5;
    public static final int ORIENTATION_TRANSVERSE = 7;
    public static final int ORIENTATION_UNDEFINED = 0;
    private static final String TAG = "ExpandExifInterface";

    @Deprecated
    public static final String TAG_APERTURE = "FNumber";
    public static final String TAG_APERTURE_VALUE = "ApertureValue";
    public static final String TAG_ARTIST = "Artist";
    public static final String TAG_BITS_PER_SAMPLE = "BitsPerSample";
    public static final String TAG_BRIGHTNESS_VALUE = "BrightnessValue";
    public static final String TAG_CFA_PATTERN = "CFAPattern";
    public static final String TAG_COLOR_SPACE = "ColorSpace";
    public static final String TAG_COMPONENTS_CONFIGURATION = "ComponentsConfiguration";
    public static final String TAG_COMPRESSED_BITS_PER_PIXEL = "CompressedBitsPerPixel";
    public static final String TAG_COMPRESSION = "Compression";
    public static final String TAG_CONTRAST = "Contrast";
    public static final String TAG_COPYRIGHT = "Copyright";
    public static final String TAG_CUSTOM_RENDERED = "CustomRendered";
    public static final String TAG_DATETIME = "DateTime";
    public static final String TAG_DATETIME_DIGITIZED = "DateTimeDigitized";
    public static final String TAG_DATETIME_ORIGINAL = "DateTimeOriginal";
    public static final String TAG_DEVICE_SETTING_DESCRIPTION = "DeviceSettingDescription";
    public static final String TAG_DIGITAL_ZOOM_RATIO = "DigitalZoomRatio";
    private static final String TAG_EXIF_IFD_POINTER = "ExifIFDPointer";
    public static final String TAG_EXIF_VERSION = "ExifVersion";
    public static final String TAG_EXPOSURE_BIAS_VALUE = "ExposureBiasValue";
    public static final String TAG_EXPOSURE_INDEX = "ExposureIndex";
    public static final String TAG_EXPOSURE_MODE = "ExposureMode";
    public static final String TAG_EXPOSURE_PROGRAM = "ExposureProgram";
    public static final String TAG_EXPOSURE_TIME = "ExposureTime";
    public static final String TAG_FILE_SOURCE = "FileSource";
    public static final String TAG_FLASH = "Flash";
    public static final String TAG_FLASHPIX_VERSION = "FlashpixVersion";
    public static final String TAG_FLASH_ENERGY = "FlashEnergy";
    public static final String TAG_FOCAL_LENGTH = "FocalLength";
    public static final String TAG_FOCAL_LENGTH_IN_35MM_FILM = "FocalLengthIn35mmFilm";
    public static final String TAG_FOCAL_PLANE_RESOLUTION_UNIT = "FocalPlaneResolutionUnit";
    public static final String TAG_FOCAL_PLANE_X_RESOLUTION = "FocalPlaneXResolution";
    public static final String TAG_FOCAL_PLANE_Y_RESOLUTION = "FocalPlaneYResolution";
    public static final String TAG_F_NUMBER = "FNumber";
    public static final String TAG_GAIN_CONTROL = "GainControl";
    public static final String TAG_GPS_ALTITUDE = "GPSAltitude";
    public static final String TAG_GPS_ALTITUDE_REF = "GPSAltitudeRef";
    public static final String TAG_GPS_AREA_INFORMATION = "GPSAreaInformation";
    public static final String TAG_GPS_DATESTAMP = "GPSDateStamp";
    public static final String TAG_GPS_DEST_BEARING = "GPSDestBearing";
    public static final String TAG_GPS_DEST_BEARING_REF = "GPSDestBearingRef";
    public static final String TAG_GPS_DEST_DISTANCE = "GPSDestDistance";
    public static final String TAG_GPS_DEST_DISTANCE_REF = "GPSDestDistanceRef";
    public static final String TAG_GPS_DEST_LATITUDE = "GPSDestLatitude";
    public static final String TAG_GPS_DEST_LATITUDE_REF = "GPSDestLatitudeRef";
    public static final String TAG_GPS_DEST_LONGITUDE = "GPSDestLongitude";
    public static final String TAG_GPS_DEST_LONGITUDE_REF = "GPSDestLongitudeRef";
    public static final String TAG_GPS_DIFFERENTIAL = "GPSDifferential";
    public static final String TAG_GPS_DOP = "GPSDOP";
    public static final String TAG_GPS_IMG_DIRECTION = "GPSImgDirection";
    public static final String TAG_GPS_IMG_DIRECTION_REF = "GPSImgDirectionRef";
    private static final String TAG_GPS_INFO_IFD_POINTER = "GPSInfoIFDPointer";
    public static final String TAG_GPS_LATITUDE = "GPSLatitude";
    public static final String TAG_GPS_LATITUDE_REF = "GPSLatitudeRef";
    public static final String TAG_GPS_LONGITUDE = "GPSLongitude";
    public static final String TAG_GPS_LONGITUDE_REF = "GPSLongitudeRef";
    public static final String TAG_GPS_MAP_DATUM = "GPSMapDatum";
    public static final String TAG_GPS_MEASURE_MODE = "GPSMeasureMode";
    public static final String TAG_GPS_PROCESSING_METHOD = "GPSProcessingMethod";
    public static final String TAG_GPS_SATELLITES = "GPSSatellites";
    public static final String TAG_GPS_SPEED = "GPSSpeed";
    public static final String TAG_GPS_SPEED_REF = "GPSSpeedRef";
    public static final String TAG_GPS_STATUS = "GPSStatus";
    public static final String TAG_GPS_TIMESTAMP = "GPSTimeStamp";
    public static final String TAG_GPS_TRACK = "GPSTrack";
    public static final String TAG_GPS_TRACK_REF = "GPSTrackRef";
    public static final String TAG_GPS_VERSION_ID = "GPSVersionID";
    public static final String TAG_IMAGE_DESCRIPTION = "ImageDescription";
    public static final String TAG_IMAGE_LENGTH = "ImageLength";
    public static final String TAG_IMAGE_UNIQUE_ID = "ImageUniqueID";
    public static final String TAG_IMAGE_WIDTH = "ImageWidth";
    private static final String TAG_INTEROPERABILITY_IFD_POINTER = "InteroperabilityIFDPointer";
    public static final String TAG_INTEROPERABILITY_INDEX = "InteroperabilityIndex";

    @Deprecated
    public static final String TAG_ISO = "ISOSpeedRatings";
    public static final String TAG_ISO_SPEED_RATINGS = "ISOSpeedRatings";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT = "JPEGInterchangeFormat";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT_LENGTH = "JPEGInterchangeFormatLength";
    public static final String TAG_LIGHT_SOURCE = "LightSource";
    public static final String TAG_MAKE = "Make";
    public static final String TAG_MAKER_NOTE = "MakerNote";
    public static final String TAG_MAX_APERTURE_VALUE = "MaxApertureValue";
    public static final String TAG_METERING_MODE = "MeteringMode";
    public static final String TAG_MODEL = "Model";
    public static final String TAG_OECF = "OECF";
    public static final String TAG_ORIENTATION = "Orientation";
    public static final String TAG_PHOTOMETRIC_INTERPRETATION = "PhotometricInterpretation";
    public static final String TAG_PIXEL_X_DIMENSION = "PixelXDimension";
    public static final String TAG_PIXEL_Y_DIMENSION = "PixelYDimension";
    public static final String TAG_PLANAR_CONFIGURATION = "PlanarConfiguration";
    public static final String TAG_PRIMARY_CHROMATICITIES = "PrimaryChromaticities";
    public static final String TAG_REFERENCE_BLACK_WHITE = "ReferenceBlackWhite";
    public static final String TAG_RELATED_SOUND_FILE = "RelatedSoundFile";
    public static final String TAG_RESOLUTION_UNIT = "ResolutionUnit";
    public static final String TAG_ROWS_PER_STRIP = "RowsPerStrip";
    public static final String TAG_SAMPLES_PER_PIXEL = "SamplesPerPixel";
    public static final String TAG_SATURATION = "Saturation";
    public static final String TAG_SCENE_CAPTURE_TYPE = "SceneCaptureType";
    public static final String TAG_SCENE_TYPE = "SceneType";
    public static final String TAG_SENSING_METHOD = "SensingMethod";
    public static final String TAG_SHARPNESS = "Sharpness";
    public static final String TAG_SHUTTER_SPEED_VALUE = "ShutterSpeedValue";
    public static final String TAG_SOFTWARE = "Software";
    public static final String TAG_SPATIAL_FREQUENCY_RESPONSE = "SpatialFrequencyResponse";
    public static final String TAG_SPECTRAL_SENSITIVITY = "SpectralSensitivity";
    public static final String TAG_STRIP_BYTE_COUNTS = "StripByteCounts";
    public static final String TAG_STRIP_OFFSETS = "StripOffsets";
    public static final String TAG_SUBJECT_AREA = "SubjectArea";
    public static final String TAG_SUBJECT_DISTANCE = "SubjectDistance";
    public static final String TAG_SUBJECT_DISTANCE_RANGE = "SubjectDistanceRange";
    public static final String TAG_SUBJECT_LOCATION = "SubjectLocation";
    public static final String TAG_SUBSEC_TIME = "SubSecTime";
    public static final String TAG_SUBSEC_TIME_DIG = "SubSecTimeDigitized";
    public static final String TAG_SUBSEC_TIME_DIGITIZED = "SubSecTimeDigitized";
    public static final String TAG_SUBSEC_TIME_ORIG = "SubSecTimeOriginal";
    public static final String TAG_SUBSEC_TIME_ORIGINAL = "SubSecTimeOriginal";
    public static final String TAG_THUMBNAIL_IMAGE_LENGTH = "ThumbnailImageLength";
    public static final String TAG_THUMBNAIL_IMAGE_WIDTH = "ThumbnailImageWidth";
    public static final String TAG_TRANSFER_FUNCTION = "TransferFunction";
    public static final String TAG_USER_COMMENT = "UserComment";
    public static final String TAG_WHITE_BALANCE = "WhiteBalance";
    public static final String TAG_WHITE_POINT = "WhitePoint";
    public static final String TAG_X_RESOLUTION = "XResolution";
    public static final String TAG_Y_CB_CR_COEFFICIENTS = "YCbCrCoefficients";
    public static final String TAG_Y_CB_CR_POSITIONING = "YCbCrPositioning";
    public static final String TAG_Y_CB_CR_SUB_SAMPLING = "YCbCrSubSampling";
    public static final String TAG_Y_RESOLUTION = "YResolution";
    public static final int WHITEBALANCE_AUTO = 0;
    public static final int WHITEBALANCE_MANUAL = 1;
    private static final HashMap[] sExifTagMapsForReading;
    private static final HashMap[] sExifTagMapsForWriting;
    private static SimpleDateFormat sFormatter;
    private static final Pattern sGpsTimestampPattern;
    private static final Pattern sNonZeroTimePattern;
    private static final HashSet<String> sTagSetForCompatibility;
    private final AssetManager.AssetInputStream mAssetInputStream;
    private final HashMap[] mAttributes = new HashMap[EXIF_TAGS.length];
    private ByteOrder mExifByteOrder = ByteOrder.BIG_ENDIAN;
    private final String mFilename;
    private final boolean mIsInputStream;
    private boolean mIsRaw;
    private static final byte MARKER_SOI = -40;
    private static final byte[] JPEG_SIGNATURE = {-1, MARKER_SOI, -1};
    private static final String[] IFD_FORMAT_NAMES = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE"};
    private static final int[] IFD_FORMAT_BYTES_PER_FORMAT = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
    private static final byte[] EXIF_ASCII_PREFIX = {65, 83, 67, 73, 73, 0, 0, 0};
    private static byte[] mBuf = new byte[8192];

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class ByteOrderAwarenessDataInputStream extends ByteArrayInputStream {
        private ByteOrder mByteOrder;
        private final long mLength;
        private long mPosition;
        private static final ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        private static final ByteOrder BIG_ENDIAN = ByteOrder.BIG_ENDIAN;

        public ByteOrderAwarenessDataInputStream(byte[] bArr) {
            super(bArr);
            this.mByteOrder = ByteOrder.BIG_ENDIAN;
            this.mLength = bArr.length;
            this.mPosition = 0L;
        }

        public long peek() {
            return this.mPosition;
        }

        public byte readByte() throws IOException {
            long j3 = this.mPosition + 1;
            this.mPosition = j3;
            if (j3 <= this.mLength) {
                int read = super.read();
                if (read >= 0) {
                    return (byte) read;
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readLong());
        }

        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readInt());
        }

        public void readFully(byte[] bArr) throws IOException {
            long length = this.mPosition + bArr.length;
            this.mPosition = length;
            if (length <= this.mLength) {
                if (super.read(bArr, 0, bArr.length) == bArr.length) {
                    return;
                } else {
                    throw new IOException("Couldn't read up to the length of buffer");
                }
            }
            throw new EOFException();
        }

        public int readInt() throws IOException {
            long j3 = this.mPosition + 4;
            this.mPosition = j3;
            if (j3 <= this.mLength) {
                int read = super.read();
                int read2 = super.read();
                int read3 = super.read();
                int read4 = super.read();
                if ((read | read2 | read3 | read4) >= 0) {
                    ByteOrder byteOrder = this.mByteOrder;
                    if (byteOrder == LITTLE_ENDIAN) {
                        return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                    }
                    if (byteOrder == BIG_ENDIAN) {
                        return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
                    }
                    throw new IOException("Invalid byte order: " + this.mByteOrder);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public long readLong() throws IOException {
            long j3 = this.mPosition + 8;
            this.mPosition = j3;
            if (j3 <= this.mLength) {
                int read = super.read();
                int read2 = super.read();
                int read3 = super.read();
                int read4 = super.read();
                int read5 = super.read();
                int read6 = super.read();
                int read7 = super.read();
                int read8 = super.read();
                if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) >= 0) {
                    ByteOrder byteOrder = this.mByteOrder;
                    if (byteOrder == LITTLE_ENDIAN) {
                        return (read8 << 56) + (read7 << 48) + (read6 << 40) + (read5 << 32) + (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                    }
                    if (byteOrder == BIG_ENDIAN) {
                        return (read << 56) + (read2 << 48) + (read3 << 40) + (read4 << 32) + (read5 << 24) + (read6 << 16) + (read7 << 8) + read8;
                    }
                    throw new IOException("Invalid byte order: " + this.mByteOrder);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public short readShort() throws IOException {
            long j3 = this.mPosition + 2;
            this.mPosition = j3;
            if (j3 <= this.mLength) {
                int read = super.read();
                int read2 = super.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.mByteOrder;
                    if (byteOrder == LITTLE_ENDIAN) {
                        return (short) ((read2 << 8) + read);
                    }
                    if (byteOrder == BIG_ENDIAN) {
                        return (short) ((read << 8) + read2);
                    }
                    throw new IOException("Invalid byte order: " + this.mByteOrder);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public long readUnsignedInt() throws IOException {
            return readInt() & 4294967295L;
        }

        public int readUnsignedShort() throws IOException {
            long j3 = this.mPosition + 2;
            this.mPosition = j3;
            if (j3 <= this.mLength) {
                int read = super.read();
                int read2 = super.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.mByteOrder;
                    if (byteOrder == LITTLE_ENDIAN) {
                        return (read2 << 8) + read;
                    }
                    if (byteOrder == BIG_ENDIAN) {
                        return (read << 8) + read2;
                    }
                    throw new IOException("Invalid byte order: " + this.mByteOrder);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public void seek(long j3) throws IOException {
            this.mPosition = 0L;
            reset();
            if (skip(j3) == j3) {
            } else {
                throw new IOException("Couldn't seek up to the byteCount");
            }
        }

        public void setByteOrder(ByteOrder byteOrder) {
            this.mByteOrder = byteOrder;
        }

        @Override // java.io.ByteArrayInputStream, java.io.InputStream
        public long skip(long j3) {
            long skip = super.skip(Math.min(j3, this.mLength - this.mPosition));
            this.mPosition += skip;
            return skip;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class Rational {
        public final long denominator;
        public final long numerator;

        Rational(long j3, long j16) {
            if (j16 == 0) {
                this.numerator = 0L;
                this.denominator = 1L;
            } else {
                this.numerator = j3;
                this.denominator = j16;
            }
        }

        public double calculate() {
            return this.numerator / this.denominator;
        }

        public String toString() {
            return this.numerator + "/" + this.denominator;
        }
    }

    static {
        ExifTag[] exifTagArr = {new ExifTag("ImageWidth", 256, 3, 4), new ExifTag("ImageLength", 257, 3, 4), new ExifTag("BitsPerSample", 258, 3), new ExifTag("Compression", 259, 3), new ExifTag("PhotometricInterpretation", 262, 3), new ExifTag("ImageDescription", 270, 2), new ExifTag("Make", 271, 2), new ExifTag("Model", 272, 2), new ExifTag("StripOffsets", 273, 3, 4), new ExifTag("Orientation", 274, 3), new ExifTag("SamplesPerPixel", 277, 3), new ExifTag("RowsPerStrip", 278, 3, 4), new ExifTag("StripByteCounts", FilterEnum.MIC_PTU_TRANS_ROUHE, 3, 4), new ExifTag("XResolution", FilterEnum.MIC_PTU_BAIXI, 5), new ExifTag("YResolution", 283, 5), new ExifTag("PlanarConfiguration", 284, 3), new ExifTag("ResolutionUnit", 296, 3), new ExifTag("TransferFunction", 301, 3), new ExifTag("Software", 305, 2), new ExifTag("DateTime", 306, 2), new ExifTag("Artist", 315, 2), new ExifTag("WhitePoint", 318, 5), new ExifTag("PrimaryChromaticities", 319, 5), new ExifTag("JPEGInterchangeFormat", 513, 4), new ExifTag("JPEGInterchangeFormatLength", 514, 4), new ExifTag("YCbCrCoefficients", 529, 5), new ExifTag("YCbCrSubSampling", 530, 3), new ExifTag("YCbCrPositioning", TVKQQLiveAssetPlayerMsg.PLAYER_INFO_ON_RICH_MEDIA_PREPARED, 3), new ExifTag("ReferenceBlackWhite", TVKQQLiveAssetPlayerMsg.PLAYER_INFO_ON_RICH_MEDIA_PREPARE_FAILED, 5), new ExifTag("Copyright", 33432, 2), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4)};
        IFD_TIFF_TAGS = exifTagArr;
        ExifTag[] exifTagArr2 = {new ExifTag("ExposureTime", 33434, 5), new ExifTag("FNumber", 33437, 5), new ExifTag("ExposureProgram", 34850, 3), new ExifTag("SpectralSensitivity", 34852, 2), new ExifTag("ISOSpeedRatings", 34855, 3), new ExifTag("OECF", 34856, 7), new ExifTag("ExifVersion", 36864, 2), new ExifTag("DateTimeOriginal", GCloudVoiceErrorCode.GCloudVoiceErrno.GCLOUD_VOICE_COORDINATE_ROOMNAME_ERROR, 2), new ExifTag("DateTimeDigitized", 36868, 2), new ExifTag("ComponentsConfiguration", 37121, 7), new ExifTag("CompressedBitsPerPixel", 37122, 5), new ExifTag("ShutterSpeedValue", 37377, 10), new ExifTag("ApertureValue", 37378, 5), new ExifTag("BrightnessValue", 37379, 10), new ExifTag("ExposureBiasValue", 37380, 10), new ExifTag("MaxApertureValue", 37381, 5), new ExifTag("SubjectDistance", 37382, 5), new ExifTag("MeteringMode", 37383, 3), new ExifTag("LightSource", 37384, 3), new ExifTag("Flash", 37385, 3), new ExifTag("FocalLength", 37386, 5), new ExifTag("SubjectArea", 37396, 3), new ExifTag("MakerNote", 37500, 7), new ExifTag("UserComment", 37510, 7), new ExifTag("SubSecTime", 37520, 2), new ExifTag("SubSecTimeOriginal", 37521, 2), new ExifTag("SubSecTimeDigitized", 37522, 2), new ExifTag("FlashpixVersion", 40960, 7), new ExifTag("ColorSpace", GCloudVoiceErrorCode.GCloudVoiceCompleteCode.GV_ON_ST_SUCC, 3), new ExifTag("PixelXDimension", GCloudVoiceErrorCode.GCloudVoiceCompleteCode.GV_ON_ST_HTTP_ERROR, 3, 4), new ExifTag("PixelYDimension", GCloudVoiceErrorCode.GCloudVoiceCompleteCode.GV_ON_ST_SERVER_ERROR, 3, 4), new ExifTag("RelatedSoundFile", GCloudVoiceErrorCode.GCloudVoiceCompleteCode.GV_ON_ST_INVALID_JSON, 2), new ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, GCloudVoiceErrorCode.GCloudVoiceCompleteCode.GV_ON_ST_ALREADY_EXIST, 4), new ExifTag("FlashEnergy", 41483, 5), new ExifTag("SpatialFrequencyResponse", 41484, 7), new ExifTag("FocalPlaneXResolution", 41486, 5), new ExifTag("FocalPlaneYResolution", 41487, 5), new ExifTag("FocalPlaneResolutionUnit", 41488, 3), new ExifTag("SubjectLocation", 41492, 3), new ExifTag("ExposureIndex", 41493, 5), new ExifTag("SensingMethod", 41495, 3), new ExifTag("FileSource", 41728, 7), new ExifTag("SceneType", 41729, 7), new ExifTag("CFAPattern", 41730, 7), new ExifTag("CustomRendered", 41985, 3), new ExifTag("ExposureMode", 41986, 3), new ExifTag("WhiteBalance", ProfileContants.FIELD_HAS_NEARBY_AVATAR_FLAG, 3), new ExifTag("DigitalZoomRatio", 41988, 5), new ExifTag("FocalLengthIn35mmFilm", 41989, 3), new ExifTag("SceneCaptureType", 41990, 3), new ExifTag("GainControl", 41991, 3), new ExifTag("Contrast", 41992, 3), new ExifTag("Saturation", ProfileContants.FIELD_FRESHNEWS_NOTIFY_SWITCH, 3), new ExifTag("Sharpness", 41994, 3), new ExifTag("DeviceSettingDescription", 41995, 7), new ExifTag("SubjectDistanceRange", 41996, 3), new ExifTag("ImageUniqueID", 42016, 2)};
        IFD_EXIF_TAGS = exifTagArr2;
        ExifTag[] exifTagArr3 = {new ExifTag("GPSVersionID", 0, 1), new ExifTag("GPSLatitudeRef", 1, 2), new ExifTag("GPSLatitude", 2, 5), new ExifTag("GPSLongitudeRef", 3, 2), new ExifTag("GPSLongitude", 4, 5), new ExifTag("GPSAltitudeRef", 5, 1), new ExifTag("GPSAltitude", 6, 5), new ExifTag("GPSTimeStamp", 7, 5), new ExifTag("GPSSatellites", 8, 2), new ExifTag("GPSStatus", 9, 2), new ExifTag("GPSMeasureMode", 10, 2), new ExifTag("GPSDOP", 11, 5), new ExifTag("GPSSpeedRef", 12, 2), new ExifTag("GPSSpeed", 13, 5), new ExifTag("GPSTrackRef", 14, 2), new ExifTag("GPSTrack", 15, 5), new ExifTag("GPSImgDirectionRef", 16, 2), new ExifTag("GPSImgDirection", 17, 5), new ExifTag("GPSMapDatum", 18, 2), new ExifTag("GPSDestLatitudeRef", 19, 2), new ExifTag("GPSDestLatitude", 20, 5), new ExifTag("GPSDestLongitudeRef", 21, 2), new ExifTag("GPSDestLongitude", 22, 5), new ExifTag("GPSDestBearingRef", 23, 2), new ExifTag("GPSDestBearing", 24, 5), new ExifTag("GPSDestDistanceRef", 25, 2), new ExifTag("GPSDestDistance", 26, 5), new ExifTag("GPSProcessingMethod", 27, 7), new ExifTag("GPSAreaInformation", 28, 7), new ExifTag("GPSDateStamp", 29, 2), new ExifTag("GPSDifferential", 30, 3)};
        IFD_GPS_TAGS = exifTagArr3;
        ExifTag[] exifTagArr4 = {new ExifTag("InteroperabilityIndex", 1, 2)};
        IFD_INTEROPERABILITY_TAGS = exifTagArr4;
        ExifTag[] exifTagArr5 = {new ExifTag("ThumbnailImageWidth", 256, 3, 4), new ExifTag("ThumbnailImageLength", 257, 3, 4), new ExifTag("BitsPerSample", 258, 3), new ExifTag("Compression", 259, 3), new ExifTag("PhotometricInterpretation", 262, 3), new ExifTag("ImageDescription", 270, 2), new ExifTag("Make", 271, 2), new ExifTag("Model", 272, 2), new ExifTag("StripOffsets", 3, 4), new ExifTag("Orientation", 274, 3), new ExifTag("SamplesPerPixel", 277, 3), new ExifTag("RowsPerStrip", 278, 3, 4), new ExifTag("StripByteCounts", FilterEnum.MIC_PTU_TRANS_ROUHE, 3, 4), new ExifTag("XResolution", FilterEnum.MIC_PTU_BAIXI, 5), new ExifTag("YResolution", 283, 5), new ExifTag("PlanarConfiguration", 284, 3), new ExifTag("ResolutionUnit", 296, 3), new ExifTag("TransferFunction", 301, 3), new ExifTag("Software", 305, 2), new ExifTag("DateTime", 306, 2), new ExifTag("Artist", 315, 2), new ExifTag("WhitePoint", 318, 5), new ExifTag("PrimaryChromaticities", 319, 5), new ExifTag("JPEGInterchangeFormat", 513, 4), new ExifTag("JPEGInterchangeFormatLength", 514, 4), new ExifTag("YCbCrCoefficients", 529, 5), new ExifTag("YCbCrSubSampling", 530, 3), new ExifTag("YCbCrPositioning", TVKQQLiveAssetPlayerMsg.PLAYER_INFO_ON_RICH_MEDIA_PREPARED, 3), new ExifTag("ReferenceBlackWhite", TVKQQLiveAssetPlayerMsg.PLAYER_INFO_ON_RICH_MEDIA_PREPARE_FAILED, 5), new ExifTag("Copyright", 33432, 2), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4)};
        IFD_THUMBNAIL_TAGS = exifTagArr5;
        ExifTag[][] exifTagArr6 = {exifTagArr, exifTagArr2, exifTagArr3, exifTagArr4, exifTagArr5};
        EXIF_TAGS = exifTagArr6;
        IFD_POINTER_TAGS = new ExifTag[]{new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, GCloudVoiceErrorCode.GCloudVoiceCompleteCode.GV_ON_ST_ALREADY_EXIST, 4)};
        IFD_POINTER_TAG_HINTS = new int[]{1, 2, 3};
        JPEG_INTERCHANGE_FORMAT_TAG = new ExifTag("JPEGInterchangeFormat", 513, 4);
        JPEG_INTERCHANGE_FORMAT_LENGTH_TAG = new ExifTag("JPEGInterchangeFormatLength", 514, 4);
        sExifTagMapsForReading = new HashMap[exifTagArr6.length];
        sExifTagMapsForWriting = new HashMap[exifTagArr6.length];
        sTagSetForCompatibility = new HashSet<>(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        Charset forName = Charset.forName("US-ASCII");
        ASCII = forName;
        IDENTIFIER_EXIF_APP1 = "Exif\u0000\u0000".getBytes(forName);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        sFormatter = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        int i3 = 0;
        while (true) {
            ExifTag[][] exifTagArr7 = EXIF_TAGS;
            if (i3 < exifTagArr7.length) {
                sExifTagMapsForReading[i3] = new HashMap();
                sExifTagMapsForWriting[i3] = new HashMap();
                for (ExifTag exifTag : exifTagArr7[i3]) {
                    sExifTagMapsForReading[i3].put(Integer.valueOf(exifTag.number), exifTag);
                    sExifTagMapsForWriting[i3].put(exifTag.name, exifTag);
                }
                i3++;
            } else {
                sNonZeroTimePattern = Pattern.compile(".*[1-9].*");
                sGpsTimestampPattern = Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
                return;
            }
        }
    }

    public ExpandExifInterface(String str) throws IOException {
        FileInputStream fileInputStream;
        if (str != null) {
            FileInputStream fileInputStream2 = null;
            this.mAssetInputStream = null;
            this.mFilename = str;
            this.mIsInputStream = false;
            try {
                fileInputStream = new FileInputStream(str);
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                loadAttributes(fileInputStream);
                ioUtilsCloseQuietly(fileInputStream);
                return;
            } catch (Throwable th6) {
                th = th6;
                fileInputStream2 = fileInputStream;
                ioUtilsCloseQuietly(fileInputStream2);
                throw th;
            }
        }
        throw new IllegalArgumentException("filename cannot be null");
    }

    private void addDefaultValuesForCompatibility() {
        String attribute = getAttribute("DateTimeOriginal");
        if (attribute != null) {
            this.mAttributes[0].put("DateTime", ExifAttribute.createString(attribute));
        }
        if (getAttribute("ImageWidth") == null) {
            this.mAttributes[0].put("ImageWidth", ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
        if (getAttribute("ImageLength") == null) {
            this.mAttributes[0].put("ImageLength", ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
        if (getAttribute("Orientation") == null) {
            this.mAttributes[0].put("Orientation", ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
        if (getAttribute("LightSource") == null) {
            this.mAttributes[1].put("LightSource", ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
    }

    private static float convertRationalLatLonToFloat(String str, String str2) {
        try {
            String[] split = str.split(",");
            String[] split2 = split[0].split("/");
            double parseDouble = Double.parseDouble(split2[0].trim()) / Double.parseDouble(split2[1].trim());
            String[] split3 = split[1].split("/");
            double parseDouble2 = Double.parseDouble(split3[0].trim()) / Double.parseDouble(split3[1].trim());
            String[] split4 = split[2].split("/");
            double parseDouble3 = parseDouble + (parseDouble2 / 60.0d) + ((Double.parseDouble(split4[0].trim()) / Double.parseDouble(split4[1].trim())) / 3600.0d);
            if (!str2.equals(ExifInterface.LATITUDE_SOUTH)) {
                if (!str2.equals("W")) {
                    return (float) parseDouble3;
                }
            }
            return (float) (-parseDouble3);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new IllegalArgumentException();
        } catch (NumberFormatException unused2) {
            throw new IllegalArgumentException();
        }
    }

    private ExifAttribute getExifAttribute(String str) {
        for (int i3 = 0; i3 < EXIF_TAGS.length; i3++) {
            Object obj = this.mAttributes[i3].get(str);
            if (obj != null) {
                return (ExifAttribute) obj;
            }
        }
        return null;
    }

    private static int getIfdHintFromTagNumber(int i3) {
        int i16 = 0;
        while (true) {
            int[] iArr = IFD_POINTER_TAG_HINTS;
            if (i16 < iArr.length) {
                if (IFD_POINTER_TAGS[i16].number == i3) {
                    return iArr[i16];
                }
                i16++;
            } else {
                return -1;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x0116, code lost:
    
        android.util.Log.w("exif-demo", "bytesRead : " + r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x012e, code lost:
    
        return;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:18:0x0047. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:19:0x004a. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:20:0x004d. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:21:0x0050. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0055 A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void getJpegAttributes(InputStream inputStream) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        byte readByte = dataInputStream.readByte();
        if (readByte == -1) {
            if (dataInputStream.readByte() == -40) {
                int i3 = 2;
                while (true) {
                    byte readByte2 = dataInputStream.readByte();
                    if (readByte2 == -1) {
                        byte readByte3 = dataInputStream.readByte();
                        int i16 = i3 + 1 + 1;
                        if (readByte3 != -39 && readByte3 != -38) {
                            int readUnsignedShort = dataInputStream.readUnsignedShort() - 2;
                            int i17 = i16 + 2;
                            if (readUnsignedShort >= 0) {
                                if (readByte3 != -31) {
                                    if (readByte3 != -2) {
                                        switch (readByte3) {
                                            default:
                                                switch (readByte3) {
                                                    default:
                                                        switch (readByte3) {
                                                            default:
                                                                switch (readByte3) {
                                                                }
                                                            case -55:
                                                            case -54:
                                                            case -53:
                                                                if (dataInputStream.skipBytes(1) == 1) {
                                                                    this.mAttributes[0].put("ImageLength", ExifAttribute.createULong(dataInputStream.readUnsignedShort(), this.mExifByteOrder));
                                                                    this.mAttributes[0].put("ImageWidth", ExifAttribute.createULong(dataInputStream.readUnsignedShort(), this.mExifByteOrder));
                                                                    readUnsignedShort -= 5;
                                                                    break;
                                                                } else {
                                                                    throw new IOException("Invalid SOFx");
                                                                }
                                                        }
                                                    case DownloaderConstant.E_WAP_LENGTH_LIMITED /* -59 */:
                                                    case DownloaderConstant.E_NO_LOCATION_ON_REDIRECT /* -58 */:
                                                    case DownloaderConstant.E_NORMAL_REDIRECT /* -57 */:
                                                        break;
                                                }
                                            case -64:
                                            case -63:
                                            case -62:
                                            case DownloaderConstant.E_CLIENT_FAIL /* -61 */:
                                                break;
                                        }
                                    } else {
                                        byte[] bArr = new byte[readUnsignedShort];
                                        if (dataInputStream.read(bArr) == readUnsignedShort) {
                                            if (getAttribute("UserComment") == null) {
                                                this.mAttributes[1].put("UserComment", ExifAttribute.createString(new String(bArr, ASCII)));
                                            }
                                            readUnsignedShort = 0;
                                        } else {
                                            throw new IOException("Invalid exif");
                                        }
                                    }
                                } else if (readUnsignedShort >= 6) {
                                    byte[] bArr2 = new byte[6];
                                    if (inputStream.read(bArr2) == 6) {
                                        i17 += 6;
                                        readUnsignedShort -= 6;
                                        if (Arrays.equals(bArr2, IDENTIFIER_EXIF_APP1)) {
                                            if (readUnsignedShort > 0) {
                                                byte[] bArr3 = new byte[readUnsignedShort];
                                                if (dataInputStream.read(bArr3) == readUnsignedShort) {
                                                    readExifSegment(bArr3, i17);
                                                    i17 += readUnsignedShort;
                                                    readUnsignedShort = 0;
                                                } else {
                                                    throw new IOException("Invalid exif");
                                                }
                                            } else {
                                                throw new IOException("Invalid exif");
                                            }
                                        }
                                    } else {
                                        throw new IOException("Invalid exif");
                                    }
                                }
                                if (readUnsignedShort >= 0) {
                                    if (dataInputStream.skipBytes(readUnsignedShort) == readUnsignedShort) {
                                        i3 = i17 + readUnsignedShort;
                                    } else {
                                        throw new IOException("Invalid JPEG segment");
                                    }
                                } else {
                                    throw new IOException("Invalid length");
                                }
                            } else {
                                throw new IOException("Invalid length");
                            }
                        }
                    } else {
                        throw new IOException("Invalid marker:" + Integer.toHexString(readByte2 & 255));
                    }
                }
            } else {
                throw new IOException("Invalid marker: " + Integer.toHexString(readByte & 255));
            }
        } else {
            throw new IOException("Invalid marker: " + Integer.toHexString(readByte & 255));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Pair<Integer, Integer> guessDataFormat(String str) {
        int intValue;
        int i3;
        if (str.contains(",")) {
            String[] split = str.split(",");
            Pair<Integer, Integer> guessDataFormat = guessDataFormat(split[0]);
            if (((Integer) guessDataFormat.first).intValue() == 2) {
                return guessDataFormat;
            }
            for (int i16 = 1; i16 < split.length; i16++) {
                Pair<Integer, Integer> guessDataFormat2 = guessDataFormat(split[i16]);
                Object obj = guessDataFormat2.first;
                Object obj2 = guessDataFormat.first;
                if (obj != obj2 && guessDataFormat2.second != obj2) {
                    intValue = -1;
                } else {
                    intValue = ((Integer) obj2).intValue();
                }
                if (((Integer) guessDataFormat.second).intValue() != -1) {
                    Object obj3 = guessDataFormat2.first;
                    Object obj4 = guessDataFormat.second;
                    if (obj3 == obj4 || guessDataFormat2.second == obj4) {
                        i3 = ((Integer) obj4).intValue();
                        if (intValue != -1 && i3 == -1) {
                            return new Pair<>(2, -1);
                        }
                        if (intValue != -1) {
                            guessDataFormat = new Pair<>(Integer.valueOf(i3), -1);
                        } else if (i3 == -1) {
                            guessDataFormat = new Pair<>(Integer.valueOf(intValue), -1);
                        }
                    }
                }
                i3 = -1;
                if (intValue != -1) {
                }
                if (intValue != -1) {
                }
            }
            return guessDataFormat;
        }
        if (str.contains("/")) {
            String[] split2 = str.split("/");
            if (split2.length == 2) {
                try {
                    long parseLong = Long.parseLong(split2[0]);
                    long parseLong2 = Long.parseLong(split2[1]);
                    if (parseLong >= 0 && parseLong2 >= 0) {
                        if (parseLong <= TTL.MAX_VALUE && parseLong2 <= TTL.MAX_VALUE) {
                            return new Pair<>(10, 5);
                        }
                        return new Pair<>(5, -1);
                    }
                    return new Pair<>(10, -1);
                } catch (NumberFormatException unused) {
                }
            }
            return new Pair<>(2, -1);
        }
        try {
            try {
                Long valueOf = Long.valueOf(Long.parseLong(str));
                if (valueOf.longValue() >= 0 && valueOf.longValue() <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                    return new Pair<>(3, 4);
                }
                if (valueOf.longValue() < 0) {
                    return new Pair<>(9, -1);
                }
                return new Pair<>(4, -1);
            } catch (NumberFormatException unused2) {
                Double.parseDouble(str);
                return new Pair<>(12, -1);
            }
        } catch (NumberFormatException unused3) {
            return new Pair<>(2, -1);
        }
    }

    public static void ioUtilsCloseQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e16) {
                throw e16;
            } catch (Exception unused) {
            }
        }
    }

    private static boolean isJpegInputStream(ExpandBufferedInputStream expandBufferedInputStream) throws IOException {
        expandBufferedInputStream.mark(3);
        byte[] bArr = new byte[3];
        if (expandBufferedInputStream.read(bArr) == 3) {
            boolean equals = Arrays.equals(JPEG_SIGNATURE, bArr);
            expandBufferedInputStream.reset();
            return equals;
        }
        throw new EOFException();
    }

    private void loadAttributes(InputStream inputStream) throws IOException {
        for (int i3 = 0; i3 < EXIF_TAGS.length; i3++) {
            try {
                try {
                    this.mAttributes[i3] = new HashMap();
                } catch (IOException e16) {
                    Log.w(TAG, "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", e16);
                }
            } finally {
                addDefaultValuesForCompatibility();
            }
        }
        ExpandBufferedInputStream expandBufferedInputStream = new ExpandBufferedInputStream(inputStream, mBuf);
        if (!isJpegInputStream(expandBufferedInputStream)) {
            return;
        }
        getJpegAttributes(expandBufferedInputStream);
    }

    private void printAttributes() {
        for (int i3 = 0; i3 < this.mAttributes.length; i3++) {
            Log.d(TAG, "The size of tag group[" + i3 + "]: " + this.mAttributes[i3].size());
            for (Map.Entry entry : this.mAttributes[i3].entrySet()) {
                ExifAttribute exifAttribute = (ExifAttribute) entry.getValue();
                Log.d(TAG, "tagName: " + entry.getKey() + ", tagType: " + exifAttribute.toString() + ", tagValue: '" + exifAttribute.getStringValue(this.mExifByteOrder) + "'");
            }
        }
    }

    private void readExifSegment(byte[] bArr, int i3) throws IOException {
        ByteOrderAwarenessDataInputStream byteOrderAwarenessDataInputStream = new ByteOrderAwarenessDataInputStream(bArr);
        short readShort = byteOrderAwarenessDataInputStream.readShort();
        if (readShort != 18761) {
            if (readShort == 19789) {
                this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
            } else {
                throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
            }
        } else {
            this.mExifByteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        byteOrderAwarenessDataInputStream.setByteOrder(this.mExifByteOrder);
        int readUnsignedShort = byteOrderAwarenessDataInputStream.readUnsignedShort();
        if (readUnsignedShort == 42) {
            long readUnsignedInt = byteOrderAwarenessDataInputStream.readUnsignedInt();
            if (readUnsignedInt >= 8 && readUnsignedInt < bArr.length) {
                long j3 = readUnsignedInt - 8;
                if (j3 > 0 && byteOrderAwarenessDataInputStream.skip(j3) != j3) {
                    throw new IOException("Couldn't jump to first Ifd: " + j3);
                }
                readImageFileDirectory(byteOrderAwarenessDataInputStream, 0);
                return;
            }
            throw new IOException("Invalid first Ifd offset: " + readUnsignedInt);
        }
        throw new IOException("Invalid exif start: " + Integer.toHexString(readUnsignedShort));
    }

    private void readImageFileDirectory(ByteOrderAwarenessDataInputStream byteOrderAwarenessDataInputStream, int i3) throws IOException {
        int i16;
        int readUnsignedShort;
        long j3;
        try {
            if (byteOrderAwarenessDataInputStream.peek() + 2 > byteOrderAwarenessDataInputStream.mLength) {
                return;
            }
            short readShort = byteOrderAwarenessDataInputStream.readShort();
            if (byteOrderAwarenessDataInputStream.peek() + (readShort * 12) > byteOrderAwarenessDataInputStream.mLength) {
                return;
            }
            for (short s16 = 0; s16 < readShort; s16 = (short) (s16 + 1)) {
                int readUnsignedShort2 = byteOrderAwarenessDataInputStream.readUnsignedShort();
                int readUnsignedShort3 = byteOrderAwarenessDataInputStream.readUnsignedShort();
                int readInt = byteOrderAwarenessDataInputStream.readInt();
                long peek = byteOrderAwarenessDataInputStream.peek() + 4;
                ExifTag exifTag = (ExifTag) sExifTagMapsForReading[i3].get(Integer.valueOf(readUnsignedShort2));
                if (exifTag != null && readUnsignedShort3 > 0) {
                    int[] iArr = IFD_FORMAT_BYTES_PER_FORMAT;
                    if (readUnsignedShort3 < iArr.length) {
                        int i17 = iArr[readUnsignedShort3] * readInt;
                        if (i17 > 4) {
                            long readUnsignedInt = byteOrderAwarenessDataInputStream.readUnsignedInt();
                            i16 = readUnsignedShort2;
                            if (i17 + readUnsignedInt <= byteOrderAwarenessDataInputStream.mLength) {
                                byteOrderAwarenessDataInputStream.seek(readUnsignedInt);
                            } else {
                                Log.w(TAG, "Skip the tag entry since data offset is invalid: " + readUnsignedInt);
                                byteOrderAwarenessDataInputStream.seek(peek);
                            }
                        } else {
                            i16 = readUnsignedShort2;
                        }
                        int ifdHintFromTagNumber = getIfdHintFromTagNumber(i16);
                        if (ifdHintFromTagNumber >= 0) {
                            if (readUnsignedShort3 != 3) {
                                if (readUnsignedShort3 != 4) {
                                    if (readUnsignedShort3 != 8) {
                                        if (readUnsignedShort3 != 9) {
                                            j3 = -1;
                                        } else {
                                            readUnsignedShort = byteOrderAwarenessDataInputStream.readInt();
                                        }
                                    } else {
                                        readUnsignedShort = byteOrderAwarenessDataInputStream.readShort();
                                    }
                                } else {
                                    j3 = byteOrderAwarenessDataInputStream.readUnsignedInt();
                                }
                                if (j3 <= 0 && j3 < byteOrderAwarenessDataInputStream.mLength) {
                                    byteOrderAwarenessDataInputStream.seek(j3);
                                    readImageFileDirectory(byteOrderAwarenessDataInputStream, ifdHintFromTagNumber);
                                } else {
                                    Log.w(TAG, "Skip jump into the IFD since its offset is invalid: " + j3);
                                }
                                byteOrderAwarenessDataInputStream.seek(peek);
                            } else {
                                readUnsignedShort = byteOrderAwarenessDataInputStream.readUnsignedShort();
                            }
                            j3 = readUnsignedShort;
                            if (j3 <= 0) {
                            }
                            Log.w(TAG, "Skip jump into the IFD since its offset is invalid: " + j3);
                            byteOrderAwarenessDataInputStream.seek(peek);
                        } else {
                            byte[] bArr = new byte[iArr[readUnsignedShort3] * readInt];
                            byteOrderAwarenessDataInputStream.readFully(bArr);
                            this.mAttributes[i3].put(exifTag.name, new ExifAttribute(readUnsignedShort3, readInt, bArr));
                            if (byteOrderAwarenessDataInputStream.peek() != peek) {
                                byteOrderAwarenessDataInputStream.seek(peek);
                            }
                        }
                    }
                }
                if (exifTag == null) {
                    Log.w(TAG, "Skip the tag entry since tag number is not defined: " + readUnsignedShort2);
                } else {
                    Log.w(TAG, "Skip the tag entry since data format is invalid: " + readUnsignedShort3);
                }
                byteOrderAwarenessDataInputStream.seek(peek);
            }
            if (byteOrderAwarenessDataInputStream.peek() + 4 <= byteOrderAwarenessDataInputStream.mLength) {
                long readUnsignedInt2 = byteOrderAwarenessDataInputStream.readUnsignedInt();
                if (readUnsignedInt2 > 8 && readUnsignedInt2 < byteOrderAwarenessDataInputStream.mLength) {
                    byteOrderAwarenessDataInputStream.seek(readUnsignedInt2);
                    readImageFileDirectory(byteOrderAwarenessDataInputStream, 4);
                }
            }
        } catch (OutOfMemoryError e16) {
            Log.w(TAG, "OutOfMemoryError : " + e16);
        } catch (StackOverflowError e17) {
            Log.w(TAG, "StackOverflowError : " + e17);
        }
    }

    public double getAltitude(double d16) {
        double attributeDouble = getAttributeDouble("GPSAltitude", -1.0d);
        int i3 = -1;
        int attributeInt = getAttributeInt("GPSAltitudeRef", -1);
        if (attributeDouble >= 0.0d && attributeInt >= 0) {
            if (attributeInt != 1) {
                i3 = 1;
            }
            return attributeDouble * i3;
        }
        return d16;
    }

    public String getAttribute(String str) {
        Rational[] rationalArr;
        ExifAttribute exifAttribute = getExifAttribute(str);
        if (exifAttribute != null) {
            if (!sTagSetForCompatibility.contains(str)) {
                return exifAttribute.getStringValue(this.mExifByteOrder);
            }
            if (str.equals("GPSTimeStamp")) {
                int i3 = exifAttribute.format;
                if ((i3 != 5 && i3 != 10) || (rationalArr = (Rational[]) exifAttribute.getValue(this.mExifByteOrder)) == null || rationalArr.length != 3) {
                    return null;
                }
                Rational rational = rationalArr[0];
                Rational rational2 = rationalArr[1];
                Rational rational3 = rationalArr[2];
                return String.format("%02d:%02d:%02d", Integer.valueOf((int) (((float) rational.numerator) / ((float) rational.denominator))), Integer.valueOf((int) (((float) rational2.numerator) / ((float) rational2.denominator))), Integer.valueOf((int) (((float) rational3.numerator) / ((float) rational3.denominator))));
            }
            try {
                return Double.toString(exifAttribute.getDoubleValue(this.mExifByteOrder));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public double getAttributeDouble(String str, double d16) {
        ExifAttribute exifAttribute = getExifAttribute(str);
        if (exifAttribute == null) {
            return d16;
        }
        try {
            return exifAttribute.getDoubleValue(this.mExifByteOrder);
        } catch (NumberFormatException unused) {
            return d16;
        }
    }

    public int getAttributeInt(String str, int i3) {
        ExifAttribute exifAttribute = getExifAttribute(str);
        if (exifAttribute == null) {
            return i3;
        }
        try {
            return exifAttribute.getIntValue(this.mExifByteOrder);
        } catch (NumberFormatException unused) {
            return i3;
        }
    }

    public long getDateTime() {
        String attribute = getAttribute("DateTime");
        if (attribute != null && sNonZeroTimePattern.matcher(attribute).matches()) {
            try {
                Date parse = sFormatter.parse(attribute, new ParsePosition(0));
                if (parse == null) {
                    return -1L;
                }
                long time = parse.getTime();
                String attribute2 = getAttribute("SubSecTime");
                if (attribute2 != null) {
                    try {
                        long longValue = Long.valueOf(attribute2).longValue();
                        while (longValue > 1000) {
                            longValue /= 10;
                        }
                        return time + longValue;
                    } catch (NumberFormatException unused) {
                        return time;
                    }
                }
                return time;
            } catch (IllegalArgumentException unused2) {
            }
        }
        return -1L;
    }

    public long getGpsDateTime() {
        String attribute = getAttribute("GPSDateStamp");
        String attribute2 = getAttribute("GPSTimeStamp");
        if (attribute != null && attribute2 != null) {
            Pattern pattern = sNonZeroTimePattern;
            if (pattern.matcher(attribute).matches() || pattern.matcher(attribute2).matches()) {
                try {
                    Date parse = sFormatter.parse(attribute + TokenParser.SP + attribute2, new ParsePosition(0));
                    if (parse == null) {
                        return -1L;
                    }
                    return parse.getTime();
                } catch (IllegalArgumentException unused) {
                }
            }
        }
        return -1L;
    }

    public boolean getLatLong(float[] fArr) {
        String attribute = getAttribute("GPSLatitude");
        String attribute2 = getAttribute("GPSLatitudeRef");
        String attribute3 = getAttribute("GPSLongitude");
        String attribute4 = getAttribute("GPSLongitudeRef");
        if (attribute != null && attribute2 != null && attribute3 != null && attribute4 != null) {
            try {
                fArr[0] = convertRationalLatLonToFloat(attribute, attribute2);
                fArr[1] = convertRationalLatLonToFloat(attribute3, attribute4);
                return true;
            } catch (IllegalArgumentException unused) {
            }
        }
        return false;
    }

    public boolean hasThumbnail() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class ExifAttribute {
        public final byte[] bytes;
        public final int format;
        public final int numberOfComponents;

        ExifAttribute(int i3, int i16, byte[] bArr) {
            this.format = i3;
            this.numberOfComponents = i16;
            this.bytes = bArr;
        }

        public static ExifAttribute createByte(String str) {
            if (str.length() == 1 && str.charAt(0) >= '0' && str.charAt(0) <= '1') {
                return new ExifAttribute(1, 1, new byte[]{(byte) (str.charAt(0) - '0')});
            }
            byte[] bytes = str.getBytes(ExpandExifInterface.ASCII);
            return new ExifAttribute(1, bytes.length, bytes);
        }

        public static ExifAttribute createDouble(double[] dArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[ExpandExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[12] * dArr.length]);
            wrap.order(byteOrder);
            for (double d16 : dArr) {
                wrap.putDouble(d16);
            }
            return new ExifAttribute(12, dArr.length, wrap.array());
        }

        public static ExifAttribute createSLong(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[ExpandExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[9] * iArr.length]);
            wrap.order(byteOrder);
            for (int i3 : iArr) {
                wrap.putInt(i3);
            }
            return new ExifAttribute(9, iArr.length, wrap.array());
        }

        public static ExifAttribute createSRational(Rational[] rationalArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[ExpandExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[10] * rationalArr.length]);
            wrap.order(byteOrder);
            for (Rational rational : rationalArr) {
                wrap.putInt((int) rational.numerator);
                wrap.putInt((int) rational.denominator);
            }
            return new ExifAttribute(10, rationalArr.length, wrap.array());
        }

        public static ExifAttribute createString(String str) {
            byte[] bytes = (str + (char) 0).getBytes(ExpandExifInterface.ASCII);
            return new ExifAttribute(2, bytes.length, bytes);
        }

        public static ExifAttribute createULong(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[ExpandExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[4] * jArr.length]);
            wrap.order(byteOrder);
            for (long j3 : jArr) {
                wrap.putInt((int) j3);
            }
            return new ExifAttribute(4, jArr.length, wrap.array());
        }

        public static ExifAttribute createURational(Rational[] rationalArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[ExpandExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[5] * rationalArr.length]);
            wrap.order(byteOrder);
            for (Rational rational : rationalArr) {
                wrap.putInt((int) rational.numerator);
                wrap.putInt((int) rational.denominator);
            }
            return new ExifAttribute(5, rationalArr.length, wrap.array());
        }

        public static ExifAttribute createUShort(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[ExpandExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[3] * iArr.length]);
            wrap.order(byteOrder);
            for (int i3 : iArr) {
                wrap.putShort((short) i3);
            }
            return new ExifAttribute(3, iArr.length, wrap.array());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Object getValue(ByteOrder byteOrder) {
            byte b16;
            byte b17;
            try {
                ByteOrderAwarenessDataInputStream byteOrderAwarenessDataInputStream = new ByteOrderAwarenessDataInputStream(this.bytes);
                byteOrderAwarenessDataInputStream.setByteOrder(byteOrder);
                int i3 = 0;
                boolean z16 = true;
                switch (this.format) {
                    case 1:
                    case 6:
                        byte[] bArr = this.bytes;
                        if (bArr.length == 1 && (b16 = bArr[0]) >= 0 && b16 <= 1) {
                            return new String(new char[]{(char) (b16 + 48)});
                        }
                        return new String(bArr, ExpandExifInterface.ASCII);
                    case 2:
                    case 7:
                        if (this.numberOfComponents >= ExpandExifInterface.EXIF_ASCII_PREFIX.length) {
                            int i16 = 0;
                            while (true) {
                                if (i16 < ExpandExifInterface.EXIF_ASCII_PREFIX.length) {
                                    if (this.bytes[i16] != ExpandExifInterface.EXIF_ASCII_PREFIX[i16]) {
                                        z16 = false;
                                    } else {
                                        i16++;
                                    }
                                }
                            }
                            if (z16) {
                                i3 = ExpandExifInterface.EXIF_ASCII_PREFIX.length;
                            }
                        }
                        StringBuilder sb5 = new StringBuilder();
                        while (i3 < this.numberOfComponents && (b17 = this.bytes[i3]) != 0) {
                            if (b17 >= 32) {
                                sb5.append((char) b17);
                            } else {
                                sb5.append('?');
                            }
                            i3++;
                        }
                        return sb5.toString();
                    case 3:
                        int[] iArr = new int[this.numberOfComponents];
                        while (i3 < this.numberOfComponents) {
                            iArr[i3] = byteOrderAwarenessDataInputStream.readUnsignedShort();
                            i3++;
                        }
                        return iArr;
                    case 4:
                        long[] jArr = new long[this.numberOfComponents];
                        while (i3 < this.numberOfComponents) {
                            jArr[i3] = byteOrderAwarenessDataInputStream.readUnsignedInt();
                            i3++;
                        }
                        return jArr;
                    case 5:
                        Rational[] rationalArr = new Rational[this.numberOfComponents];
                        while (i3 < this.numberOfComponents) {
                            rationalArr[i3] = new Rational(byteOrderAwarenessDataInputStream.readUnsignedInt(), byteOrderAwarenessDataInputStream.readUnsignedInt());
                            i3++;
                        }
                        return rationalArr;
                    case 8:
                        int[] iArr2 = new int[this.numberOfComponents];
                        while (i3 < this.numberOfComponents) {
                            iArr2[i3] = byteOrderAwarenessDataInputStream.readShort();
                            i3++;
                        }
                        return iArr2;
                    case 9:
                        int[] iArr3 = new int[this.numberOfComponents];
                        while (i3 < this.numberOfComponents) {
                            iArr3[i3] = byteOrderAwarenessDataInputStream.readInt();
                            i3++;
                        }
                        return iArr3;
                    case 10:
                        Rational[] rationalArr2 = new Rational[this.numberOfComponents];
                        while (i3 < this.numberOfComponents) {
                            rationalArr2[i3] = new Rational(byteOrderAwarenessDataInputStream.readInt(), byteOrderAwarenessDataInputStream.readInt());
                            i3++;
                        }
                        return rationalArr2;
                    case 11:
                        double[] dArr = new double[this.numberOfComponents];
                        while (i3 < this.numberOfComponents) {
                            dArr[i3] = byteOrderAwarenessDataInputStream.readFloat();
                            i3++;
                        }
                        return dArr;
                    case 12:
                        double[] dArr2 = new double[this.numberOfComponents];
                        while (i3 < this.numberOfComponents) {
                            dArr2[i3] = byteOrderAwarenessDataInputStream.readDouble();
                            i3++;
                        }
                        return dArr2;
                    default:
                        return null;
                }
            } catch (IOException e16) {
                Log.w(ExpandExifInterface.TAG, "IOException occurred during reading a value", e16);
                return null;
            }
        }

        public double getDoubleValue(ByteOrder byteOrder) {
            Object value = getValue(byteOrder);
            if (value != null) {
                if (value instanceof String) {
                    return Double.parseDouble((String) value);
                }
                if (value instanceof long[]) {
                    if (((long[]) value).length == 1) {
                        return r5[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                }
                if (value instanceof int[]) {
                    if (((int[]) value).length == 1) {
                        return r5[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                }
                if (value instanceof double[]) {
                    double[] dArr = (double[]) value;
                    if (dArr.length == 1) {
                        return dArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                }
                if (value instanceof Rational[]) {
                    Rational[] rationalArr = (Rational[]) value;
                    if (rationalArr.length == 1) {
                        return rationalArr[0].calculate();
                    }
                    throw new NumberFormatException("There are more than one component");
                }
                throw new NumberFormatException("Couldn't find a double value");
            }
            throw new NumberFormatException("NULL can't be converted to a double value");
        }

        public int getIntValue(ByteOrder byteOrder) {
            Object value = getValue(byteOrder);
            if (value != null) {
                if (value instanceof String) {
                    return Integer.parseInt((String) value);
                }
                if (value instanceof long[]) {
                    long[] jArr = (long[]) value;
                    if (jArr.length == 1) {
                        return (int) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                }
                if (value instanceof int[]) {
                    int[] iArr = (int[]) value;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                }
                throw new NumberFormatException("Couldn't find a integer value");
            }
            throw new NumberFormatException("NULL can't be converted to a integer value");
        }

        public String getStringValue(ByteOrder byteOrder) {
            Object value = getValue(byteOrder);
            if (value == null) {
                return null;
            }
            if (value instanceof String) {
                return (String) value;
            }
            StringBuilder sb5 = new StringBuilder();
            int i3 = 0;
            if (value instanceof long[]) {
                long[] jArr = (long[]) value;
                while (i3 < jArr.length) {
                    sb5.append(jArr[i3]);
                    i3++;
                    if (i3 != jArr.length) {
                        sb5.append(",");
                    }
                }
                return sb5.toString();
            }
            if (value instanceof int[]) {
                int[] iArr = (int[]) value;
                while (i3 < iArr.length) {
                    sb5.append(iArr[i3]);
                    i3++;
                    if (i3 != iArr.length) {
                        sb5.append(",");
                    }
                }
                return sb5.toString();
            }
            if (value instanceof double[]) {
                double[] dArr = (double[]) value;
                while (i3 < dArr.length) {
                    sb5.append(dArr[i3]);
                    i3++;
                    if (i3 != dArr.length) {
                        sb5.append(",");
                    }
                }
                return sb5.toString();
            }
            if (!(value instanceof Rational[])) {
                return null;
            }
            Rational[] rationalArr = (Rational[]) value;
            while (i3 < rationalArr.length) {
                sb5.append(rationalArr[i3].numerator);
                sb5.append('/');
                sb5.append(rationalArr[i3].denominator);
                i3++;
                if (i3 != rationalArr.length) {
                    sb5.append(",");
                }
            }
            return sb5.toString();
        }

        public int size() {
            return ExpandExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[this.format] * this.numberOfComponents;
        }

        public String toString() {
            return "(" + ExpandExifInterface.IFD_FORMAT_NAMES[this.format] + ", data length:" + this.bytes.length + ")";
        }

        public static ExifAttribute createDouble(double d16, ByteOrder byteOrder) {
            return createDouble(new double[]{d16}, byteOrder);
        }

        public static ExifAttribute createSLong(int i3, ByteOrder byteOrder) {
            return createSLong(new int[]{i3}, byteOrder);
        }

        public static ExifAttribute createULong(long j3, ByteOrder byteOrder) {
            return createULong(new long[]{j3}, byteOrder);
        }

        public static ExifAttribute createUShort(int i3, ByteOrder byteOrder) {
            return createUShort(new int[]{i3}, byteOrder);
        }

        public static ExifAttribute createSRational(Rational rational, ByteOrder byteOrder) {
            return createSRational(new Rational[]{rational}, byteOrder);
        }

        public static ExifAttribute createURational(Rational rational, ByteOrder byteOrder) {
            return createURational(new Rational[]{rational}, byteOrder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class ExifTag {
        public final String name;
        public final int number;
        public final int primaryFormat;
        public final int secondaryFormat;

        ExifTag(String str, int i3, int i16) {
            this.name = str;
            this.number = i3;
            this.primaryFormat = i16;
            this.secondaryFormat = -1;
        }

        ExifTag(String str, int i3, int i16, int i17) {
            this.name = str;
            this.number = i3;
            this.primaryFormat = i16;
            this.secondaryFormat = i17;
        }
    }
}
