package androidx.exifinterface.media;

import android.annotation.SuppressLint;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.gcloudsdk.gcloud.voice.GCloudVoiceErrorCode;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl;
import com.tencent.component.media.MtpConstants;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.state.map.MapItemKt;
import com.tencent.view.FilterEnum;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.httpcore.message.TokenParser;
import org.jf.dexlib2.analysis.RegisterType;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes.dex */
public class ExifInterface {
    public static final short ALTITUDE_ABOVE_SEA_LEVEL = 0;
    public static final short ALTITUDE_BELOW_SEA_LEVEL = 1;
    static final Charset ASCII;
    static final short BYTE_ALIGN_II = 18761;
    static final short BYTE_ALIGN_MM = 19789;
    public static final int COLOR_SPACE_S_RGB = 1;
    public static final int COLOR_SPACE_UNCALIBRATED = 65535;
    public static final short CONTRAST_HARD = 2;
    public static final short CONTRAST_NORMAL = 0;
    public static final short CONTRAST_SOFT = 1;
    public static final int DATA_DEFLATE_ZIP = 8;
    public static final int DATA_HUFFMAN_COMPRESSED = 2;
    public static final int DATA_JPEG = 6;
    public static final int DATA_JPEG_COMPRESSED = 7;
    public static final int DATA_LOSSY_JPEG = 34892;
    public static final int DATA_PACK_BITS_COMPRESSED = 32773;
    public static final int DATA_UNCOMPRESSED = 1;
    private static final Pattern DATETIME_PRIMARY_FORMAT_PATTERN;
    private static final Pattern DATETIME_SECONDARY_FORMAT_PATTERN;
    private static final int DATETIME_VALUE_STRING_LENGTH = 19;
    private static final ExifTag[] EXIF_POINTER_TAGS;
    static final ExifTag[][] EXIF_TAGS;
    public static final short EXPOSURE_MODE_AUTO = 0;
    public static final short EXPOSURE_MODE_AUTO_BRACKET = 2;
    public static final short EXPOSURE_MODE_MANUAL = 1;
    public static final short EXPOSURE_PROGRAM_ACTION = 6;
    public static final short EXPOSURE_PROGRAM_APERTURE_PRIORITY = 3;
    public static final short EXPOSURE_PROGRAM_CREATIVE = 5;
    public static final short EXPOSURE_PROGRAM_LANDSCAPE_MODE = 8;
    public static final short EXPOSURE_PROGRAM_MANUAL = 1;
    public static final short EXPOSURE_PROGRAM_NORMAL = 2;
    public static final short EXPOSURE_PROGRAM_NOT_DEFINED = 0;
    public static final short EXPOSURE_PROGRAM_PORTRAIT_MODE = 7;
    public static final short EXPOSURE_PROGRAM_SHUTTER_PRIORITY = 4;
    public static final short FILE_SOURCE_DSC = 3;
    public static final short FILE_SOURCE_OTHER = 0;
    public static final short FILE_SOURCE_REFLEX_SCANNER = 2;
    public static final short FILE_SOURCE_TRANSPARENT_SCANNER = 1;
    public static final short FLAG_FLASH_FIRED = 1;
    public static final short FLAG_FLASH_MODE_AUTO = 24;
    public static final short FLAG_FLASH_MODE_COMPULSORY_FIRING = 8;
    public static final short FLAG_FLASH_MODE_COMPULSORY_SUPPRESSION = 16;
    public static final short FLAG_FLASH_NO_FLASH_FUNCTION = 32;
    public static final short FLAG_FLASH_RED_EYE_SUPPORTED = 64;
    public static final short FLAG_FLASH_RETURN_LIGHT_DETECTED = 6;
    public static final short FLAG_FLASH_RETURN_LIGHT_NOT_DETECTED = 4;
    public static final short FORMAT_CHUNKY = 1;
    public static final short FORMAT_PLANAR = 2;
    public static final short GAIN_CONTROL_HIGH_GAIN_DOWN = 4;
    public static final short GAIN_CONTROL_HIGH_GAIN_UP = 2;
    public static final short GAIN_CONTROL_LOW_GAIN_DOWN = 3;
    public static final short GAIN_CONTROL_LOW_GAIN_UP = 1;
    public static final short GAIN_CONTROL_NONE = 0;
    public static final String GPS_DIRECTION_MAGNETIC = "M";
    public static final String GPS_DIRECTION_TRUE = "T";
    public static final String GPS_DISTANCE_KILOMETERS = "K";
    public static final String GPS_DISTANCE_MILES = "M";
    public static final String GPS_DISTANCE_NAUTICAL_MILES = "N";
    public static final String GPS_MEASUREMENT_2D = "2";
    public static final String GPS_MEASUREMENT_3D = "3";
    public static final short GPS_MEASUREMENT_DIFFERENTIAL_CORRECTED = 1;
    public static final String GPS_MEASUREMENT_INTERRUPTED = "V";
    public static final String GPS_MEASUREMENT_IN_PROGRESS = "A";
    public static final short GPS_MEASUREMENT_NO_DIFFERENTIAL = 0;
    public static final String GPS_SPEED_KILOMETERS_PER_HOUR = "K";
    public static final String GPS_SPEED_KNOTS = "N";
    public static final String GPS_SPEED_MILES_PER_HOUR = "M";
    private static final Pattern GPS_TIMESTAMP_PATTERN;
    static final byte[] IDENTIFIER_EXIF_APP1;
    private static final byte[] IDENTIFIER_XMP_APP1;
    private static final ExifTag[] IFD_EXIF_TAGS;
    private static final int IFD_FORMAT_BYTE = 1;
    private static final int IFD_FORMAT_DOUBLE = 12;
    private static final int IFD_FORMAT_IFD = 13;
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
    private static final ExifTag[] IFD_GPS_TAGS;
    private static final ExifTag[] IFD_INTEROPERABILITY_TAGS;
    private static final int IFD_OFFSET = 8;
    private static final ExifTag[] IFD_THUMBNAIL_TAGS;
    private static final ExifTag[] IFD_TIFF_TAGS;
    private static final int IFD_TYPE_EXIF = 1;
    private static final int IFD_TYPE_GPS = 2;
    private static final int IFD_TYPE_INTEROPERABILITY = 3;
    private static final int IFD_TYPE_ORF_CAMERA_SETTINGS = 7;
    private static final int IFD_TYPE_ORF_IMAGE_PROCESSING = 8;
    private static final int IFD_TYPE_ORF_MAKER_NOTE = 6;
    private static final int IFD_TYPE_PEF = 9;
    static final int IFD_TYPE_PREVIEW = 5;
    static final int IFD_TYPE_PRIMARY = 0;
    static final int IFD_TYPE_THUMBNAIL = 4;
    private static final int IMAGE_TYPE_ARW = 1;
    private static final int IMAGE_TYPE_CR2 = 2;
    private static final int IMAGE_TYPE_DNG = 3;
    private static final int IMAGE_TYPE_HEIF = 12;
    private static final int IMAGE_TYPE_JPEG = 4;
    private static final int IMAGE_TYPE_NEF = 5;
    private static final int IMAGE_TYPE_NRW = 6;
    private static final int IMAGE_TYPE_ORF = 7;
    private static final int IMAGE_TYPE_PEF = 8;
    private static final int IMAGE_TYPE_PNG = 13;
    private static final int IMAGE_TYPE_RAF = 9;
    private static final int IMAGE_TYPE_RW2 = 10;
    private static final int IMAGE_TYPE_SRW = 11;
    private static final int IMAGE_TYPE_UNKNOWN = 0;
    private static final int IMAGE_TYPE_WEBP = 14;
    private static final ExifTag JPEG_INTERCHANGE_FORMAT_LENGTH_TAG;
    private static final ExifTag JPEG_INTERCHANGE_FORMAT_TAG;
    public static final String LATITUDE_NORTH = "N";
    public static final String LATITUDE_SOUTH = "S";
    public static final short LIGHT_SOURCE_CLOUDY_WEATHER = 10;
    public static final short LIGHT_SOURCE_COOL_WHITE_FLUORESCENT = 14;
    public static final short LIGHT_SOURCE_D50 = 23;
    public static final short LIGHT_SOURCE_D55 = 20;
    public static final short LIGHT_SOURCE_D65 = 21;
    public static final short LIGHT_SOURCE_D75 = 22;
    public static final short LIGHT_SOURCE_DAYLIGHT = 1;
    public static final short LIGHT_SOURCE_DAYLIGHT_FLUORESCENT = 12;
    public static final short LIGHT_SOURCE_DAY_WHITE_FLUORESCENT = 13;
    public static final short LIGHT_SOURCE_FINE_WEATHER = 9;
    public static final short LIGHT_SOURCE_FLASH = 4;
    public static final short LIGHT_SOURCE_FLUORESCENT = 2;
    public static final short LIGHT_SOURCE_ISO_STUDIO_TUNGSTEN = 24;
    public static final short LIGHT_SOURCE_OTHER = 255;
    public static final short LIGHT_SOURCE_SHADE = 11;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_A = 17;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_B = 18;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_C = 19;
    public static final short LIGHT_SOURCE_TUNGSTEN = 3;
    public static final short LIGHT_SOURCE_UNKNOWN = 0;
    public static final short LIGHT_SOURCE_WARM_WHITE_FLUORESCENT = 16;
    public static final short LIGHT_SOURCE_WHITE_FLUORESCENT = 15;
    public static final String LONGITUDE_EAST = "E";
    public static final String LONGITUDE_WEST = "W";
    static final byte MARKER = -1;
    static final byte MARKER_APP1 = -31;
    private static final byte MARKER_COM = -2;
    static final byte MARKER_EOI = -39;
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
    private static final int MAX_THUMBNAIL_SIZE = 512;
    public static final short METERING_MODE_AVERAGE = 1;
    public static final short METERING_MODE_CENTER_WEIGHT_AVERAGE = 2;
    public static final short METERING_MODE_MULTI_SPOT = 4;
    public static final short METERING_MODE_OTHER = 255;
    public static final short METERING_MODE_PARTIAL = 6;
    public static final short METERING_MODE_PATTERN = 5;
    public static final short METERING_MODE_SPOT = 3;
    public static final short METERING_MODE_UNKNOWN = 0;
    private static final Pattern NON_ZERO_TIME_PATTERN;
    private static final ExifTag[] ORF_CAMERA_SETTINGS_TAGS;
    private static final ExifTag[] ORF_IMAGE_PROCESSING_TAGS;
    private static final int ORF_MAKER_NOTE_HEADER_1_SIZE = 8;
    private static final int ORF_MAKER_NOTE_HEADER_2_SIZE = 12;
    private static final ExifTag[] ORF_MAKER_NOTE_TAGS;
    private static final short ORF_SIGNATURE_1 = 20306;
    private static final short ORF_SIGNATURE_2 = 21330;
    public static final int ORIENTATION_FLIP_HORIZONTAL = 2;
    public static final int ORIENTATION_FLIP_VERTICAL = 4;
    public static final int ORIENTATION_NORMAL = 1;
    public static final int ORIENTATION_ROTATE_180 = 3;
    public static final int ORIENTATION_ROTATE_270 = 8;
    public static final int ORIENTATION_ROTATE_90 = 6;
    public static final int ORIENTATION_TRANSPOSE = 5;
    public static final int ORIENTATION_TRANSVERSE = 7;
    public static final int ORIENTATION_UNDEFINED = 0;
    public static final int ORIGINAL_RESOLUTION_IMAGE = 0;
    private static final int PEF_MAKER_NOTE_SKIP_SIZE = 6;
    private static final String PEF_SIGNATURE = "PENTAX";
    private static final ExifTag[] PEF_TAGS;
    public static final int PHOTOMETRIC_INTERPRETATION_BLACK_IS_ZERO = 1;
    public static final int PHOTOMETRIC_INTERPRETATION_RGB = 2;
    public static final int PHOTOMETRIC_INTERPRETATION_WHITE_IS_ZERO = 0;
    public static final int PHOTOMETRIC_INTERPRETATION_YCBCR = 6;
    private static final int PNG_CHUNK_CRC_BYTE_LENGTH = 4;
    private static final int PNG_CHUNK_TYPE_BYTE_LENGTH = 4;
    private static final int RAF_OFFSET_TO_JPEG_IMAGE_OFFSET = 84;
    private static final String RAF_SIGNATURE = "FUJIFILMCCD-RAW";
    public static final int REDUCED_RESOLUTION_IMAGE = 1;
    public static final short RENDERED_PROCESS_CUSTOM = 1;
    public static final short RENDERED_PROCESS_NORMAL = 0;
    public static final short RESOLUTION_UNIT_CENTIMETERS = 3;
    public static final short RESOLUTION_UNIT_INCHES = 2;
    private static final short RW2_SIGNATURE = 85;
    public static final short SATURATION_HIGH = 0;
    public static final short SATURATION_LOW = 0;
    public static final short SATURATION_NORMAL = 0;
    public static final short SCENE_CAPTURE_TYPE_LANDSCAPE = 1;
    public static final short SCENE_CAPTURE_TYPE_NIGHT = 3;
    public static final short SCENE_CAPTURE_TYPE_PORTRAIT = 2;
    public static final short SCENE_CAPTURE_TYPE_STANDARD = 0;
    public static final short SCENE_TYPE_DIRECTLY_PHOTOGRAPHED = 1;
    public static final short SENSITIVITY_TYPE_ISO_SPEED = 3;
    public static final short SENSITIVITY_TYPE_REI = 2;
    public static final short SENSITIVITY_TYPE_REI_AND_ISO = 6;
    public static final short SENSITIVITY_TYPE_SOS = 1;
    public static final short SENSITIVITY_TYPE_SOS_AND_ISO = 5;
    public static final short SENSITIVITY_TYPE_SOS_AND_REI = 4;
    public static final short SENSITIVITY_TYPE_SOS_AND_REI_AND_ISO = 7;
    public static final short SENSITIVITY_TYPE_UNKNOWN = 0;
    public static final short SENSOR_TYPE_COLOR_SEQUENTIAL = 5;
    public static final short SENSOR_TYPE_COLOR_SEQUENTIAL_LINEAR = 8;
    public static final short SENSOR_TYPE_NOT_DEFINED = 1;
    public static final short SENSOR_TYPE_ONE_CHIP = 2;
    public static final short SENSOR_TYPE_THREE_CHIP = 4;
    public static final short SENSOR_TYPE_TRILINEAR = 7;
    public static final short SENSOR_TYPE_TWO_CHIP = 3;
    public static final short SHARPNESS_HARD = 2;
    public static final short SHARPNESS_NORMAL = 0;
    public static final short SHARPNESS_SOFT = 1;
    private static final int SIGNATURE_CHECK_SIZE = 5000;
    public static final int STREAM_TYPE_EXIF_DATA_ONLY = 1;
    public static final int STREAM_TYPE_FULL_IMAGE_DATA = 0;
    public static final short SUBJECT_DISTANCE_RANGE_CLOSE_VIEW = 2;
    public static final short SUBJECT_DISTANCE_RANGE_DISTANT_VIEW = 3;
    public static final short SUBJECT_DISTANCE_RANGE_MACRO = 1;
    public static final short SUBJECT_DISTANCE_RANGE_UNKNOWN = 0;
    public static final String TAG_APERTURE_VALUE = "ApertureValue";
    public static final String TAG_ARTIST = "Artist";
    public static final String TAG_BITS_PER_SAMPLE = "BitsPerSample";
    public static final String TAG_BODY_SERIAL_NUMBER = "BodySerialNumber";
    public static final String TAG_BRIGHTNESS_VALUE = "BrightnessValue";

    @Deprecated
    public static final String TAG_CAMARA_OWNER_NAME = "CameraOwnerName";
    public static final String TAG_CAMERA_OWNER_NAME = "CameraOwnerName";
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
    public static final String TAG_DEFAULT_CROP_SIZE = "DefaultCropSize";
    public static final String TAG_DEVICE_SETTING_DESCRIPTION = "DeviceSettingDescription";
    public static final String TAG_DIGITAL_ZOOM_RATIO = "DigitalZoomRatio";
    public static final String TAG_DNG_VERSION = "DNGVersion";
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
    public static final String TAG_GAMMA = "Gamma";
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
    public static final String TAG_GPS_H_POSITIONING_ERROR = "GPSHPositioningError";
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
    public static final String TAG_ISO_SPEED = "ISOSpeed";
    public static final String TAG_ISO_SPEED_LATITUDE_YYY = "ISOSpeedLatitudeyyy";
    public static final String TAG_ISO_SPEED_LATITUDE_ZZZ = "ISOSpeedLatitudezzz";

    @Deprecated
    public static final String TAG_ISO_SPEED_RATINGS = "ISOSpeedRatings";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT = "JPEGInterchangeFormat";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT_LENGTH = "JPEGInterchangeFormatLength";
    public static final String TAG_LENS_MAKE = "LensMake";
    public static final String TAG_LENS_MODEL = "LensModel";
    public static final String TAG_LENS_SERIAL_NUMBER = "LensSerialNumber";
    public static final String TAG_LENS_SPECIFICATION = "LensSpecification";
    public static final String TAG_LIGHT_SOURCE = "LightSource";
    public static final String TAG_MAKE = "Make";
    public static final String TAG_MAKER_NOTE = "MakerNote";
    public static final String TAG_MAX_APERTURE_VALUE = "MaxApertureValue";
    public static final String TAG_METERING_MODE = "MeteringMode";
    public static final String TAG_MODEL = "Model";
    public static final String TAG_NEW_SUBFILE_TYPE = "NewSubfileType";
    public static final String TAG_OECF = "OECF";
    public static final String TAG_OFFSET_TIME = "OffsetTime";
    public static final String TAG_OFFSET_TIME_DIGITIZED = "OffsetTimeDigitized";
    public static final String TAG_OFFSET_TIME_ORIGINAL = "OffsetTimeOriginal";
    public static final String TAG_ORF_ASPECT_FRAME = "AspectFrame";
    private static final String TAG_ORF_CAMERA_SETTINGS_IFD_POINTER = "CameraSettingsIFDPointer";
    private static final String TAG_ORF_IMAGE_PROCESSING_IFD_POINTER = "ImageProcessingIFDPointer";
    public static final String TAG_ORF_PREVIEW_IMAGE_LENGTH = "PreviewImageLength";
    public static final String TAG_ORF_PREVIEW_IMAGE_START = "PreviewImageStart";
    public static final String TAG_ORF_THUMBNAIL_IMAGE = "ThumbnailImage";
    public static final String TAG_ORIENTATION = "Orientation";
    public static final String TAG_PHOTOGRAPHIC_SENSITIVITY = "PhotographicSensitivity";
    public static final String TAG_PHOTOMETRIC_INTERPRETATION = "PhotometricInterpretation";
    public static final String TAG_PIXEL_X_DIMENSION = "PixelXDimension";
    public static final String TAG_PIXEL_Y_DIMENSION = "PixelYDimension";
    public static final String TAG_PLANAR_CONFIGURATION = "PlanarConfiguration";
    public static final String TAG_PRIMARY_CHROMATICITIES = "PrimaryChromaticities";
    private static final ExifTag TAG_RAF_IMAGE_SIZE;
    public static final String TAG_RECOMMENDED_EXPOSURE_INDEX = "RecommendedExposureIndex";
    public static final String TAG_REFERENCE_BLACK_WHITE = "ReferenceBlackWhite";
    public static final String TAG_RELATED_SOUND_FILE = "RelatedSoundFile";
    public static final String TAG_RESOLUTION_UNIT = "ResolutionUnit";
    public static final String TAG_ROWS_PER_STRIP = "RowsPerStrip";
    public static final String TAG_RW2_ISO = "ISO";
    public static final String TAG_RW2_JPG_FROM_RAW = "JpgFromRaw";
    public static final String TAG_RW2_SENSOR_BOTTOM_BORDER = "SensorBottomBorder";
    public static final String TAG_RW2_SENSOR_LEFT_BORDER = "SensorLeftBorder";
    public static final String TAG_RW2_SENSOR_RIGHT_BORDER = "SensorRightBorder";
    public static final String TAG_RW2_SENSOR_TOP_BORDER = "SensorTopBorder";
    public static final String TAG_SAMPLES_PER_PIXEL = "SamplesPerPixel";
    public static final String TAG_SATURATION = "Saturation";
    public static final String TAG_SCENE_CAPTURE_TYPE = "SceneCaptureType";
    public static final String TAG_SCENE_TYPE = "SceneType";
    public static final String TAG_SENSING_METHOD = "SensingMethod";
    public static final String TAG_SENSITIVITY_TYPE = "SensitivityType";
    public static final String TAG_SHARPNESS = "Sharpness";
    public static final String TAG_SHUTTER_SPEED_VALUE = "ShutterSpeedValue";
    public static final String TAG_SOFTWARE = "Software";
    public static final String TAG_SPATIAL_FREQUENCY_RESPONSE = "SpatialFrequencyResponse";
    public static final String TAG_SPECTRAL_SENSITIVITY = "SpectralSensitivity";
    public static final String TAG_STANDARD_OUTPUT_SENSITIVITY = "StandardOutputSensitivity";
    public static final String TAG_STRIP_BYTE_COUNTS = "StripByteCounts";
    public static final String TAG_STRIP_OFFSETS = "StripOffsets";
    public static final String TAG_SUBFILE_TYPE = "SubfileType";
    public static final String TAG_SUBJECT_AREA = "SubjectArea";
    public static final String TAG_SUBJECT_DISTANCE = "SubjectDistance";
    public static final String TAG_SUBJECT_DISTANCE_RANGE = "SubjectDistanceRange";
    public static final String TAG_SUBJECT_LOCATION = "SubjectLocation";
    public static final String TAG_SUBSEC_TIME = "SubSecTime";
    public static final String TAG_SUBSEC_TIME_DIGITIZED = "SubSecTimeDigitized";
    public static final String TAG_SUBSEC_TIME_ORIGINAL = "SubSecTimeOriginal";
    private static final String TAG_SUB_IFD_POINTER = "SubIFDPointer";
    public static final String TAG_THUMBNAIL_IMAGE_LENGTH = "ThumbnailImageLength";
    public static final String TAG_THUMBNAIL_IMAGE_WIDTH = "ThumbnailImageWidth";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String TAG_THUMBNAIL_ORIENTATION = "ThumbnailOrientation";
    public static final String TAG_TRANSFER_FUNCTION = "TransferFunction";
    public static final String TAG_USER_COMMENT = "UserComment";
    public static final String TAG_WHITE_BALANCE = "WhiteBalance";
    public static final String TAG_WHITE_POINT = "WhitePoint";
    public static final String TAG_XMP = "Xmp";
    public static final String TAG_X_RESOLUTION = "XResolution";
    public static final String TAG_Y_CB_CR_COEFFICIENTS = "YCbCrCoefficients";
    public static final String TAG_Y_CB_CR_POSITIONING = "YCbCrPositioning";
    public static final String TAG_Y_CB_CR_SUB_SAMPLING = "YCbCrSubSampling";
    public static final String TAG_Y_RESOLUTION = "YResolution";
    private static final int WEBP_CHUNK_SIZE_BYTE_LENGTH = 4;
    private static final int WEBP_CHUNK_TYPE_BYTE_LENGTH = 4;
    private static final int WEBP_CHUNK_TYPE_VP8X_DEFAULT_LENGTH = 10;
    private static final int WEBP_FILE_SIZE_BYTE_LENGTH = 4;
    private static final byte WEBP_VP8L_SIGNATURE = 47;

    @Deprecated
    public static final int WHITEBALANCE_AUTO = 0;

    @Deprecated
    public static final int WHITEBALANCE_MANUAL = 1;
    public static final short WHITE_BALANCE_AUTO = 0;
    public static final short WHITE_BALANCE_MANUAL = 1;
    public static final short Y_CB_CR_POSITIONING_CENTERED = 1;
    public static final short Y_CB_CR_POSITIONING_CO_SITED = 2;
    private static final HashMap<Integer, Integer> sExifPointerTagMap;
    private static final HashMap<Integer, ExifTag>[] sExifTagMapsForReading;
    private static final HashMap<String, ExifTag>[] sExifTagMapsForWriting;
    private static SimpleDateFormat sFormatterPrimary;
    private static SimpleDateFormat sFormatterSecondary;
    private static final HashSet<String> sTagSetForCompatibility;
    private boolean mAreThumbnailStripsConsecutive;
    private AssetManager.AssetInputStream mAssetInputStream;
    private final HashMap<String, ExifAttribute>[] mAttributes;
    private Set<Integer> mAttributesOffsets;
    private ByteOrder mExifByteOrder;
    private String mFilename;
    private boolean mHasThumbnail;
    private boolean mHasThumbnailStrips;
    private boolean mIsExifDataOnly;
    private int mMimeType;
    private boolean mModified;
    private int mOffsetToExifData;
    private int mOrfMakerNoteOffset;
    private int mOrfThumbnailLength;
    private int mOrfThumbnailOffset;
    private FileDescriptor mSeekableFileDescriptor;
    private byte[] mThumbnailBytes;
    private int mThumbnailCompression;
    private int mThumbnailLength;
    private int mThumbnailOffset;
    private boolean mXmpIsFromSeparateMarker;
    private static final String TAG = "ExifInterface";
    private static final boolean DEBUG = Log.isLoggable(TAG, 3);
    private static final List<Integer> ROTATION_ORDER = Arrays.asList(1, 6, 3, 8);
    private static final List<Integer> FLIPPED_ROTATION_ORDER = Arrays.asList(2, 7, 4, 5);
    public static final int[] BITS_PER_SAMPLE_RGB = {8, 8, 8};
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_1 = {4};
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_2 = {8};
    private static final byte MARKER_SOI = -40;
    static final byte[] JPEG_SIGNATURE = {-1, MARKER_SOI, -1};
    private static final byte[] HEIF_TYPE_FTYP = {102, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_TopicPic, PublicAccountH5AbilityPluginImpl.OPENCAMERA};
    private static final byte[] HEIF_BRAND_MIF1 = {Constants.CHANNEL_DATATYPE_NETWORK_BANDWIDTH, 105, 102, 49};
    private static final byte[] HEIF_BRAND_HEIC = {104, 101, 105, 99};
    private static final byte[] ORF_MAKER_NOTE_HEADER_1 = {79, 76, 89, 77, 80, 0};
    private static final byte[] ORF_MAKER_NOTE_HEADER_2 = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    private static final byte[] PNG_SIGNATURE = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final byte[] PNG_CHUNK_TYPE_EXIF = {101, 88, 73, 102};
    private static final byte[] PNG_CHUNK_TYPE_IHDR = {73, 72, 68, 82};
    private static final byte[] PNG_CHUNK_TYPE_IEND = {73, 69, 78, 68};
    private static final byte[] WEBP_SIGNATURE_1 = {82, 73, 70, 70};
    private static final byte[] WEBP_SIGNATURE_2 = {87, 69, 66, 80};
    private static final byte[] WEBP_CHUNK_TYPE_EXIF = {69, 88, 73, 70};
    static final byte START_CODE = 42;
    private static final byte[] WEBP_VP8_SIGNATURE = {-99, 1, START_CODE};
    private static final byte[] WEBP_CHUNK_TYPE_VP8X = "VP8X".getBytes(Charset.defaultCharset());
    private static final byte[] WEBP_CHUNK_TYPE_VP8L = "VP8L".getBytes(Charset.defaultCharset());
    private static final byte[] WEBP_CHUNK_TYPE_VP8 = "VP8 ".getBytes(Charset.defaultCharset());
    private static final byte[] WEBP_CHUNK_TYPE_ANIM = "ANIM".getBytes(Charset.defaultCharset());
    private static final byte[] WEBP_CHUNK_TYPE_ANMF = "ANMF".getBytes(Charset.defaultCharset());
    static final String[] IFD_FORMAT_NAMES = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
    static final int[] IFD_FORMAT_BYTES_PER_FORMAT = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    static final byte[] EXIF_ASCII_PREFIX = {65, 83, 67, 73, 73, 0, 0, 0};

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class ByteOrderedDataInputStream extends InputStream implements DataInput {
        private ByteOrder mByteOrder;
        private DataInputStream mDataInputStream;
        final int mLength;
        int mPosition;
        private static final ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        private static final ByteOrder BIG_ENDIAN = ByteOrder.BIG_ENDIAN;

        public ByteOrderedDataInputStream(InputStream inputStream) throws IOException {
            this(inputStream, ByteOrder.BIG_ENDIAN);
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.mDataInputStream.available();
        }

        public int getLength() {
            return this.mLength;
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i3) {
            this.mDataInputStream.mark(i3);
        }

        public int peek() {
            return this.mPosition;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            this.mPosition++;
            return this.mDataInputStream.read();
        }

        @Override // java.io.DataInput
        public boolean readBoolean() throws IOException {
            this.mPosition++;
            return this.mDataInputStream.readBoolean();
        }

        @Override // java.io.DataInput
        public byte readByte() throws IOException {
            int i3 = this.mPosition + 1;
            this.mPosition = i3;
            if (i3 <= this.mLength) {
                int read = this.mDataInputStream.read();
                if (read >= 0) {
                    return (byte) read;
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public char readChar() throws IOException {
            this.mPosition += 2;
            return this.mDataInputStream.readChar();
        }

        @Override // java.io.DataInput
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr, int i3, int i16) throws IOException {
            int i17 = this.mPosition + i16;
            this.mPosition = i17;
            if (i17 <= this.mLength) {
                if (this.mDataInputStream.read(bArr, i3, i16) != i16) {
                    throw new IOException("Couldn't read up to the length of buffer");
                }
                return;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public int readInt() throws IOException {
            int i3 = this.mPosition + 4;
            this.mPosition = i3;
            if (i3 <= this.mLength) {
                int read = this.mDataInputStream.read();
                int read2 = this.mDataInputStream.read();
                int read3 = this.mDataInputStream.read();
                int read4 = this.mDataInputStream.read();
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

        @Override // java.io.DataInput
        public String readLine() throws IOException {
            Log.d(ExifInterface.TAG, "Currently unsupported");
            return null;
        }

        @Override // java.io.DataInput
        public long readLong() throws IOException {
            int i3 = this.mPosition + 8;
            this.mPosition = i3;
            if (i3 <= this.mLength) {
                int read = this.mDataInputStream.read();
                int read2 = this.mDataInputStream.read();
                int read3 = this.mDataInputStream.read();
                int read4 = this.mDataInputStream.read();
                int read5 = this.mDataInputStream.read();
                int read6 = this.mDataInputStream.read();
                int read7 = this.mDataInputStream.read();
                int read8 = this.mDataInputStream.read();
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

        @Override // java.io.DataInput
        public short readShort() throws IOException {
            int i3 = this.mPosition + 2;
            this.mPosition = i3;
            if (i3 <= this.mLength) {
                int read = this.mDataInputStream.read();
                int read2 = this.mDataInputStream.read();
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

        @Override // java.io.DataInput
        public String readUTF() throws IOException {
            this.mPosition += 2;
            return this.mDataInputStream.readUTF();
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() throws IOException {
            this.mPosition++;
            return this.mDataInputStream.readUnsignedByte();
        }

        public long readUnsignedInt() throws IOException {
            return readInt() & 4294967295L;
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() throws IOException {
            int i3 = this.mPosition + 2;
            this.mPosition = i3;
            if (i3 <= this.mLength) {
                int read = this.mDataInputStream.read();
                int read2 = this.mDataInputStream.read();
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
            int i3 = this.mPosition;
            if (i3 > j3) {
                this.mPosition = 0;
                this.mDataInputStream.reset();
                this.mDataInputStream.mark(this.mLength);
            } else {
                j3 -= i3;
            }
            int i16 = (int) j3;
            if (skipBytes(i16) == i16) {
            } else {
                throw new IOException("Couldn't seek up to the byteCount");
            }
        }

        public void setByteOrder(ByteOrder byteOrder) {
            this.mByteOrder = byteOrder;
        }

        @Override // java.io.DataInput
        public int skipBytes(int i3) throws IOException {
            int min = Math.min(i3, this.mLength - this.mPosition);
            int i16 = 0;
            while (i16 < min) {
                i16 += this.mDataInputStream.skipBytes(min - i16);
            }
            this.mPosition += i16;
            return i16;
        }

        ByteOrderedDataInputStream(InputStream inputStream, ByteOrder byteOrder) throws IOException {
            this.mByteOrder = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.mDataInputStream = dataInputStream;
            int available = dataInputStream.available();
            this.mLength = available;
            this.mPosition = 0;
            this.mDataInputStream.mark(available);
            this.mByteOrder = byteOrder;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i3, int i16) throws IOException {
            int read = this.mDataInputStream.read(bArr, i3, i16);
            this.mPosition += read;
            return read;
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr) throws IOException {
            int length = this.mPosition + bArr.length;
            this.mPosition = length;
            if (length <= this.mLength) {
                if (this.mDataInputStream.read(bArr, 0, bArr.length) != bArr.length) {
                    throw new IOException("Couldn't read up to the length of buffer");
                }
                return;
            }
            throw new EOFException();
        }

        public ByteOrderedDataInputStream(byte[] bArr) throws IOException {
            this(new ByteArrayInputStream(bArr));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class ByteOrderedDataOutputStream extends FilterOutputStream {
        private ByteOrder mByteOrder;
        final OutputStream mOutputStream;

        public ByteOrderedDataOutputStream(OutputStream outputStream, ByteOrder byteOrder) {
            super(outputStream);
            this.mOutputStream = outputStream;
            this.mByteOrder = byteOrder;
        }

        public void setByteOrder(ByteOrder byteOrder) {
            this.mByteOrder = byteOrder;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.mOutputStream.write(bArr);
        }

        public void writeByte(int i3) throws IOException {
            this.mOutputStream.write(i3);
        }

        public void writeInt(int i3) throws IOException {
            ByteOrder byteOrder = this.mByteOrder;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.mOutputStream.write((i3 >>> 0) & 255);
                this.mOutputStream.write((i3 >>> 8) & 255);
                this.mOutputStream.write((i3 >>> 16) & 255);
                this.mOutputStream.write((i3 >>> 24) & 255);
                return;
            }
            if (byteOrder == ByteOrder.BIG_ENDIAN) {
                this.mOutputStream.write((i3 >>> 24) & 255);
                this.mOutputStream.write((i3 >>> 16) & 255);
                this.mOutputStream.write((i3 >>> 8) & 255);
                this.mOutputStream.write((i3 >>> 0) & 255);
            }
        }

        public void writeShort(short s16) throws IOException {
            ByteOrder byteOrder = this.mByteOrder;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.mOutputStream.write((s16 >>> 0) & 255);
                this.mOutputStream.write((s16 >>> 8) & 255);
            } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
                this.mOutputStream.write((s16 >>> 8) & 255);
                this.mOutputStream.write((s16 >>> 0) & 255);
            }
        }

        public void writeUnsignedInt(long j3) throws IOException {
            writeInt((int) j3);
        }

        public void writeUnsignedShort(int i3) throws IOException {
            writeShort((short) i3);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i3, int i16) throws IOException {
            this.mOutputStream.write(bArr, i3, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class ExifAttribute {
        public static final long BYTES_OFFSET_UNKNOWN = -1;
        public final byte[] bytes;
        public final long bytesOffset;
        public final int format;
        public final int numberOfComponents;

        ExifAttribute(int i3, int i16, byte[] bArr) {
            this(i3, i16, -1L, bArr);
        }

        public static ExifAttribute createByte(String str) {
            if (str.length() == 1 && str.charAt(0) >= '0' && str.charAt(0) <= '1') {
                return new ExifAttribute(1, 1, new byte[]{(byte) (str.charAt(0) - '0')});
            }
            byte[] bytes = str.getBytes(ExifInterface.ASCII);
            return new ExifAttribute(1, bytes.length, bytes);
        }

        public static ExifAttribute createDouble(double[] dArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[12] * dArr.length]);
            wrap.order(byteOrder);
            for (double d16 : dArr) {
                wrap.putDouble(d16);
            }
            return new ExifAttribute(12, dArr.length, wrap.array());
        }

        public static ExifAttribute createSLong(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[9] * iArr.length]);
            wrap.order(byteOrder);
            for (int i3 : iArr) {
                wrap.putInt(i3);
            }
            return new ExifAttribute(9, iArr.length, wrap.array());
        }

        public static ExifAttribute createSRational(Rational[] rationalArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[10] * rationalArr.length]);
            wrap.order(byteOrder);
            for (Rational rational : rationalArr) {
                wrap.putInt((int) rational.numerator);
                wrap.putInt((int) rational.denominator);
            }
            return new ExifAttribute(10, rationalArr.length, wrap.array());
        }

        public static ExifAttribute createString(String str) {
            byte[] bytes = (str + (char) 0).getBytes(ExifInterface.ASCII);
            return new ExifAttribute(2, bytes.length, bytes);
        }

        public static ExifAttribute createULong(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[4] * jArr.length]);
            wrap.order(byteOrder);
            for (long j3 : jArr) {
                wrap.putInt((int) j3);
            }
            return new ExifAttribute(4, jArr.length, wrap.array());
        }

        public static ExifAttribute createURational(Rational[] rationalArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[5] * rationalArr.length]);
            wrap.order(byteOrder);
            for (Rational rational : rationalArr) {
                wrap.putInt((int) rational.numerator);
                wrap.putInt((int) rational.denominator);
            }
            return new ExifAttribute(5, rationalArr.length, wrap.array());
        }

        public static ExifAttribute createUShort(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[3] * iArr.length]);
            wrap.order(byteOrder);
            for (int i3 : iArr) {
                wrap.putShort((short) i3);
            }
            return new ExifAttribute(3, iArr.length, wrap.array());
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

        /* JADX WARN: Not initialized variable reg: 3, insn: 0x019b: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:412), block:B:168:0x019b */
        /* JADX WARN: Removed duplicated region for block: B:171:0x019e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        Object getValue(ByteOrder byteOrder) {
            ByteOrderedDataInputStream byteOrderedDataInputStream;
            InputStream inputStream;
            byte b16;
            byte b17;
            byte[] bArr;
            InputStream inputStream2 = null;
            try {
                try {
                    byteOrderedDataInputStream = new ByteOrderedDataInputStream(this.bytes);
                } catch (IOException e16) {
                    e = e16;
                    byteOrderedDataInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    if (inputStream2 != null) {
                    }
                    throw th;
                }
                try {
                    byteOrderedDataInputStream.setByteOrder(byteOrder);
                    int i3 = 0;
                    boolean z16 = true;
                    switch (this.format) {
                        case 1:
                        case 6:
                            byte[] bArr2 = this.bytes;
                            if (bArr2.length == 1 && (b16 = bArr2[0]) >= 0 && b16 <= 1) {
                                String str = new String(new char[]{(char) (b16 + 48)});
                                try {
                                    byteOrderedDataInputStream.close();
                                } catch (IOException e17) {
                                    Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e17);
                                }
                                return str;
                            }
                            String str2 = new String(bArr2, ExifInterface.ASCII);
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (IOException e18) {
                                Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e18);
                            }
                            return str2;
                        case 2:
                        case 7:
                            if (this.numberOfComponents >= ExifInterface.EXIF_ASCII_PREFIX.length) {
                                int i16 = 0;
                                while (true) {
                                    bArr = ExifInterface.EXIF_ASCII_PREFIX;
                                    if (i16 < bArr.length) {
                                        if (this.bytes[i16] != bArr[i16]) {
                                            z16 = false;
                                        } else {
                                            i16++;
                                        }
                                    }
                                }
                                if (z16) {
                                    i3 = bArr.length;
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
                            String sb6 = sb5.toString();
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (IOException e19) {
                                Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e19);
                            }
                            return sb6;
                        case 3:
                            int[] iArr = new int[this.numberOfComponents];
                            while (i3 < this.numberOfComponents) {
                                iArr[i3] = byteOrderedDataInputStream.readUnsignedShort();
                                i3++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (IOException e26) {
                                Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e26);
                            }
                            return iArr;
                        case 4:
                            long[] jArr = new long[this.numberOfComponents];
                            while (i3 < this.numberOfComponents) {
                                jArr[i3] = byteOrderedDataInputStream.readUnsignedInt();
                                i3++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (IOException e27) {
                                Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e27);
                            }
                            return jArr;
                        case 5:
                            Rational[] rationalArr = new Rational[this.numberOfComponents];
                            while (i3 < this.numberOfComponents) {
                                rationalArr[i3] = new Rational(byteOrderedDataInputStream.readUnsignedInt(), byteOrderedDataInputStream.readUnsignedInt());
                                i3++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (IOException e28) {
                                Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e28);
                            }
                            return rationalArr;
                        case 8:
                            int[] iArr2 = new int[this.numberOfComponents];
                            while (i3 < this.numberOfComponents) {
                                iArr2[i3] = byteOrderedDataInputStream.readShort();
                                i3++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (IOException e29) {
                                Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e29);
                            }
                            return iArr2;
                        case 9:
                            int[] iArr3 = new int[this.numberOfComponents];
                            while (i3 < this.numberOfComponents) {
                                iArr3[i3] = byteOrderedDataInputStream.readInt();
                                i3++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (IOException e36) {
                                Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e36);
                            }
                            return iArr3;
                        case 10:
                            Rational[] rationalArr2 = new Rational[this.numberOfComponents];
                            while (i3 < this.numberOfComponents) {
                                rationalArr2[i3] = new Rational(byteOrderedDataInputStream.readInt(), byteOrderedDataInputStream.readInt());
                                i3++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (IOException e37) {
                                Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e37);
                            }
                            return rationalArr2;
                        case 11:
                            double[] dArr = new double[this.numberOfComponents];
                            while (i3 < this.numberOfComponents) {
                                dArr[i3] = byteOrderedDataInputStream.readFloat();
                                i3++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (IOException e38) {
                                Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e38);
                            }
                            return dArr;
                        case 12:
                            double[] dArr2 = new double[this.numberOfComponents];
                            while (i3 < this.numberOfComponents) {
                                dArr2[i3] = byteOrderedDataInputStream.readDouble();
                                i3++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (IOException e39) {
                                Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e39);
                            }
                            return dArr2;
                        default:
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (IOException e46) {
                                Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e46);
                            }
                            return null;
                    }
                } catch (IOException e47) {
                    e = e47;
                    Log.w(ExifInterface.TAG, "IOException occurred during reading a value", e);
                    if (byteOrderedDataInputStream != null) {
                        try {
                            byteOrderedDataInputStream.close();
                        } catch (IOException e48) {
                            Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e48);
                        }
                    }
                    return null;
                }
            } catch (Throwable th6) {
                th = th6;
                inputStream2 = inputStream;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e49) {
                        Log.e(ExifInterface.TAG, "IOException occurred while closing InputStream", e49);
                    }
                }
                throw th;
            }
        }

        public int size() {
            return ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[this.format] * this.numberOfComponents;
        }

        public String toString() {
            return "(" + ExifInterface.IFD_FORMAT_NAMES[this.format] + ", data length:" + this.bytes.length + ")";
        }

        ExifAttribute(int i3, int i16, long j3, byte[] bArr) {
            this.format = i3;
            this.numberOfComponents = i16;
            this.bytesOffset = j3;
            this.bytes = bArr;
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

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public @interface ExifStreamType {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public @interface IfdType {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Rational {
        public final long denominator;
        public final long numerator;

        Rational(double d16) {
            this((long) (d16 * 10000.0d), 10000L);
        }

        public double calculate() {
            return this.numerator / this.denominator;
        }

        public String toString() {
            return this.numerator + "/" + this.denominator;
        }

        Rational(long j3, long j16) {
            if (j16 == 0) {
                this.numerator = 0L;
                this.denominator = 1L;
            } else {
                this.numerator = j3;
                this.denominator = j16;
            }
        }
    }

    static {
        ExifTag[] exifTagArr = {new ExifTag(TAG_NEW_SUBFILE_TYPE, 254, 4), new ExifTag(TAG_SUBFILE_TYPE, 255, 4), new ExifTag("ImageWidth", 256, 3, 4), new ExifTag("ImageLength", 257, 3, 4), new ExifTag("BitsPerSample", 258, 3), new ExifTag("Compression", 259, 3), new ExifTag("PhotometricInterpretation", 262, 3), new ExifTag("ImageDescription", 270, 2), new ExifTag("Make", 271, 2), new ExifTag("Model", 272, 2), new ExifTag("StripOffsets", 273, 3, 4), new ExifTag("Orientation", 274, 3), new ExifTag("SamplesPerPixel", 277, 3), new ExifTag("RowsPerStrip", 278, 3, 4), new ExifTag("StripByteCounts", FilterEnum.MIC_PTU_TRANS_ROUHE, 3, 4), new ExifTag("XResolution", FilterEnum.MIC_PTU_BAIXI, 5), new ExifTag("YResolution", 283, 5), new ExifTag("PlanarConfiguration", 284, 3), new ExifTag("ResolutionUnit", 296, 3), new ExifTag("TransferFunction", 301, 3), new ExifTag("Software", 305, 2), new ExifTag("DateTime", 306, 2), new ExifTag("Artist", 315, 2), new ExifTag("WhitePoint", 318, 5), new ExifTag("PrimaryChromaticities", 319, 5), new ExifTag(TAG_SUB_IFD_POINTER, MapItemKt.ITEM_AVATAR_MIN_WIDTH, 4), new ExifTag("JPEGInterchangeFormat", 513, 4), new ExifTag("JPEGInterchangeFormatLength", 514, 4), new ExifTag("YCbCrCoefficients", 529, 5), new ExifTag("YCbCrSubSampling", 530, 3), new ExifTag("YCbCrPositioning", TVKQQLiveAssetPlayerMsg.PLAYER_INFO_ON_RICH_MEDIA_PREPARED, 3), new ExifTag("ReferenceBlackWhite", TVKQQLiveAssetPlayerMsg.PLAYER_INFO_ON_RICH_MEDIA_PREPARE_FAILED, 5), new ExifTag("Copyright", 33432, 2), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new ExifTag(TAG_RW2_SENSOR_TOP_BORDER, 4, 4), new ExifTag(TAG_RW2_SENSOR_LEFT_BORDER, 5, 4), new ExifTag(TAG_RW2_SENSOR_BOTTOM_BORDER, 6, 4), new ExifTag(TAG_RW2_SENSOR_RIGHT_BORDER, 7, 4), new ExifTag(TAG_RW2_ISO, 23, 3), new ExifTag(TAG_RW2_JPG_FROM_RAW, 46, 7), new ExifTag(TAG_XMP, 700, 1)};
        IFD_TIFF_TAGS = exifTagArr;
        ExifTag[] exifTagArr2 = {new ExifTag("ExposureTime", 33434, 5), new ExifTag("FNumber", 33437, 5), new ExifTag("ExposureProgram", 34850, 3), new ExifTag("SpectralSensitivity", 34852, 2), new ExifTag(TAG_PHOTOGRAPHIC_SENSITIVITY, 34855, 3), new ExifTag("OECF", 34856, 7), new ExifTag(TAG_SENSITIVITY_TYPE, 34864, 3), new ExifTag(TAG_STANDARD_OUTPUT_SENSITIVITY, 34865, 4), new ExifTag(TAG_RECOMMENDED_EXPOSURE_INDEX, 34866, 4), new ExifTag(TAG_ISO_SPEED, 34867, 4), new ExifTag(TAG_ISO_SPEED_LATITUDE_YYY, 34868, 4), new ExifTag(TAG_ISO_SPEED_LATITUDE_ZZZ, 34869, 4), new ExifTag("ExifVersion", 36864, 2), new ExifTag("DateTimeOriginal", GCloudVoiceErrorCode.GCloudVoiceErrno.GCLOUD_VOICE_COORDINATE_ROOMNAME_ERROR, 2), new ExifTag("DateTimeDigitized", 36868, 2), new ExifTag(TAG_OFFSET_TIME, 36880, 2), new ExifTag(TAG_OFFSET_TIME_ORIGINAL, 36881, 2), new ExifTag(TAG_OFFSET_TIME_DIGITIZED, 36882, 2), new ExifTag("ComponentsConfiguration", 37121, 7), new ExifTag("CompressedBitsPerPixel", 37122, 5), new ExifTag("ShutterSpeedValue", 37377, 10), new ExifTag("ApertureValue", 37378, 5), new ExifTag("BrightnessValue", 37379, 10), new ExifTag("ExposureBiasValue", 37380, 10), new ExifTag("MaxApertureValue", 37381, 5), new ExifTag("SubjectDistance", 37382, 5), new ExifTag("MeteringMode", 37383, 3), new ExifTag("LightSource", 37384, 3), new ExifTag("Flash", 37385, 3), new ExifTag("FocalLength", 37386, 5), new ExifTag("SubjectArea", 37396, 3), new ExifTag("MakerNote", 37500, 7), new ExifTag("UserComment", 37510, 7), new ExifTag("SubSecTime", 37520, 2), new ExifTag("SubSecTimeOriginal", 37521, 2), new ExifTag("SubSecTimeDigitized", 37522, 2), new ExifTag("FlashpixVersion", 40960, 7), new ExifTag("ColorSpace", GCloudVoiceErrorCode.GCloudVoiceCompleteCode.GV_ON_ST_SUCC, 3), new ExifTag("PixelXDimension", GCloudVoiceErrorCode.GCloudVoiceCompleteCode.GV_ON_ST_HTTP_ERROR, 3, 4), new ExifTag("PixelYDimension", GCloudVoiceErrorCode.GCloudVoiceCompleteCode.GV_ON_ST_SERVER_ERROR, 3, 4), new ExifTag("RelatedSoundFile", GCloudVoiceErrorCode.GCloudVoiceCompleteCode.GV_ON_ST_INVALID_JSON, 2), new ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, GCloudVoiceErrorCode.GCloudVoiceCompleteCode.GV_ON_ST_ALREADY_EXIST, 4), new ExifTag("FlashEnergy", 41483, 5), new ExifTag("SpatialFrequencyResponse", 41484, 7), new ExifTag("FocalPlaneXResolution", 41486, 5), new ExifTag("FocalPlaneYResolution", 41487, 5), new ExifTag("FocalPlaneResolutionUnit", 41488, 3), new ExifTag("SubjectLocation", 41492, 3), new ExifTag("ExposureIndex", 41493, 5), new ExifTag("SensingMethod", 41495, 3), new ExifTag("FileSource", 41728, 7), new ExifTag("SceneType", 41729, 7), new ExifTag("CFAPattern", 41730, 7), new ExifTag("CustomRendered", 41985, 3), new ExifTag("ExposureMode", 41986, 3), new ExifTag("WhiteBalance", ProfileContants.FIELD_HAS_NEARBY_AVATAR_FLAG, 3), new ExifTag("DigitalZoomRatio", 41988, 5), new ExifTag("FocalLengthIn35mmFilm", 41989, 3), new ExifTag("SceneCaptureType", 41990, 3), new ExifTag("GainControl", 41991, 3), new ExifTag("Contrast", 41992, 3), new ExifTag("Saturation", ProfileContants.FIELD_FRESHNEWS_NOTIFY_SWITCH, 3), new ExifTag("Sharpness", 41994, 3), new ExifTag("DeviceSettingDescription", 41995, 7), new ExifTag("SubjectDistanceRange", 41996, 3), new ExifTag("ImageUniqueID", 42016, 2), new ExifTag("CameraOwnerName", 42032, 2), new ExifTag(TAG_BODY_SERIAL_NUMBER, 42033, 2), new ExifTag(TAG_LENS_SPECIFICATION, ProfileContants.FIELD_IS_NEARBY_NOVICE, 5), new ExifTag(TAG_LENS_MAKE, 42035, 2), new ExifTag(TAG_LENS_MODEL, 42036, 2), new ExifTag(TAG_GAMMA, 42240, 5), new ExifTag(TAG_DNG_VERSION, 50706, 1), new ExifTag(TAG_DEFAULT_CROP_SIZE, 50720, 3, 4)};
        IFD_EXIF_TAGS = exifTagArr2;
        ExifTag[] exifTagArr3 = {new ExifTag("GPSVersionID", 0, 1), new ExifTag("GPSLatitudeRef", 1, 2), new ExifTag("GPSLatitude", 2, 5, 10), new ExifTag("GPSLongitudeRef", 3, 2), new ExifTag("GPSLongitude", 4, 5, 10), new ExifTag("GPSAltitudeRef", 5, 1), new ExifTag("GPSAltitude", 6, 5), new ExifTag("GPSTimeStamp", 7, 5), new ExifTag("GPSSatellites", 8, 2), new ExifTag("GPSStatus", 9, 2), new ExifTag("GPSMeasureMode", 10, 2), new ExifTag("GPSDOP", 11, 5), new ExifTag("GPSSpeedRef", 12, 2), new ExifTag("GPSSpeed", 13, 5), new ExifTag("GPSTrackRef", 14, 2), new ExifTag("GPSTrack", 15, 5), new ExifTag("GPSImgDirectionRef", 16, 2), new ExifTag("GPSImgDirection", 17, 5), new ExifTag("GPSMapDatum", 18, 2), new ExifTag("GPSDestLatitudeRef", 19, 2), new ExifTag("GPSDestLatitude", 20, 5), new ExifTag("GPSDestLongitudeRef", 21, 2), new ExifTag("GPSDestLongitude", 22, 5), new ExifTag("GPSDestBearingRef", 23, 2), new ExifTag("GPSDestBearing", 24, 5), new ExifTag("GPSDestDistanceRef", 25, 2), new ExifTag("GPSDestDistance", 26, 5), new ExifTag("GPSProcessingMethod", 27, 7), new ExifTag("GPSAreaInformation", 28, 7), new ExifTag("GPSDateStamp", 29, 2), new ExifTag("GPSDifferential", 30, 3), new ExifTag(TAG_GPS_H_POSITIONING_ERROR, 31, 5)};
        IFD_GPS_TAGS = exifTagArr3;
        ExifTag[] exifTagArr4 = {new ExifTag("InteroperabilityIndex", 1, 2)};
        IFD_INTEROPERABILITY_TAGS = exifTagArr4;
        ExifTag[] exifTagArr5 = {new ExifTag(TAG_NEW_SUBFILE_TYPE, 254, 4), new ExifTag(TAG_SUBFILE_TYPE, 255, 4), new ExifTag("ThumbnailImageWidth", 256, 3, 4), new ExifTag("ThumbnailImageLength", 257, 3, 4), new ExifTag("BitsPerSample", 258, 3), new ExifTag("Compression", 259, 3), new ExifTag("PhotometricInterpretation", 262, 3), new ExifTag("ImageDescription", 270, 2), new ExifTag("Make", 271, 2), new ExifTag("Model", 272, 2), new ExifTag("StripOffsets", 273, 3, 4), new ExifTag(TAG_THUMBNAIL_ORIENTATION, 274, 3), new ExifTag("SamplesPerPixel", 277, 3), new ExifTag("RowsPerStrip", 278, 3, 4), new ExifTag("StripByteCounts", FilterEnum.MIC_PTU_TRANS_ROUHE, 3, 4), new ExifTag("XResolution", FilterEnum.MIC_PTU_BAIXI, 5), new ExifTag("YResolution", 283, 5), new ExifTag("PlanarConfiguration", 284, 3), new ExifTag("ResolutionUnit", 296, 3), new ExifTag("TransferFunction", 301, 3), new ExifTag("Software", 305, 2), new ExifTag("DateTime", 306, 2), new ExifTag("Artist", 315, 2), new ExifTag("WhitePoint", 318, 5), new ExifTag("PrimaryChromaticities", 319, 5), new ExifTag(TAG_SUB_IFD_POINTER, MapItemKt.ITEM_AVATAR_MIN_WIDTH, 4), new ExifTag("JPEGInterchangeFormat", 513, 4), new ExifTag("JPEGInterchangeFormatLength", 514, 4), new ExifTag("YCbCrCoefficients", 529, 5), new ExifTag("YCbCrSubSampling", 530, 3), new ExifTag("YCbCrPositioning", TVKQQLiveAssetPlayerMsg.PLAYER_INFO_ON_RICH_MEDIA_PREPARED, 3), new ExifTag("ReferenceBlackWhite", TVKQQLiveAssetPlayerMsg.PLAYER_INFO_ON_RICH_MEDIA_PREPARE_FAILED, 5), new ExifTag("Copyright", 33432, 2), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new ExifTag(TAG_DNG_VERSION, 50706, 1), new ExifTag(TAG_DEFAULT_CROP_SIZE, 50720, 3, 4)};
        IFD_THUMBNAIL_TAGS = exifTagArr5;
        TAG_RAF_IMAGE_SIZE = new ExifTag("StripOffsets", 273, 3);
        ExifTag[] exifTagArr6 = {new ExifTag(TAG_ORF_THUMBNAIL_IMAGE, 256, 7), new ExifTag(TAG_ORF_CAMERA_SETTINGS_IFD_POINTER, MtpConstants.RESPONSE_SPECIFICATION_OF_DESTINATION_UNSUPPORTED, 4), new ExifTag(TAG_ORF_IMAGE_PROCESSING_IFD_POINTER, 8256, 4)};
        ORF_MAKER_NOTE_TAGS = exifTagArr6;
        ExifTag[] exifTagArr7 = {new ExifTag(TAG_ORF_PREVIEW_IMAGE_START, 257, 4), new ExifTag(TAG_ORF_PREVIEW_IMAGE_LENGTH, 258, 4)};
        ORF_CAMERA_SETTINGS_TAGS = exifTagArr7;
        ExifTag[] exifTagArr8 = {new ExifTag(TAG_ORF_ASPECT_FRAME, PlayerResources.RawId.RAW_360_FRAG_SHADER, 3)};
        ORF_IMAGE_PROCESSING_TAGS = exifTagArr8;
        ExifTag[] exifTagArr9 = {new ExifTag("ColorSpace", 55, 3)};
        PEF_TAGS = exifTagArr9;
        ExifTag[][] exifTagArr10 = {exifTagArr, exifTagArr2, exifTagArr3, exifTagArr4, exifTagArr5, exifTagArr, exifTagArr6, exifTagArr7, exifTagArr8, exifTagArr9};
        EXIF_TAGS = exifTagArr10;
        EXIF_POINTER_TAGS = new ExifTag[]{new ExifTag(TAG_SUB_IFD_POINTER, MapItemKt.ITEM_AVATAR_MIN_WIDTH, 4), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, GCloudVoiceErrorCode.GCloudVoiceCompleteCode.GV_ON_ST_ALREADY_EXIST, 4), new ExifTag(TAG_ORF_CAMERA_SETTINGS_IFD_POINTER, MtpConstants.RESPONSE_SPECIFICATION_OF_DESTINATION_UNSUPPORTED, 1), new ExifTag(TAG_ORF_IMAGE_PROCESSING_IFD_POINTER, 8256, 1)};
        JPEG_INTERCHANGE_FORMAT_TAG = new ExifTag("JPEGInterchangeFormat", 513, 4);
        JPEG_INTERCHANGE_FORMAT_LENGTH_TAG = new ExifTag("JPEGInterchangeFormatLength", 514, 4);
        sExifTagMapsForReading = new HashMap[exifTagArr10.length];
        sExifTagMapsForWriting = new HashMap[exifTagArr10.length];
        sTagSetForCompatibility = new HashSet<>(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        sExifPointerTagMap = new HashMap<>();
        Charset forName = Charset.forName("US-ASCII");
        ASCII = forName;
        IDENTIFIER_EXIF_APP1 = "Exif\u0000\u0000".getBytes(forName);
        IDENTIFIER_XMP_APP1 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(forName);
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale);
        sFormatterPrimary = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
        sFormatterSecondary = simpleDateFormat2;
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("UTC"));
        int i3 = 0;
        while (true) {
            ExifTag[][] exifTagArr11 = EXIF_TAGS;
            if (i3 < exifTagArr11.length) {
                sExifTagMapsForReading[i3] = new HashMap<>();
                sExifTagMapsForWriting[i3] = new HashMap<>();
                for (ExifTag exifTag : exifTagArr11[i3]) {
                    sExifTagMapsForReading[i3].put(Integer.valueOf(exifTag.number), exifTag);
                    sExifTagMapsForWriting[i3].put(exifTag.name, exifTag);
                }
                i3++;
            } else {
                HashMap<Integer, Integer> hashMap = sExifPointerTagMap;
                ExifTag[] exifTagArr12 = EXIF_POINTER_TAGS;
                hashMap.put(Integer.valueOf(exifTagArr12[0].number), 5);
                hashMap.put(Integer.valueOf(exifTagArr12[1].number), 1);
                hashMap.put(Integer.valueOf(exifTagArr12[2].number), 2);
                hashMap.put(Integer.valueOf(exifTagArr12[3].number), 3);
                hashMap.put(Integer.valueOf(exifTagArr12[4].number), 7);
                hashMap.put(Integer.valueOf(exifTagArr12[5].number), 8);
                NON_ZERO_TIME_PATTERN = Pattern.compile(".*[1-9].*");
                GPS_TIMESTAMP_PATTERN = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
                DATETIME_PRIMARY_FORMAT_PATTERN = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                DATETIME_SECONDARY_FORMAT_PATTERN = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                return;
            }
        }
    }

    public ExifInterface(@NonNull File file) throws IOException {
        ExifTag[][] exifTagArr = EXIF_TAGS;
        this.mAttributes = new HashMap[exifTagArr.length];
        this.mAttributesOffsets = new HashSet(exifTagArr.length);
        this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
        if (file != null) {
            initForFilename(file.getAbsolutePath());
            return;
        }
        throw new NullPointerException("file cannot be null");
    }

    private void addDefaultValuesForCompatibility() {
        String attribute = getAttribute("DateTimeOriginal");
        if (attribute != null && getAttribute("DateTime") == null) {
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

    private static String byteArrayToHexString(byte[] bArr) {
        StringBuilder sb5 = new StringBuilder(bArr.length * 2);
        for (byte b16 : bArr) {
            sb5.append(String.format("%02x", Byte.valueOf(b16)));
        }
        return sb5.toString();
    }

    private static void closeFileDescriptor(FileDescriptor fileDescriptor) {
        try {
            Os.close(fileDescriptor);
        } catch (Exception unused) {
            Log.e(TAG, "Error closing fd.");
        }
    }

    private static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e16) {
                throw e16;
            } catch (Exception unused) {
            }
        }
    }

    private String convertDecimalDegree(double d16) {
        long j3 = (long) d16;
        double d17 = d16 - j3;
        long j16 = (long) (d17 * 60.0d);
        return j3 + "/1," + j16 + "/1," + Math.round((d17 - (j16 / 60.0d)) * 3600.0d * 1.0E7d) + "/10000000";
    }

    private static double convertRationalLatLonToDouble(String str, String str2) {
        try {
            String[] split = str.split(",", -1);
            String[] split2 = split[0].split("/", -1);
            double parseDouble = Double.parseDouble(split2[0].trim()) / Double.parseDouble(split2[1].trim());
            String[] split3 = split[1].split("/", -1);
            double parseDouble2 = Double.parseDouble(split3[0].trim()) / Double.parseDouble(split3[1].trim());
            String[] split4 = split[2].split("/", -1);
            double parseDouble3 = parseDouble + (parseDouble2 / 60.0d) + ((Double.parseDouble(split4[0].trim()) / Double.parseDouble(split4[1].trim())) / 3600.0d);
            if (!str2.equals(LATITUDE_SOUTH) && !str2.equals("W")) {
                if (!str2.equals("N") && !str2.equals("E")) {
                    throw new IllegalArgumentException();
                }
                return parseDouble3;
            }
            return -parseDouble3;
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException unused) {
            throw new IllegalArgumentException();
        }
    }

    private static long[] convertToLongArray(Object obj) {
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            long[] jArr = new long[iArr.length];
            for (int i3 = 0; i3 < iArr.length; i3++) {
                jArr[i3] = iArr[i3];
            }
            return jArr;
        }
        if (obj instanceof long[]) {
            return (long[]) obj;
        }
        return null;
    }

    private static int copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        int i3 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return i3;
            }
            i3 += read;
            outputStream.write(bArr, 0, read);
        }
    }

    private void copyChunksUpToGivenChunkType(ByteOrderedDataInputStream byteOrderedDataInputStream, ByteOrderedDataOutputStream byteOrderedDataOutputStream, byte[] bArr, byte[] bArr2) throws IOException {
        String str;
        while (true) {
            byte[] bArr3 = new byte[4];
            if (byteOrderedDataInputStream.read(bArr3) != 4) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Encountered invalid length while copying WebP chunks up tochunk type ");
                Charset charset = ASCII;
                sb5.append(new String(bArr, charset));
                if (bArr2 == null) {
                    str = "";
                } else {
                    str = " or " + new String(bArr2, charset);
                }
                sb5.append(str);
                throw new IOException(sb5.toString());
            }
            copyWebPChunk(byteOrderedDataInputStream, byteOrderedDataOutputStream, bArr3);
            if (!Arrays.equals(bArr3, bArr)) {
                if (bArr2 != null && Arrays.equals(bArr3, bArr2)) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private void copyWebPChunk(ByteOrderedDataInputStream byteOrderedDataInputStream, ByteOrderedDataOutputStream byteOrderedDataOutputStream, byte[] bArr) throws IOException {
        int readInt = byteOrderedDataInputStream.readInt();
        byteOrderedDataOutputStream.write(bArr);
        byteOrderedDataOutputStream.writeInt(readInt);
        if (readInt % 2 == 1) {
            readInt++;
        }
        copy(byteOrderedDataInputStream, byteOrderedDataOutputStream, readInt);
    }

    @Nullable
    private ExifAttribute getExifAttribute(@NonNull String str) {
        if (str != null) {
            if ("ISOSpeedRatings".equals(str)) {
                if (DEBUG) {
                    Log.d(TAG, "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
                }
                str = TAG_PHOTOGRAPHIC_SENSITIVITY;
            }
            for (int i3 = 0; i3 < EXIF_TAGS.length; i3++) {
                ExifAttribute exifAttribute = this.mAttributes[i3].get(str);
                if (exifAttribute != null) {
                    return exifAttribute;
                }
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    private void getHeifAttributes(final ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        String str;
        String str2;
        String str3;
        int i3;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(new MediaDataSource() { // from class: androidx.exifinterface.media.ExifInterface.1
                long mPosition;

                @Override // android.media.MediaDataSource
                public long getSize() throws IOException {
                    return -1L;
                }

                @Override // android.media.MediaDataSource
                public int readAt(long j3, byte[] bArr, int i16, int i17) throws IOException {
                    if (i17 == 0) {
                        return 0;
                    }
                    if (j3 < 0) {
                        return -1;
                    }
                    try {
                        long j16 = this.mPosition;
                        if (j16 != j3) {
                            if (j16 >= 0 && j3 >= j16 + byteOrderedDataInputStream.available()) {
                                return -1;
                            }
                            byteOrderedDataInputStream.seek(j3);
                            this.mPosition = j3;
                        }
                        if (i17 > byteOrderedDataInputStream.available()) {
                            i17 = byteOrderedDataInputStream.available();
                        }
                        int read = byteOrderedDataInputStream.read(bArr, i16, i17);
                        if (read >= 0) {
                            this.mPosition += read;
                            return read;
                        }
                    } catch (IOException unused) {
                    }
                    this.mPosition = -1L;
                    return -1;
                }

                @Override // java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                }
            });
            String extractMetadata = mediaMetadataRetriever.extractMetadata(33);
            String extractMetadata2 = mediaMetadataRetriever.extractMetadata(34);
            String extractMetadata3 = mediaMetadataRetriever.extractMetadata(26);
            String extractMetadata4 = mediaMetadataRetriever.extractMetadata(17);
            if ("yes".equals(extractMetadata3)) {
                str = mediaMetadataRetriever.extractMetadata(29);
                str2 = mediaMetadataRetriever.extractMetadata(30);
                str3 = mediaMetadataRetriever.extractMetadata(31);
            } else if ("yes".equals(extractMetadata4)) {
                str = mediaMetadataRetriever.extractMetadata(18);
                str2 = mediaMetadataRetriever.extractMetadata(19);
                str3 = mediaMetadataRetriever.extractMetadata(24);
            } else {
                str = null;
                str2 = null;
                str3 = null;
            }
            if (str != null) {
                this.mAttributes[0].put("ImageWidth", ExifAttribute.createUShort(Integer.parseInt(str), this.mExifByteOrder));
            }
            if (str2 != null) {
                this.mAttributes[0].put("ImageLength", ExifAttribute.createUShort(Integer.parseInt(str2), this.mExifByteOrder));
            }
            if (str3 != null) {
                int parseInt = Integer.parseInt(str3);
                if (parseInt != 90) {
                    if (parseInt != 180) {
                        if (parseInt != 270) {
                            i3 = 1;
                        } else {
                            i3 = 8;
                        }
                    } else {
                        i3 = 3;
                    }
                } else {
                    i3 = 6;
                }
                this.mAttributes[0].put("Orientation", ExifAttribute.createUShort(i3, this.mExifByteOrder));
            }
            if (extractMetadata != null && extractMetadata2 != null) {
                int parseInt2 = Integer.parseInt(extractMetadata);
                int parseInt3 = Integer.parseInt(extractMetadata2);
                if (parseInt3 > 6) {
                    byteOrderedDataInputStream.seek(parseInt2);
                    byte[] bArr = new byte[6];
                    if (byteOrderedDataInputStream.read(bArr) == 6) {
                        int i16 = parseInt2 + 6;
                        int i17 = parseInt3 - 6;
                        if (Arrays.equals(bArr, IDENTIFIER_EXIF_APP1)) {
                            byte[] bArr2 = new byte[i17];
                            if (byteOrderedDataInputStream.read(bArr2) == i17) {
                                this.mOffsetToExifData = i16;
                                readExifSegment(bArr2, 0);
                            } else {
                                throw new IOException("Can't read exif");
                            }
                        } else {
                            throw new IOException("Invalid identifier");
                        }
                    } else {
                        throw new IOException("Can't read identifier");
                    }
                } else {
                    throw new IOException("Invalid exif length");
                }
            }
            if (DEBUG) {
                Log.d(TAG, "Heif meta: " + str + HippyTKDListViewAdapter.X + str2 + ", rotation " + str3);
            }
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:30:0x00be. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c5 A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void getJpegAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream, int i3, int i16) throws IOException {
        String str;
        boolean z16 = DEBUG;
        String str2 = TAG;
        if (z16) {
            Log.d(TAG, "getJpegAttributes starting with: " + byteOrderedDataInputStream);
        }
        int i17 = 0;
        byteOrderedDataInputStream.mark(0);
        byteOrderedDataInputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
        byte readByte = byteOrderedDataInputStream.readByte();
        if (readByte == -1) {
            if (byteOrderedDataInputStream.readByte() == -40) {
                int i18 = 2;
                int i19 = 2;
                while (true) {
                    byte readByte2 = byteOrderedDataInputStream.readByte();
                    if (readByte2 == -1) {
                        int i26 = i19 + 1;
                        byte readByte3 = byteOrderedDataInputStream.readByte();
                        boolean z17 = DEBUG;
                        if (z17) {
                            Log.d(str2, "Found JPEG segment indicator: " + Integer.toHexString(readByte3 & 255));
                        }
                        int i27 = i26 + 1;
                        if (readByte3 != -39 && readByte3 != -38) {
                            int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort() - i18;
                            int i28 = i27 + i18;
                            if (z17) {
                                Log.d(str2, "JPEG segment: " + Integer.toHexString(readByte3 & 255) + " (length: " + (readUnsignedShort + 2) + ")");
                            }
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
                                                                if (byteOrderedDataInputStream.skipBytes(1) == 1) {
                                                                    this.mAttributes[i16].put("ImageLength", ExifAttribute.createULong(byteOrderedDataInputStream.readUnsignedShort(), this.mExifByteOrder));
                                                                    this.mAttributes[i16].put("ImageWidth", ExifAttribute.createULong(byteOrderedDataInputStream.readUnsignedShort(), this.mExifByteOrder));
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
                                        if (byteOrderedDataInputStream.read(bArr) == readUnsignedShort) {
                                            if (getAttribute("UserComment") == null) {
                                                this.mAttributes[1].put("UserComment", ExifAttribute.createString(new String(bArr, ASCII)));
                                            }
                                            readUnsignedShort = i17;
                                        } else {
                                            throw new IOException("Invalid exif");
                                        }
                                    }
                                    str = str2;
                                } else {
                                    byte[] bArr2 = new byte[readUnsignedShort];
                                    byteOrderedDataInputStream.readFully(bArr2);
                                    int i29 = i28 + readUnsignedShort;
                                    byte[] bArr3 = IDENTIFIER_EXIF_APP1;
                                    if (startsWith(bArr2, bArr3)) {
                                        byte[] copyOfRange = Arrays.copyOfRange(bArr2, bArr3.length, readUnsignedShort);
                                        this.mOffsetToExifData = i3 + i28 + bArr3.length;
                                        readExifSegment(copyOfRange, i16);
                                        setThumbnailData(new ByteOrderedDataInputStream(copyOfRange));
                                    } else {
                                        byte[] bArr4 = IDENTIFIER_XMP_APP1;
                                        if (startsWith(bArr2, bArr4)) {
                                            int length = i28 + bArr4.length;
                                            byte[] copyOfRange2 = Arrays.copyOfRange(bArr2, bArr4.length, readUnsignedShort);
                                            if (getAttribute(TAG_XMP) == null) {
                                                str = str2;
                                                this.mAttributes[i17].put(TAG_XMP, new ExifAttribute(1, copyOfRange2.length, length, copyOfRange2));
                                                this.mXmpIsFromSeparateMarker = true;
                                                i28 = i29;
                                                readUnsignedShort = 0;
                                            }
                                        }
                                    }
                                    str = str2;
                                    i28 = i29;
                                    readUnsignedShort = 0;
                                }
                                if (readUnsignedShort >= 0) {
                                    if (byteOrderedDataInputStream.skipBytes(readUnsignedShort) == readUnsignedShort) {
                                        i19 = i28 + readUnsignedShort;
                                        str2 = str;
                                        i17 = 0;
                                        i18 = 2;
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
                byteOrderedDataInputStream.setByteOrder(this.mExifByteOrder);
                return;
            }
            throw new IOException("Invalid marker: " + Integer.toHexString(readByte & 255));
        }
        throw new IOException("Invalid marker: " + Integer.toHexString(readByte & 255));
    }

    private int getMimeType(BufferedInputStream bufferedInputStream) throws IOException {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (isJpegFormat(bArr)) {
            return 4;
        }
        if (isRafFormat(bArr)) {
            return 9;
        }
        if (isHeifFormat(bArr)) {
            return 12;
        }
        if (isOrfFormat(bArr)) {
            return 7;
        }
        if (isRw2Format(bArr)) {
            return 10;
        }
        if (isPngFormat(bArr)) {
            return 13;
        }
        if (isWebpFormat(bArr)) {
            return 14;
        }
        return 0;
    }

    private void getOrfAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        int i3;
        int i16;
        getRawAttributes(byteOrderedDataInputStream);
        ExifAttribute exifAttribute = this.mAttributes[1].get("MakerNote");
        if (exifAttribute != null) {
            ByteOrderedDataInputStream byteOrderedDataInputStream2 = new ByteOrderedDataInputStream(exifAttribute.bytes);
            byteOrderedDataInputStream2.setByteOrder(this.mExifByteOrder);
            byte[] bArr = ORF_MAKER_NOTE_HEADER_1;
            byte[] bArr2 = new byte[bArr.length];
            byteOrderedDataInputStream2.readFully(bArr2);
            byteOrderedDataInputStream2.seek(0L);
            byte[] bArr3 = ORF_MAKER_NOTE_HEADER_2;
            byte[] bArr4 = new byte[bArr3.length];
            byteOrderedDataInputStream2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                byteOrderedDataInputStream2.seek(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                byteOrderedDataInputStream2.seek(12L);
            }
            readImageFileDirectory(byteOrderedDataInputStream2, 6);
            ExifAttribute exifAttribute2 = this.mAttributes[7].get(TAG_ORF_PREVIEW_IMAGE_START);
            ExifAttribute exifAttribute3 = this.mAttributes[7].get(TAG_ORF_PREVIEW_IMAGE_LENGTH);
            if (exifAttribute2 != null && exifAttribute3 != null) {
                this.mAttributes[5].put("JPEGInterchangeFormat", exifAttribute2);
                this.mAttributes[5].put("JPEGInterchangeFormatLength", exifAttribute3);
            }
            ExifAttribute exifAttribute4 = this.mAttributes[8].get(TAG_ORF_ASPECT_FRAME);
            if (exifAttribute4 != null) {
                int[] iArr = (int[]) exifAttribute4.getValue(this.mExifByteOrder);
                if (iArr != null && iArr.length == 4) {
                    int i17 = iArr[2];
                    int i18 = iArr[0];
                    if (i17 > i18 && (i3 = iArr[3]) > (i16 = iArr[1])) {
                        int i19 = (i17 - i18) + 1;
                        int i26 = (i3 - i16) + 1;
                        if (i19 < i26) {
                            int i27 = i19 + i26;
                            i26 = i27 - i26;
                            i19 = i27 - i26;
                        }
                        ExifAttribute createUShort = ExifAttribute.createUShort(i19, this.mExifByteOrder);
                        ExifAttribute createUShort2 = ExifAttribute.createUShort(i26, this.mExifByteOrder);
                        this.mAttributes[0].put("ImageWidth", createUShort);
                        this.mAttributes[0].put("ImageLength", createUShort2);
                        return;
                    }
                    return;
                }
                Log.w(TAG, "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
            }
        }
    }

    private void getPngAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        if (DEBUG) {
            Log.d(TAG, "getPngAttributes starting with: " + byteOrderedDataInputStream);
        }
        byteOrderedDataInputStream.mark(0);
        byteOrderedDataInputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
        byte[] bArr = PNG_SIGNATURE;
        byteOrderedDataInputStream.skipBytes(bArr.length);
        int length = bArr.length + 0;
        while (true) {
            try {
                int readInt = byteOrderedDataInputStream.readInt();
                int i3 = length + 4;
                byte[] bArr2 = new byte[4];
                if (byteOrderedDataInputStream.read(bArr2) == 4) {
                    int i16 = i3 + 4;
                    if (i16 == 16 && !Arrays.equals(bArr2, PNG_CHUNK_TYPE_IHDR)) {
                        throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                    }
                    if (!Arrays.equals(bArr2, PNG_CHUNK_TYPE_IEND)) {
                        if (Arrays.equals(bArr2, PNG_CHUNK_TYPE_EXIF)) {
                            byte[] bArr3 = new byte[readInt];
                            if (byteOrderedDataInputStream.read(bArr3) == readInt) {
                                int readInt2 = byteOrderedDataInputStream.readInt();
                                CRC32 crc32 = new CRC32();
                                crc32.update(bArr2);
                                crc32.update(bArr3);
                                if (((int) crc32.getValue()) == readInt2) {
                                    this.mOffsetToExifData = i16;
                                    readExifSegment(bArr3, 0);
                                    validateImages();
                                    setThumbnailData(new ByteOrderedDataInputStream(bArr3));
                                    return;
                                }
                                throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + readInt2 + ", calculated CRC value: " + crc32.getValue());
                            }
                            throw new IOException("Failed to read given length for given PNG chunk type: " + byteArrayToHexString(bArr2));
                        }
                        int i17 = readInt + 4;
                        byteOrderedDataInputStream.skipBytes(i17);
                        length = i16 + i17;
                    } else {
                        return;
                    }
                } else {
                    throw new IOException("Encountered invalid length while parsing PNG chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    private void getRafAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        boolean z16 = DEBUG;
        if (z16) {
            Log.d(TAG, "getRafAttributes starting with: " + byteOrderedDataInputStream);
        }
        byteOrderedDataInputStream.mark(0);
        byteOrderedDataInputStream.skipBytes(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        byteOrderedDataInputStream.read(bArr);
        byteOrderedDataInputStream.read(bArr2);
        byteOrderedDataInputStream.read(bArr3);
        int i3 = ByteBuffer.wrap(bArr).getInt();
        int i16 = ByteBuffer.wrap(bArr2).getInt();
        int i17 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i16];
        byteOrderedDataInputStream.seek(i3);
        byteOrderedDataInputStream.read(bArr4);
        getJpegAttributes(new ByteOrderedDataInputStream(bArr4), i3, 5);
        byteOrderedDataInputStream.seek(i17);
        byteOrderedDataInputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
        int readInt = byteOrderedDataInputStream.readInt();
        if (z16) {
            Log.d(TAG, "numberOfDirectoryEntry: " + readInt);
        }
        for (int i18 = 0; i18 < readInt; i18++) {
            int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
            int readUnsignedShort2 = byteOrderedDataInputStream.readUnsignedShort();
            if (readUnsignedShort == TAG_RAF_IMAGE_SIZE.number) {
                short readShort = byteOrderedDataInputStream.readShort();
                short readShort2 = byteOrderedDataInputStream.readShort();
                ExifAttribute createUShort = ExifAttribute.createUShort(readShort, this.mExifByteOrder);
                ExifAttribute createUShort2 = ExifAttribute.createUShort(readShort2, this.mExifByteOrder);
                this.mAttributes[0].put("ImageLength", createUShort);
                this.mAttributes[0].put("ImageWidth", createUShort2);
                if (DEBUG) {
                    Log.d(TAG, "Updated to length: " + ((int) readShort) + ", width: " + ((int) readShort2));
                    return;
                }
                return;
            }
            byteOrderedDataInputStream.skipBytes(readUnsignedShort2);
        }
    }

    private void getRawAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        ExifAttribute exifAttribute;
        parseTiffHeaders(byteOrderedDataInputStream, byteOrderedDataInputStream.available());
        readImageFileDirectory(byteOrderedDataInputStream, 0);
        updateImageSizeValues(byteOrderedDataInputStream, 0);
        updateImageSizeValues(byteOrderedDataInputStream, 5);
        updateImageSizeValues(byteOrderedDataInputStream, 4);
        validateImages();
        if (this.mMimeType == 8 && (exifAttribute = this.mAttributes[1].get("MakerNote")) != null) {
            ByteOrderedDataInputStream byteOrderedDataInputStream2 = new ByteOrderedDataInputStream(exifAttribute.bytes);
            byteOrderedDataInputStream2.setByteOrder(this.mExifByteOrder);
            byteOrderedDataInputStream2.seek(6L);
            readImageFileDirectory(byteOrderedDataInputStream2, 9);
            ExifAttribute exifAttribute2 = this.mAttributes[9].get("ColorSpace");
            if (exifAttribute2 != null) {
                this.mAttributes[1].put("ColorSpace", exifAttribute2);
            }
        }
    }

    private void getRw2Attributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        if (DEBUG) {
            Log.d(TAG, "getRw2Attributes starting with: " + byteOrderedDataInputStream);
        }
        getRawAttributes(byteOrderedDataInputStream);
        ExifAttribute exifAttribute = this.mAttributes[0].get(TAG_RW2_JPG_FROM_RAW);
        if (exifAttribute != null) {
            getJpegAttributes(new ByteOrderedDataInputStream(exifAttribute.bytes), (int) exifAttribute.bytesOffset, 5);
        }
        ExifAttribute exifAttribute2 = this.mAttributes[0].get(TAG_RW2_ISO);
        ExifAttribute exifAttribute3 = this.mAttributes[1].get(TAG_PHOTOGRAPHIC_SENSITIVITY);
        if (exifAttribute2 != null && exifAttribute3 == null) {
            this.mAttributes[1].put(TAG_PHOTOGRAPHIC_SENSITIVITY, exifAttribute2);
        }
    }

    private void getStandaloneAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        byte[] bArr = IDENTIFIER_EXIF_APP1;
        byteOrderedDataInputStream.skipBytes(bArr.length);
        byte[] bArr2 = new byte[byteOrderedDataInputStream.available()];
        byteOrderedDataInputStream.readFully(bArr2);
        this.mOffsetToExifData = bArr.length;
        readExifSegment(bArr2, 0);
    }

    private void getWebpAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        if (DEBUG) {
            Log.d(TAG, "getWebpAttributes starting with: " + byteOrderedDataInputStream);
        }
        byteOrderedDataInputStream.mark(0);
        byteOrderedDataInputStream.setByteOrder(ByteOrder.LITTLE_ENDIAN);
        byteOrderedDataInputStream.skipBytes(WEBP_SIGNATURE_1.length);
        int readInt = byteOrderedDataInputStream.readInt() + 8;
        int skipBytes = byteOrderedDataInputStream.skipBytes(WEBP_SIGNATURE_2.length) + 8;
        while (true) {
            try {
                byte[] bArr = new byte[4];
                if (byteOrderedDataInputStream.read(bArr) == 4) {
                    int readInt2 = byteOrderedDataInputStream.readInt();
                    int i3 = skipBytes + 4 + 4;
                    if (Arrays.equals(WEBP_CHUNK_TYPE_EXIF, bArr)) {
                        byte[] bArr2 = new byte[readInt2];
                        if (byteOrderedDataInputStream.read(bArr2) == readInt2) {
                            this.mOffsetToExifData = i3;
                            readExifSegment(bArr2, 0);
                            setThumbnailData(new ByteOrderedDataInputStream(bArr2));
                            return;
                        } else {
                            throw new IOException("Failed to read given length for given PNG chunk type: " + byteArrayToHexString(bArr));
                        }
                    }
                    if (readInt2 % 2 == 1) {
                        readInt2++;
                    }
                    int i16 = i3 + readInt2;
                    if (i16 == readInt) {
                        return;
                    }
                    if (i16 <= readInt) {
                        int skipBytes2 = byteOrderedDataInputStream.skipBytes(readInt2);
                        if (skipBytes2 == readInt2) {
                            skipBytes = i3 + skipBytes2;
                        } else {
                            throw new IOException("Encountered WebP file with invalid chunk size");
                        }
                    } else {
                        throw new IOException("Encountered WebP file with invalid chunk size");
                    }
                } else {
                    throw new IOException("Encountered invalid length while parsing WebP chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    private static Pair<Integer, Integer> guessDataFormat(String str) {
        int intValue;
        int i3;
        if (str.contains(",")) {
            String[] split = str.split(",", -1);
            Pair<Integer, Integer> guessDataFormat = guessDataFormat(split[0]);
            if (((Integer) guessDataFormat.first).intValue() == 2) {
                return guessDataFormat;
            }
            for (int i16 = 1; i16 < split.length; i16++) {
                Pair<Integer, Integer> guessDataFormat2 = guessDataFormat(split[i16]);
                if (!((Integer) guessDataFormat2.first).equals(guessDataFormat.first) && !((Integer) guessDataFormat2.second).equals(guessDataFormat.first)) {
                    intValue = -1;
                } else {
                    intValue = ((Integer) guessDataFormat.first).intValue();
                }
                if (((Integer) guessDataFormat.second).intValue() != -1 && (((Integer) guessDataFormat2.first).equals(guessDataFormat.second) || ((Integer) guessDataFormat2.second).equals(guessDataFormat.second))) {
                    i3 = ((Integer) guessDataFormat.second).intValue();
                } else {
                    i3 = -1;
                }
                if (intValue == -1 && i3 == -1) {
                    return new Pair<>(2, -1);
                }
                if (intValue == -1) {
                    guessDataFormat = new Pair<>(Integer.valueOf(i3), -1);
                } else if (i3 == -1) {
                    guessDataFormat = new Pair<>(Integer.valueOf(intValue), -1);
                }
            }
            return guessDataFormat;
        }
        if (str.contains("/")) {
            String[] split2 = str.split("/", -1);
            if (split2.length == 2) {
                try {
                    long parseDouble = (long) Double.parseDouble(split2[0]);
                    long parseDouble2 = (long) Double.parseDouble(split2[1]);
                    if (parseDouble >= 0 && parseDouble2 >= 0) {
                        if (parseDouble <= TTL.MAX_VALUE && parseDouble2 <= TTL.MAX_VALUE) {
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

    private void handleThumbnailFromJfif(ByteOrderedDataInputStream byteOrderedDataInputStream, HashMap hashMap) throws IOException {
        ExifAttribute exifAttribute = (ExifAttribute) hashMap.get("JPEGInterchangeFormat");
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get("JPEGInterchangeFormatLength");
        if (exifAttribute != null && exifAttribute2 != null) {
            int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
            int intValue2 = exifAttribute2.getIntValue(this.mExifByteOrder);
            if (this.mMimeType == 7) {
                intValue += this.mOrfMakerNoteOffset;
            }
            int min = Math.min(intValue2, byteOrderedDataInputStream.getLength() - intValue);
            if (intValue > 0 && min > 0) {
                this.mHasThumbnail = true;
                if (this.mFilename == null && this.mAssetInputStream == null && this.mSeekableFileDescriptor == null) {
                    byte[] bArr = new byte[min];
                    byteOrderedDataInputStream.skip(intValue);
                    byteOrderedDataInputStream.read(bArr);
                    this.mThumbnailBytes = bArr;
                }
                this.mThumbnailOffset = intValue;
                this.mThumbnailLength = min;
            }
            if (DEBUG) {
                Log.d(TAG, "Setting thumbnail attributes with offset: " + intValue + ", length: " + min);
            }
        }
    }

    private void handleThumbnailFromStrips(ByteOrderedDataInputStream byteOrderedDataInputStream, HashMap hashMap) throws IOException {
        ExifAttribute exifAttribute = (ExifAttribute) hashMap.get("StripOffsets");
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get("StripByteCounts");
        if (exifAttribute != null && exifAttribute2 != null) {
            long[] convertToLongArray = convertToLongArray(exifAttribute.getValue(this.mExifByteOrder));
            long[] convertToLongArray2 = convertToLongArray(exifAttribute2.getValue(this.mExifByteOrder));
            if (convertToLongArray != null && convertToLongArray.length != 0) {
                if (convertToLongArray2 != null && convertToLongArray2.length != 0) {
                    if (convertToLongArray.length != convertToLongArray2.length) {
                        Log.w(TAG, "stripOffsets and stripByteCounts should have same length.");
                        return;
                    }
                    long j3 = 0;
                    for (long j16 : convertToLongArray2) {
                        j3 += j16;
                    }
                    int i3 = (int) j3;
                    byte[] bArr = new byte[i3];
                    this.mAreThumbnailStripsConsecutive = true;
                    this.mHasThumbnailStrips = true;
                    this.mHasThumbnail = true;
                    int i16 = 0;
                    int i17 = 0;
                    for (int i18 = 0; i18 < convertToLongArray.length; i18++) {
                        int i19 = (int) convertToLongArray[i18];
                        int i26 = (int) convertToLongArray2[i18];
                        if (i18 < convertToLongArray.length - 1 && i19 + i26 != convertToLongArray[i18 + 1]) {
                            this.mAreThumbnailStripsConsecutive = false;
                        }
                        int i27 = i19 - i16;
                        if (i27 < 0) {
                            Log.d(TAG, "Invalid strip offset value");
                            return;
                        }
                        long j17 = i27;
                        if (byteOrderedDataInputStream.skip(j17) != j17) {
                            Log.d(TAG, "Failed to skip " + i27 + " bytes.");
                            return;
                        }
                        int i28 = i16 + i27;
                        byte[] bArr2 = new byte[i26];
                        if (byteOrderedDataInputStream.read(bArr2) != i26) {
                            Log.d(TAG, "Failed to read " + i26 + " bytes.");
                            return;
                        }
                        i16 = i28 + i26;
                        System.arraycopy(bArr2, 0, bArr, i17, i26);
                        i17 += i26;
                    }
                    this.mThumbnailBytes = bArr;
                    if (this.mAreThumbnailStripsConsecutive) {
                        this.mThumbnailOffset = (int) convertToLongArray[0];
                        this.mThumbnailLength = i3;
                        return;
                    }
                    return;
                }
                Log.w(TAG, "stripByteCounts should not be null or have zero length.");
                return;
            }
            Log.w(TAG, "stripOffsets should not be null or have zero length.");
        }
    }

    private void initForFilename(String str) throws IOException {
        FileInputStream fileInputStream;
        if (str != null) {
            FileInputStream fileInputStream2 = null;
            this.mAssetInputStream = null;
            this.mFilename = str;
            try {
                fileInputStream = new FileInputStream(str);
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                if (isSeekableFD(fileInputStream.getFD())) {
                    this.mSeekableFileDescriptor = fileInputStream.getFD();
                } else {
                    this.mSeekableFileDescriptor = null;
                }
                loadAttributes(fileInputStream);
                closeQuietly(fileInputStream);
                return;
            } catch (Throwable th6) {
                th = th6;
                fileInputStream2 = fileInputStream;
                closeQuietly(fileInputStream2);
                throw th;
            }
        }
        throw new NullPointerException("filename cannot be null");
    }

    private static boolean isExifDataOnly(BufferedInputStream bufferedInputStream) throws IOException {
        byte[] bArr = IDENTIFIER_EXIF_APP1;
        bufferedInputStream.mark(bArr.length);
        byte[] bArr2 = new byte[bArr.length];
        bufferedInputStream.read(bArr2);
        bufferedInputStream.reset();
        int i3 = 0;
        while (true) {
            byte[] bArr3 = IDENTIFIER_EXIF_APP1;
            if (i3 < bArr3.length) {
                if (bArr2[i3] != bArr3[i3]) {
                    return false;
                }
                i3++;
            } else {
                return true;
            }
        }
    }

    private boolean isHeifFormat(byte[] bArr) throws IOException {
        ByteOrderedDataInputStream byteOrderedDataInputStream;
        long readInt;
        byte[] bArr2;
        long j3;
        ByteOrderedDataInputStream byteOrderedDataInputStream2 = null;
        try {
            try {
                byteOrderedDataInputStream = new ByteOrderedDataInputStream(bArr);
                try {
                    readInt = byteOrderedDataInputStream.readInt();
                    bArr2 = new byte[4];
                    byteOrderedDataInputStream.read(bArr2);
                } catch (Exception e16) {
                    e = e16;
                    byteOrderedDataInputStream2 = byteOrderedDataInputStream;
                    if (DEBUG) {
                        Log.d(TAG, "Exception parsing HEIF file type box.", e);
                    }
                    if (byteOrderedDataInputStream2 != null) {
                        byteOrderedDataInputStream2.close();
                    }
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    byteOrderedDataInputStream2 = byteOrderedDataInputStream;
                    if (byteOrderedDataInputStream2 != null) {
                        byteOrderedDataInputStream2.close();
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e17) {
            e = e17;
        }
        if (!Arrays.equals(bArr2, HEIF_TYPE_FTYP)) {
            byteOrderedDataInputStream.close();
            return false;
        }
        if (readInt == 1) {
            readInt = byteOrderedDataInputStream.readLong();
            j3 = 16;
            if (readInt < 16) {
                byteOrderedDataInputStream.close();
                return false;
            }
        } else {
            j3 = 8;
        }
        if (readInt > bArr.length) {
            readInt = bArr.length;
        }
        long j16 = readInt - j3;
        if (j16 < 8) {
            byteOrderedDataInputStream.close();
            return false;
        }
        byte[] bArr3 = new byte[4];
        boolean z16 = false;
        boolean z17 = false;
        for (long j17 = 0; j17 < j16 / 4; j17++) {
            if (byteOrderedDataInputStream.read(bArr3) != 4) {
                byteOrderedDataInputStream.close();
                return false;
            }
            if (j17 != 1) {
                if (Arrays.equals(bArr3, HEIF_BRAND_MIF1)) {
                    z16 = true;
                } else if (Arrays.equals(bArr3, HEIF_BRAND_HEIC)) {
                    z17 = true;
                }
                if (z16 && z17) {
                    byteOrderedDataInputStream.close();
                    return true;
                }
            }
        }
        byteOrderedDataInputStream.close();
        return false;
    }

    private static boolean isJpegFormat(byte[] bArr) throws IOException {
        int i3 = 0;
        while (true) {
            byte[] bArr2 = JPEG_SIGNATURE;
            if (i3 < bArr2.length) {
                if (bArr[i3] != bArr2[i3]) {
                    return false;
                }
                i3++;
            } else {
                return true;
            }
        }
    }

    private boolean isOrfFormat(byte[] bArr) throws IOException {
        ByteOrderedDataInputStream byteOrderedDataInputStream;
        boolean z16 = false;
        ByteOrderedDataInputStream byteOrderedDataInputStream2 = null;
        try {
            byteOrderedDataInputStream = new ByteOrderedDataInputStream(bArr);
        } catch (Exception unused) {
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            ByteOrder readByteOrder = readByteOrder(byteOrderedDataInputStream);
            this.mExifByteOrder = readByteOrder;
            byteOrderedDataInputStream.setByteOrder(readByteOrder);
            short readShort = byteOrderedDataInputStream.readShort();
            if (readShort == 20306 || readShort == 21330) {
                z16 = true;
            }
            byteOrderedDataInputStream.close();
            return z16;
        } catch (Exception unused2) {
            byteOrderedDataInputStream2 = byteOrderedDataInputStream;
            if (byteOrderedDataInputStream2 != null) {
                byteOrderedDataInputStream2.close();
            }
            return false;
        } catch (Throwable th6) {
            th = th6;
            byteOrderedDataInputStream2 = byteOrderedDataInputStream;
            if (byteOrderedDataInputStream2 != null) {
                byteOrderedDataInputStream2.close();
            }
            throw th;
        }
    }

    private boolean isPngFormat(byte[] bArr) throws IOException {
        int i3 = 0;
        while (true) {
            byte[] bArr2 = PNG_SIGNATURE;
            if (i3 < bArr2.length) {
                if (bArr[i3] != bArr2[i3]) {
                    return false;
                }
                i3++;
            } else {
                return true;
            }
        }
    }

    private boolean isRafFormat(byte[] bArr) throws IOException {
        byte[] bytes = RAF_SIGNATURE.getBytes(Charset.defaultCharset());
        for (int i3 = 0; i3 < bytes.length; i3++) {
            if (bArr[i3] != bytes[i3]) {
                return false;
            }
        }
        return true;
    }

    private boolean isRw2Format(byte[] bArr) throws IOException {
        ByteOrderedDataInputStream byteOrderedDataInputStream;
        boolean z16 = false;
        ByteOrderedDataInputStream byteOrderedDataInputStream2 = null;
        try {
            byteOrderedDataInputStream = new ByteOrderedDataInputStream(bArr);
        } catch (Exception unused) {
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            ByteOrder readByteOrder = readByteOrder(byteOrderedDataInputStream);
            this.mExifByteOrder = readByteOrder;
            byteOrderedDataInputStream.setByteOrder(readByteOrder);
            if (byteOrderedDataInputStream.readShort() == 85) {
                z16 = true;
            }
            byteOrderedDataInputStream.close();
            return z16;
        } catch (Exception unused2) {
            byteOrderedDataInputStream2 = byteOrderedDataInputStream;
            if (byteOrderedDataInputStream2 != null) {
                byteOrderedDataInputStream2.close();
            }
            return false;
        } catch (Throwable th6) {
            th = th6;
            byteOrderedDataInputStream2 = byteOrderedDataInputStream;
            if (byteOrderedDataInputStream2 != null) {
                byteOrderedDataInputStream2.close();
            }
            throw th;
        }
    }

    private static boolean isSeekableFD(FileDescriptor fileDescriptor) {
        try {
            Os.lseek(fileDescriptor, 0L, OsConstants.SEEK_CUR);
            return true;
        } catch (Exception unused) {
            if (DEBUG) {
                Log.d(TAG, "The file descriptor for the given input is not seekable");
                return false;
            }
            return false;
        }
    }

    private boolean isSupportedDataType(HashMap hashMap) throws IOException {
        ExifAttribute exifAttribute;
        int intValue;
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get("BitsPerSample");
        if (exifAttribute2 != null) {
            int[] iArr = (int[]) exifAttribute2.getValue(this.mExifByteOrder);
            int[] iArr2 = BITS_PER_SAMPLE_RGB;
            if (Arrays.equals(iArr2, iArr)) {
                return true;
            }
            if (this.mMimeType == 3 && (exifAttribute = (ExifAttribute) hashMap.get("PhotometricInterpretation")) != null && (((intValue = exifAttribute.getIntValue(this.mExifByteOrder)) == 1 && Arrays.equals(iArr, BITS_PER_SAMPLE_GREYSCALE_2)) || (intValue == 6 && Arrays.equals(iArr, iArr2)))) {
                return true;
            }
        }
        if (DEBUG) {
            Log.d(TAG, "Unsupported data type value");
            return false;
        }
        return false;
    }

    private boolean isSupportedFormatForSavingAttributes() {
        int i3 = this.mMimeType;
        if (i3 != 4 && i3 != 13 && i3 != 14) {
            return false;
        }
        return true;
    }

    public static boolean isSupportedMimeType(@NonNull String str) {
        if (str != null) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            lowerCase.hashCode();
            char c16 = '\uffff';
            switch (lowerCase.hashCode()) {
                case -1875291391:
                    if (lowerCase.equals("image/x-fuji-raf")) {
                        c16 = 0;
                        break;
                    }
                    break;
                case -1635437028:
                    if (lowerCase.equals("image/x-samsung-srw")) {
                        c16 = 1;
                        break;
                    }
                    break;
                case -1594371159:
                    if (lowerCase.equals("image/x-sony-arw")) {
                        c16 = 2;
                        break;
                    }
                    break;
                case -1487464693:
                    if (lowerCase.equals(MimeHelper.IMAGE_HEIC)) {
                        c16 = 3;
                        break;
                    }
                    break;
                case -1487464690:
                    if (lowerCase.equals(MimeHelper.IMAGE_HEIF)) {
                        c16 = 4;
                        break;
                    }
                    break;
                case -1487394660:
                    if (lowerCase.equals("image/jpeg")) {
                        c16 = 5;
                        break;
                    }
                    break;
                case -1487018032:
                    if (lowerCase.equals("image/webp")) {
                        c16 = 6;
                        break;
                    }
                    break;
                case -1423313290:
                    if (lowerCase.equals("image/x-adobe-dng")) {
                        c16 = 7;
                        break;
                    }
                    break;
                case -985160897:
                    if (lowerCase.equals("image/x-panasonic-rw2")) {
                        c16 = '\b';
                        break;
                    }
                    break;
                case -879258763:
                    if (lowerCase.equals("image/png")) {
                        c16 = '\t';
                        break;
                    }
                    break;
                case -332763809:
                    if (lowerCase.equals("image/x-pentax-pef")) {
                        c16 = '\n';
                        break;
                    }
                    break;
                case 1378106698:
                    if (lowerCase.equals("image/x-olympus-orf")) {
                        c16 = 11;
                        break;
                    }
                    break;
                case 2099152104:
                    if (lowerCase.equals("image/x-nikon-nef")) {
                        c16 = '\f';
                        break;
                    }
                    break;
                case 2099152524:
                    if (lowerCase.equals("image/x-nikon-nrw")) {
                        c16 = '\r';
                        break;
                    }
                    break;
                case 2111234748:
                    if (lowerCase.equals("image/x-canon-cr2")) {
                        c16 = 14;
                        break;
                    }
                    break;
            }
            switch (c16) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case '\b':
                case '\t':
                case '\n':
                case 11:
                case '\f':
                case '\r':
                case 14:
                    return true;
                default:
                    return false;
            }
        }
        throw new NullPointerException("mimeType shouldn't be null");
    }

    private boolean isThumbnail(HashMap hashMap) throws IOException {
        ExifAttribute exifAttribute = (ExifAttribute) hashMap.get("ImageLength");
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get("ImageWidth");
        if (exifAttribute != null && exifAttribute2 != null) {
            int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
            int intValue2 = exifAttribute2.getIntValue(this.mExifByteOrder);
            if (intValue <= 512 && intValue2 <= 512) {
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean isWebpFormat(byte[] bArr) throws IOException {
        int i3 = 0;
        while (true) {
            byte[] bArr2 = WEBP_SIGNATURE_1;
            if (i3 < bArr2.length) {
                if (bArr[i3] != bArr2[i3]) {
                    return false;
                }
                i3++;
            } else {
                int i16 = 0;
                while (true) {
                    byte[] bArr3 = WEBP_SIGNATURE_2;
                    if (i16 < bArr3.length) {
                        if (bArr[WEBP_SIGNATURE_1.length + i16 + 4] != bArr3[i16]) {
                            return false;
                        }
                        i16++;
                    } else {
                        return true;
                    }
                }
            }
        }
    }

    private void loadAttributes(@NonNull InputStream inputStream) {
        boolean z16;
        if (inputStream != null) {
            for (int i3 = 0; i3 < EXIF_TAGS.length; i3++) {
                try {
                    try {
                        this.mAttributes[i3] = new HashMap<>();
                    } catch (IOException e16) {
                        boolean z17 = DEBUG;
                        if (z17) {
                            Log.w(TAG, "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", e16);
                        }
                        addDefaultValuesForCompatibility();
                        if (!z17) {
                            return;
                        }
                    }
                } finally {
                    addDefaultValuesForCompatibility();
                    if (DEBUG) {
                        printAttributes();
                    }
                }
            }
            if (!this.mIsExifDataOnly) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
                this.mMimeType = getMimeType(bufferedInputStream);
                inputStream = bufferedInputStream;
            }
            ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(inputStream);
            if (!this.mIsExifDataOnly) {
                switch (this.mMimeType) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 11:
                        getRawAttributes(byteOrderedDataInputStream);
                        break;
                    case 4:
                        getJpegAttributes(byteOrderedDataInputStream, 0, 0);
                        addDefaultValuesForCompatibility();
                        if (DEBUG) {
                            printAttributes();
                            return;
                        }
                        return;
                    case 7:
                        getOrfAttributes(byteOrderedDataInputStream);
                        break;
                    case 9:
                        getRafAttributes(byteOrderedDataInputStream);
                        addDefaultValuesForCompatibility();
                        if (DEBUG) {
                            printAttributes();
                            return;
                        }
                        return;
                    case 10:
                        getRw2Attributes(byteOrderedDataInputStream);
                        addDefaultValuesForCompatibility();
                        if (DEBUG) {
                            printAttributes();
                            return;
                        }
                        return;
                    case 12:
                        getHeifAttributes(byteOrderedDataInputStream);
                        break;
                    case 13:
                        getPngAttributes(byteOrderedDataInputStream);
                        addDefaultValuesForCompatibility();
                        if (DEBUG) {
                            printAttributes();
                            return;
                        }
                        return;
                    case 14:
                        getWebpAttributes(byteOrderedDataInputStream);
                        addDefaultValuesForCompatibility();
                        if (DEBUG) {
                            printAttributes();
                            return;
                        }
                        return;
                }
            } else {
                getStandaloneAttributes(byteOrderedDataInputStream);
            }
            byteOrderedDataInputStream.seek(this.mOffsetToExifData);
            setThumbnailData(byteOrderedDataInputStream);
            if (!z16) {
                return;
            }
            return;
        }
        throw new NullPointerException("inputstream shouldn't be null");
    }

    private static Long parseDateTime(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        if (str != null && NON_ZERO_TIME_PATTERN.matcher(str).matches()) {
            ParsePosition parsePosition = new ParsePosition(0);
            try {
                Date parse = sFormatterPrimary.parse(str, parsePosition);
                if (parse == null && (parse = sFormatterSecondary.parse(str, parsePosition)) == null) {
                    return null;
                }
                long time = parse.getTime();
                if (str3 != null) {
                    int i3 = 1;
                    String substring = str3.substring(0, 1);
                    int parseInt = Integer.parseInt(str3.substring(1, 3));
                    int parseInt2 = Integer.parseInt(str3.substring(4, 6));
                    if ((Marker.ANY_NON_NULL_MARKER.equals(substring) || "-".equals(substring)) && ":".equals(str3.substring(3, 4)) && parseInt <= 14) {
                        int i16 = ((parseInt * 60) + parseInt2) * 60 * 1000;
                        if (!"-".equals(substring)) {
                            i3 = -1;
                        }
                        time += i16 * i3;
                    }
                }
                if (str2 != null) {
                    try {
                        long parseLong = Long.parseLong(str2);
                        while (parseLong > 1000) {
                            parseLong /= 10;
                        }
                        time += parseLong;
                    } catch (NumberFormatException unused) {
                    }
                }
                return Long.valueOf(time);
            } catch (IllegalArgumentException unused2) {
            }
        }
        return null;
    }

    private void parseTiffHeaders(ByteOrderedDataInputStream byteOrderedDataInputStream, int i3) throws IOException {
        ByteOrder readByteOrder = readByteOrder(byteOrderedDataInputStream);
        this.mExifByteOrder = readByteOrder;
        byteOrderedDataInputStream.setByteOrder(readByteOrder);
        int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
        int i16 = this.mMimeType;
        if (i16 != 7 && i16 != 10 && readUnsignedShort != 42) {
            throw new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
        }
        int readInt = byteOrderedDataInputStream.readInt();
        if (readInt >= 8 && readInt < i3) {
            int i17 = readInt - 8;
            if (i17 > 0 && byteOrderedDataInputStream.skipBytes(i17) != i17) {
                throw new IOException("Couldn't jump to first Ifd: " + i17);
            }
            return;
        }
        throw new IOException("Invalid first Ifd offset: " + readInt);
    }

    private void printAttributes() {
        for (int i3 = 0; i3 < this.mAttributes.length; i3++) {
            Log.d(TAG, "The size of tag group[" + i3 + "]: " + this.mAttributes[i3].size());
            for (Map.Entry<String, ExifAttribute> entry : this.mAttributes[i3].entrySet()) {
                ExifAttribute value = entry.getValue();
                Log.d(TAG, "tagName: " + entry.getKey() + ", tagType: " + value.toString() + ", tagValue: '" + value.getStringValue(this.mExifByteOrder) + "'");
            }
        }
    }

    private ByteOrder readByteOrder(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        short readShort = byteOrderedDataInputStream.readShort();
        if (readShort != 18761) {
            if (readShort == 19789) {
                if (DEBUG) {
                    Log.d(TAG, "readExifSegment: Byte Align MM");
                }
                return ByteOrder.BIG_ENDIAN;
            }
            throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
        }
        if (DEBUG) {
            Log.d(TAG, "readExifSegment: Byte Align II");
        }
        return ByteOrder.LITTLE_ENDIAN;
    }

    private void readExifSegment(byte[] bArr, int i3) throws IOException {
        ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(bArr);
        parseTiffHeaders(byteOrderedDataInputStream, bArr.length);
        readImageFileDirectory(byteOrderedDataInputStream, i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void readImageFileDirectory(ByteOrderedDataInputStream byteOrderedDataInputStream, int i3) throws IOException {
        String str;
        short s16;
        long j3;
        boolean z16;
        short s17;
        ExifTag exifTag;
        long j16;
        int i16;
        int i17;
        long j17;
        int readUnsignedShort;
        long j18;
        long j19;
        String str2;
        int i18 = i3;
        this.mAttributesOffsets.add(Integer.valueOf(byteOrderedDataInputStream.mPosition));
        if (byteOrderedDataInputStream.mPosition + 2 > byteOrderedDataInputStream.mLength) {
            return;
        }
        short readShort = byteOrderedDataInputStream.readShort();
        boolean z17 = DEBUG;
        String str3 = TAG;
        if (z17) {
            Log.d(TAG, "numberOfDirectoryEntry: " + ((int) readShort));
        }
        if (byteOrderedDataInputStream.mPosition + (readShort * 12) <= byteOrderedDataInputStream.mLength && readShort > 0) {
            char c16 = 0;
            short s18 = 0;
            while (s18 < readShort) {
                int readUnsignedShort2 = byteOrderedDataInputStream.readUnsignedShort();
                int readUnsignedShort3 = byteOrderedDataInputStream.readUnsignedShort();
                int readInt = byteOrderedDataInputStream.readInt();
                long peek = byteOrderedDataInputStream.peek() + 4;
                ExifTag exifTag2 = sExifTagMapsForReading[i18].get(Integer.valueOf(readUnsignedShort2));
                boolean z18 = DEBUG;
                if (z18) {
                    Object[] objArr = new Object[5];
                    objArr[c16] = Integer.valueOf(i3);
                    objArr[1] = Integer.valueOf(readUnsignedShort2);
                    if (exifTag2 != null) {
                        str2 = exifTag2.name;
                    } else {
                        str2 = null;
                    }
                    objArr[2] = str2;
                    objArr[3] = Integer.valueOf(readUnsignedShort3);
                    objArr[4] = Integer.valueOf(readInt);
                    Log.d(str3, String.format("ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d", objArr));
                }
                if (exifTag2 == null) {
                    if (z18) {
                        Log.d(str3, "Skip the tag entry since tag number is not defined: " + readUnsignedShort2);
                    }
                } else {
                    if (readUnsignedShort3 > 0) {
                        if (readUnsignedShort3 < IFD_FORMAT_BYTES_PER_FORMAT.length) {
                            if (!exifTag2.isFormatCompatible(readUnsignedShort3)) {
                                if (z18) {
                                    Log.d(str3, "Skip the tag entry since data format (" + IFD_FORMAT_NAMES[readUnsignedShort3] + ") is unexpected for tag: " + exifTag2.name);
                                }
                            } else {
                                if (readUnsignedShort3 == 7) {
                                    readUnsignedShort3 = exifTag2.primaryFormat;
                                }
                                str = str3;
                                s16 = s18;
                                j3 = readInt * r8[readUnsignedShort3];
                                if (j3 >= 0 && j3 <= TTL.MAX_VALUE) {
                                    z16 = true;
                                    if (z16) {
                                    }
                                    s18 = (short) (s16 + 1);
                                    i18 = i3;
                                    str3 = str;
                                    readShort = s17;
                                    c16 = 0;
                                } else {
                                    if (z18) {
                                        Log.d(str, "Skip the tag entry since the number of components is invalid: " + readInt);
                                    }
                                    z16 = false;
                                    if (z16) {
                                        byteOrderedDataInputStream.seek(peek);
                                        s17 = readShort;
                                    } else {
                                        if (j3 > 4) {
                                            int readInt2 = byteOrderedDataInputStream.readInt();
                                            s17 = readShort;
                                            if (z18) {
                                                StringBuilder sb5 = new StringBuilder();
                                                i16 = readUnsignedShort3;
                                                sb5.append("seek to data offset: ");
                                                sb5.append(readInt2);
                                                Log.d(str, sb5.toString());
                                            } else {
                                                i16 = readUnsignedShort3;
                                            }
                                            if (this.mMimeType == 7) {
                                                if ("MakerNote".equals(exifTag2.name)) {
                                                    this.mOrfMakerNoteOffset = readInt2;
                                                } else if (i18 == 6 && TAG_ORF_THUMBNAIL_IMAGE.equals(exifTag2.name)) {
                                                    this.mOrfThumbnailOffset = readInt2;
                                                    this.mOrfThumbnailLength = readInt;
                                                    ExifAttribute createUShort = ExifAttribute.createUShort(6, this.mExifByteOrder);
                                                    i17 = readInt;
                                                    ExifAttribute createULong = ExifAttribute.createULong(this.mOrfThumbnailOffset, this.mExifByteOrder);
                                                    exifTag = exifTag2;
                                                    ExifAttribute createULong2 = ExifAttribute.createULong(this.mOrfThumbnailLength, this.mExifByteOrder);
                                                    this.mAttributes[4].put("Compression", createUShort);
                                                    this.mAttributes[4].put("JPEGInterchangeFormat", createULong);
                                                    this.mAttributes[4].put("JPEGInterchangeFormatLength", createULong2);
                                                    j19 = readInt2;
                                                    j16 = j3;
                                                    if (j19 + j3 > byteOrderedDataInputStream.mLength) {
                                                        byteOrderedDataInputStream.seek(j19);
                                                    } else {
                                                        if (z18) {
                                                            Log.d(str, "Skip the tag entry since data offset is invalid: " + readInt2);
                                                        }
                                                        byteOrderedDataInputStream.seek(peek);
                                                    }
                                                }
                                            }
                                            exifTag = exifTag2;
                                            i17 = readInt;
                                            j19 = readInt2;
                                            j16 = j3;
                                            if (j19 + j3 > byteOrderedDataInputStream.mLength) {
                                            }
                                        } else {
                                            s17 = readShort;
                                            exifTag = exifTag2;
                                            j16 = j3;
                                            i16 = readUnsignedShort3;
                                            i17 = readInt;
                                        }
                                        Integer num = sExifPointerTagMap.get(Integer.valueOf(readUnsignedShort2));
                                        if (z18) {
                                            StringBuilder sb6 = new StringBuilder();
                                            sb6.append("nextIfdType: ");
                                            sb6.append(num);
                                            sb6.append(" byteCount: ");
                                            j17 = j16;
                                            sb6.append(j17);
                                            Log.d(str, sb6.toString());
                                        } else {
                                            j17 = j16;
                                        }
                                        if (num != null) {
                                            int i19 = i16;
                                            if (i19 != 3) {
                                                if (i19 != 4) {
                                                    if (i19 != 8) {
                                                        if (i19 != 9 && i19 != 13) {
                                                            j18 = -1;
                                                        } else {
                                                            readUnsignedShort = byteOrderedDataInputStream.readInt();
                                                        }
                                                    } else {
                                                        readUnsignedShort = byteOrderedDataInputStream.readShort();
                                                    }
                                                } else {
                                                    j18 = byteOrderedDataInputStream.readUnsignedInt();
                                                }
                                                if (z18) {
                                                    Log.d(str, String.format("Offset: %d, tagName: %s", Long.valueOf(j18), exifTag.name));
                                                }
                                                if (j18 <= 0 && j18 < byteOrderedDataInputStream.mLength) {
                                                    if (!this.mAttributesOffsets.contains(Integer.valueOf((int) j18))) {
                                                        byteOrderedDataInputStream.seek(j18);
                                                        readImageFileDirectory(byteOrderedDataInputStream, num.intValue());
                                                    } else if (z18) {
                                                        Log.d(str, "Skip jump into the IFD since it has already been read: IfdType " + num + " (at " + j18 + ")");
                                                    }
                                                } else if (z18) {
                                                    Log.d(str, "Skip jump into the IFD since its offset is invalid: " + j18);
                                                }
                                                byteOrderedDataInputStream.seek(peek);
                                            } else {
                                                readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
                                            }
                                            j18 = readUnsignedShort;
                                            if (z18) {
                                            }
                                            if (j18 <= 0) {
                                            }
                                            if (z18) {
                                            }
                                            byteOrderedDataInputStream.seek(peek);
                                        } else {
                                            ExifTag exifTag3 = exifTag;
                                            int peek2 = byteOrderedDataInputStream.peek() + this.mOffsetToExifData;
                                            byte[] bArr = new byte[(int) j17];
                                            byteOrderedDataInputStream.readFully(bArr);
                                            ExifAttribute exifAttribute = new ExifAttribute(i16, i17, peek2, bArr);
                                            this.mAttributes[i3].put(exifTag3.name, exifAttribute);
                                            if (TAG_DNG_VERSION.equals(exifTag3.name)) {
                                                this.mMimeType = 3;
                                            }
                                            if ((("Make".equals(exifTag3.name) || "Model".equals(exifTag3.name)) && exifAttribute.getStringValue(this.mExifByteOrder).contains(PEF_SIGNATURE)) || ("Compression".equals(exifTag3.name) && exifAttribute.getIntValue(this.mExifByteOrder) == 65535)) {
                                                this.mMimeType = 8;
                                            }
                                            if (byteOrderedDataInputStream.peek() != peek) {
                                                byteOrderedDataInputStream.seek(peek);
                                            }
                                        }
                                    }
                                    s18 = (short) (s16 + 1);
                                    i18 = i3;
                                    str3 = str;
                                    readShort = s17;
                                    c16 = 0;
                                }
                            }
                        }
                    }
                    str = str3;
                    s16 = s18;
                    if (z18) {
                        Log.d(str, "Skip the tag entry since data format is invalid: " + readUnsignedShort3);
                    }
                    j3 = 0;
                    z16 = false;
                    if (z16) {
                    }
                    s18 = (short) (s16 + 1);
                    i18 = i3;
                    str3 = str;
                    readShort = s17;
                    c16 = 0;
                }
                str = str3;
                s16 = s18;
                j3 = 0;
                z16 = false;
                if (z16) {
                }
                s18 = (short) (s16 + 1);
                i18 = i3;
                str3 = str;
                readShort = s17;
                c16 = 0;
            }
            String str4 = str3;
            if (byteOrderedDataInputStream.peek() + 4 <= byteOrderedDataInputStream.mLength) {
                int readInt3 = byteOrderedDataInputStream.readInt();
                boolean z19 = DEBUG;
                if (z19) {
                    Log.d(str4, String.format("nextIfdOffset: %d", Integer.valueOf(readInt3)));
                }
                long j26 = readInt3;
                if (j26 > 0 && readInt3 < byteOrderedDataInputStream.mLength) {
                    if (!this.mAttributesOffsets.contains(Integer.valueOf(readInt3))) {
                        byteOrderedDataInputStream.seek(j26);
                        if (this.mAttributes[4].isEmpty()) {
                            readImageFileDirectory(byteOrderedDataInputStream, 4);
                            return;
                        } else {
                            if (this.mAttributes[5].isEmpty()) {
                                readImageFileDirectory(byteOrderedDataInputStream, 5);
                                return;
                            }
                            return;
                        }
                    }
                    if (z19) {
                        Log.d(str4, "Stop reading file since re-reading an IFD may cause an infinite loop: " + readInt3);
                        return;
                    }
                    return;
                }
                if (z19) {
                    Log.d(str4, "Stop reading file since a wrong offset may cause an infinite loop: " + readInt3);
                }
            }
        }
    }

    private void removeAttribute(String str) {
        for (int i3 = 0; i3 < EXIF_TAGS.length; i3++) {
            this.mAttributes[i3].remove(str);
        }
    }

    private void retrieveJpegImageSize(ByteOrderedDataInputStream byteOrderedDataInputStream, int i3) throws IOException {
        ExifAttribute exifAttribute = this.mAttributes[i3].get("ImageLength");
        ExifAttribute exifAttribute2 = this.mAttributes[i3].get("ImageWidth");
        if (exifAttribute == null || exifAttribute2 == null) {
            ExifAttribute exifAttribute3 = this.mAttributes[i3].get("JPEGInterchangeFormat");
            ExifAttribute exifAttribute4 = this.mAttributes[i3].get("JPEGInterchangeFormatLength");
            if (exifAttribute3 != null && exifAttribute4 != null) {
                int intValue = exifAttribute3.getIntValue(this.mExifByteOrder);
                int intValue2 = exifAttribute3.getIntValue(this.mExifByteOrder);
                byteOrderedDataInputStream.seek(intValue);
                byte[] bArr = new byte[intValue2];
                byteOrderedDataInputStream.read(bArr);
                getJpegAttributes(new ByteOrderedDataInputStream(bArr), intValue, i3);
            }
        }
    }

    private void saveJpegAttributes(InputStream inputStream, OutputStream outputStream) throws IOException {
        ExifAttribute exifAttribute;
        if (DEBUG) {
            Log.d(TAG, "saveJpegAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + ")");
        }
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        ByteOrderedDataOutputStream byteOrderedDataOutputStream = new ByteOrderedDataOutputStream(outputStream, ByteOrder.BIG_ENDIAN);
        if (dataInputStream.readByte() == -1) {
            byteOrderedDataOutputStream.writeByte(-1);
            if (dataInputStream.readByte() == -40) {
                byteOrderedDataOutputStream.writeByte(-40);
                if (getAttribute(TAG_XMP) != null && this.mXmpIsFromSeparateMarker) {
                    exifAttribute = this.mAttributes[0].remove(TAG_XMP);
                } else {
                    exifAttribute = null;
                }
                byteOrderedDataOutputStream.writeByte(-1);
                byteOrderedDataOutputStream.writeByte(-31);
                writeExifSegment(byteOrderedDataOutputStream);
                if (exifAttribute != null) {
                    this.mAttributes[0].put(TAG_XMP, exifAttribute);
                }
                byte[] bArr = new byte[4096];
                while (dataInputStream.readByte() == -1) {
                    byte readByte = dataInputStream.readByte();
                    if (readByte != -39 && readByte != -38) {
                        if (readByte != -31) {
                            byteOrderedDataOutputStream.writeByte(-1);
                            byteOrderedDataOutputStream.writeByte(readByte);
                            int readUnsignedShort = dataInputStream.readUnsignedShort();
                            byteOrderedDataOutputStream.writeUnsignedShort(readUnsignedShort);
                            int i3 = readUnsignedShort - 2;
                            if (i3 >= 0) {
                                while (i3 > 0) {
                                    int read = dataInputStream.read(bArr, 0, Math.min(i3, 4096));
                                    if (read >= 0) {
                                        byteOrderedDataOutputStream.write(bArr, 0, read);
                                        i3 -= read;
                                    }
                                }
                            } else {
                                throw new IOException("Invalid length");
                            }
                        } else {
                            int readUnsignedShort2 = dataInputStream.readUnsignedShort() - 2;
                            if (readUnsignedShort2 >= 0) {
                                byte[] bArr2 = new byte[6];
                                if (readUnsignedShort2 >= 6) {
                                    if (dataInputStream.read(bArr2) == 6) {
                                        if (Arrays.equals(bArr2, IDENTIFIER_EXIF_APP1)) {
                                            int i16 = readUnsignedShort2 - 6;
                                            if (dataInputStream.skipBytes(i16) != i16) {
                                                throw new IOException("Invalid length");
                                            }
                                        }
                                    } else {
                                        throw new IOException("Invalid exif");
                                    }
                                }
                                byteOrderedDataOutputStream.writeByte(-1);
                                byteOrderedDataOutputStream.writeByte(readByte);
                                byteOrderedDataOutputStream.writeUnsignedShort(readUnsignedShort2 + 2);
                                if (readUnsignedShort2 >= 6) {
                                    readUnsignedShort2 -= 6;
                                    byteOrderedDataOutputStream.write(bArr2);
                                }
                                while (readUnsignedShort2 > 0) {
                                    int read2 = dataInputStream.read(bArr, 0, Math.min(readUnsignedShort2, 4096));
                                    if (read2 >= 0) {
                                        byteOrderedDataOutputStream.write(bArr, 0, read2);
                                        readUnsignedShort2 -= read2;
                                    }
                                }
                            } else {
                                throw new IOException("Invalid length");
                            }
                        }
                    } else {
                        byteOrderedDataOutputStream.writeByte(-1);
                        byteOrderedDataOutputStream.writeByte(readByte);
                        copy(dataInputStream, byteOrderedDataOutputStream);
                        return;
                    }
                }
                throw new IOException("Invalid marker");
            }
            throw new IOException("Invalid marker");
        }
        throw new IOException("Invalid marker");
    }

    private void savePngAttributes(InputStream inputStream, OutputStream outputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        if (DEBUG) {
            Log.d(TAG, "savePngAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + ")");
        }
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        ByteOrderedDataOutputStream byteOrderedDataOutputStream = new ByteOrderedDataOutputStream(outputStream, byteOrder);
        byte[] bArr = PNG_SIGNATURE;
        copy(dataInputStream, byteOrderedDataOutputStream, bArr.length);
        int i3 = this.mOffsetToExifData;
        if (i3 == 0) {
            int readInt = dataInputStream.readInt();
            byteOrderedDataOutputStream.writeInt(readInt);
            copy(dataInputStream, byteOrderedDataOutputStream, readInt + 4 + 4);
        } else {
            copy(dataInputStream, byteOrderedDataOutputStream, ((i3 - bArr.length) - 4) - 4);
            dataInputStream.skipBytes(dataInputStream.readInt() + 4 + 4);
        }
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            ByteOrderedDataOutputStream byteOrderedDataOutputStream2 = new ByteOrderedDataOutputStream(byteArrayOutputStream, byteOrder);
            writeExifSegment(byteOrderedDataOutputStream2);
            byte[] byteArray = ((ByteArrayOutputStream) byteOrderedDataOutputStream2.mOutputStream).toByteArray();
            byteOrderedDataOutputStream.write(byteArray);
            CRC32 crc32 = new CRC32();
            crc32.update(byteArray, 4, byteArray.length - 4);
            byteOrderedDataOutputStream.writeInt((int) crc32.getValue());
            closeQuietly(byteArrayOutputStream);
            copy(dataInputStream, byteOrderedDataOutputStream);
        } catch (Throwable th6) {
            th = th6;
            byteArrayOutputStream2 = byteArrayOutputStream;
            closeQuietly(byteArrayOutputStream2);
            throw th;
        }
    }

    private void saveWebpAttributes(InputStream inputStream, OutputStream outputStream) throws IOException {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        if (DEBUG) {
            Log.d(TAG, "saveWebpAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + ")");
        }
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(inputStream, byteOrder);
        ByteOrderedDataOutputStream byteOrderedDataOutputStream = new ByteOrderedDataOutputStream(outputStream, byteOrder);
        byte[] bArr = WEBP_SIGNATURE_1;
        copy(byteOrderedDataInputStream, byteOrderedDataOutputStream, bArr.length);
        byte[] bArr2 = WEBP_SIGNATURE_2;
        byteOrderedDataInputStream.skipBytes(bArr2.length + 4);
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    ByteOrderedDataOutputStream byteOrderedDataOutputStream2 = new ByteOrderedDataOutputStream(byteArrayOutputStream2, byteOrder);
                    int i27 = this.mOffsetToExifData;
                    if (i27 != 0) {
                        copy(byteOrderedDataInputStream, byteOrderedDataOutputStream2, ((i27 - ((bArr.length + 4) + bArr2.length)) - 4) - 4);
                        byteOrderedDataInputStream.skipBytes(4);
                        byteOrderedDataInputStream.skipBytes(byteOrderedDataInputStream.readInt());
                        writeExifSegment(byteOrderedDataOutputStream2);
                    } else {
                        byte[] bArr3 = new byte[4];
                        if (byteOrderedDataInputStream.read(bArr3) == 4) {
                            byte[] bArr4 = WEBP_CHUNK_TYPE_VP8X;
                            boolean z16 = false;
                            if (Arrays.equals(bArr3, bArr4)) {
                                int readInt = byteOrderedDataInputStream.readInt();
                                if (readInt % 2 == 1) {
                                    i26 = readInt + 1;
                                } else {
                                    i26 = readInt;
                                }
                                byte[] bArr5 = new byte[i26];
                                byteOrderedDataInputStream.read(bArr5);
                                byte b16 = (byte) (8 | bArr5[0]);
                                bArr5[0] = b16;
                                if (((b16 >> 1) & 1) == 1) {
                                    z16 = true;
                                }
                                byteOrderedDataOutputStream2.write(bArr4);
                                byteOrderedDataOutputStream2.writeInt(readInt);
                                byteOrderedDataOutputStream2.write(bArr5);
                                if (z16) {
                                    copyChunksUpToGivenChunkType(byteOrderedDataInputStream, byteOrderedDataOutputStream2, WEBP_CHUNK_TYPE_ANIM, null);
                                    while (true) {
                                        byte[] bArr6 = new byte[4];
                                        inputStream.read(bArr6);
                                        if (!Arrays.equals(bArr6, WEBP_CHUNK_TYPE_ANMF)) {
                                            break;
                                        } else {
                                            copyWebPChunk(byteOrderedDataInputStream, byteOrderedDataOutputStream2, bArr6);
                                        }
                                    }
                                    writeExifSegment(byteOrderedDataOutputStream2);
                                } else {
                                    copyChunksUpToGivenChunkType(byteOrderedDataInputStream, byteOrderedDataOutputStream2, WEBP_CHUNK_TYPE_VP8, WEBP_CHUNK_TYPE_VP8L);
                                    writeExifSegment(byteOrderedDataOutputStream2);
                                }
                            } else {
                                byte[] bArr7 = WEBP_CHUNK_TYPE_VP8;
                                if (Arrays.equals(bArr3, bArr7) || Arrays.equals(bArr3, WEBP_CHUNK_TYPE_VP8L)) {
                                    int readInt2 = byteOrderedDataInputStream.readInt();
                                    if (readInt2 % 2 == 1) {
                                        i3 = readInt2 + 1;
                                    } else {
                                        i3 = readInt2;
                                    }
                                    byte[] bArr8 = new byte[3];
                                    if (Arrays.equals(bArr3, bArr7)) {
                                        byteOrderedDataInputStream.read(bArr8);
                                        byte[] bArr9 = new byte[3];
                                        if (byteOrderedDataInputStream.read(bArr9) == 3 && Arrays.equals(WEBP_VP8_SIGNATURE, bArr9)) {
                                            i16 = byteOrderedDataInputStream.readInt();
                                            i17 = (i16 << 18) >> 18;
                                            i18 = (i16 << 2) >> 18;
                                            i3 -= 10;
                                            i19 = 0;
                                        } else {
                                            throw new IOException("Encountered error while checking VP8 signature");
                                        }
                                    } else if (Arrays.equals(bArr3, WEBP_CHUNK_TYPE_VP8L)) {
                                        if (byteOrderedDataInputStream.readByte() == 47) {
                                            i16 = byteOrderedDataInputStream.readInt();
                                            i19 = i16 & 8;
                                            i3 -= 5;
                                            i18 = ((i16 << 4) >> 18) + 1;
                                            i17 = ((i16 << 18) >> 18) + 1;
                                        } else {
                                            throw new IOException("Encountered error while checking VP8L signature");
                                        }
                                    } else {
                                        i16 = 0;
                                        i17 = 0;
                                        i18 = 0;
                                        i19 = 0;
                                    }
                                    byteOrderedDataOutputStream2.write(bArr4);
                                    byteOrderedDataOutputStream2.writeInt(10);
                                    byte[] bArr10 = new byte[10];
                                    byte b17 = (byte) (bArr10[0] | 8);
                                    bArr10[0] = b17;
                                    bArr10[0] = (byte) (b17 | (i19 << 4));
                                    int i28 = i17 - 1;
                                    int i29 = i18 - 1;
                                    bArr10[4] = (byte) i28;
                                    bArr10[5] = (byte) (i28 >> 8);
                                    bArr10[6] = (byte) (i28 >> 16);
                                    bArr10[7] = (byte) i29;
                                    bArr10[8] = (byte) (i29 >> 8);
                                    bArr10[9] = (byte) (i29 >> 16);
                                    byteOrderedDataOutputStream2.write(bArr10);
                                    byteOrderedDataOutputStream2.write(bArr3);
                                    byteOrderedDataOutputStream2.writeInt(readInt2);
                                    if (Arrays.equals(bArr3, bArr7)) {
                                        byteOrderedDataOutputStream2.write(bArr8);
                                        byteOrderedDataOutputStream2.write(WEBP_VP8_SIGNATURE);
                                        byteOrderedDataOutputStream2.writeInt(i16);
                                    } else if (Arrays.equals(bArr3, WEBP_CHUNK_TYPE_VP8L)) {
                                        byteOrderedDataOutputStream2.write(47);
                                        byteOrderedDataOutputStream2.writeInt(i16);
                                    }
                                    copy(byteOrderedDataInputStream, byteOrderedDataOutputStream2, i3);
                                    writeExifSegment(byteOrderedDataOutputStream2);
                                }
                            }
                        } else {
                            throw new IOException("Encountered invalid length while parsing WebP chunk type");
                        }
                    }
                    copy(byteOrderedDataInputStream, byteOrderedDataOutputStream2);
                    int size = byteArrayOutputStream2.size();
                    byte[] bArr11 = WEBP_SIGNATURE_2;
                    byteOrderedDataOutputStream.writeInt(size + bArr11.length);
                    byteOrderedDataOutputStream.write(bArr11);
                    byteArrayOutputStream2.writeTo(byteOrderedDataOutputStream);
                    closeQuietly(byteArrayOutputStream2);
                } catch (Exception e16) {
                    e = e16;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    throw new IOException("Failed to save WebP file", e);
                } catch (Throwable th5) {
                    th = th5;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    closeQuietly(byteArrayOutputStream);
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    private void setThumbnailData(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        HashMap<String, ExifAttribute> hashMap = this.mAttributes[4];
        ExifAttribute exifAttribute = hashMap.get("Compression");
        if (exifAttribute != null) {
            int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
            this.mThumbnailCompression = intValue;
            if (intValue != 1) {
                if (intValue != 6) {
                    if (intValue != 7) {
                        return;
                    }
                } else {
                    handleThumbnailFromJfif(byteOrderedDataInputStream, hashMap);
                    return;
                }
            }
            if (isSupportedDataType(hashMap)) {
                handleThumbnailFromStrips(byteOrderedDataInputStream, hashMap);
                return;
            }
            return;
        }
        this.mThumbnailCompression = 6;
        handleThumbnailFromJfif(byteOrderedDataInputStream, hashMap);
    }

    private static boolean startsWith(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length < bArr2.length) {
            return false;
        }
        for (int i3 = 0; i3 < bArr2.length; i3++) {
            if (bArr[i3] != bArr2[i3]) {
                return false;
            }
        }
        return true;
    }

    private void swapBasedOnImageSize(int i3, int i16) throws IOException {
        if (!this.mAttributes[i3].isEmpty() && !this.mAttributes[i16].isEmpty()) {
            ExifAttribute exifAttribute = this.mAttributes[i3].get("ImageLength");
            ExifAttribute exifAttribute2 = this.mAttributes[i3].get("ImageWidth");
            ExifAttribute exifAttribute3 = this.mAttributes[i16].get("ImageLength");
            ExifAttribute exifAttribute4 = this.mAttributes[i16].get("ImageWidth");
            if (exifAttribute != null && exifAttribute2 != null) {
                if (exifAttribute3 != null && exifAttribute4 != null) {
                    int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
                    int intValue2 = exifAttribute2.getIntValue(this.mExifByteOrder);
                    int intValue3 = exifAttribute3.getIntValue(this.mExifByteOrder);
                    int intValue4 = exifAttribute4.getIntValue(this.mExifByteOrder);
                    if (intValue < intValue3 && intValue2 < intValue4) {
                        HashMap<String, ExifAttribute>[] hashMapArr = this.mAttributes;
                        HashMap<String, ExifAttribute> hashMap = hashMapArr[i3];
                        hashMapArr[i3] = hashMapArr[i16];
                        hashMapArr[i16] = hashMap;
                        return;
                    }
                    return;
                }
                if (DEBUG) {
                    Log.d(TAG, "Second image does not contain valid size information");
                    return;
                }
                return;
            }
            if (DEBUG) {
                Log.d(TAG, "First image does not contain valid size information");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d(TAG, "Cannot perform swap since only one image data exists");
        }
    }

    private void updateImageSizeValues(ByteOrderedDataInputStream byteOrderedDataInputStream, int i3) throws IOException {
        ExifAttribute createUShort;
        ExifAttribute createUShort2;
        ExifAttribute exifAttribute = this.mAttributes[i3].get(TAG_DEFAULT_CROP_SIZE);
        ExifAttribute exifAttribute2 = this.mAttributes[i3].get(TAG_RW2_SENSOR_TOP_BORDER);
        ExifAttribute exifAttribute3 = this.mAttributes[i3].get(TAG_RW2_SENSOR_LEFT_BORDER);
        ExifAttribute exifAttribute4 = this.mAttributes[i3].get(TAG_RW2_SENSOR_BOTTOM_BORDER);
        ExifAttribute exifAttribute5 = this.mAttributes[i3].get(TAG_RW2_SENSOR_RIGHT_BORDER);
        if (exifAttribute != null) {
            if (exifAttribute.format == 5) {
                Rational[] rationalArr = (Rational[]) exifAttribute.getValue(this.mExifByteOrder);
                if (rationalArr != null && rationalArr.length == 2) {
                    createUShort = ExifAttribute.createURational(rationalArr[0], this.mExifByteOrder);
                    createUShort2 = ExifAttribute.createURational(rationalArr[1], this.mExifByteOrder);
                } else {
                    Log.w(TAG, "Invalid crop size values. cropSize=" + Arrays.toString(rationalArr));
                    return;
                }
            } else {
                int[] iArr = (int[]) exifAttribute.getValue(this.mExifByteOrder);
                if (iArr != null && iArr.length == 2) {
                    createUShort = ExifAttribute.createUShort(iArr[0], this.mExifByteOrder);
                    createUShort2 = ExifAttribute.createUShort(iArr[1], this.mExifByteOrder);
                } else {
                    Log.w(TAG, "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                    return;
                }
            }
            this.mAttributes[i3].put("ImageWidth", createUShort);
            this.mAttributes[i3].put("ImageLength", createUShort2);
            return;
        }
        if (exifAttribute2 != null && exifAttribute3 != null && exifAttribute4 != null && exifAttribute5 != null) {
            int intValue = exifAttribute2.getIntValue(this.mExifByteOrder);
            int intValue2 = exifAttribute4.getIntValue(this.mExifByteOrder);
            int intValue3 = exifAttribute5.getIntValue(this.mExifByteOrder);
            int intValue4 = exifAttribute3.getIntValue(this.mExifByteOrder);
            if (intValue2 > intValue && intValue3 > intValue4) {
                ExifAttribute createUShort3 = ExifAttribute.createUShort(intValue2 - intValue, this.mExifByteOrder);
                ExifAttribute createUShort4 = ExifAttribute.createUShort(intValue3 - intValue4, this.mExifByteOrder);
                this.mAttributes[i3].put("ImageLength", createUShort3);
                this.mAttributes[i3].put("ImageWidth", createUShort4);
                return;
            }
            return;
        }
        retrieveJpegImageSize(byteOrderedDataInputStream, i3);
    }

    private void validateImages() throws IOException {
        swapBasedOnImageSize(0, 5);
        swapBasedOnImageSize(0, 4);
        swapBasedOnImageSize(5, 4);
        ExifAttribute exifAttribute = this.mAttributes[1].get("PixelXDimension");
        ExifAttribute exifAttribute2 = this.mAttributes[1].get("PixelYDimension");
        if (exifAttribute != null && exifAttribute2 != null) {
            this.mAttributes[0].put("ImageWidth", exifAttribute);
            this.mAttributes[0].put("ImageLength", exifAttribute2);
        }
        if (this.mAttributes[4].isEmpty() && isThumbnail(this.mAttributes[5])) {
            HashMap<String, ExifAttribute>[] hashMapArr = this.mAttributes;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap<>();
        }
        if (!isThumbnail(this.mAttributes[4])) {
            Log.d(TAG, "No image meets the size requirements of a thumbnail image.");
        }
    }

    private int writeExifSegment(ByteOrderedDataOutputStream byteOrderedDataOutputStream) throws IOException {
        short s16;
        ExifTag[][] exifTagArr = EXIF_TAGS;
        int[] iArr = new int[exifTagArr.length];
        int[] iArr2 = new int[exifTagArr.length];
        for (ExifTag exifTag : EXIF_POINTER_TAGS) {
            removeAttribute(exifTag.name);
        }
        removeAttribute(JPEG_INTERCHANGE_FORMAT_TAG.name);
        removeAttribute(JPEG_INTERCHANGE_FORMAT_LENGTH_TAG.name);
        for (int i3 = 0; i3 < EXIF_TAGS.length; i3++) {
            for (Object obj : this.mAttributes[i3].entrySet().toArray()) {
                Map.Entry entry = (Map.Entry) obj;
                if (entry.getValue() == null) {
                    this.mAttributes[i3].remove(entry.getKey());
                }
            }
        }
        if (!this.mAttributes[1].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[1].name, ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
        if (!this.mAttributes[2].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[2].name, ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
        if (!this.mAttributes[3].isEmpty()) {
            this.mAttributes[1].put(EXIF_POINTER_TAGS[3].name, ExifAttribute.createULong(0L, this.mExifByteOrder));
        }
        if (this.mHasThumbnail) {
            this.mAttributes[4].put(JPEG_INTERCHANGE_FORMAT_TAG.name, ExifAttribute.createULong(0L, this.mExifByteOrder));
            this.mAttributes[4].put(JPEG_INTERCHANGE_FORMAT_LENGTH_TAG.name, ExifAttribute.createULong(this.mThumbnailLength, this.mExifByteOrder));
        }
        for (int i16 = 0; i16 < EXIF_TAGS.length; i16++) {
            Iterator<Map.Entry<String, ExifAttribute>> it = this.mAttributes[i16].entrySet().iterator();
            int i17 = 0;
            while (it.hasNext()) {
                int size = it.next().getValue().size();
                if (size > 4) {
                    i17 += size;
                }
            }
            iArr2[i16] = iArr2[i16] + i17;
        }
        int i18 = 8;
        for (int i19 = 0; i19 < EXIF_TAGS.length; i19++) {
            if (!this.mAttributes[i19].isEmpty()) {
                iArr[i19] = i18;
                i18 += (this.mAttributes[i19].size() * 12) + 2 + 4 + iArr2[i19];
            }
        }
        if (this.mHasThumbnail) {
            this.mAttributes[4].put(JPEG_INTERCHANGE_FORMAT_TAG.name, ExifAttribute.createULong(i18, this.mExifByteOrder));
            this.mThumbnailOffset = i18;
            i18 += this.mThumbnailLength;
        }
        if (this.mMimeType == 4) {
            i18 += 8;
        }
        if (DEBUG) {
            for (int i26 = 0; i26 < EXIF_TAGS.length; i26++) {
                Log.d(TAG, String.format("index: %d, offsets: %d, tag count: %d, data sizes: %d, total size: %d", Integer.valueOf(i26), Integer.valueOf(iArr[i26]), Integer.valueOf(this.mAttributes[i26].size()), Integer.valueOf(iArr2[i26]), Integer.valueOf(i18)));
            }
        }
        if (!this.mAttributes[1].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[1].name, ExifAttribute.createULong(iArr[1], this.mExifByteOrder));
        }
        if (!this.mAttributes[2].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[2].name, ExifAttribute.createULong(iArr[2], this.mExifByteOrder));
        }
        if (!this.mAttributes[3].isEmpty()) {
            this.mAttributes[1].put(EXIF_POINTER_TAGS[3].name, ExifAttribute.createULong(iArr[3], this.mExifByteOrder));
        }
        int i27 = this.mMimeType;
        if (i27 != 4) {
            if (i27 != 13) {
                if (i27 == 14) {
                    byteOrderedDataOutputStream.write(WEBP_CHUNK_TYPE_EXIF);
                    byteOrderedDataOutputStream.writeInt(i18);
                }
            } else {
                byteOrderedDataOutputStream.writeInt(i18);
                byteOrderedDataOutputStream.write(PNG_CHUNK_TYPE_EXIF);
            }
        } else {
            byteOrderedDataOutputStream.writeUnsignedShort(i18);
            byteOrderedDataOutputStream.write(IDENTIFIER_EXIF_APP1);
        }
        if (this.mExifByteOrder == ByteOrder.BIG_ENDIAN) {
            s16 = BYTE_ALIGN_MM;
        } else {
            s16 = BYTE_ALIGN_II;
        }
        byteOrderedDataOutputStream.writeShort(s16);
        byteOrderedDataOutputStream.setByteOrder(this.mExifByteOrder);
        byteOrderedDataOutputStream.writeUnsignedShort(42);
        byteOrderedDataOutputStream.writeUnsignedInt(8L);
        for (int i28 = 0; i28 < EXIF_TAGS.length; i28++) {
            if (!this.mAttributes[i28].isEmpty()) {
                byteOrderedDataOutputStream.writeUnsignedShort(this.mAttributes[i28].size());
                int size2 = iArr[i28] + 2 + (this.mAttributes[i28].size() * 12) + 4;
                for (Map.Entry<String, ExifAttribute> entry2 : this.mAttributes[i28].entrySet()) {
                    int i29 = sExifTagMapsForWriting[i28].get(entry2.getKey()).number;
                    ExifAttribute value = entry2.getValue();
                    int size3 = value.size();
                    byteOrderedDataOutputStream.writeUnsignedShort(i29);
                    byteOrderedDataOutputStream.writeUnsignedShort(value.format);
                    byteOrderedDataOutputStream.writeInt(value.numberOfComponents);
                    if (size3 > 4) {
                        byteOrderedDataOutputStream.writeUnsignedInt(size2);
                        size2 += size3;
                    } else {
                        byteOrderedDataOutputStream.write(value.bytes);
                        if (size3 < 4) {
                            while (size3 < 4) {
                                byteOrderedDataOutputStream.writeByte(0);
                                size3++;
                            }
                        }
                    }
                }
                if (i28 == 0 && !this.mAttributes[4].isEmpty()) {
                    byteOrderedDataOutputStream.writeUnsignedInt(iArr[4]);
                } else {
                    byteOrderedDataOutputStream.writeUnsignedInt(0L);
                }
                Iterator<Map.Entry<String, ExifAttribute>> it5 = this.mAttributes[i28].entrySet().iterator();
                while (it5.hasNext()) {
                    byte[] bArr = it5.next().getValue().bytes;
                    if (bArr.length > 4) {
                        byteOrderedDataOutputStream.write(bArr, 0, bArr.length);
                    }
                }
            }
        }
        if (this.mHasThumbnail) {
            byteOrderedDataOutputStream.write(getThumbnailBytes());
        }
        if (this.mMimeType == 14 && i18 % 2 == 1) {
            byteOrderedDataOutputStream.writeByte(0);
        }
        byteOrderedDataOutputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
        return i18;
    }

    public void flipHorizontally() {
        int i3 = 1;
        switch (getAttributeInt("Orientation", 1)) {
            case 1:
                i3 = 2;
                break;
            case 2:
                break;
            case 3:
                i3 = 4;
                break;
            case 4:
                i3 = 3;
                break;
            case 5:
                i3 = 6;
                break;
            case 6:
                i3 = 5;
                break;
            case 7:
                i3 = 8;
                break;
            case 8:
                i3 = 7;
                break;
            default:
                i3 = 0;
                break;
        }
        setAttribute("Orientation", Integer.toString(i3));
    }

    public void flipVertically() {
        int i3 = 1;
        switch (getAttributeInt("Orientation", 1)) {
            case 1:
                i3 = 4;
                break;
            case 2:
                i3 = 3;
                break;
            case 3:
                i3 = 2;
                break;
            case 4:
                break;
            case 5:
                i3 = 8;
                break;
            case 6:
                i3 = 7;
                break;
            case 7:
                i3 = 6;
                break;
            case 8:
                i3 = 5;
                break;
            default:
                i3 = 0;
                break;
        }
        setAttribute("Orientation", Integer.toString(i3));
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

    @Nullable
    public String getAttribute(@NonNull String str) {
        if (str != null) {
            ExifAttribute exifAttribute = getExifAttribute(str);
            if (exifAttribute != null) {
                if (!sTagSetForCompatibility.contains(str)) {
                    return exifAttribute.getStringValue(this.mExifByteOrder);
                }
                if (str.equals("GPSTimeStamp")) {
                    int i3 = exifAttribute.format;
                    if (i3 != 5 && i3 != 10) {
                        Log.w(TAG, "GPS Timestamp format is not rational. format=" + exifAttribute.format);
                        return null;
                    }
                    Rational[] rationalArr = (Rational[]) exifAttribute.getValue(this.mExifByteOrder);
                    if (rationalArr != null && rationalArr.length == 3) {
                        Rational rational = rationalArr[0];
                        Rational rational2 = rationalArr[1];
                        Rational rational3 = rationalArr[2];
                        return String.format("%02d:%02d:%02d", Integer.valueOf((int) (((float) rational.numerator) / ((float) rational.denominator))), Integer.valueOf((int) (((float) rational2.numerator) / ((float) rational2.denominator))), Integer.valueOf((int) (((float) rational3.numerator) / ((float) rational3.denominator))));
                    }
                    Log.w(TAG, "Invalid GPS Timestamp array. array=" + Arrays.toString(rationalArr));
                    return null;
                }
                try {
                    return Double.toString(exifAttribute.getDoubleValue(this.mExifByteOrder));
                } catch (NumberFormatException unused) {
                }
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    @Nullable
    public byte[] getAttributeBytes(@NonNull String str) {
        if (str != null) {
            ExifAttribute exifAttribute = getExifAttribute(str);
            if (exifAttribute != null) {
                return exifAttribute.bytes;
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    public double getAttributeDouble(@NonNull String str, double d16) {
        if (str != null) {
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
        throw new NullPointerException("tag shouldn't be null");
    }

    public int getAttributeInt(@NonNull String str, int i3) {
        if (str != null) {
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
        throw new NullPointerException("tag shouldn't be null");
    }

    @Nullable
    public long[] getAttributeRange(@NonNull String str) {
        if (str != null) {
            if (!this.mModified) {
                ExifAttribute exifAttribute = getExifAttribute(str);
                if (exifAttribute != null) {
                    return new long[]{exifAttribute.bytesOffset, exifAttribute.bytes.length};
                }
                return null;
            }
            throw new IllegalStateException("The underlying file has been modified since being parsed");
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Long getDateTime() {
        return parseDateTime(getAttribute("DateTime"), getAttribute("SubSecTime"), getAttribute(TAG_OFFSET_TIME));
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Long getDateTimeDigitized() {
        return parseDateTime(getAttribute("DateTimeDigitized"), getAttribute("SubSecTimeDigitized"), getAttribute(TAG_OFFSET_TIME_DIGITIZED));
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Long getDateTimeOriginal() {
        return parseDateTime(getAttribute("DateTimeOriginal"), getAttribute("SubSecTimeOriginal"), getAttribute(TAG_OFFSET_TIME_ORIGINAL));
    }

    @Nullable
    @SuppressLint({"AutoBoxing"})
    public Long getGpsDateTime() {
        String attribute = getAttribute("GPSDateStamp");
        String attribute2 = getAttribute("GPSTimeStamp");
        if (attribute != null && attribute2 != null) {
            Pattern pattern = NON_ZERO_TIME_PATTERN;
            if (pattern.matcher(attribute).matches() || pattern.matcher(attribute2).matches()) {
                String str = attribute + TokenParser.SP + attribute2;
                ParsePosition parsePosition = new ParsePosition(0);
                try {
                    Date parse = sFormatterPrimary.parse(str, parsePosition);
                    if (parse == null && (parse = sFormatterSecondary.parse(str, parsePosition)) == null) {
                        return null;
                    }
                    return Long.valueOf(parse.getTime());
                } catch (IllegalArgumentException unused) {
                }
            }
        }
        return null;
    }

    @Deprecated
    public boolean getLatLong(float[] fArr) {
        double[] latLong = getLatLong();
        if (latLong == null) {
            return false;
        }
        fArr[0] = (float) latLong[0];
        fArr[1] = (float) latLong[1];
        return true;
    }

    public int getRotationDegrees() {
        switch (getAttributeInt("Orientation", 1)) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 8:
                return 270;
            case 6:
            case 7:
                return 90;
            default:
                return 0;
        }
    }

    @Nullable
    public byte[] getThumbnail() {
        int i3 = this.mThumbnailCompression;
        if (i3 != 6 && i3 != 7) {
            return null;
        }
        return getThumbnailBytes();
    }

    @Nullable
    public Bitmap getThumbnailBitmap() {
        if (!this.mHasThumbnail) {
            return null;
        }
        if (this.mThumbnailBytes == null) {
            this.mThumbnailBytes = getThumbnailBytes();
        }
        int i3 = this.mThumbnailCompression;
        if (i3 != 6 && i3 != 7) {
            if (i3 == 1) {
                int length = this.mThumbnailBytes.length / 3;
                int[] iArr = new int[length];
                for (int i16 = 0; i16 < length; i16++) {
                    byte[] bArr = this.mThumbnailBytes;
                    int i17 = i16 * 3;
                    iArr[i16] = (bArr[i17] << RegisterType.UNINIT_REF) + 0 + (bArr[i17 + 1] << 8) + bArr[i17 + 2];
                }
                ExifAttribute exifAttribute = this.mAttributes[4].get("ImageLength");
                ExifAttribute exifAttribute2 = this.mAttributes[4].get("ImageWidth");
                if (exifAttribute != null && exifAttribute2 != null) {
                    return Bitmap.createBitmap(iArr, exifAttribute2.getIntValue(this.mExifByteOrder), exifAttribute.getIntValue(this.mExifByteOrder), Bitmap.Config.ARGB_8888);
                }
            }
            return null;
        }
        return BitmapFactory.decodeByteArray(this.mThumbnailBytes, 0, this.mThumbnailLength);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0068 A[Catch: Exception -> 0x008b, all -> 0x00ab, TRY_ENTER, TryCatch #1 {Exception -> 0x008b, blocks: (B:17:0x0051, B:20:0x0068, B:22:0x0074, B:27:0x007f, B:28:0x0084, B:29:0x0085, B:30:0x008a), top: B:16:0x0051 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0085 A[Catch: Exception -> 0x008b, all -> 0x00ab, TryCatch #1 {Exception -> 0x008b, blocks: (B:17:0x0051, B:20:0x0068, B:22:0x0074, B:27:0x007f, B:28:0x0084, B:29:0x0085, B:30:0x008a), top: B:16:0x0051 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b2  */
    /* JADX WARN: Type inference failed for: r1v1, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.content.res.AssetManager$AssetInputStream, java.io.Closeable, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.Closeable, java.io.InputStream] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] getThumbnailBytes() {
        FileDescriptor fileDescriptor;
        Exception e16;
        FileDescriptor fileDescriptor2;
        FileInputStream fileInputStream;
        Closeable closeable = null;
        if (!this.mHasThumbnail) {
            return null;
        }
        ?? r16 = this.mThumbnailBytes;
        try {
            if (r16 != 0) {
                return r16;
            }
            try {
                r16 = this.mAssetInputStream;
            } catch (Exception e17) {
                r16 = 0;
                e16 = e17;
                fileDescriptor2 = null;
            } catch (Throwable th5) {
                th = th5;
                fileDescriptor = null;
            }
            try {
                if (r16 != 0) {
                    try {
                        if (r16.markSupported()) {
                            r16.reset();
                            fileInputStream = r16;
                        } else {
                            Log.d(TAG, "Cannot read thumbnail from inputstream without mark/reset support");
                            closeQuietly(r16);
                            return null;
                        }
                    } catch (Exception e18) {
                        e16 = e18;
                        fileDescriptor2 = null;
                        Log.d(TAG, "Encountered exception while getting thumbnail", e16);
                        closeQuietly(r16);
                        if (fileDescriptor2 != null) {
                        }
                        return null;
                    } catch (Throwable th6) {
                        th = th6;
                        fileDescriptor = null;
                        closeable = r16;
                        closeQuietly(closeable);
                        if (fileDescriptor != null) {
                        }
                        throw th;
                    }
                } else if (this.mFilename != null) {
                    fileInputStream = new FileInputStream(this.mFilename);
                } else {
                    FileDescriptor dup = Os.dup(this.mSeekableFileDescriptor);
                    try {
                        Os.lseek(dup, 0L, OsConstants.SEEK_SET);
                        fileDescriptor2 = dup;
                        r16 = new FileInputStream(dup);
                        if (r16.skip(this.mThumbnailOffset + this.mOffsetToExifData) != this.mThumbnailOffset + this.mOffsetToExifData) {
                            byte[] bArr = new byte[this.mThumbnailLength];
                            if (r16.read(bArr) == this.mThumbnailLength) {
                                this.mThumbnailBytes = bArr;
                                closeQuietly(r16);
                                if (fileDescriptor2 != null) {
                                    closeFileDescriptor(fileDescriptor2);
                                }
                                return bArr;
                            }
                            throw new IOException("Corrupted image");
                        }
                        throw new IOException("Corrupted image");
                    } catch (Exception e19) {
                        e16 = e19;
                        fileDescriptor2 = dup;
                        r16 = 0;
                        Log.d(TAG, "Encountered exception while getting thumbnail", e16);
                        closeQuietly(r16);
                        if (fileDescriptor2 != null) {
                        }
                        return null;
                    } catch (Throwable th7) {
                        th = th7;
                        fileDescriptor = dup;
                        closeQuietly(closeable);
                        if (fileDescriptor != null) {
                            closeFileDescriptor(fileDescriptor);
                        }
                        throw th;
                    }
                }
                if (r16.skip(this.mThumbnailOffset + this.mOffsetToExifData) != this.mThumbnailOffset + this.mOffsetToExifData) {
                }
            } catch (Exception e26) {
                e16 = e26;
                Log.d(TAG, "Encountered exception while getting thumbnail", e16);
                closeQuietly(r16);
                if (fileDescriptor2 != null) {
                    closeFileDescriptor(fileDescriptor2);
                }
                return null;
            }
            fileDescriptor2 = null;
            r16 = fileInputStream;
        } catch (Throwable th8) {
            th = th8;
        }
    }

    @Nullable
    public long[] getThumbnailRange() {
        if (!this.mModified) {
            if (!this.mHasThumbnail) {
                return null;
            }
            if (this.mHasThumbnailStrips && !this.mAreThumbnailStripsConsecutive) {
                return null;
            }
            return new long[]{this.mThumbnailOffset + this.mOffsetToExifData, this.mThumbnailLength};
        }
        throw new IllegalStateException("The underlying file has been modified since being parsed");
    }

    public boolean hasAttribute(@NonNull String str) {
        if (getExifAttribute(str) != null) {
            return true;
        }
        return false;
    }

    public boolean hasThumbnail() {
        return this.mHasThumbnail;
    }

    public boolean isFlipped() {
        int attributeInt = getAttributeInt("Orientation", 1);
        if (attributeInt == 2 || attributeInt == 7 || attributeInt == 4 || attributeInt == 5) {
            return true;
        }
        return false;
    }

    public boolean isThumbnailCompressed() {
        if (!this.mHasThumbnail) {
            return false;
        }
        int i3 = this.mThumbnailCompression;
        if (i3 != 6 && i3 != 7) {
            return false;
        }
        return true;
    }

    public void resetOrientation() {
        setAttribute("Orientation", Integer.toString(1));
    }

    public void rotate(int i3) {
        if (i3 % 90 == 0) {
            int attributeInt = getAttributeInt("Orientation", 1);
            List<Integer> list = ROTATION_ORDER;
            int i16 = 0;
            if (list.contains(Integer.valueOf(attributeInt))) {
                int indexOf = (list.indexOf(Integer.valueOf(attributeInt)) + (i3 / 90)) % 4;
                if (indexOf < 0) {
                    i16 = 4;
                }
                i16 = list.get(indexOf + i16).intValue();
            } else {
                List<Integer> list2 = FLIPPED_ROTATION_ORDER;
                if (list2.contains(Integer.valueOf(attributeInt))) {
                    int indexOf2 = (list2.indexOf(Integer.valueOf(attributeInt)) + (i3 / 90)) % 4;
                    if (indexOf2 < 0) {
                        i16 = 4;
                    }
                    i16 = list2.get(indexOf2 + i16).intValue();
                }
            }
            setAttribute("Orientation", Integer.toString(i16));
            return;
        }
        throw new IllegalArgumentException("degree should be a multiple of 90");
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00d0 A[Catch: all -> 0x00f9, Exception -> 0x00fb, TryCatch #16 {Exception -> 0x00fb, all -> 0x00f9, blocks: (B:50:0x00cc, B:52:0x00d0, B:53:0x00e6, B:57:0x00df), top: B:49:0x00cc }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00df A[Catch: all -> 0x00f9, Exception -> 0x00fb, TryCatch #16 {Exception -> 0x00fb, all -> 0x00f9, blocks: (B:50:0x00cc, B:52:0x00d0, B:53:0x00e6, B:57:0x00df), top: B:49:0x00cc }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0133  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void saveAttributes() throws IOException {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        Closeable closeable;
        FileOutputStream fileOutputStream2;
        Exception exc;
        FileOutputStream fileOutputStream3;
        InputStream inputStream;
        Exception e16;
        FileOutputStream fileOutputStream4;
        FileInputStream fileInputStream2;
        BufferedOutputStream bufferedOutputStream;
        if (isSupportedFormatForSavingAttributes()) {
            if (this.mSeekableFileDescriptor == null && this.mFilename == null) {
                throw new IOException("ExifInterface does not support saving attributes for the current input.");
            }
            this.mModified = true;
            this.mThumbnailBytes = getThumbnail();
            InputStream inputStream2 = null;
            try {
                File createTempFile = File.createTempFile(FaceUtil.IMG_TEMP, "tmp");
                if (this.mFilename != null) {
                    fileInputStream = new FileInputStream(this.mFilename);
                } else {
                    Os.lseek(this.mSeekableFileDescriptor, 0L, OsConstants.SEEK_SET);
                    fileInputStream = new FileInputStream(this.mSeekableFileDescriptor);
                }
                try {
                    fileOutputStream = new FileOutputStream(createTempFile);
                    try {
                        copy(fileInputStream, fileOutputStream);
                        closeQuietly(fileInputStream);
                        closeQuietly(fileOutputStream);
                        try {
                            try {
                                try {
                                    fileInputStream2 = new FileInputStream(createTempFile);
                                } catch (Throwable th5) {
                                    th = th5;
                                    closeable = null;
                                    closeQuietly(inputStream2);
                                    closeQuietly(closeable);
                                    if (0 == 0) {
                                        createTempFile.delete();
                                    }
                                    throw th;
                                }
                            } catch (Exception e17) {
                                e = e17;
                                fileOutputStream2 = null;
                            }
                            try {
                                if (this.mFilename != null) {
                                    fileOutputStream3 = new FileOutputStream(this.mFilename);
                                } else {
                                    Os.lseek(this.mSeekableFileDescriptor, 0L, OsConstants.SEEK_SET);
                                    fileOutputStream3 = new FileOutputStream(this.mSeekableFileDescriptor);
                                }
                                try {
                                    BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream2);
                                    try {
                                        bufferedOutputStream = new BufferedOutputStream(fileOutputStream3);
                                    } catch (Exception e18) {
                                        inputStream2 = fileInputStream2;
                                        exc = e18;
                                    } catch (Throwable th6) {
                                        th = th6;
                                        closeable = null;
                                        inputStream2 = bufferedInputStream;
                                        closeQuietly(inputStream2);
                                        closeQuietly(closeable);
                                        if (0 == 0) {
                                        }
                                        throw th;
                                    }
                                    try {
                                        int i3 = this.mMimeType;
                                        if (i3 == 4) {
                                            saveJpegAttributes(bufferedInputStream, bufferedOutputStream);
                                        } else if (i3 == 13) {
                                            savePngAttributes(bufferedInputStream, bufferedOutputStream);
                                        } else if (i3 == 14) {
                                            saveWebpAttributes(bufferedInputStream, bufferedOutputStream);
                                        }
                                        closeQuietly(bufferedInputStream);
                                        closeQuietly(bufferedOutputStream);
                                        createTempFile.delete();
                                        this.mThumbnailBytes = null;
                                    } catch (Exception e19) {
                                        exc = e19;
                                        inputStream2 = fileInputStream2;
                                        try {
                                            inputStream = new FileInputStream(createTempFile);
                                            try {
                                                if (this.mFilename != null) {
                                                }
                                                fileOutputStream3 = fileOutputStream4;
                                                copy(inputStream, fileOutputStream3);
                                                closeQuietly(inputStream);
                                                closeQuietly(fileOutputStream3);
                                                throw new IOException("Failed to save new file", exc);
                                            } catch (Exception e26) {
                                                e16 = e26;
                                                try {
                                                    throw new IOException("Failed to save new file. Original file is stored in " + createTempFile.getAbsolutePath(), e16);
                                                } catch (Throwable th7) {
                                                    th = th7;
                                                    inputStream2 = inputStream;
                                                    closeQuietly(inputStream2);
                                                    closeQuietly(fileOutputStream3);
                                                    throw th;
                                                }
                                            } catch (Throwable th8) {
                                                th = th8;
                                                inputStream2 = inputStream;
                                                closeQuietly(inputStream2);
                                                closeQuietly(fileOutputStream3);
                                                throw th;
                                            }
                                        } catch (Exception e27) {
                                            inputStream = inputStream2;
                                            e16 = e27;
                                        } catch (Throwable th9) {
                                            th = th9;
                                            closeQuietly(inputStream2);
                                            closeQuietly(fileOutputStream3);
                                            throw th;
                                        }
                                    }
                                } catch (Exception e28) {
                                    inputStream2 = fileInputStream2;
                                    exc = e28;
                                }
                            } catch (Exception e29) {
                                e = e29;
                                fileOutputStream2 = null;
                                inputStream2 = fileInputStream2;
                                exc = e;
                                fileOutputStream3 = fileOutputStream2;
                                inputStream = new FileInputStream(createTempFile);
                                if (this.mFilename != null) {
                                    Os.lseek(this.mSeekableFileDescriptor, 0L, OsConstants.SEEK_SET);
                                    fileOutputStream4 = new FileOutputStream(this.mSeekableFileDescriptor);
                                } else {
                                    fileOutputStream4 = new FileOutputStream(this.mFilename);
                                }
                                fileOutputStream3 = fileOutputStream4;
                                copy(inputStream, fileOutputStream3);
                                closeQuietly(inputStream);
                                closeQuietly(fileOutputStream3);
                                throw new IOException("Failed to save new file", exc);
                            }
                        } catch (Throwable th10) {
                            th = th10;
                        }
                    } catch (Exception e36) {
                        e = e36;
                        inputStream2 = fileInputStream;
                        try {
                            throw new IOException("Failed to copy original file to temp file", e);
                        } catch (Throwable th11) {
                            th = th11;
                            closeQuietly(inputStream2);
                            closeQuietly(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th12) {
                        th = th12;
                        inputStream2 = fileInputStream;
                        closeQuietly(inputStream2);
                        closeQuietly(fileOutputStream);
                        throw th;
                    }
                } catch (Exception e37) {
                    e = e37;
                    fileOutputStream = null;
                } catch (Throwable th13) {
                    th = th13;
                    fileOutputStream = null;
                }
            } catch (Exception e38) {
                e = e38;
                fileOutputStream = null;
            } catch (Throwable th14) {
                th = th14;
                fileOutputStream = null;
            }
        } else {
            throw new IOException("ExifInterface only supports saving attributes on JPEG, PNG, or WebP formats.");
        }
    }

    public void setAltitude(double d16) {
        String str;
        if (d16 >= 0.0d) {
            str = "0";
        } else {
            str = "1";
        }
        setAttribute("GPSAltitude", new Rational(Math.abs(d16)).toString());
        setAttribute("GPSAltitudeRef", str);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:58:0x022c. Please report as an issue. */
    public void setAttribute(@NonNull String str, @Nullable String str2) {
        ExifTag exifTag;
        int i3;
        int i16;
        String str3;
        String str4 = str;
        String str5 = str2;
        if (str4 != null) {
            if (("DateTime".equals(str4) || "DateTimeOriginal".equals(str4) || "DateTimeDigitized".equals(str4)) && str5 != null) {
                boolean find = DATETIME_PRIMARY_FORMAT_PATTERN.matcher(str5).find();
                boolean find2 = DATETIME_SECONDARY_FORMAT_PATTERN.matcher(str5).find();
                if (str2.length() == 19 && (find || find2)) {
                    if (find2) {
                        str5 = str5.replaceAll("-", ":");
                    }
                } else {
                    Log.w(TAG, "Invalid value for " + str4 + ProgressTracer.SEPARATOR + str5);
                    return;
                }
            }
            if ("ISOSpeedRatings".equals(str4)) {
                if (DEBUG) {
                    Log.d(TAG, "setAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
                }
                str4 = TAG_PHOTOGRAPHIC_SENSITIVITY;
            }
            int i17 = 2;
            int i18 = 1;
            if (str5 != null && sTagSetForCompatibility.contains(str4)) {
                if (str4.equals("GPSTimeStamp")) {
                    Matcher matcher = GPS_TIMESTAMP_PATTERN.matcher(str5);
                    if (!matcher.find()) {
                        Log.w(TAG, "Invalid value for " + str4 + ProgressTracer.SEPARATOR + str5);
                        return;
                    }
                    str5 = Integer.parseInt(matcher.group(1)) + "/1," + Integer.parseInt(matcher.group(2)) + "/1," + Integer.parseInt(matcher.group(3)) + "/1";
                } else {
                    try {
                        str5 = new Rational(Double.parseDouble(str5)).toString();
                    } catch (NumberFormatException unused) {
                        Log.w(TAG, "Invalid value for " + str4 + ProgressTracer.SEPARATOR + str5);
                        return;
                    }
                }
            }
            int i19 = 0;
            int i26 = 0;
            while (i26 < EXIF_TAGS.length) {
                if ((i26 != 4 || this.mHasThumbnail) && (exifTag = sExifTagMapsForWriting[i26].get(str4)) != null) {
                    if (str5 == null) {
                        this.mAttributes[i26].remove(str4);
                    } else {
                        Pair<Integer, Integer> guessDataFormat = guessDataFormat(str5);
                        int i27 = -1;
                        if (exifTag.primaryFormat != ((Integer) guessDataFormat.first).intValue() && exifTag.primaryFormat != ((Integer) guessDataFormat.second).intValue()) {
                            int i28 = exifTag.secondaryFormat;
                            if (i28 != -1 && (i28 == ((Integer) guessDataFormat.first).intValue() || exifTag.secondaryFormat == ((Integer) guessDataFormat.second).intValue())) {
                                i3 = exifTag.secondaryFormat;
                            } else {
                                int i29 = exifTag.primaryFormat;
                                if (i29 != i18 && i29 != 7 && i29 != i17) {
                                    if (DEBUG) {
                                        StringBuilder sb5 = new StringBuilder();
                                        sb5.append("Given tag (");
                                        sb5.append(str4);
                                        sb5.append(") value didn't match with one of expected formats: ");
                                        String[] strArr = IFD_FORMAT_NAMES;
                                        sb5.append(strArr[exifTag.primaryFormat]);
                                        String str6 = "";
                                        if (exifTag.secondaryFormat == -1) {
                                            str3 = "";
                                        } else {
                                            str3 = ", " + strArr[exifTag.secondaryFormat];
                                        }
                                        sb5.append(str3);
                                        sb5.append(" (guess: ");
                                        sb5.append(strArr[((Integer) guessDataFormat.first).intValue()]);
                                        if (((Integer) guessDataFormat.second).intValue() != -1) {
                                            str6 = ", " + strArr[((Integer) guessDataFormat.second).intValue()];
                                        }
                                        sb5.append(str6);
                                        sb5.append(")");
                                        Log.d(TAG, sb5.toString());
                                    }
                                } else {
                                    i3 = i29;
                                }
                            }
                        } else {
                            i3 = exifTag.primaryFormat;
                        }
                        switch (i3) {
                            case 1:
                                i16 = i18;
                                this.mAttributes[i26].put(str4, ExifAttribute.createByte(str5));
                                break;
                            case 2:
                            case 7:
                                i16 = i18;
                                this.mAttributes[i26].put(str4, ExifAttribute.createString(str5));
                                break;
                            case 3:
                                i16 = i18;
                                String[] split = str5.split(",", -1);
                                int[] iArr = new int[split.length];
                                for (int i36 = 0; i36 < split.length; i36++) {
                                    iArr[i36] = Integer.parseInt(split[i36]);
                                }
                                this.mAttributes[i26].put(str4, ExifAttribute.createUShort(iArr, this.mExifByteOrder));
                                break;
                            case 4:
                                i16 = i18;
                                String[] split2 = str5.split(",", -1);
                                long[] jArr = new long[split2.length];
                                for (int i37 = 0; i37 < split2.length; i37++) {
                                    jArr[i37] = Long.parseLong(split2[i37]);
                                }
                                this.mAttributes[i26].put(str4, ExifAttribute.createULong(jArr, this.mExifByteOrder));
                                break;
                            case 5:
                                String[] split3 = str5.split(",", -1);
                                Rational[] rationalArr = new Rational[split3.length];
                                int i38 = 0;
                                while (i38 < split3.length) {
                                    String[] split4 = split3[i38].split("/", i27);
                                    rationalArr[i38] = new Rational((long) Double.parseDouble(split4[0]), (long) Double.parseDouble(split4[1]));
                                    i38++;
                                    i27 = -1;
                                }
                                i16 = 1;
                                this.mAttributes[i26].put(str4, ExifAttribute.createURational(rationalArr, this.mExifByteOrder));
                                break;
                            case 6:
                            case 8:
                            case 11:
                            default:
                                i16 = i18;
                                if (DEBUG) {
                                    Log.d(TAG, "Data format isn't one of expected formats: " + i3);
                                    break;
                                } else {
                                    break;
                                }
                            case 9:
                                String[] split5 = str5.split(",", -1);
                                int[] iArr2 = new int[split5.length];
                                for (int i39 = 0; i39 < split5.length; i39++) {
                                    iArr2[i39] = Integer.parseInt(split5[i39]);
                                }
                                this.mAttributes[i26].put(str4, ExifAttribute.createSLong(iArr2, this.mExifByteOrder));
                                i16 = 1;
                                break;
                            case 10:
                                String[] split6 = str5.split(",", -1);
                                Rational[] rationalArr2 = new Rational[split6.length];
                                int i46 = i19;
                                while (i46 < split6.length) {
                                    String[] split7 = split6[i46].split("/", -1);
                                    rationalArr2[i46] = new Rational((long) Double.parseDouble(split7[i19]), (long) Double.parseDouble(split7[i18]));
                                    i46++;
                                    split6 = split6;
                                    i19 = 0;
                                    i18 = 1;
                                }
                                this.mAttributes[i26].put(str4, ExifAttribute.createSRational(rationalArr2, this.mExifByteOrder));
                                i16 = 1;
                                break;
                            case 12:
                                String[] split8 = str5.split(",", -1);
                                double[] dArr = new double[split8.length];
                                for (int i47 = i19; i47 < split8.length; i47++) {
                                    dArr[i47] = Double.parseDouble(split8[i47]);
                                }
                                this.mAttributes[i26].put(str4, ExifAttribute.createDouble(dArr, this.mExifByteOrder));
                                break;
                        }
                        i26++;
                        i18 = i16;
                        i17 = 2;
                        i19 = 0;
                    }
                }
                i16 = i18;
                i26++;
                i18 = i16;
                i17 = 2;
                i19 = 0;
            }
            return;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setDateTime(@NonNull Long l3) {
        long longValue = l3.longValue() % 1000;
        setAttribute("DateTime", sFormatterPrimary.format(new Date(l3.longValue())));
        setAttribute("SubSecTime", Long.toString(longValue));
    }

    public void setGpsInfo(Location location) {
        if (location == null) {
            return;
        }
        setAttribute("GPSProcessingMethod", location.getProvider());
        setLatLong(location.getLatitude(), location.getLongitude());
        setAltitude(location.getAltitude());
        setAttribute("GPSSpeedRef", "K");
        setAttribute("GPSSpeed", new Rational((location.getSpeed() * ((float) TimeUnit.HOURS.toSeconds(1L))) / 1000.0f).toString());
        String[] split = sFormatterPrimary.format(new Date(location.getTime())).split("\\s+", -1);
        setAttribute("GPSDateStamp", split[0]);
        setAttribute("GPSTimeStamp", split[1]);
    }

    public void setLatLong(double d16, double d17) {
        String str;
        String str2;
        if (d16 >= -90.0d && d16 <= 90.0d && !Double.isNaN(d16)) {
            if (d17 >= -180.0d && d17 <= 180.0d && !Double.isNaN(d17)) {
                if (d16 >= 0.0d) {
                    str = "N";
                } else {
                    str = LATITUDE_SOUTH;
                }
                setAttribute("GPSLatitudeRef", str);
                setAttribute("GPSLatitude", convertDecimalDegree(Math.abs(d16)));
                if (d17 >= 0.0d) {
                    str2 = "E";
                } else {
                    str2 = "W";
                }
                setAttribute("GPSLongitudeRef", str2);
                setAttribute("GPSLongitude", convertDecimalDegree(Math.abs(d17)));
                return;
            }
            throw new IllegalArgumentException("Longitude value " + d17 + " is not valid.");
        }
        throw new IllegalArgumentException("Latitude value " + d16 + " is not valid.");
    }

    private static void copy(InputStream inputStream, OutputStream outputStream, int i3) throws IOException {
        byte[] bArr = new byte[8192];
        while (i3 > 0) {
            int min = Math.min(i3, 8192);
            int read = inputStream.read(bArr, 0, min);
            if (read == min) {
                i3 -= read;
                outputStream.write(bArr, 0, read);
            } else {
                throw new IOException("Failed to copy the given amount of bytes from the inputstream to the output stream.");
            }
        }
    }

    @Nullable
    public double[] getLatLong() {
        String attribute = getAttribute("GPSLatitude");
        String attribute2 = getAttribute("GPSLatitudeRef");
        String attribute3 = getAttribute("GPSLongitude");
        String attribute4 = getAttribute("GPSLongitudeRef");
        if (attribute == null || attribute2 == null || attribute3 == null || attribute4 == null) {
            return null;
        }
        try {
            return new double[]{convertRationalLatLonToDouble(attribute, attribute2), convertRationalLatLonToDouble(attribute3, attribute4)};
        } catch (IllegalArgumentException unused) {
            Log.w(TAG, "Latitude/longitude values are not parsable. " + String.format("latValue=%s, latRef=%s, lngValue=%s, lngRef=%s", attribute, attribute2, attribute3, attribute4));
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
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

        boolean isFormatCompatible(int i3) {
            int i16;
            int i17 = this.primaryFormat;
            if (i17 == 7 || i3 == 7 || i17 == i3 || (i16 = this.secondaryFormat) == i3) {
                return true;
            }
            if ((i17 == 4 || i16 == 4) && i3 == 3) {
                return true;
            }
            if ((i17 == 9 || i16 == 9) && i3 == 8) {
                return true;
            }
            if ((i17 == 12 || i16 == 12) && i3 == 11) {
                return true;
            }
            return false;
        }

        ExifTag(String str, int i3, int i16, int i17) {
            this.name = str;
            this.number = i3;
            this.primaryFormat = i16;
            this.secondaryFormat = i17;
        }
    }

    public ExifInterface(@NonNull String str) throws IOException {
        ExifTag[][] exifTagArr = EXIF_TAGS;
        this.mAttributes = new HashMap[exifTagArr.length];
        this.mAttributesOffsets = new HashSet(exifTagArr.length);
        this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
        if (str != null) {
            initForFilename(str);
            return;
        }
        throw new NullPointerException("filename cannot be null");
    }

    public ExifInterface(@NonNull FileDescriptor fileDescriptor) throws IOException {
        boolean z16;
        FileInputStream fileInputStream;
        Throwable th5;
        ExifTag[][] exifTagArr = EXIF_TAGS;
        this.mAttributes = new HashMap[exifTagArr.length];
        this.mAttributesOffsets = new HashSet(exifTagArr.length);
        this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
        if (fileDescriptor != null) {
            this.mAssetInputStream = null;
            this.mFilename = null;
            if (isSeekableFD(fileDescriptor)) {
                this.mSeekableFileDescriptor = fileDescriptor;
                try {
                    fileDescriptor = Os.dup(fileDescriptor);
                    z16 = true;
                } catch (Exception e16) {
                    throw new IOException("Failed to duplicate file descriptor", e16);
                }
            } else {
                this.mSeekableFileDescriptor = null;
                z16 = false;
            }
            try {
                fileInputStream = new FileInputStream(fileDescriptor);
            } catch (Throwable th6) {
                fileInputStream = null;
                th5 = th6;
            }
            try {
                loadAttributes(fileInputStream);
                closeQuietly(fileInputStream);
                if (z16) {
                    closeFileDescriptor(fileDescriptor);
                    return;
                }
                return;
            } catch (Throwable th7) {
                th5 = th7;
                closeQuietly(fileInputStream);
                if (z16) {
                    closeFileDescriptor(fileDescriptor);
                }
                throw th5;
            }
        }
        throw new NullPointerException("fileDescriptor cannot be null");
    }

    public ExifInterface(@NonNull InputStream inputStream) throws IOException {
        this(inputStream, 0);
    }

    public ExifInterface(@NonNull InputStream inputStream, int i3) throws IOException {
        ExifTag[][] exifTagArr = EXIF_TAGS;
        this.mAttributes = new HashMap[exifTagArr.length];
        this.mAttributesOffsets = new HashSet(exifTagArr.length);
        this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
        if (inputStream != null) {
            this.mFilename = null;
            if (i3 == 1) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
                if (!isExifDataOnly(bufferedInputStream)) {
                    Log.w(TAG, "Given data does not follow the structure of an Exif-only data.");
                    return;
                }
                this.mIsExifDataOnly = true;
                this.mAssetInputStream = null;
                this.mSeekableFileDescriptor = null;
                inputStream = bufferedInputStream;
            } else if (inputStream instanceof AssetManager.AssetInputStream) {
                this.mAssetInputStream = (AssetManager.AssetInputStream) inputStream;
                this.mSeekableFileDescriptor = null;
            } else {
                if (inputStream instanceof FileInputStream) {
                    FileInputStream fileInputStream = (FileInputStream) inputStream;
                    if (isSeekableFD(fileInputStream.getFD())) {
                        this.mAssetInputStream = null;
                        this.mSeekableFileDescriptor = fileInputStream.getFD();
                    }
                }
                this.mAssetInputStream = null;
                this.mSeekableFileDescriptor = null;
            }
            loadAttributes(inputStream);
            return;
        }
        throw new NullPointerException("inputStream cannot be null");
    }
}
